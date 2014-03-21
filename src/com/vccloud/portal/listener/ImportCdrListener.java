package com.vccloud.portal.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.util.StartupConfig;

public class ImportCdrListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(ImportCdrListener.class);

	private Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		if (StartupConfig.isRunImportCdr()) {
			timer.schedule(new MyTask(), getDelay(), StartupConfig
					.getImportCdrPeriod());
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		timer = null;
	}

	private long getDelay() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date tomorrowMorning = cal.getTime();
		return tomorrowMorning.getTime() - now.getTime();
	}

	private class MyTask extends TimerTask {
		@Override
		public void run() {
			logger.info("==================> Import Cdr task start.");
			long start = System.currentTimeMillis();
			try {
				ServiceLocator.getScheduleService().importCdr();
			} catch (Throwable t) {
				logger.error("", t);
			}
			logger.info("==================> Import Cdr task ended, costs "
					+ (System.currentTimeMillis() - start) + " ms.");
		}
	}

	public static void main(String[] args) {
		ServiceLocator.getScheduleService().importCdr();
	}

}
