package com.vccloud.portal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.db.model.TExtVidyoMemberExample;
import com.vccloud.portal.db.model.TExtVidyoPortal;
import com.vccloud.portal.db.model.TExtVidyoPortalConfig;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.db.model.TExtVidyoTenantExample;
import com.vccloud.portal.db.model.TPortalInfo;
import com.vccloud.portal.db.model.TPortalInfoExample;
import com.vccloud.portal.exception.AuthnFailedException;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.PasswordNotMatchesException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.UserService;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.vo.MemberVO;
import com.vccloud.portal.vo.TenantAndPortalInfoVO;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceUtil;

public class UserServiceImpl extends ServiceDefault implements UserService {

	@SuppressWarnings("unchecked")
	public TenantAndPortalInfoVO signInByTenant(String adminName,
			String adminPassword, String portalUrl) throws ServiceException {
		TPortalInfoExample example = new TPortalInfoExample();
		example.createCriteria().andAdminNameEqualTo(adminName);
		List<TPortalInfo> portalInfos = tPortalInfoDAO
				.selectByExample(example);
		if (!CommonUtil.isNullOrEmpty(portalInfos)) {
			TPortalInfo portalInfo = null;
			for (TPortalInfo item : portalInfos) {
				if (adminPassword.equals(item.getAdminPassword())
						&& portalUrl.equalsIgnoreCase(item.getPortalUrl())) {
					portalInfo = item;
					break;
				}
			}
			if (portalInfo != null) {
				TExtVidyoTenantExample example2 = new TExtVidyoTenantExample();
				example2.createCriteria().andUrlEqualTo(portalUrl);
				List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
						.selectByExample(example2);
				if (!CommonUtil.isNullOrEmpty(tenants)) {
					TExtVidyoTenant tenant = tenants.get(0);
					TenantAndPortalInfoVO vo = new TenantAndPortalInfoVO();
					vo.setPortalInfo(portalInfo);
					vo.setTenant(tenant);
					return vo;
				}
			}
		}
		throw new AuthnFailedException("");
	}

	@SuppressWarnings("unchecked")
	public TExtVidyoMember signInByMember(String name, String password,
			String portalUrl) throws ServiceException {
		TExtVidyoMemberExample example = new TExtVidyoMemberExample();
		example.createCriteria().andNameEqualTo(name);
		List<TExtVidyoMember> members = tExtVidyoMemberDAO
				.selectByExample(example);
		if (!CommonUtil.isNullOrEmpty(members)) {
			TExtVidyoMember member = null;
			for (TExtVidyoMember item : members) {
				if (password.equals(item.getPassword())) {
					member = item;
					break;
				}
			}
			if (member != null) {
				TExtVidyoTenant tenant = tExtVidyoTenantDAO
						.selectByPrimaryKey(member.getTenantId());
				if (tenant != null) {
					if (portalUrl.equalsIgnoreCase(tenant.getUrl())) {
						return member;
					}
				}
			}
		}
		throw new AuthnFailedException("");
	}

	public List<MemberVO> searchMembers(long tenantId, String name,
			int pageSize, int pageNo) throws ServiceException {
		List<MemberVO> result = new ArrayList<MemberVO>();
		int startIndex = pageNo * pageSize;
		List<TExtVidyoMember> list = tExtVidyoMemberDAO.searchMembers(tenantId,
				name, startIndex, pageSize);
		if (CommonUtil.isNullOrEmpty(list)) {
			return result;
		}
		for (TExtVidyoMember item : list) {
			MemberVO vo = new MemberVO();
			vo.setVidyoMember(item);
			result.add(vo);
		}
		return result;
	}

	public int countMembers(long tenantId, String name) throws ServiceException {
		return tExtVidyoMemberDAO.countMembers(tenantId, name);
	}

