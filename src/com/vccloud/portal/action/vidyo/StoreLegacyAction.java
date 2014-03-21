package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.DuplicateLegacyNameException;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;

public class StoreLegacyAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String id = params.get("id");
		String url = params.get("url");
		String name = params.get("name");
		String extension = params.get("extension");

		try {
			long id2 = 0;
			if (!CommonUtil.isNullOrEmpty(id)) {
				id2 = Long.parseLong(id);
			}
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			if (id2 > 0) {
				vidyoService.updateLegacy(id2, name, extension);
			} else {
				vidyoService.addLegacy(url, name, extension);
			}
			return RESULT_OK;
		} catch (CallVidyoWebServiceException e) {
			logger.error("", e);
			return RESULT_ERR_VIDYO;
		} catch (OperationRejectedException e) {
			return RESULT_ERR_OPERATION_REJECTED;
		} catch (DuplicateLegacyNameException e) {
			return RESULT_ERR_DUPLICATE_LEGACY_NAME;
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
		String id = params.get("id");
		String url = params.get("url");
		String name = params.get("name");
		String extension = params.get("extension");

		long id2 = 0;

		if (!CommonUtil.isNullOrEmpty(id)) {
			try {
				id2 = Long.parseLong(id);
				if (id2 <= 0) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		if (CommonUtil.isNullOrEmpty(url)) {
			return false;
		}
		if (url.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(name)) {
			return false;
		}
		if (name.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(extension)) {
			return false;
		}
		if (extension.length() > 1024) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean isTenantRoleRequired() {
		return true;
	}

}
