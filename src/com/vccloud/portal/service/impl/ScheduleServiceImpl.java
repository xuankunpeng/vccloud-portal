package com.vccloud.portal.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vccloud.portal.db.model.Conferencecall2;
import com.vccloud.portal.db.model.TCdr;
import com.vccloud.portal.db.model.TExtVidyoMember;
import com.vccloud.portal.db.model.TExtVidyoMemberExample;
import com.vccloud.portal.db.model.TExtVidyoPortal;
import com.vccloud.portal.db.model.TExtVidyoPortalExample;
import com.vccloud.portal.db.model.TExtVidyoTenant;
import com.vccloud.portal.db.model.TExtVidyoTenantExample;
import com.vccloud.portal.db.model.TLegacy;
import com.vccloud.portal.db.model.TLegacyExample;
import com.vccloud.portal.db.model.TReport;
import com.vccloud.portal.service.ScheduleService;
import com.vccloud.portal.temp.Room;
import com.vccloud.portal.temp.T;
import com.vccloud.portal.temp.Tenant;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.util.PortalConfig;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceUtil;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceUtil;

public class ScheduleServiceImpl extends ServiceDefault implements
		ScheduleService {

	private Logger logger = Logger.getLogger(ScheduleServiceImpl.class);

	@SuppressWarnings("unchecked")
	public void legacing() {
		TExtVidyoTenantExample tExtVidyoTenantExample = new TExtVidyoTenantExample();
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(tExtVidyoTenantExample);
		if (CommonUtil.isNullOrEmpty(tenants)) {
			return;
		}
		// Filter tenants.
		TLegacyExample tLegacyExample = new TLegacyExample();
		tLegacyExample.createCriteria().andRoomIdIsNotNull()
				.andRoomIdNotEqualTo("");
		List<TLegacy> legacies = tLegacyDAO
				.selectByExample(tLegacyExample);
		if (CommonUtil.isNullOrEmpty(legacies)) {
			return;
		}
		List<TExtVidyoTenant> tenants2 = new ArrayList<TExtVidyoTenant>();
		for (TExtVidyoTenant tenant : tenants) {
			for (TLegacy legacy : legacies) {
				if (legacy.getUrl() != null
						&& legacy.getUrl().equalsIgnoreCase(tenant.getUrl())) {
					tenants2.add(tenant);
					break;
				}
			}
		}
		tenants = tenants2;

		List<Long> portalIds = new ArrayList<Long>();
		for (TExtVidyoTenant item : tenants) {
			portalIds.add(item.getPortalId());
		}
		TExtVidyoPortalExample tExtVidyoPortalExample = new TExtVidyoPortalExample();
		tExtVidyoPortalExample.createCriteria().andIdIn(portalIds);
		List<TExtVidyoPortal> portals = tExtVidyoPortalDAO
				.selectByExample(tExtVidyoPortalExample);
		if (CommonUtil.isNullOrEmpty(portals)) {
			return;
		}
		Map<Long, TExtVidyoPortal> portalMaps = new HashMap<Long, TExtVidyoPortal>();
		for (TExtVidyoPortal item : portals) {
			portalMaps.put(item.getId(), item);
		}

		List<T> list = new ArrayList<T>();
		for (TExtVidyoTenant item : tenants) {
			T t = new T();
			t.setAdminName(item.getAdminName());
			t.setAdminPassword(item.getAdminPassword());
			t.setWebURL(item.getUrl());
			String portalURL = "";
			if (portalMaps.get(item.getPortalId()) != null) {
				portalURL = portalMaps.get(item.getPortalId()).getPortalurl();
			}
			t.setPortalURL(portalURL);
			list.add(t);
		}

		for (T t : list) {
			try {
				legacing(t);
			} catch (Throwable e) {
				logger
						.error("==================> ScheduleServiceImpl.legacing() caught exception, [ adminName: "
								+ t.getAdminName()
								+ ", adminPassword: "
								+ t.getAdminPassword()
								+ ", portalURL: "
								+ t.getPortalURL()
								+ ", webURL: "
								+ t.getWebURL() + " ]");
				logger.error("", e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void legacing(T t) throws Throwable {
		com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0[] rooms = VidyoPortalUserServiceUtil
				.searchPublicRooms(t.getPortalURL(), t.getAdminName(), t
						.getAdminPassword());
		if (CommonUtil.isNullOrEmpty(rooms)) {
			return;
		}
		for (com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0 room : rooms) {
			com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0[] participants = null;
			try {
				participants = VidyoPortalUserServiceUtil.getParticipants(t
						.getPortalURL(), t.getAdminName(),
						t.getAdminPassword(), room.getEntityID());
			} catch (Throwable e) {
				continue;
			}
			if (CommonUtil.isNullOrEmpty(participants)) {
				continue;
			}
			List<String> legacyExtensionsInConference = new ArrayList<String>();
			for (com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0 participant : participants) {
				if (com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityType_type0.Legacy
						.getValue().equalsIgnoreCase(
								participant.getEntityType().getValue())) {
					legacyExtensionsInConference
							.add(participant.getExtension());
				}
			}
			if (legacyExtensionsInConference.size() == participants.length) {
				// Legacy踢出会议室
				for (com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0 participant : participants) {
					com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityID participantID = new com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityID();
					participantID.setEntityID(String.valueOf(participant
							.getParticipantID()));
					try {
						VidyoPortalUserServiceUtil.leaveConference(t
								.getPortalURL(), t.getAdminName(), t
								.getAdminPassword(), room.getEntityID(),
								participantID);
					} catch (Throwable e) {
						continue;
					}
				}
			} else {
				// Legacy拉进会议室
				TLegacyExample tLegacyExample = new TLegacyExample();
				tLegacyExample.createCriteria().andRoomIdEqualTo(
						room.getEntityID().getEntityID()).andUrlEqualTo(
						t.getWebURL());
				List<TLegacy> legaciesInDB = tLegacyDAO
						.selectByExample(tLegacyExample);
				if (CommonUtil.isNullOrEmpty(legaciesInDB)) {
					continue;
				}
				for (TLegacy legacy : legaciesInDB) {
					if (!legacyExtensionsInConference.contains(legacy
							.getLegacyExtension())) {
						com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0[] arr = null;
						try {
							arr = VidyoPortalUserServiceUtil.searchLegacies(t
									.getPortalURL(), t.getAdminName(), t
									.getAdminPassword(), legacy
									.getLegacyExtension());
						} catch (Throwable e) {
							continue;
						}
						if (!CommonUtil.isNullOrEmpty(arr)) {
							com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0 targetLegacy = arr[0];
							for (com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0 item : arr) {
								if (legacy.getLegacyExtension()
										.equalsIgnoreCase(item.getExtension())) {
									targetLegacy = item;
									break;
								}
							}
							try {
								VidyoPortalUserServiceUtil.inviteToConference(t
										.getPortalURL(), t.getAdminName(), t
										.getAdminPassword(),
										room.getEntityID(), targetLegacy
												.getEntityID(), targetLegacy
												.getExtension());
							} catch (Throwable e) {
								continue;
							}
						}
					}
				}
			}
		}
	}

	public void muteAudioAndVideo(List<Tenant> tenants) {
		if (!CommonUtil.isNullOrEmpty(tenants)) {
			for (Tenant tenant : tenants) {
				try {
					muteAudioAndVideo(tenant);
				} catch (Throwable t) {
					logger.error("", t);
				}
			}
		}
	}

	private void muteAudioAndVideo(Tenant tenant) {
		String tenantURL = tenant.getTenantURL();
		String adminName = tenant.getAdminName();
		String adminPassword = tenant.getAdminPassword();
		List<Room> rooms = tenant.getRooms();
		if (!CommonUtil.isNullOrEmpty(rooms)) {
			for (Room room : rooms) {
				int roomID = room.getRoomID();
				List<Integer> ignoreIDs = room.getIgnoreIDs();
				boolean muteAudio = room.isMuteAudio();
				boolean muteVideo = room.isMuteVideo();
				try {
					com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Entity_type0[] participants = VidyoPortalAdminServiceUtil
							.getParticipants(tenantURL, adminName,
									adminPassword, roomID);
					if (!CommonUtil.isNullOrEmpty(participants)) {
						for (com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Entity_type0 item : participants) {
							int participantID = item.getEntityID()
									.getEntityID();
							if (!ignoreIDs.contains(participantID)) {
								boolean isAudioAvailable = item.getAudio();
								boolean isVideoAvailable = item.getVideo();
								if (muteAudio && isAudioAvailable) {
									try {
										VidyoPortalAdminServiceUtil.muteAudio(
												tenantURL, adminName,
												adminPassword, roomID, item
														.getParticipantID()
														.getEntityID());
									} catch (Throwable e) {
										logger.error("", e);
									}
								}
								if (muteVideo && isVideoAvailable) {
									try {
										VidyoPortalAdminServiceUtil.stopVideo(
												tenantURL, adminName,
												adminPassword, roomID, item
														.getParticipantID()
														.getEntityID());
									} catch (Throwable e) {
										logger.error("", e);
									}
								}
							}
						}
					}
				} catch (Throwable e) {
					logger.error("", e);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void importCdr() {
		List<Date> dates = getDates4Cdr();
		if (CommonUtil.isNullOrEmpty(dates)) {
			return;
		}

		long portalConfigId = PortalConfig.getPortalConfigId();
		TExtVidyoPortalExample example = new TExtVidyoPortalExample();
		example.createCriteria().andReferenceIdEqualTo(portalConfigId);
		List<TExtVidyoPortal> portals = tExtVidyoPortalDAO
				.selectByExample(example);
		Map<Long, TExtVidyoPortal> portalMaps = new HashMap<Long, TExtVidyoPortal>();
		for (TExtVidyoPortal portal : portals) {
			portalMaps.put(portal.getId(), portal);
		}
		TExtVidyoTenantExample example2 = new TExtVidyoTenantExample();
		example2.createCriteria().andPortalIdIn(
				new ArrayList<Long>(portalMaps.keySet()));
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(example2);
		Map<Long, TExtVidyoTenant> tenantMaps = new HashMap<Long, TExtVidyoTenant>();
		for (TExtVidyoTenant tenant : tenants) {
			tenantMaps.put(tenant.getId(), tenant);
		}
		TExtVidyoMemberExample example3 = new TExtVidyoMemberExample();
		example3.createCriteria().andTenantIdIn(
				new ArrayList<Long>(tenantMaps.keySet()));
		List<TExtVidyoMember> members = tExtVidyoMemberDAO
				.selectByExample(example3);
		Map<Integer, TExtVidyoMember> memberMaps = new HashMap<Integer, TExtVidyoMember>();
		for (TExtVidyoMember member : members) {
			memberMaps.put(member.getId(), member);
		}

		for (Date date : dates) {
			for (TExtVidyoMember member : memberMaps.values()) {
				// Init cdr.
				TCdr cdr = new TCdr();
				cdr.setPortalId(portalConfigId);
				cdr.setTenantId(member.getTenantId());
				cdr.setMemberId(new Long(member.getId()));
				cdr.setDate(date);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				long year = cal.get(Calendar.YEAR);
				long month = cal.get(Calendar.MONTH) + 1;
				long day = cal.get(Calendar.DAY_OF_MONTH);
				long week = cal.get(Calendar.WEEK_OF_YEAR);
				cdr.setYear(year);
				cdr.setMonth(month);
				cdr.setDay(day);
				cdr.setWeek(week);
				cdr.setTimesCallin(0L);
				cdr.setDurationCallin(0L);
				cdr.setTimesCallout(0L);
				cdr.setDurationCallout(0L);
				long cdrId = tCdrDAO.insertSelective(cdr);
				// Feed data.
				TExtVidyoTenant tenant = tenantMaps.get(member.getTenantId());
				List<Conferencecall2> conferencecalls = conferencecall2DAO
						.searchConferenceCall2s4Cdr(tenant.getName(), member
								.getName(), CommonUtil.getStart(date),
								CommonUtil.getEnd(date));
				if (!CommonUtil.isNullOrEmpty(conferencecalls)) {
					long timesCallin = 0;
					long durationCallin = 0;
					long timesCallout = 0;
					long durationCallout = 0;
					for (Conferencecall2 conferencecall : conferencecalls) {
						if ("I".equalsIgnoreCase(conferencecall.getDirection())) {
							timesCallin++;
							durationCallin += getConferenceTimeInMinutes(conferencecall);
						} else if ("O".equalsIgnoreCase(conferencecall
								.getDirection())) {
							timesCallout++;
							durationCallout += getConferenceTimeInMinutes(conferencecall);
						}
					}
					cdr = new TCdr();
					cdr.setId(cdrId);
					cdr.setTimesCallin(timesCallin);
					cdr.setDurationCallin(durationCallin);
					cdr.setTimesCallout(timesCallout);
					cdr.setDurationCallout(durationCallout);
					tCdrDAO.updateByPrimaryKeySelective(cdr);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// Ignore.
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void importReport() {
		List<Date> dates = getDates4Report();
		if (CommonUtil.isNullOrEmpty(dates)) {
			return;
		}

		long portalConfigId = PortalConfig.getPortalConfigId();
		TExtVidyoPortalExample example = new TExtVidyoPortalExample();
		example.createCriteria().andReferenceIdEqualTo(portalConfigId);
		List<TExtVidyoPortal> portals = tExtVidyoPortalDAO
				.selectByExample(example);
		Map<Long, TExtVidyoPortal> portalMaps = new HashMap<Long, TExtVidyoPortal>();
		for (TExtVidyoPortal portal : portals) {
			portalMaps.put(portal.getId(), portal);
		}
		TExtVidyoTenantExample example2 = new TExtVidyoTenantExample();
		example2.createCriteria().andPortalIdIn(
				new ArrayList<Long>(portalMaps.keySet()));
		List<TExtVidyoTenant> tenants = tExtVidyoTenantDAO
				.selectByExample(example2);
		Map<Long, TExtVidyoTenant> tenantMaps = new HashMap<Long, TExtVidyoTenant>();
		for (TExtVidyoTenant tenant : tenants) {
			tenantMaps.put(tenant.getId(), tenant);
		}

		for (Date date : dates) {
			for (TExtVidyoTenant tenant : tenantMaps.values()) {
				TReport report = new TReport();
				report.setPortalId(portalConfigId);
				report.setTenantId(tenant.getId());
				report.setDate(date);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				long year = cal.get(Calendar.YEAR);
				long month = cal.get(Calendar.MONTH) + 1;
				long day = cal.get(Calendar.DAY_OF_MONTH);
				long week = cal.get(Calendar.WEEK_OF_YEAR);
				report.setYear(year);
				report.setMonth(month);
				report.setDay(day);
				report.setWeek(week);
				report.setQuarter1(0L);
				report.setQuarter2(0L);
				report.setQuarter3(0L);
				report.setQuarter4(0L);
				for (int hour = 0; hour < 24; hour++) {
					report.setId(null);
					report.setHour(new Long(hour));
					// Init report.
					long reportId = tReportDAO.insertSelective(report);
					// Feed data.
					cal.set(Calendar.HOUR_OF_DAY, hour);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					Date quarter0 = cal.getTime(); // 0 minute
					cal.add(Calendar.MINUTE, 15);
					Date quarter1 = cal.getTime(); // 15 minute
					cal.add(Calendar.MINUTE, 15);
					Date quarter2 = cal.getTime(); // 30 minute
					cal.add(Calendar.MINUTE, 15);
					Date quarter3 = cal.getTime(); // 45 minute
					cal.add(Calendar.MINUTE, 15);
					Date quarter4 = cal.getTime(); // 60 minute
					int count1 = conferencecall2DAO
							.countConferenceCall2s4Report(tenant.getName(),
									quarter0, quarter1);
					int count2 = conferencecall2DAO
							.countConferenceCall2s4Report(tenant.getName(),
									quarter1, quarter2);
					int count3 = conferencecall2DAO
							.countConferenceCall2s4Report(tenant.getName(),
									quarter2, quarter3);
					int count4 = conferencecall2DAO
							.countConferenceCall2s4Report(tenant.getName(),
									quarter3, quarter4);
					TReport report2 = new TReport();
					report2.setId(reportId);
					report2.setQuarter1(new Long(count1));
					report2.setQuarter2(new Long(count2));
					report2.setQuarter3(new Long(count3));
					report2.setQuarter4(new Long(count4));
					tReportDAO.updateByPrimaryKeySelective(report2);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// Ignore.
				}
			}
		}
	}

	private List<Date> getDates4Cdr() {
		List<Date> dates = new ArrayList<Date>();
		long portalConfigId = PortalConfig.getPortalConfigId();
		Date latestImportTime = tCdrDAO.getLatestImportTime(portalConfigId);
		Date now = new Date();
		if (latestImportTime == null) {
			dates.add(now);
		} else {
			long timeIntervalInMilliseconds = now.getTime()
					- latestImportTime.getTime();
			long oneDayInMilliseconds = 24 * 60 * 60 * 1000;
			long timeIntervalInDays = timeIntervalInMilliseconds
					/ oneDayInMilliseconds;
			if (timeIntervalInDays > 0) {
				for (long i = timeIntervalInDays; i > 0; i--) {
					dates.add(now);
					Calendar cal = Calendar.getInstance();
					cal.setTime(now);
					cal.add(Calendar.DATE, -1);
					now = cal.getTime();
				}
				Collections.reverse(dates);
			}
		}
		return dates;
	}

	private long getConferenceTimeInMinutes(Conferencecall2 conferencecall) {
		Date joinTime = conferencecall.getJointime();
		Date leaveTime = conferencecall.getLeavetime();
		if (joinTime != null && leaveTime != null) {
			long timeIntervalInMilliseconds = leaveTime.getTime()
					- joinTime.getTime();
			long oneMinuteInMilliseconds = 60 * 1000;
			long minutes = (long) Math.ceil((double) timeIntervalInMilliseconds
					/ (double) oneMinuteInMilliseconds);
			return minutes;
		} else {
			return 0;
		}
	}

	private List<Date> getDates4Report() {
		List<Date> dates = new ArrayList<Date>();
		long portalConfigId = PortalConfig.getPortalConfigId();
		Date latestImportTime = tReportDAO.getLatestImportTime(portalConfigId);
		Date now = new Date();
		if (latestImportTime == null) {
			dates.add(now);
		} else {
			long timeIntervalInMilliseconds = now.getTime()
					- latestImportTime.getTime();
			long oneDayInMilliseconds = 24 * 60 * 60 * 1000;
			long timeIntervalInDays = timeIntervalInMilliseconds
					/ oneDayInMilliseconds;
			if (timeIntervalInDays > 0) {
				for (long i = timeIntervalInDays; i > 0; i--) {
					dates.add(now);
					Calendar cal = Calendar.getInstance();
					cal.setTime(now);
					cal.add(Calendar.DATE, -1);
					now = cal.getTime();
				}
				Collections.reverse(dates);
			}
		}
		return dates;
	}

}
