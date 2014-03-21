package com.vccloud.portal.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.OperationRejectedException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.UserService;
import com.vccloud.portal.util.CommonUtil;

public class UpdateMemberDisplayNameAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		long tenantId = getTenantId(request);
		String memberId = params.get("memberId");
		String displayName = params.get("displayName");

		try {
			long memberId2 = Long.parseLong(memberId);
			UserService userService = ServiceLocator.getUserService();
			userService.updateMemberDisplayNameByTenant(tenantId, memberId2,
					displayName);
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
		String memberId = params.get("memberId");
		String displayName = params.get("displayName");

		try {
			long memberId2 = Long.parseLong(memberId);
			if (memberId2 <= 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		if (CommonUtil.isNullOrEmpty(displayName)) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean isTenantRoleRequired() {
		return true;
	}

}
