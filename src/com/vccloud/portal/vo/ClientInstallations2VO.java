package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.db.model.Clientinstallations2;
import com.vccloud.portal.util.CommonUtil;

public class ClientInstallations2VO {

	private Clientinstallations2 clientinstallations2;

	public Clientinstallations2 getClientinstallations2() {
		return clientinstallations2;
	}

	public void setClientinstallations2(
			Clientinstallations2 clientinstallations2) {
		this.clientinstallations2 = clientinstallations2;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		if (clientinstallations2 == null) {
			return json;
		}
		json.put("userName", CommonUtil.null2Empty(clientinstallations2
				.getUsername()));
		json.put("displayName", CommonUtil.null2Empty(clientinstallations2
				.getDisplayname()));
		json.put("tenantName", CommonUtil.null2Empty(clientinstallations2
				.getTenantname()));
		json.put("EID", CommonUtil.null2Empty(clientinstallations2.getEid()));
		json.put("ipAddress", CommonUtil.null2Empty(clientinstallations2
				.getIpaddress()));
		json.put("hostName", CommonUtil.null2Empty(clientinstallations2
				.getHostname()));
		json.put("roomName", CommonUtil.null2Empty(clientinstallations2
				.getRoomname()));
		json.put("roomOwner", CommonUtil.null2Empty(clientinstallations2
				.getRoomowner()));
		json.put("timeinstalled", CommonUtil.formatDate(clientinstallations2
				.getTimeinstalled(), "yyyy-MM-dd HH:mm:ss"));
		return json;
	}

}
