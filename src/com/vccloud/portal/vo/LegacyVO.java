package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.db.model.TLegacy;
import com.vccloud.portal.util.CommonUtil;

public class LegacyVO {

	private TLegacy legacy;

	public TLegacy getLegacy() {
		return legacy;
	}

	public void setLegacy(TLegacy legacy) {
		this.legacy = legacy;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		if (legacy == null) {
			return json;
		}
		json.put("id", legacy.getId());
		json.put("name", CommonUtil.null2Empty(legacy.getLegacyName()));
		json.put("extension", CommonUtil
				.null2Empty(legacy.getLegacyExtension()));
		return json;
	}

}
