package com.vccloud.portal.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.db.model.TPortalInfo;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.vo.CdrVO;
import com.vccloud.portal.vo.ConferenceCall2VO;
import com.vccloud.portal.vo.EmailConfigVO;
import com.vccloud.portal.vo.LegacyVO;
import com.vccloud.portal.vo.MemberVO;
import com.vccloud.portal.vo.RoomProfileVO;
import com.vccloud.portal.vo.RoomVO;

public interface VidyoService {

	public List<ConferenceCall2VO> searchConferenceCall2s(String tenantName,
			String callerName, Date startTime, Date endTime,
			String orderByClause, int pageSize, int pageNo)
			throws ServiceException;

	public int countConferenceCall2s(String tenantName, String callerName,
			Date startTime, Date endTime) throws ServiceException;

	public void storePortalInfo(String portalUrl, String welcomeWord,
			DiskFileItem item) throws ServiceException;

	public TPortalInfo getPortalInfo(String portalUrl) throws ServiceException;

	public List<RoomVO> searchPublicRooms(long tenantId)
			throws ServiceException;

	public List<RoomVO> searchPersonalRooms(long memberId)
			throws ServiceException;

	public String getVidyoPortalURL(String userPortalURL)
			throws ServiceException;

	public boolean updateRoomName(long tenantId, long roomId, String name)
			throws ServiceException;

	public boolean removeRoomPin(long tenantId, long roomId)
			throws ServiceException;

	public boolean createRoomPin(long tenantId, long roomId, String pinCode)
			throws ServiceException;

	public boolean clearRoom(long tenantId, long roomId)
			throws ServiceException;

	public boolean addLegacy(String url, String name, String extension)
			throws ServiceException;

	public boolean updateLegacy(long id, String name, String extension)
			throws ServiceException;

	public List<LegacyVO> getLegacies(String url, String roomId)
			throws ServiceException;

	public boolean assignLegacies(String url, String roomId,
			List<Long> legacyIds) throws ServiceException;

	public boolean deleteLegacy(long id) throws ServiceException;

	public List<LegacyVO> searchLegacies(long tenantId, String keyword,
			int pageSize, int pageNo) throws ServiceException;

	public int countLegacies(long tenantId, String keyword)
			throws ServiceException;

	public RoomProfileVO getRoomProfile(long tenantId, int roomId)
			throws ServiceException;

	public boolean setRoomProfile(long tenantId, int roomId,
			String roomProfileName) throws ServiceException;

	public boolean removeRoomProfile(long tenantId, int roomId)
			throws ServiceException;

	public boolean resetRoomURL(long tenantId, int roomId)
			throws ServiceException;

	public List<CdrVO> searchCdrs(long portalId, long tenantId, long memberId,
			Date startTime, Date endTime, int pageSize, int pageNo)
			throws ServiceException;

	public int countCdrs(long portalId, long tenantId, long memberId,
			Date startTime, Date endTime) throws ServiceException;
	public List<EmailConfigVO> getEmailConfig(String url) throws ServiceException;

	public void storePortalEmailConfig(String portalUrl, String host,
			String email, String port, String password)throws ServiceException;

	public void sendEmail(String fromEmail, String userId, String password,
			String host, String port, String organizer, String attendees,
			String description, String startTime, String endTime, String subject,String location)throws ServiceException;

	public List<MemberVO> getEmails(String portalUrl)throws ServiceException;

	public RoomVO getRoomPin(String portalUrl,int roomId)throws ServiceException;

	public TExtVidyoTenant getTenant(long tenantId)throws ServiceException;

	public TExtVidyoMember getMember(long memberId)throws ServiceException;

	public TExtVidyoTenant getTenant(String portalUrl)throws ServiceException;

	public boolean createRoom(long tenantId, String description, String extension,
			String groupName, String name, String ownerName, String roomType,
			String roomPIN, String moderatorPIN)throws ServiceException;
	public boolean deleteRoom(long tenantId, int roomID)
	throws ServiceException;
}
