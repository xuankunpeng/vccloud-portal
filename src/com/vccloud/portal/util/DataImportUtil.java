package com.vccloud.portal.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vccloud.portal.db.dao.TExtVidyoMemberDAO;
import com.vccloud.portal.db.dao.TExtVidyoPortalDAO;
import com.vccloud.portal.db.dao.TExtVidyoTenantDAO;
import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.db.model.TExtVidyoMemberExample;
import com.vccloud.portal.db.model.TExtVidyoPortal;
import com.vccloud.portal.db.model.TExtVidyoPortalExample;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.db.model.TExtVidyoTenantExample;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceUtil;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceUtil;

public class DataImportUtil {

	private static Logger logger = Logger.getLogger(DataImportUtil.class);

	private static BeanFactory beanFactory = null;
	private static TExtVidyoTenantDAO tExtVidyoTenantDAO = null;
	private static TExtVidyoMemberDAO tExtVidyoMemberDAO = null;
	private static TExtVidyoPortalDAO tExtVidyoPortalDAO = null;

	static {
		if (beanFactory == null) {
			ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					new String[] { "classpath:applicationContext.xml",
							"classpath:spring/applicationContext-*.xml",
							"classpath*:/applicationContext.xml",
							"classpath:**/applicationContext*.xml" });
			beanFactory = applicationContext;
		}
		tExtVidyoTenantDAO = (TExtVidyoTenantDAO) beanFactory
				.getBean("tExtVidyoTenantDAO");
		tExtVidyoMemberDAO = (TExtVidyoMemberDAO) beanFactory
				.getBean("tExtVidyoMemberDAO");
		tExtVidyoPortalDAO = (TExtVidyoPortalDAO) beanFactory
				.getBean("tExtVidyoPortalDAO");
	}

	@SuppressWarnings("unchecked")
	public static void importTenants(String portalURL, String superName,
			String superPassword) {
		com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.SingleTenantDataType[] tenants = null;
		try {
			tenants = VidyoPortalSuperServiceUtil.getListOfTenants(portalURL,
					superName, superPassword);
		} catch (ServiceException e) {
			logger.error("", e);
			return;
		}
		if (CommonUtil.isNullOrEmpty(tenants)) {
			return;
		}
		for (com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.SingleTenantDataType tenant : tenants) {
			TExtVidyoTenantExample example = new TExtVidyoTenantExample();
			example.createCriteria().andUrlEqualTo(tenant.getTenantURL());
			List<TExtVidyoTenant> list = tExtVidyoTenantDAO
					.selectByExample(example);
			if (CommonUtil.isNullOrEmpty(list)) {
				continue;
			}
			TExtVidyoTenant item = list.get(0);
			item.setDescription(tenant.getDescription());
			item.setDialIn(tenant.getDialinNumber());
			item.setExtensionPrefix(tenant.getExtensionPrefix());
			// tenant.getTenantId();
			item.setName(tenant.getTenantName());
			item.setAllowedMobile(tenant.getVidyoMobileAllowed() == 1 ? true
					: false);
			item.setVidyoReplayUrl(tenant.getVidyoReplayUrl());
			tExtVidyoTenantDAO.updateByPrimaryKeySelective(item);
		}
	}

	@SuppressWarnings("unchecked")
	public static void importMembers() {
		TExtVidyoTenantExample tExtVidyoTenantExample = new TExtVidyoTenantExample();
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(tExtVidyoTenantExample);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			return;
		}

		List<Long> portalIds = new ArrayList<Long>();
		for (TExtVidyoTenant item : tenants) {
			portalIds.add(item.getPortalId());
		}
		TExtVidyoPortalExample tExtVidyoPortalExample = new TExtVidyoPortalExample();
		tExtVidyoPortalExample.createCriteria().andIdIn(portalIds);
		List<TExtVidyoPortal> portals = tExtVidyoPortalDAO
				.selectByExample(tExtVidyoPortalExample);
		if (CommonUtil.isNullOrEmpty(portals)) {
			return;
		}
		Map<Long, TExtVidyoPortal> portalMaps = new HashMap<Long, TExtVidyoPortal>();
		for (TExtVidyoPortal item : portals) {
			portalMaps.put(item.getId(), item);
		}

		for (TExtVidyoTenant item : tenants) {
			try {
				com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members = VidyoPortalAdminServiceUtil
						.getMembers(portalMaps.get(item.getPortalId())
								.getPortalurl(), item.getAdminName(), item
								.getAdminPassword(), null);
				if (CommonUtil.isNullOrEmpty(members)) {
					continue;
				}
				for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member : members) {
					if (!com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoleName_type0.Normal
							.getValue().equalsIgnoreCase(
									member.getRoleName().getValue())) {
						continue;
					}
					TExtVidyoMemberExample tExtVidyoMemberExample = new TExtVidyoMemberExample();
					tExtVidyoMemberExample.createCriteria().andTenantIdEqualTo(
							item.getId()).andNameEqualTo(member.getName());
					List<TExtVidyoMember> test = tExtVidyoMemberDAO
							.selectByExample(tExtVidyoMemberExample);
					if (CommonUtil.isNullOrEmpty(test)) {
						TExtVidyoMember m = new TExtVidyoMember();
						m.setTenantId(item.getId());
						// member.getMemberID();
						m.setName(member.getName());
						if (!CommonUtil.isNullOrEmpty(member.getPassword())) {
							m.setPassword(member.getPassword());
						}
						m.setDisplayname(member.getDisplayName());
						m.setExtension(member.getExtension());
						m.setLanguage(member.getLanguage().getValue());
						m.setRolename(member.getRoleName().getValue());
						m.setGroupname(member.getGroupName());
						m.setProxyname(member.getProxyName());
						m.setEmail(member.getEmailAddress());
						m.setDescription(member.getDescription());
						m.setAllowcalldirect(member.getAllowCallDirect());
						m.setAllowpersonalmeeting(member
								.getAllowPersonalMeeting());
						tExtVidyoMemberDAO.insertSelective(m);
					} else {
						TExtVidyoMember m = test.get(0);
						// member.getMemberID();
						m.setName(member.getName());
						if (!CommonUtil.isNullOrEmpty(member.getPassword())) {
							m.setPassword(member.getPassword());
						}
						m.setDisplayname(member.getDisplayName());
						m.setExtension(member.getExtension());
						m.setLanguage(member.getLanguage().getValue());
						m.setRolename(member.getRoleName().getValue());
						m.setGroupname(member.getGroupName());
						m.setProxyname(member.getProxyName());
						m.setEmail(member.getEmailAddress());
						m.setDescription(member.getDescription());
						m.setAllowcalldirect(member.getAllowCallDirect());
						m.setAllowpersonalmeeting(member
								.getAllowPersonalMeeting());
						tExtVidyoMemberDAO.updateByPrimaryKeySelective(m);
					}
				}
			} catch (CallVidyoWebServiceException e) {
				logger.error("", e);
				continue;
			}
		}
	}

	public static void main(String[] args) {
		// importTenants("http://demo.10010zj.com.cn", "super", "1234qwer");
		// importTenants("http://demo.10010js.com", "super", "abc@!@#$%^");
		importMembers();
	}

}
