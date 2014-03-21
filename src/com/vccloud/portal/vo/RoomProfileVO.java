package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomProfile;

public class RoomProfileVO {

	private RoomProfile roomProfile;

	public RoomProfile getRoomProfile() {
		return roomProfile;
	}

	public void setRoomProfile(RoomProfile roomProfile) {
		this.roomProfile = roomProfile;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		if (roomProfile == null) {
			return json;
		}
		json.put("roomProfileName", CommonUtil.null2Empty(roomProfile
				.getRoomProfileName()));
		json.put("description", CommonUtil.null2Empty(roomProfile
				.getDescription()));
		return json;
	}

}
