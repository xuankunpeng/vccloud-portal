package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.UserService;
import com.vccloud.portal.service.VidyoService;

public class ClearRoomAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String roomId = params.get("roomId");

		try {
			long roomId2 = Long.parseLong(roomId);
			long tenantId = getTenantId(request);
			if (tenantId <= 0) {
				long memberId = getMemberId(request);
				UserService userService = ServiceLocator.getUserService();
				TExtVidyoMember member = userService.getMember(memberId);
				tenantId = member.getTenantId();
			}
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			vidyoService.clearRoom(tenantId, roomId2);
			return RESULT_OK;
		} catch (CallVidyoWebServiceException e) {
			logger.error("", e);
			return RESULT_ERR_VIDYO;
		} catch (OperationRejectedException e) {
			return RESULT_ERR_OPERATION_REJECTED;
		} catch (ServiceException e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		} catch (Exception e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		}
	}

	@Override
	protected boolean validateInputs(Map<String, String> params) {
		String roomId = params.get("roomId");

		try {
			long roomId2 = Long.parseLong(roomId);
			if (roomId2 <= 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
