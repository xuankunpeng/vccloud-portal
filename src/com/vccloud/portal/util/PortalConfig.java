package com.vccloud.portal.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PortalConfig {

	private static Properties prop = new Properties();

	static {
		InputStream is = StartupConfig.class.getClassLoader()
				.getResourceAsStream("portal.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			// Ignore.
		}
	}

	public static long getPortalConfigId() {
		return Long.valueOf(prop.getProperty("portal_config_id"));
	}

}
