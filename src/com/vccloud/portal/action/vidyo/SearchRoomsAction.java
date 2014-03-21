package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.vo.RoomVO;

public class SearchRoomsAction extends BaseAction {

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		try {
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			List<RoomVO> list;
			long tenantId = super.getTenantId(request);
			if (tenantId > 0) {
				list = vidyoService.searchPublicRooms(tenantId);
			} else {
				long memberId = super.getMemberId(request);
				list = vidyoService.searchPersonalRooms(memberId);
			}
			JSONObject result = new JSONObject();
			result.put("result", "ok");
			JSONArray ja = new JSONArray();
			if (!CommonUtil.isNullOrEmpty(list)) {
				for (RoomVO item : list) {
					ja.add(item.toJson());
				}
			}
			result.put("list", ja);
			return result;
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

}
