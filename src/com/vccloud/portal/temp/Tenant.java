package com.vccloud.portal.temp;

import java.util.List;

public class Tenant {

	private String tenantURL;
	private String adminName;
	private String adminPassword;
	private List<Room> rooms;

	public String getTenantURL() {
		return tenantURL;
	}

	public void setTenantURL(String tenantURL) {
		this.tenantURL = tenantURL;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
