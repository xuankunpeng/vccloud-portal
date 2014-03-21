package com.vccloud.portal.action.vidyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;

public class AssignLegaciesAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String url = params.get("url");
		String roomId = params.get("roomId");
		String legacyIds = params.get("legacyIds");

		try {
			List<Long> legacyIds2 = new ArrayList<Long>();
			if (!CommonUtil.isNullOrEmpty(legacyIds)) {
				String[] arr = legacyIds.split(",");
				for (String item : arr) {
					legacyIds2.add(Long.parseLong(item));
				}
			}
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			vidyoService.assignLegacies(url, roomId, legacyIds2);
			return RESULT_OK;
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
		String url = params.get("url");
		String roomId = params.get("roomId");
		String legacyIds = params.get("legacyIds");

		List<Long> legacyIds2 = new ArrayList<Long>();

		if (CommonUtil.isNullOrEmpty(url)) {
			return false;
		}
		if (url.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(roomId)) {
			return false;
		}
		if (roomId.length() > 1024) {
			return false;
		}
		if (!CommonUtil.isNullOrEmpty(legacyIds)) {
			String[] arr = legacyIds.split(",");
			try {
				for (String item : arr) {
					legacyIds2.add(Long.parseLong(item));
				}
			} catch (NumberFormatException e) {
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
