package com.vccloud.portal.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;

public class SignOutAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		long tenantId = getTenantId(request);
		long memberId = getMemberId(request);

		if (tenantId > 0) {
			clearLogon(request);
			clearTenant(request);
		} else if (memberId > 0) {
			clearLogon(request);
			clearMember(request);
		}
		return RESULT_OK;
	}

	private void clearLogon(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("isLogon");
		}
	}

	private void clearTenant(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("tenantId");
		}
	}

	private void clearMember(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("memberId");
		}
	}

}
