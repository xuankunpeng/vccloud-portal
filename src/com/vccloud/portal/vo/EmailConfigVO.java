package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.db.model.TPortalEmailConfig;
import com.vccloud.portal.util.CommonUtil;

public class EmailConfigVO {


	private TPortalEmailConfig emailConfig;

	

	public TPortalEmailConfig getEmailConfig() {
		return emailConfig;
	}



	public void setEmailConfig(TPortalEmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}



	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		if (emailConfig == null) {
			return json;
		}
		json.put("host", emailConfig.getHost());
		json.put("port", CommonUtil.null2Empty(emailConfig.getPort()));
		json.put("email", CommonUtil
				.null2Empty(emailConfig.getEmail()));
		json.put("password", CommonUtil.null2Empty(emailConfig.getPassword()));
		return json;
	}


}
