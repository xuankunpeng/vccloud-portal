package com.vccloud.portal.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.temp.Room;
import com.vccloud.portal.temp.Tenant;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.util.XmlUtil;

public class MuteAudioAndVideoListener implements ServletContextListener {

	private static Logger logger = Logger
			.getLogger(MuteAudioAndVideoListener.class);

	public static final String filePath = MuteAudioAndVideoListener.class
			.getResource("/").getFile()
			+ "/startup.xml";

	private Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		try {
			List<Element> elements = XmlUtil.getRootElements(filePath);
			String enable = elements.get(0).getStringValue();
			String period = elements.get(1).getStringValue();
			if (Boolean.valueOf(enable)) {
				timer.schedule(new MyTask(), 0, Long.parseLong(period));
			}
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		timer = null;
	}

	private class MyTask extends TimerTask {
		@Override
		public void run() {
			logger.info("==================> MuteAudioAndVideo task start.");
			long start = System.currentTimeMillis();
			try {
				List<Tenant> tenants = genTenants();
				ServiceLocator.getScheduleService().muteAudioAndVideo(tenants);
			} catch (Throwable t) {
				logger.error("", t);
			}
			logger
					.info("==================> MuteAudioAndVideo task ended, costs "
							+ (System.currentTimeMillis() - start) + " ms.");
		}
	}

	@SuppressWarnings("unchecked")
	private List<Tenant> genTenants() throws Exception {
		List<Tenant> tenants = new ArrayList<Tenant>();
		List<Element> elements = XmlUtil.getRootElements(filePath);
		for (int i = 2; i < elements.size(); i++) {
			Element tenant = elements.get(i);
			String tenantURL = tenant.element("TenantURL").getStringValue();
			String adminName = tenant.element("AdminName").getStringValue();
			String adminPassword = tenant.element("AdminPassword")
					.getStringValue();
			List<Room> rooms = new ArrayList<Room>();
			List<Element> elements2 = tenant.elements();
			for (int j = 3; j < elements2.size(); j++) {
				Element room = elements2.get(j);
				String roomID = room.element("RoomId").getStringValue();
				String ignoreIDs = room.element("IgnoreId").getStringValue();
				String muteAudio = room.element("MuteAudio").getStringValue();
				String muteVideo = room.element("MuteVideo").getStringValue();
				List<Integer> ignoreIDs2 = new ArrayList<Integer>();
				if (!CommonUtil.isNullOrEmpty(ignoreIDs)) {
					String[] arr = ignoreIDs.split(";");
					for (String item : arr) {
						ignoreIDs2.add(Integer.valueOf(item));
					}
				}
				Room room2 = new Room();
				room2.setRoomID(Integer.valueOf(roomID));
				room2.setIgnoreIDs(ignoreIDs2);
				room2.setMuteAudio(Boolean.valueOf(muteAudio));
				room2.setMuteVideo(Boolean.valueOf(muteVideo));
				rooms.add(room2);
			}
			Tenant tenant2 = new Tenant();
			tenant2.setTenantURL(tenantURL);
			tenant2.setAdminName(adminName);
			tenant2.setAdminPassword(adminPassword);
			tenant2.setRooms(rooms);
			tenants.add(tenant2);
		}
		return tenants;
	}

	public static void main(String[] args) {
		try {
			MuteAudioAndVideoListener test = new MuteAudioAndVideoListener();
			List<Tenant> tenants = test.genTenants();
			ServiceLocator.getScheduleService().muteAudioAndVideo(tenants);
		} catch (Throwable t) {
			logger.error("", t);
		}
	}

}
