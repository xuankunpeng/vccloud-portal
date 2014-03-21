package com.vccloud.portal.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StartupConfig {

	private static Properties prop = new Properties();

	static {
		InputStream is = StartupConfig.class.getClassLoader()
				.getResourceAsStream("startup.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			// Ignore.
		}
	}

	public static boolean isRunLegacing() {
		return Boolean.valueOf(prop.getProperty("run_legacing"));
	}

	public static long getLegacingPeriod() {
		return Long.valueOf(prop.getProperty("legacing_period"));
	}

	public static boolean isRunImportCdr() {
		return Boolean.valueOf(prop.getProperty("run_import_cdr"));
	}

	public static long getImportCdrPeriod() {
		return Long.valueOf(prop.getProperty("import_cdr_period"));
	}

	public static boolean isRunImportReport() {
		return Boolean.valueOf(prop.getProperty("run_import_report"));
	}

	public static long getImportReportPeriod() {
		return Long.valueOf(prop.getProperty("import_report_period"));
	}

}
