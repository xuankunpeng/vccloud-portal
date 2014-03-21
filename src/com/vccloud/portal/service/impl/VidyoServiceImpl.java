package com.vccloud.portal.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.log4j.Logger;

import com.vccloud.portal.constant.Constants;
import com.vccloud.portal.db.model.Conferencecall2;
import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.db.model.TExtVidyoMemberExample;
import com.vccloud.portal.db.model.TExtVidyoPortal;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.db.model.TExtVidyoTenantExample;
import com.vccloud.portal.db.model.TLegacy;
import com.vccloud.portal.db.model.TLegacyExample;
import com.vccloud.portal.db.model.TPortalEmailConfig;
import com.vccloud.portal.db.model.TPortalEmailConfigExample;
import com.vccloud.portal.db.model.TPortalInfo;
import com.vccloud.portal.db.model.TPortalInfoExample;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.DuplicateLegacyNameException;
import com.vccloud.portal.exception.DuplicateRoomExtensionException;
import com.vccloud.portal.exception.DuplicateRoomNameException;
import com.vccloud.portal.exception.FileSizeExceededException;
import com.vccloud.portal.exception.FileTypeInvalidException;
import com.vccloud.portal.exception.LogoSizeExceededException;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.util.UploadUtil;
import com.vccloud.portal.util.UploadUtil.IMAGE_TYPE;
import com.vccloud.portal.vo.CdrVO;
import com.vccloud.portal.vo.ConferenceCall2VO;
import com.vccloud.portal.vo.EmailConfigVO;
import com.vccloud.portal.vo.LegacyVO;
import com.vccloud.portal.vo.MemberVO;
import com.vccloud.portal.vo.RoomProfileVO;
import com.vccloud.portal.vo.RoomVO;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceUtil;

public class VidyoServiceImpl extends ServiceDefault implements VidyoService {

	private Logger logger = Logger.getLogger(VidyoServiceImpl.class);

	public List<ConferenceCall2VO> searchConferenceCall2s(String tenantName,
			String callerName, Date startTime, Date endTime,
			String orderByClause, int pageSize, int pageNo)
			throws ServiceException {
		List<ConferenceCall2VO> result = new ArrayList<ConferenceCall2VO>();
		int startIndex = pageNo * pageSize;
		List<Conferencecall2> list = conferencecall2DAO.searchConferenceCall2s(
				tenantName, callerName, startTime, endTime, orderByClause,
				startIndex, pageSize);
		if (CommonUtil.isNullOrEmpty(list)) {
			return result;
		}
		for (Conferencecall2 item : list) {
			ConferenceCall2VO vo = new ConferenceCall2VO();
			vo.setConferencecall2(item);
			result.add(vo);
		}
		return result;
	}

	public int countConferenceCall2s(String tenantName, String callerName,
			Date startTime, Date endTime) throws ServiceException {
		return conferencecall2DAO.countConferenceCall2s(tenantName, callerName,
				startTime, endTime);
	}

