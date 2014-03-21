package com.vccloud.portal.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocator {

	private static BeanFactory beanFactory = null;

	static {
		if (beanFactory == null) {
			ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					new String[] { "classpath:applicationContext.xml",
							"classpath:spring/applicationContext-*.xml",
							"classpath*:/applicationContext.xml", // for modular projects
							"classpath:**/applicationContext*.xml" // for web projects
					});
			beanFactory = applicationContext;
		}
	}

	public static UserService getUserService() {
		return (UserService) beanFactory.getBean("userService");
	}

	public static VidyoService getVidyoService() {
		return (VidyoService) beanFactory.getBean("vidyoService");
	}

	public static ScheduleService getScheduleService() {
		return (ScheduleService) beanFactory.getBean("scheduleService");
	}

}
