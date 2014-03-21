package com.vccloud.portal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author Created by Weijia, Li
 * @author Review and refactor by Wenjing, Xie
 * 
 */
public class DBConnectionUtil {

	private static Logger logger = Logger.getLogger(DBConnectionUtil.class);

	public static Connection openBusinessDBConnection() {
		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		Properties props = new Properties();
		try {
			props.load(DBConnectionUtil.class.getClassLoader()
					.getResourceAsStream("jdbc-business.properties"));
			driver = props.getProperty("jdbc.mysql.driverClassName.business");
			url = props.getProperty("jdbc.mysql.url.business.2");
			user = props.getProperty("jdbc.mysql.username.business");
			password = props.getProperty("jdbc.mysql.password.business");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

}