	public void storePortalInfo(String portalUrl, String welcomeWord,
			DiskFileItem item) throws ServiceException {
		String suffix = "";
		if (item != null && item.getSize() > 0) {
			String fileName = item.getName();
			if (CommonUtil.isNullOrEmpty(fileName)) {
				throw new FileTypeInvalidException("");
			}
			String[] arr = fileName.split("\\.");
			if (arr.length > 1) {
				suffix = "." + arr[arr.length - 1].toLowerCase();
			} else {
				throw new FileTypeInvalidException("");
			}
			/**
			 * <pre>
			 * if (!UploadUtil.checkLogoFileSuffix(suffix)) {
			 * 	throw new FileTypeInvalidException(&quot;&quot;);
			 * }
			 * </pre>
			 */
			if (!UploadUtil.checkLogoFileSize(item.getSize())) {
				throw new FileSizeExceededException("");
			}
		}

		TPortalInfo test = getPortalInfo(portalUrl);
		Date now = new Date();
		long id = 0;
		if (test == null) {
			TPortalInfo portalInfo = new TPortalInfo();
			portalInfo.setPortalUrl(portalUrl);
			portalInfo.setWelcomeWord(welcomeWord);
			portalInfo.setCreateTime(now);
			portalInfo.setUpdateTime(now);
			id = tPortalInfoDAO.insertSelective(portalInfo);
		} else {
			TPortalInfo portalInfo = new TPortalInfo();
			portalInfo.setId(test.getId());
			portalInfo.setPortalUrl(portalUrl);
			portalInfo.setWelcomeWord(welcomeWord);
			portalInfo.setUpdateTime(now);
			tPortalInfoDAO.updateByPrimaryKeySelective(portalInfo);
			id = test.getId();
		}
		test = tPortalInfoDAO.selectByPrimaryKey(id);

		if (item != null && item.getSize() > 0) {
			uploadLogoFile(item, id, suffix);
			String logoUrl = UploadUtil.getLogoFileName(id, suffix,
					IMAGE_TYPE.ORIGINAL);
			TPortalInfo portalInfo = new TPortalInfo();
			portalInfo.setId(id);
			portalInfo.setLogoUrl(logoUrl);
			portalInfo.setUpdateTime(now);
			tPortalInfoDAO.updateByPrimaryKeySelective(portalInfo);
		}
	}

	@SuppressWarnings("unchecked")
	public TPortalInfo getPortalInfo(String portalUrl) throws ServiceException {
		TPortalInfoExample example = new TPortalInfoExample();
		example.createCriteria().andPortalUrlEqualTo(portalUrl);
		List<TPortalInfo> list = tPortalInfoDAO.selectByExample(example);
		if (CommonUtil.isNullOrEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	public List<RoomVO> searchPublicRooms(long tenantId)
			throws ServiceException {
		List<RoomVO> result = new ArrayList<RoomVO>();
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			return result;
		}
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room[] rooms = VidyoPortalAdminServiceUtil
				.getRooms(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword());
		if (!CommonUtil.isNullOrEmpty(rooms)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room room : rooms) {
				if ("Public".equalsIgnoreCase(room.getRoomType().getValue())) {
					RoomVO vo = new RoomVO();
					vo.setRoom(room);
					result.add(vo);
				}
			}
		}
		return result;
	}

	public List<RoomVO> searchPersonalRooms(long memberId)
			throws ServiceException {
		List<RoomVO> result = new ArrayList<RoomVO>();
		int memberId2 = new Long(memberId).intValue();
		TExtVidyoMember member = tExtVidyoMemberDAO
				.selectByPrimaryKey(memberId2);
		if (member == null) {
			return result;
		}
		TExtVidyoTenant tenant = tExtVidyoTenantDAO.selectByPrimaryKey(member
				.getTenantId());
		if (tenant == null) {
			return result;
		}
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room[] rooms = VidyoPortalAdminServiceUtil
				.getRooms(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword());
		if (!CommonUtil.isNullOrEmpty(rooms)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room room : rooms) {
				if ("Personal".equalsIgnoreCase(room.getRoomType().getValue())
						&& member.getName().equalsIgnoreCase(
								room.getOwnerName())) {
					RoomVO vo = new RoomVO();
					vo.setRoom(room);
					result.add(vo);
				}
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public String getVidyoPortalURL(String userPortalURL)
			throws ServiceException {
		if (CommonUtil.isNullOrEmpty(userPortalURL)) {
			return null;
		}
		TExtVidyoTenantExample example = new TExtVidyoTenantExample();
		example.createCriteria().andUrlEqualTo(userPortalURL);
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(example);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			return null;
		}
		TExtVidyoTenant tenant = tenants.get(0);
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			return null;
		}
		return portal.getPortalurl();
	}

