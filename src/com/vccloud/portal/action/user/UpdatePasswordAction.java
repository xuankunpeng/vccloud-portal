package com.vccloud.portal.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.PasswordNotMatchesException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.UserService;
import com.vccloud.portal.util.CommonUtil;

public class UpdatePasswordAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		long memberId = getMemberId(request);
		long tenantId = getTenantId(request);
		String password = params.get("password");
		String newPassword = params.get("newPassword");

		try {
			UserService userService = ServiceLocator.getUserService();
			if (memberId > 0) {
				userService.updateMemberPassword(memberId, password,
						newPassword);
			} else if (tenantId > 0) {
				userService.updateTenantPassword(tenantId, password,
						newPassword);
			}
			return RESULT_OK;
		} catch (OperationRejectedException e) {
			return RESULT_ERR_OPERATION_REJECTED;
		} catch (PasswordNotMatchesException e) {
			return RESULT_ERR_PASSWORD_NOT_MATCHES;
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
		String password = params.get("password");
		String newPassword = params.get("newPassword");

		if (CommonUtil.isNullOrEmpty(password)) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(newPassword)) {
			return false;
		}
		return true;
	}

}
