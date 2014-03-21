package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.util.CommonUtil;

public class CdrVO {

	private long portalId;
	private long tenantId;
	private long memberId;
	private int timesCallin;
	private int timesCallout;
	private int durationCallin;
	private int durationCallout;
	private String name;

	public long getPortalId() {
		return portalId;
	}

	public void setPortalId(long portalId) {
		this.portalId = portalId;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public int getTimesCallin() {
		return timesCallin;
	}

	public void setTimesCallin(int timesCallin) {
		this.timesCallin = timesCallin;
	}

	public int getTimesCallout() {
		return timesCallout;
	}

	public void setTimesCallout(int timesCallout) {
		this.timesCallout = timesCallout;
	}

	public int getDurationCallin() {
		return durationCallin;
	}

	public void setDurationCallin(int durationCallin) {
		this.durationCallin = durationCallin;
	}

	public int getDurationCallout() {
		return durationCallout;
	}

	public void setDurationCallout(int durationCallout) {
		this.durationCallout = durationCallout;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("portalId", portalId);
		json.put("tenantId", tenantId);
		json.put("memberId", memberId);
		json.put("timesCallin", timesCallin);
		json.put("timesCallout", timesCallout);
		json.put("timesAll", timesCallin + timesCallout);
		json.put("durationCallin", durationCallin);
		json.put("durationCallout", durationCallout);
		json.put("durationAll", durationCallin + durationCallout);
		json.put("name", CommonUtil.null2Empty(name));
		return json;
	}

}
