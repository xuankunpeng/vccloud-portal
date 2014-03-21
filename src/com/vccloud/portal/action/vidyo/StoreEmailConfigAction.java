package com.vccloud.portal.action.vidyo;

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
/**
 * 
 * @author xuan
 *
 */
public class StoreEmailConfigAction extends BaseAction{

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl=params.get("portalUrl");
		String host=params.get("host");
		String email=params.get("email");
		String port=params.get("port");
		String password=params.get("password");
		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			vidyoService.storePortalEmailConfig(portalUrl,host,email,port,password);
			JSONObject result=new JSONObject();
			result.put("result", "ok");
			result.put("host",CommonUtil.null2Empty(host));
			result.put("email", CommonUtil.null2Empty(email));
			result.put("port", CommonUtil.null2Empty(port));
			result.put("password",CommonUtil.null2Empty(password));
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
		String portalUrl = params.get("portalUrl");
		String host=params.get("host");
		String email=params.get("email");
		String port=params.get("port");
		String password=params.get("password");

		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		if (portalUrl.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(host)) {
			return false;
		}
		if (host.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(email)) {
			return false;
		}
		if (email.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(port)) {
			return false;
		}
		if (port.length() > 1024) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(password)) {
			return false;
		}
		if (password.length() > 1024) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean isTenantRoleRequired() {
		return true;
	}

}
