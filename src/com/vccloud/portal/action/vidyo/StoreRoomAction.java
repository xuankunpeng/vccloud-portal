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
import com.vccloud.portal.exception.DuplicateRoomExtensionException;
import com.vccloud.portal.exception.DuplicateRoomNameException;
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
public class StoreRoomAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl = params.get("portalUrl");
		String description = params.get("description");
		String extension = params.get("extension");
		String groupName = "Default";
		String name = params.get("name");
		String roomType = params.get("roomType");
		String roomPIN = params.get("roomPIN");
		String moderatorPIN = params.get("moderatorPIN");
		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			TExtVidyoTenant tenant = vidyoService.getTenant(portalUrl);
			Long tenantId = tenant.getId();
			String ownerName = tenant.getAdminName();
			String extension_prefix=tenant.getExtensionPrefix();
			extension=extension+extension_prefix;
			vidyoService
					.createRoom(tenantId, description, extension, groupName,
							name, ownerName, roomType, roomPIN, moderatorPIN);
			return RESULT_OK;
		} catch (OperationRejectedException e) {
			return RESULT_ERR_OPERATION_REJECTED;
		} catch (DuplicateRoomNameException e) {
			return RESULT_ERR_DUPLICATE_ROOM_NAME;
		} catch (DuplicateRoomExtensionException e) {
			return RESULT_ERR_DUPLICATE_ROOM_EXTENSION;
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
		String extension = params.get("extension");
		String name = params.get("name");
		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		if (portalUrl.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(name)) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(extension)) {
			return false;
		}
		return true;
	}

	protected boolean isOperatorRoleRequired() {
		return true;
	}

}
