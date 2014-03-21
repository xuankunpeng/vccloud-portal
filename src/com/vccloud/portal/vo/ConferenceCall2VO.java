package com.vccloud.portal.vo;

import net.sf.json.JSONObject;

import com.vccloud.portal.db.model.Conferencecall2;
import com.vccloud.portal.util.CommonUtil;

public class ConferenceCall2VO {

	private Conferencecall2 conferencecall2;

	public Conferencecall2 getConferencecall2() {
		return conferencecall2;
	}

	public void setConferencecall2(Conferencecall2 conferencecall2) {
		this.conferencecall2 = conferencecall2;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		if (conferencecall2 == null) {
			return json;
		}
		json.put("CallID", conferencecall2.getCallid());
		json.put("UniqueCallID", CommonUtil.null2Empty(conferencecall2
				.getUniquecallid()));
		json.put("ConferenceName", CommonUtil.null2Empty(conferencecall2
				.getConferencename()));
		json.put("TenantName", CommonUtil.null2Empty(conferencecall2
				.getTenantname()));
		json.put("ConferenceType", CommonUtil.null2Empty(conferencecall2
				.getConferencetype()));
		json.put("EndpointType", CommonUtil.null2Empty(conferencecall2
				.getEndpointtype()));
		json.put("CallerID", CommonUtil.null2Empty(conferencecall2
				.getCallerid()));
		json.put("CallerName", CommonUtil.null2Empty(conferencecall2
				.getCallername()));
		json.put("JoinTime", CommonUtil.formatDate(conferencecall2
				.getJointime(), "yyyy-MM-dd HH:mm:ss"));
		json.put("LeaveTime", CommonUtil.formatDate(conferencecall2
				.getLeavetime(), "yyyy-MM-dd HH:mm:ss"));
		json.put("CallState", CommonUtil.null2Empty(conferencecall2
				.getCallstate()));
		json.put("Direction", CommonUtil.null2Empty(conferencecall2
				.getDirection()));
		json.put("RouterID", CommonUtil.null2Empty(conferencecall2
				.getRouterid()));
		json.put("GWID", CommonUtil.null2Empty(conferencecall2.getGwid()));
		json.put("GWPrefix", CommonUtil.null2Empty(conferencecall2
				.getGwprefix()));
		return json;
	}

}
