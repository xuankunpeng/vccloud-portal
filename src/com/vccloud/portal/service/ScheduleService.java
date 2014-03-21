package com.vccloud.portal.service;

import java.util.List;

import com.vccloud.portal.temp.Tenant;

public interface ScheduleService {

	public void legacing();

	public void muteAudioAndVideo(List<Tenant> tenants);

	public void importCdr();

	public void importReport();

}
