package com.vccloud.portal.action.vidyo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.disk.DiskFileItem;

import com.vccloud.portal.action.BaseAction;
import com.vccloud.portal.db.model.TPortalEmailConfig;
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
public class SendEmailAction extends BaseAction{

	@Override
	public JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable {
		String attendees=params.get("attendees");
		String organizer=params.get("organizer");
		String description=params.get("description");
		String startTime=params.get("startTime");
		String endTime=params.get("endTime");
		String subject=params.get("subject");
		String portalUrl=params.get("portalUrl");
		String location=params.get("location");
		//Long tenantId=Long.parseLong(params.get("tenantId"));
		String fromEmail="";
		String userId="";
		String password="";
		String host="";
		String port="";
		
		try {
			
			VidyoService vidyoService = ServiceLocator.getVidyoService();
			List<EmailConfigVO> list = vidyoService.getEmailConfig(portalUrl);
			
			JSONObject result = new JSONObject();
			result.put("result", "ok");
			if (!CommonUtil.isNullOrEmpty(list)) {
				for (EmailConfigVO item : list) {
					TPortalEmailConfig emailConfig=item.getEmailConfig();
					String ee=emailConfig.getEmail();
					userId=ee.split("@")[0];
					fromEmail=ee;
					password=emailConfig.getPassword();
					host=emailConfig.getHost();
					port=emailConfig.getPort();
					
				}
			}
		vidyoService.sendEmail(fromEmail,userId,password,host,port,organizer,attendees
				,description,startTime,endTime,subject,location);	
		return result;
		} catch (ServiceException e) {
			logger.error("", e);
			return RESULT_ERR_SYS;
		}catch(Exception e){
			logger.error("", e);
			return RESULT_ERR_SYS;
		}
		//return null;
	}
	@Override
	protected boolean validateInputs(Map<String, String> params) {
		String attendees=params.get("attendees");
		String organizer=params.get("organizer");
		String description=params.get("description");
		String startTime=params.get("startTime");
		String endTime=params.get("endTime");
		String subject=params.get("subject");
		String portalUrl=params.get("portalUrl");
		//String tenantId=params.get("tenantId");
		String location=params.get("location");
		if(CommonUtil.isNullOrEmpty(attendees)){
			return false;
		}
		if(attendees.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(organizer)){
			return false;
		}
		if(organizer.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(description)){
			return false;
		}
		if(description.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(startTime)){
			return false;
		}
		if(startTime.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(endTime)){
			return false;
		}
		if(endTime.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(subject)){
			return false;
		}
		if(subject.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(portalUrl)){
			return false;
		}
		if(portalUrl.length()>1024){
			return false;
		}
		if(CommonUtil.isNullOrEmpty(location)){
			return false;
		}
		if(location.length()>1024){
			return false;
		}
//		if (CommonUtil.isNullOrEmpty(tenantId)) {
//			return false;
//		}
//		if (tenantId.length() > 1024) {
//			return false;
//		}
		return true;
	}
}
