package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.vo.MemberVO;
import com.vccloud.portal.vo.RoomVO;
/**
 * 
 * @author xuan
 *
 */
public class GetEmailsAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl=params.get("portalUrl");
		String roomId=params.get("roomId");
		String organizerName="";
		String organizerEmail="";
		//String content="";
		String roomName="";
		String roomPin="";
		String roomURL="";
		String guestUrl="";
		String roomKey="";
		String webURL="";
		try {
			int roomId2 = Integer.parseInt(roomId);
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			List<MemberVO> list = vidyoService.getEmails(portalUrl);
			JSONObject result = new JSONObject();
			result.put("result", "ok");
			long tenantId = super.getTenantId(request);
			if(tenantId>0){
				TExtVidyoTenant tenant=vidyoService.getTenant(tenantId);
				organizerName=tenant.getAdminName();
				organizerEmail="";
				result.put("organizerName", organizerName);
				result.put("organizerEmail", organizerEmail);
			}else{
				long memberId = getMemberId(request);
				TExtVidyoMember member=vidyoService.getMember(memberId);
				organizerName=member.getDisplayname();
				organizerEmail=member.getEmail();
				result.put("organizerName", organizerName);
				result.put("organizerEmail", organizerEmail);
			}
			RoomVO roomVO=vidyoService.getRoomPin(portalUrl,roomId2);
			roomURL=roomVO.getRoom().getRoomMode().getRoomURL();
			roomName=roomVO.getRoom().getName();
			webURL=vidyoService.getVidyoPortalURL(portalUrl);
			if(roomURL!=null){
				roomKey = roomURL.split("key=")[1];
				if(webURL.equals(portalUrl)){
					guestUrl = "http://u.seekoom.com/pc/?key="+roomKey+"&url="+portalUrl;
				}else{
					guestUrl = "http://"+portalUrl+"/pc/?key="+roomKey+"&url="+portalUrl;
				}
				if(roomVO.getRoom().getRoomMode().getRoomPIN()!=null){
					roomPin=roomVO.getRoom().getRoomMode().getRoomPIN();
				}
			}
			result.put("roomName", roomName);
			result.put("guestUrl", guestUrl);
			result.put("roomPin", roomPin);
			JSONArray ja = new JSONArray();
			if (!CommonUtil.isNullOrEmpty(list)) {
				for (MemberVO item : list) {
					ja.add(item.toJson());
				}
			}
			result.put("emails", ja);
			return result;
		} catch (ServiceException e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		}catch (Exception e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		}
	}
	@Override
	protected boolean validateInputs(Map<String, String> params) {
        String portalUrl=params.get("portalUrl");
        String roomId = params.get("roomId");
		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		if (portalUrl.length() > 1024) {
			return false;
		}
		if(!CommonUtil.isNullOrEmpty("roomId")){
			try {
				int roomId2 = Integer.parseInt(roomId);
				if (roomId2 <= 0) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
}
