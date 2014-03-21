package com.vccloud.portal.vo;

import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.db.model.TPortalInfo;

public class TenantAndPortalInfoVO {

	private TExtVidyoTenant tenant;
	private TPortalInfo portalInfo;

	public TExtVidyoTenant getTenant() {
		return tenant;
	}

	public void setTenant(TExtVidyoTenant tenant) {
		this.tenant = tenant;
	}

	public TPortalInfo getPortalInfo() {
		return portalInfo;
	}

	public void setPortalInfo(TPortalInfo portalInfo) {
		this.portalInfo = portalInfo;
	}

}