	public boolean updateMemberPasswordByTenant(long tenantId, long memberId,
			String newPassword) throws ServiceException {
		Integer memberId2 = Integer.valueOf(memberId + "");
		TExtVidyoMember member = tExtVidyoMemberDAO
				.selectByPrimaryKey(memberId2);
		if (member == null || member.getTenantId() == null) {
			throw new OperationRejectedException("");
		}
		if (tenantId != member.getTenantId().longValue()) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tExtVidyoTenantDAO.selectByPrimaryKey(member
				.getTenantId());
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		member.setPassword(newPassword);
		tExtVidyoMemberDAO.updateByPrimaryKeySelective(member);

		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members = VidyoPortalAdminServiceUtil
				.getMembers(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword(), null);
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member2 = getMatchedMember(
				members, member);
		boolean b = VidyoPortalAdminServiceUtil.updateMemberPassword(portalURL,
				tenant.getAdminName(), tenant.getAdminPassword(), newPassword,
				member2);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean updateMemberDisplayNameByTenant(long tenantId,
			long memberId, String displayName) throws ServiceException {
		Integer memberId2 = Integer.valueOf(memberId + "");
		TExtVidyoMember member = tExtVidyoMemberDAO
				.selectByPrimaryKey(memberId2);
		if (member == null || member.getTenantId() == null) {
			throw new OperationRejectedException("");
		}
		if (tenantId != member.getTenantId().longValue()) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tExtVidyoTenantDAO.selectByPrimaryKey(member
				.getTenantId());
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		member.setDisplayname(displayName);
		tExtVidyoMemberDAO.updateByPrimaryKeySelective(member);
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members = VidyoPortalAdminServiceUtil
				.getMembers(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword(), null);
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member2 = getMatchedMember(
				members, member);
		boolean b = VidyoPortalAdminServiceUtil.updateMemberDisplayName(
				portalURL, tenant.getAdminName(), tenant.getAdminPassword(),
				displayName, member2);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return b;
	}

	public boolean updateMemberPassword(long memberId, String password,
			String newPassword) throws ServiceException {
		Integer memberId2 = Integer.valueOf(memberId + "");
		TExtVidyoMember member = tExtVidyoMemberDAO
				.selectByPrimaryKey(memberId2);
		if (member == null || member.getTenantId() == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tExtVidyoTenantDAO.selectByPrimaryKey(member
				.getTenantId());
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		if (!password.equals(member.getPassword())) {
			throw new PasswordNotMatchesException("");
		}
		member.setPassword(newPassword);
		tExtVidyoMemberDAO.updateByPrimaryKeySelective(member);

		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members = VidyoPortalAdminServiceUtil
				.getMembers(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword(), null);
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member2 = getMatchedMember(
				members, member);
		boolean b = VidyoPortalAdminServiceUtil.updateMemberPassword(portalURL,
				tenant.getAdminName(), tenant.getAdminPassword(), newPassword,
				member2);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean updateMemberDisplayName(long memberId, String displayName)
			throws ServiceException {
		Integer memberId2 = Integer.valueOf(memberId + "");
		TExtVidyoMember member = tExtVidyoMemberDAO
				.selectByPrimaryKey(memberId2);
		if (member == null || member.getTenantId() == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tExtVidyoTenantDAO.selectByPrimaryKey(member
				.getTenantId());
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		member.setDisplayname(displayName);
		tExtVidyoMemberDAO.updateByPrimaryKeySelective(member);
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members = VidyoPortalAdminServiceUtil
				.getMembers(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword(), null);
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member2 = getMatchedMember(
				members, member);
		boolean b = VidyoPortalAdminServiceUtil.updateMemberDisplayName(
				portalURL, tenant.getAdminName(), tenant.getAdminPassword(),
				displayName, member2);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean updateTenantPassword(long tenantId, String password,
			String newPassword) throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null || CommonUtil.isNullOrEmpty(tenant.getUrl())) {
			throw new OperationRejectedException("");
		}
		TPortalInfoExample example = new TPortalInfoExample();
		example.createCriteria().andPortalUrlEqualTo(tenant.getUrl());
		List<TPortalInfo> portalInfos = tPortalInfoDAO
				.selectByExample(example);
		if (CommonUtil.isNullOrEmpty(portalInfos)) {
			throw new OperationRejectedException("");
		}
		TPortalInfo portalInfo = portalInfos.get(0);
		if (!password.equals(portalInfo.getAdminPassword())) {
			throw new PasswordNotMatchesException("");
		}
		Date now = new Date();
		portalInfo.setAdminPassword(newPassword);
		portalInfo.setUpdateTime(now);
		tPortalInfoDAO.updateByPrimaryKeySelective(portalInfo);
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean updateTenantDisplayName(long tenantId, String displayName)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null || CommonUtil.isNullOrEmpty(tenant.getUrl())) {
			throw new OperationRejectedException("");
		}
		TPortalInfoExample example = new TPortalInfoExample();
		example.createCriteria().andPortalUrlEqualTo(tenant.getUrl());
		List<TPortalInfo> portalInfos = tPortalInfoDAO
				.selectByExample(example);
		if (CommonUtil.isNullOrEmpty(portalInfos)) {
			throw new OperationRejectedException("");
		}
		TPortalInfo portalInfo = portalInfos.get(0);
		Date now = new Date();
		portalInfo.setDisplayName(displayName);
		portalInfo.setUpdateTime(now);
		tPortalInfoDAO.updateByPrimaryKeySelective(portalInfo);
		return true;
	}

	public TExtVidyoMember getMember(long memberId) throws ServiceException {
		return tExtVidyoMemberDAO.selectByPrimaryKey(new Long(memberId)
				.intValue());
	}

	public TExtVidyoTenant getTenantByMemberId(long memberId)
			throws ServiceException {
		TExtVidyoMember member = tExtVidyoMemberDAO
				.selectByPrimaryKey((int) memberId);
		if (member != null) {
			long tenantId = member.getTenantId();
			return tExtVidyoTenantDAO.selectByPrimaryKey(tenantId);
		}
		return null;
	}

	public TExtVidyoPortalConfig getPortalConfigByTenantId(long tenantId)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant != null) {
			long portalId = tenant.getPortalId();
			TExtVidyoPortal portal = tExtVidyoPortalDAO
					.selectByPrimaryKey(portalId);
			if (portal != null) {
				long referenceId = portal.getReferenceId();
				return tExtVidyoPortalConfigDAO.selectByPrimaryKey(referenceId);
			}
		}
		return null;
	}

	private String getRealPortalURL(long portalId) throws ServiceException {
		TExtVidyoPortal portal = tExtVidyoPortalDAO
				.selectByPrimaryKey(portalId);
		if (portal == null) {
			return null;
		}
		return portal.getPortalurl();
	}

	private com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member getMatchedMember(
			com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members,
			TExtVidyoMember member) {
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member result = null;
		if (!CommonUtil.isNullOrEmpty(members)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member item : members) {
				if (member.getName().equalsIgnoreCase(item.getName())) {
					result = item;
					break;
				}
			}
		}
		return result;
	}

}
