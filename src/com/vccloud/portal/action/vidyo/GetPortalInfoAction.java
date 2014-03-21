package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.db.model.TPortalInfo;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;

public class GetPortalInfoAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl = params.get("portalUrl");

		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			TPortalInfo portalInfo = vidyoService.getPortalInfo(portalUrl);
			JSONObject result = new JSONObject();
			result.put("result", "ok");
			result.put("portalUrl", portalUrl);
			if (portalInfo != null) {
				// result.put("logoUrl", portalInfo.getLogoUrl());
				result.put("welcomeWord", CommonUtil.null2Empty(portalInfo
						.getWelcomeWord()));
				result.put("acl", CommonUtil.null2Empty(portalInfo.getAcl()));
			}
			long memberId = getMemberId(request);
			long tenantId = getTenantId(request);
			if (memberId > 0) {
				result.put("role", "member");
			} else if (tenantId > 0) {
				result.put("role", "tenant");
			} else {
				result.put("role", "");
			}
			return result;
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

		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean isAuthnRequired() {
		return false;
	}

}
