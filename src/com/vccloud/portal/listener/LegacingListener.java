package com.vccloud.portal.listener;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.util.StartupConfig;

public class LegacingListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(LegacingListener.class);

	private Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		if (StartupConfig.isRunLegacing()) {
			timer.schedule(new MyTask(), 0, StartupConfig.getLegacingPeriod());
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		timer = null;
	}

	private class MyTask extends TimerTask {
		@Override
		public void run() {
			logger.info("==================> Legacing task start.");
			long start = System.currentTimeMillis();
			try {
				ServiceLocator.getScheduleService().legacing();
			} catch (Throwable t) {
				logger.error("", t);
			}
			logger.info("==================> Legacing task ended, costs "
					+ (System.currentTimeMillis() - start) + " ms.");
		}
	}

	public static void main(String[] args) {
		ServiceLocator.getScheduleService().legacing();
	}

}
