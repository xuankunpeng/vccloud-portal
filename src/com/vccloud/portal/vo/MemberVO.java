package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.util.CommonUtil;

public class MemberVO {

	private TExtVidyoMember vidyoMember;

	public TExtVidyoMember getVidyoMember() {
		return vidyoMember;
	}

	public void setVidyoMember(TExtVidyoMember vidyoMember) {
		this.vidyoMember = vidyoMember;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		if (vidyoMember == null) {
			return json;
		}
		json.put("id", vidyoMember.getId());
		json.put("name", CommonUtil.null2Empty(vidyoMember.getName()));
		json.put("displayname", CommonUtil.null2Empty(vidyoMember
				.getDisplayname()));
		json.put("email",CommonUtil.null2Empty(vidyoMember.getEmail()));
		return json;
	}

}