	public boolean updateRoomName(long tenantId, long roomId, String name)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		int roomId2 = new Long(roomId).intValue();
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room room = null;
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room[] rooms = VidyoPortalAdminServiceUtil
				.getRooms(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword());
		if (!CommonUtil.isNullOrEmpty(rooms)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room item : rooms) {
				if (name.equalsIgnoreCase(item.getName())
						&& roomId != item.getRoomID().getEntityID()) {
					throw new DuplicateRoomNameException("");
				}
				if (roomId2 == item.getRoomID().getEntityID()) {
					room = item;
				}
			}
		}
		if (room == null) {
			throw new OperationRejectedException("");
		}
		boolean b = VidyoPortalAdminServiceUtil.updateRoomName(portalURL,
				tenant.getAdminName(), tenant.getAdminPassword(), name, room);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean removeRoomPin(long tenantId, long roomId)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		int roomId2 = new Long(roomId).intValue();
		String portalURL = getRealPortalURL(tenant.getPortalId());
		boolean b = VidyoPortalAdminServiceUtil.removeRoomPIN(portalURL, tenant
				.getAdminName(), tenant.getAdminPassword(), roomId2);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean createRoomPin(long tenantId, long roomId, String pinCode)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		int roomId2 = new Long(roomId).intValue();
		String portalURL = getRealPortalURL(tenant.getPortalId());
		boolean b = VidyoPortalAdminServiceUtil.createRoomPIN(portalURL, tenant
				.getAdminName(), tenant.getAdminPassword(), roomId2, pinCode);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean clearRoom(long tenantId, long roomId)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		int roomId2 = new Long(roomId).intValue();
		String portalURL = getRealPortalURL(tenant.getPortalId());

		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Entity_type0[] participants = VidyoPortalAdminServiceUtil
				.getParticipants(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword(), roomId2);
		if (!CommonUtil.isNullOrEmpty(participants)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Entity_type0 item : participants) {
				try {
					VidyoPortalAdminServiceUtil.leaveConference(portalURL,
							tenant.getAdminName(), tenant.getAdminPassword(),
							roomId2, item.getParticipantID().getEntityID());
				} catch (Exception e) {
					// Continue! Maybe some participant has already left the
					// conference.
				}
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean addLegacy(String url, String name, String extension)
			throws ServiceException {
		TLegacyExample tLegacyExample = new TLegacyExample();
		tLegacyExample.createCriteria().andUrlEqualTo(url)
				.andLegacyNameEqualTo(name);
		List<TLegacy> test = tLegacyDAO.selectByExample(tLegacyExample);
		if (!CommonUtil.isNullOrEmpty(test)) {
			throw new DuplicateLegacyNameException("");
		}
		TExtVidyoTenantExample tExtVidyoTenantExample = new TExtVidyoTenantExample();
		tExtVidyoTenantExample.createCriteria().andUrlEqualTo(url);
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(tExtVidyoTenantExample);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tenants.get(0);
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}

		TLegacy legacy = new TLegacy();
		Date now = new Date();
		legacy.setUrl(url);
		legacy.setLegacyName(name);
		legacy.setLegacyExtension(extension);
		legacy.setRoomId("");
		legacy.setCreateTime(now);
		legacy.setUpdateTime(now);
		tLegacyDAO.insertSelective(legacy);

		String adminName = tenant.getAdminName();
		String adminPassword = tenant.getAdminPassword();
		String portalurl = portal.getPortalurl();
		boolean b = VidyoPortalAdminServiceUtil.addLegacy(portalurl, adminName,
				adminPassword, name, extension);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean updateLegacy(long id, String name, String extension)
			throws ServiceException {
		TLegacy legacy = tLegacyDAO.selectByPrimaryKey(id);
		if (legacy == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenantExample tExtVidyoTenantExample = new TExtVidyoTenantExample();
		tExtVidyoTenantExample.createCriteria().andUrlEqualTo(legacy.getUrl());
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(tExtVidyoTenantExample);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tenants.get(0);
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}
		String adminName = tenant.getAdminName();
		String adminPassword = tenant.getAdminPassword();
		String portalurl = portal.getPortalurl();
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member = getLegacy(
				portalurl, adminName, adminPassword, name);
		if (member == null) {
			throw new OperationRejectedException("");
		}

		Date now = new Date();
		legacy.setLegacyExtension(extension);
		legacy.setUpdateTime(now);
		tLegacyDAO.updateByPrimaryKeySelective(legacy);

		member.setExtension(extension);
		boolean b = VidyoPortalAdminServiceUtil.updateLegacy(portalurl,
				adminName, adminPassword, member.getMemberID(), member);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<LegacyVO> getLegacies(String url, String roomId)
			throws ServiceException {
		List<LegacyVO> result = new ArrayList<LegacyVO>();
		TLegacyExample example = new TLegacyExample();
		example.createCriteria().andUrlEqualTo(url).andRoomIdEqualTo(roomId);
		List<TLegacy> list = tLegacyDAO.selectByExample(example);
		if (!CommonUtil.isNullOrEmpty(list)) {
			for (TLegacy item : list) {
				LegacyVO vo = new LegacyVO();
				vo.setLegacy(item);
				result.add(vo);
			}
		}
		return result;
	}

	public boolean assignLegacies(String url, String roomId,
			List<Long> legacyIds) throws ServiceException {
		Date now = new Date();
		TLegacyExample example = new TLegacyExample();
		example.createCriteria().andUrlEqualTo(url).andRoomIdEqualTo(roomId);
		TLegacy legacy = new TLegacy();
		legacy.setRoomId("");
		legacy.setUpdateTime(now);
		tLegacyDAO.updateByExampleSelective(legacy, example);
		if (!CommonUtil.isNullOrEmpty(legacyIds)) {
			example = new TLegacyExample();
			example.createCriteria().andIdIn(legacyIds);
			legacy = new TLegacy();
			legacy.setRoomId(roomId);
			legacy.setUpdateTime(now);
			tLegacyDAO.updateByExampleSelective(legacy, example);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteLegacy(long id) throws ServiceException {
		TLegacy legacy = tLegacyDAO.selectByPrimaryKey(id);
		if (legacy == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenantExample tExtVidyoTenantExample = new TExtVidyoTenantExample();
		tExtVidyoTenantExample.createCriteria().andUrlEqualTo(legacy.getUrl());
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(tExtVidyoTenantExample);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tenants.get(0);
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}
		String adminName = tenant.getAdminName();
		String adminPassword = tenant.getAdminPassword();
		String portalurl = portal.getPortalurl();
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member = getLegacy(
				portalurl, adminName, adminPassword, legacy.getLegacyName());
		if (member == null) {
			throw new OperationRejectedException("");
		}
		tLegacyDAO.deleteByPrimaryKey(id);

		boolean b = VidyoPortalAdminServiceUtil.deleteMember(portalurl,
				adminName, adminPassword, member.getMemberID().getEntityID());
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public List<LegacyVO> searchLegacies(long tenantId, String keyword,
			int pageSize, int pageNo) throws ServiceException {
		List<LegacyVO> result = new ArrayList<LegacyVO>();
		int startIndex = pageNo * pageSize;
		List<TLegacy> list = tLegacyDAO.searchLegacies(tenantId, keyword,
				startIndex, pageSize);
		if (CommonUtil.isNullOrEmpty(list)) {
			return result;
		}
		for (TLegacy item : list) {
			LegacyVO vo = new LegacyVO();
			vo.setLegacy(item);
			result.add(vo);
		}
		return result;
	}

	public int countLegacies(long tenantId, String keyword)
			throws ServiceException {
		return tLegacyDAO.countLegacies(tenantId, keyword);
	}

	public RoomProfileVO getRoomProfile(long tenantId, int roomId)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID roomID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
		roomID2.setEntityID(roomId);
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomProfile roomProfile = VidyoPortalAdminServiceUtil
				.getRoomProfile(portal.getPortalurl(), tenant.getAdminName(),
						tenant.getAdminPassword(), roomID2);
		RoomProfileVO vo = new RoomProfileVO();
		vo.setRoomProfile(roomProfile);
		return vo;
	}

	public boolean setRoomProfile(long tenantId, int roomId,
			String roomProfileName) throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID roomID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
		roomID2.setEntityID(roomId);
		boolean b = VidyoPortalAdminServiceUtil.setRoomProfile(portal
				.getPortalurl(), tenant.getAdminName(), tenant
				.getAdminPassword(), roomID2, roomProfileName);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean removeRoomProfile(long tenantId, int roomId)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID roomID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
		roomID2.setEntityID(roomId);
		boolean b = VidyoPortalAdminServiceUtil.removeRoomProfile(portal
				.getPortalurl(), tenant.getAdminName(), tenant
				.getAdminPassword(), roomID2);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public boolean resetRoomURL(long tenantId, int roomId)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		TExtVidyoPortal portal = tExtVidyoPortalDAO.selectByPrimaryKey(tenant
				.getPortalId());
		if (portal == null) {
			throw new OperationRejectedException("");
		}
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID roomID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
		roomID2.setEntityID(roomId);
		boolean b = VidyoPortalAdminServiceUtil.removeRoomURL(portal
				.getPortalurl(), tenant.getAdminName(), tenant
				.getAdminPassword(), roomID2);
		boolean b2 = VidyoPortalAdminServiceUtil.createRoomURL(portal
				.getPortalurl(), tenant.getAdminName(), tenant
				.getAdminPassword(), roomID2);
		if (!b || !b2) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	public List<CdrVO> searchCdrs(long portalId, long tenantId, long memberId,
			Date startTime, Date endTime, int pageSize, int pageNo)
			throws ServiceException {
		int startIndex = pageNo * pageSize;
		if (portalId > 0) {
			if (tenantId > 0) {
				if (memberId > 0) {
					// Only this member.
					List<CdrVO> cdrs = tCdrDAO.searchCdrsByMemberId(portalId,
							tenantId, memberId, startTime, endTime, startIndex,
							pageSize);
					return feedName4CdrsAsMember(cdrs);
				} else {
					// Members belongs to this tenant.
					List<CdrVO> cdrs = tCdrDAO.searchCdrsByTenantId(portalId,
							tenantId, startTime, endTime, startIndex, pageSize);
					return feedName4CdrsAsMember(cdrs);
				}
			} else {
				// Tenants belongs to this portal.
				List<CdrVO> cdrs = tCdrDAO.searchCdrsByPortalId(portalId,
						startTime, endTime, startIndex, pageSize);
				return feedName4CdrsAsTenant(cdrs);
			}
		} else {
			// All tenants.
			List<CdrVO> cdrs = tCdrDAO.searchCdrsAll(startTime, endTime,
					startIndex, pageSize);
			return feedName4CdrsAsTenant(cdrs);
		}
	}

	public int countCdrs(long portalId, long tenantId, long memberId,
			Date startTime, Date endTime) throws ServiceException {
		if (portalId > 0) {
			if (tenantId > 0) {
				if (memberId > 0) {
					return tCdrDAO.countCdrsByMemberId(portalId, tenantId,
							memberId, startTime, endTime);
				} else {
					return tCdrDAO.countCdrsByTenantId(portalId, tenantId,
							startTime, endTime);
				}
			} else {
				return tCdrDAO
						.countCdrsByPortalId(portalId, startTime, endTime);
			}
		} else {
			return tCdrDAO.countCdrsAll(startTime, endTime);
		}
	}

	private String getRealPortalURL(long portalId) throws ServiceException {
		TExtVidyoPortal portal = tExtVidyoPortalDAO
				.selectByPrimaryKey(portalId);
		if (portal == null) {
			return null;
		}
		return portal.getPortalurl();
	}

	private void uploadLogoFile(DiskFileItem item, long id, String suffix)
			throws ServiceException {
		String logoDir = UploadUtil.getLogoDir(id);
		String logoFilePath = UploadUtil.getLogoFilePath(id, suffix,
				IMAGE_TYPE.ORIGINAL);
		try {
			File dir = new File(logoDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(logoFilePath);
			item.write(file);

			checkLogoFile(file);
		} catch (LogoSizeExceededException e) {
			File file = new File(logoFilePath);
			file.delete();
			throw e;
		} catch (FileTypeInvalidException e) {
			File file = new File(logoFilePath);
			file.delete();
			throw e;
		} catch (Throwable t) {
			logger.error("Upload logo fail, id : " + id
					+ ". DB will roll back!", t);
			throw new ServiceException("");
		}
	}

	/**
	 * 校验长宽，并暗中包含判断文件是否为图片的逻辑。
	 * 
	 * @param file
	 * @throws ServiceException
	 */
	private void checkLogoFile(File file) throws ServiceException {
		InputStream is = null;
		BufferedImage src = null;
		try {
			is = new FileInputStream(file);
			src = ImageIO.read(is);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			if (width > Constants.LogoMaxSize.WIDTH
					|| height > Constants.LogoMaxSize.HEIGHT) {
				throw new LogoSizeExceededException("");
			}
		} catch (IOException e) {
			throw new FileTypeInvalidException("");
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

	private com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member getLegacy(
			String portalURL, String username, String password, String name)
			throws ServiceException {
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member member = null;
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member[] members = VidyoPortalAdminServiceUtil
				.getMembers(portalURL, username, password, name);
		if (!CommonUtil.isNullOrEmpty(members)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member item : members) {
				if (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoleName_type0.Legacy
						.getValue().equalsIgnoreCase(
								item.getRoleName().getValue())
						&& name.equalsIgnoreCase(item.getName())) {
					member = item;
					break;
				}
			}
		}
		return member;
	}

	@SuppressWarnings("unchecked")
	private List<CdrVO> feedName4CdrsAsMember(List<CdrVO> cdrs) {
		List<CdrVO> result = new ArrayList<CdrVO>();
		if (!CommonUtil.isNullOrEmpty(cdrs)) {
			Set<Long> memberIds = new HashSet<Long>();
			for (CdrVO cdr : cdrs) {
				memberIds.add(cdr.getMemberId());
			}
			TExtVidyoMemberExample example = new TExtVidyoMemberExample();
			example.createCriteria().andIdIn(new ArrayList(memberIds));
			List<TExtVidyoMember> members = tExtVidyoMemberDAO
					.selectByExample(example);
			Map<Long, TExtVidyoMember> memberMap = new HashMap<Long, TExtVidyoMember>();
			if (!CommonUtil.isNullOrEmpty(members)) {
				for (TExtVidyoMember member : members) {
					memberMap.put(new Long(member.getId()), member);
				}
			}
			for (CdrVO cdr : cdrs) {
				long memberId = cdr.getMemberId();
				TExtVidyoMember member = memberMap.get(memberId);
				if (member != null) {
					cdr.setName(member.getDisplayname());
				}
				result.add(cdr);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private List<CdrVO> feedName4CdrsAsTenant(List<CdrVO> cdrs) {
		List<CdrVO> result = new ArrayList<CdrVO>();
		if (!CommonUtil.isNullOrEmpty(cdrs)) {
			Set<Long> tenantIds = new HashSet<Long>();
			for (CdrVO cdr : cdrs) {
				tenantIds.add(cdr.getTenantId());
			}
			TExtVidyoTenantExample example = new TExtVidyoTenantExample();
			example.createCriteria().andIdIn(new ArrayList(tenantIds));
			List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
					.selectByExample(example);
			Map<Long, TExtVidyoTenant> tenantMap = new HashMap<Long, TExtVidyoTenant>();
			if (!CommonUtil.isNullOrEmpty(tenants)) {
				for (TExtVidyoTenant tenant : tenants) {
					tenantMap.put(tenant.getId(), tenant);
				}
			}
			for (CdrVO cdr : cdrs) {
				long tenantId = cdr.getTenantId();
				TExtVidyoTenant tenant = tenantMap.get(tenantId);
				if (tenant != null) {
					cdr.setName(tenant.getName());
				}
				result.add(cdr);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<EmailConfigVO> getEmailConfig(String portalUrl)
			throws ServiceException {
		List<EmailConfigVO> result = new ArrayList<EmailConfigVO>();
		TPortalEmailConfigExample example = new TPortalEmailConfigExample();
		example.createCriteria().andPortalUrlEqualTo(portalUrl);
		List<TPortalEmailConfig> list = tPortalEmailConfigDAO
				.selectByExample(example);
		if (!CommonUtil.isNullOrEmpty(list)) {
			for (TPortalEmailConfig item : list) {
				EmailConfigVO vo = new EmailConfigVO();
				vo.setEmailConfig(item);
				result.add(vo);
			}
		}
		return result;

	}

	public void storePortalEmailConfig(String portalUrl, String host,
			String email, String port, String password) throws ServiceException {
		List<EmailConfigVO> emailConfig1 = getEmailConfig(portalUrl);
		if (CommonUtil.isNullOrEmpty(emailConfig1)) {
			TPortalEmailConfig emailConfig = new TPortalEmailConfig();
			emailConfig.setEmail(email);
			emailConfig.setHost(host);
			emailConfig.setPassword(password);
			emailConfig.setPort(port);
			emailConfig.setPortalUrl(portalUrl);
			tPortalEmailConfigDAO.insertSelective(emailConfig);
		} else {
			for (EmailConfigVO emailConfigVO : emailConfig1) {
				TPortalEmailConfig emailConfig = emailConfigVO.getEmailConfig();
				TPortalEmailConfig emailConfig2 = new TPortalEmailConfig();
				emailConfig2.setEmail(email);
				emailConfig2.setHost(host);
				emailConfig2.setPassword(password);
				emailConfig2.setPort(port);
				emailConfig2.setPortalUrl(portalUrl);
				emailConfig2.setId(emailConfig.getId());
				tPortalEmailConfigDAO.updateByPrimaryKeySelective(emailConfig2);
			}
		}

	}

	@SuppressWarnings("deprecation")
	public void sendEmail(String fromEmail, final String userId,
			final String password, String host, String port, String organizer,
			String attendees, String description, String startTime,
			String endTime, String subject, String location)
			throws ServiceException {
		try {
			Properties props = new Properties();
			try {
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", port);

			} catch (Exception e) {
				e.printStackTrace();
			}
			Authenticator authenticator = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userId, password);
				}
			};
			Session session;
			session = Session.getInstance(props, authenticator);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			String[] toEmail = attendees.split(";");
			for (String attende : toEmail) {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(attende));
			}
			message.setSubject(subject);
			StringBuffer buffer = new StringBuffer();
			buffer.append("BEGIN:VCALENDAR\n");
			buffer.append("VERSION:2.0\n");
			buffer.append("METHOD:REQUEST\n");
			buffer.append("BEGIN:VEVENT\n");
			for (String attende : toEmail) {
				buffer.append("ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:mailto:"
						+ attende + "\n");
			}
			buffer.append("CLASS:PUBLIC\n");
			buffer.append("CREATED:"/* +str */+ "\n");
			buffer.append("DESCRIPTION:" + description + "\n");
			buffer.append("DTEND:" + endTime + "\n");
			buffer.append("DTSTAMP:"/* +str */+ "\n");
			buffer.append("DTSTART:" + startTime + "\n");
			buffer.append("ORGANIZER;CN=\"\":mailto:" + organizer + "\n");
			buffer.append("SEQUENCE:0\n");
			buffer.append("UID:" + UUID.randomUUID().toString() + "\n");
			buffer.append("LOCATION:" + location + "\n");
			buffer.append("SUMMARY;LANGUAGE=en-cn:" + subject + "\n");
			buffer.append("BEGIN:VALARM\n");
			buffer.append("TRIGGER:-PT720M\n");
			buffer.append("ACTION:DISPLAY\n");
			buffer.append("DESCRIPTION:Reminder\n");
			buffer.append("END:VALARM\n");
			buffer.append("END:VEVENT\n");
			buffer.append("END:VCALENDAR\n");

			BodyPart messageBodyPart = new MimeBodyPart();
			byte[] b = buffer.toString().getBytes("UTF-8");
			// 测试下来如果不这么转换的话，会以纯文本的形式发送过去，
			// 如果没有method=REQUEST;charset=\"UTF-8\"，outlook会议附件的形式存在，而不是直接打开就是一个会议请求
			messageBodyPart.setDataHandler(new DataHandler(
					new ByteArrayDataSource(new ByteArrayInputStream(b),
							"text/calendar;method=REQUEST;charset=\"UTF-8\"")));

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException me) {
			me.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<MemberVO> getEmails(String portalUrl) throws ServiceException {
		List<MemberVO> result = new ArrayList<MemberVO>();
		TExtVidyoTenantExample example1 = new TExtVidyoTenantExample();
		example1.createCriteria().andUrlEqualTo(portalUrl);
		List<TExtVidyoTenant> tenants = (List<TExtVidyoTenant>) tExtVidyoTenantDAO
				.selectByExample(example1);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			return result;
		}
		TExtVidyoTenant tenant = tenants.get(0);
		Long tenantId = tenant.getId();
		TExtVidyoMemberExample example = new TExtVidyoMemberExample();
		example.createCriteria().andTenantIdEqualTo(tenantId);
		List<TExtVidyoMember> list = (List<TExtVidyoMember>) tExtVidyoMemberDAO
				.selectByExample(example);
		if (!CommonUtil.isNullOrEmpty(list)) {
			for (TExtVidyoMember item : list) {
				MemberVO vo = new MemberVO();
				vo.setVidyoMember(item);
				result.add(vo);
			}
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	public RoomVO getRoomPin(String portalUrl, int roomId)

	throws ServiceException {

		RoomVO result = new RoomVO();
		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return null;
		}
		TExtVidyoTenantExample example = new TExtVidyoTenantExample();
		example.createCriteria().andUrlEqualTo(portalUrl);
		List<TExtVidyoTenant> tenants = (List<TExtVidyoTenant>) tExtVidyoTenantDAO
				.selectByExample(example);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			return null;
		}
		TExtVidyoTenant tenant = tenants.get(0);
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room room = VidyoPortalAdminServiceUtil
				.getRoom(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword(), roomId);
		if (!(room == null)) {
			result.setRoom(room);
		}
		return result;

	}

	public TExtVidyoTenant getTenant(long tenantId) throws ServiceException {
		return tExtVidyoTenantDAO.selectByPrimaryKey(tenantId);
	}

	public TExtVidyoMember getMember(long memberId) throws ServiceException {
		return tExtVidyoMemberDAO.selectByPrimaryKey((int) memberId);
	}

	/**
	 * @author xuan
	 */
	@SuppressWarnings("unchecked")
	public TExtVidyoTenant getTenant(String portalUrl) throws ServiceException {
		TExtVidyoTenantExample tExtVidyoTenantExample = new TExtVidyoTenantExample();
		tExtVidyoTenantExample.createCriteria().andUrlEqualTo(portalUrl);
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(tExtVidyoTenantExample);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			throw new OperationRejectedException("");
		}
		TExtVidyoTenant tenant = tenants.get(0);
		return tenant;
	}

	/**
	 * @author xuan
	 */
	public boolean createRoom(long tenantId, String description,
			String extension, String groupName, String name, String ownerName,
			String roomType, String roomPIN, String moderatorPIN)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		String portalURL = getRealPortalURL(tenant.getPortalId());
		com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room[] rooms = VidyoPortalAdminServiceUtil
				.getRooms(portalURL, tenant.getAdminName(), tenant
						.getAdminPassword());
		if (!CommonUtil.isNullOrEmpty(rooms)) {
			for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room item : rooms) {
				if (name.equalsIgnoreCase(item.getName())) {
					throw new DuplicateRoomNameException("");
				}
				if (extension.equalsIgnoreCase(item.getExtension())) {
					throw new DuplicateRoomExtensionException("");
				}
			}
		}
		boolean b = VidyoPortalAdminServiceUtil.addRoom(portalURL, tenant
				.getAdminName(), tenant.getAdminPassword(), description,
				extension, groupName, name, ownerName, roomType, roomPIN,
				moderatorPIN);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

	/**
	 * @author xuan
	 */
	public boolean deleteRoom(long tenantId, int roomID)
			throws ServiceException {
		TExtVidyoTenant tenant = tExtVidyoTenantDAO
				.selectByPrimaryKey(tenantId);
		if (tenant == null) {
			throw new OperationRejectedException("");
		}
		String portalURL = getRealPortalURL(tenant.getPortalId());
		boolean b = VidyoPortalAdminServiceUtil.deleteRoom(portalURL, tenant
				.getAdminName(), tenant.getAdminPassword(), roomID);
		if (!b) {
			throw new CallVidyoWebServiceException("");
		}
		return true;
	}

}
