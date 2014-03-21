package com.vccloud.portal.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.exception.AuthnFailedException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.UserService;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.vo.TenantAndPortalInfoVO;

public class SignInAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String username = params.get("username");
		String password = params.get("password");
		String portalUrl = params.get("portalUrl");

		try {
			TenantAndPortalInfoVO tenantAndPortalInfo = null;
			TExtVidyoMember member = null;
			UserService userService = ServiceLocator.getUserService();
			try {
				tenantAndPortalInfo = userService.signInByTenant(username,
						password, portalUrl);
			} catch (AuthnFailedException e1) {
				try {
					member = userService.signInByMember(username, password,
							portalUrl);
				} catch (AuthnFailedException e2) {
					logger.debug("Sign in failed, username: " + username
							+ ", password: " + password);
				}
			}
			if (tenantAndPortalInfo != null) {
				setLogon(request);
				setTenant(request, tenantAndPortalInfo.getTenant().getId());

				JSONObject result = new JSONObject();
				result.put("result", "ok");
				result.put("role", "tenant");
				result.put("displayname", tenantAndPortalInfo.getPortalInfo()
						.getDisplayName());
				return result;
			} else if (member != null) {
				setLogon(request);
				setMember(request, member.getId());

				JSONObject result = new JSONObject();
				result.put("result", "ok");
				result.put("role", "member");
				result.put("displayname", member.getDisplayname());
				return result;
			} else {
				return RESULT_ERR_AUTHN_FAILED;
			}
		} catch (ServiceException e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		} catch (Exception e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		}
	}

	@Override
	protected boolean isAuthnRequired() {
		return false;
	}

	@Override
	protected boolean validateInputs(Map<String, String> params) {
		String username = params.get("username");
		String password = params.get("password");
		String portalUrl = params.get("portalUrl");

		if (CommonUtil.isNullOrEmpty(username)) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(password)) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(portalUrl)) {
			return false;
		}
		return true;
	}

	private void setLogon(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String domain = getDomain(request);
		JSONObject json = new JSONObject();
		json.put(domain, true);
		session.setAttribute("isLogon", json);
	}

	private void setTenant(HttpServletRequest request, long tenantId) {
		HttpSession session = request.getSession(true);
		String domain = getDomain(request);
		JSONObject json = new JSONObject();
		json.put(domain, tenantId);
		session.setAttribute("tenantId", json);
	}

	private void setMember(HttpServletRequest request, long memberId) {
		HttpSession session = request.getSession(true);
		String domain = getDomain(request);
		JSONObject json = new JSONObject();
		json.put(domain, memberId);
		session.setAttribute("memberId", json);
	}

}
