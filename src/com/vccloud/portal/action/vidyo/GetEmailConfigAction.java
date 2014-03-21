package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.vo.EmailConfigVO;
/**
 * 
 * @author xuan
 *
 */
public class GetEmailConfigAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String portalUrl = params.get("portalUrl");
		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			List<EmailConfigVO> list = vidyoService.getEmailConfig(portalUrl);
			JSONObject result = new JSONObject();
			result.put("result", "ok");
			JSONArray ja = new JSONArray();
			if (!CommonUtil.isNullOrEmpty(list)) {
				for (EmailConfigVO item : list) {
					ja.add(item.toJson());
				}
			}
			result.put("emailConfig", ja);
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
		String url = params.get("portalUrl");

		if (CommonUtil.isNullOrEmpty(url)) {
			return false;
		}
		if (url.length() > 1024) {
			return false;
		}
		return true;
	}

}
