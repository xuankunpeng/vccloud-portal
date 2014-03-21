package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.FileSizeExceededException;
import com.vccloud.portal.exception.FileTypeInvalidException;
import com.vccloud.portal.exception.LogoSizeExceededException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;

public class StorePortalInfoAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl = params.get("portalUrl");
		String welcomeWord = params.get("welcomeWord");

		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			DiskFileItem item = CommonUtil.isNullOrEmpty(diskFiles) ? null
					: diskFiles.get(0);
			vidyoService.storePortalInfo(portalUrl, welcomeWord, item);
			JSONObject result = new JSONObject();
			result.put("result", "ok");
			result.put("welcomeWord", CommonUtil.null2Empty(welcomeWord));
			return result;
		} catch (FileTypeInvalidException e) {
			return RESULT_ERR_FILE_TYPE_INVALID;
		} catch (LogoSizeExceededException e) {
			return RESULT_ERR_LOGO_SIZE_EXCEEDED;
		} catch (FileSizeExceededException e) {
			return RESULT_ERR_FILE_SIZE_EXCEEDED;
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
		String welcomeWord = params.get("welcomeWord");

		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		if (portalUrl.length() > 1024) {
			return false;
		}
		if (!CommonUtil.isNullOrEmpty(welcomeWord)) {
			if (welcomeWord.length() > 1024) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected boolean isTenantRoleRequired() {
		return true;
	}

}
