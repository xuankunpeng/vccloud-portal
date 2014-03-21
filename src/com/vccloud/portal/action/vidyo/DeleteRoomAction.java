package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;
/**
 * 
 * @author xuan
 *
 */
public class DeleteRoomAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl = params.get("portalUrl");
		String roomId = params.get("roomId");

		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			TExtVidyoTenant tenant = vidyoService.getTenant(portalUrl);
			Long tenantId = tenant.getId();
			int roomId2 = Integer.parseInt(roomId);
			vidyoService.deleteRoom(tenantId, roomId2);
			return RESULT_OK;
		} catch (OperationRejectedException e) {
			return RESULT_ERR_OPERATION_REJECTED;
		} catch (CallVidyoWebServiceException e) {
			logger.error("", e);
			return RESULT_ERR_VIDYO;
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
		String portalUrl = params.get("portalUrl");
		String roomId = params.get("roomId");

		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		if (portalUrl.length() > 1024) {
			return false;
		}
		try {
			int roomId2 = Integer.parseInt(roomId);
			if (roomId2 <= 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	protected boolean isOperatorRoleRequired() {
		return true;
	}

}
