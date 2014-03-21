package com.vccloud.portal.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.UUID;

import javax.xml.datatype.XMLGregorianCalendar;

public class CommonUtil {

	public static boolean isNullOrEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	public static boolean isNullOrEmpty(Object[] arr) {
		return arr == null || arr.length == 0;
	}

	public static boolean isNullOrEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<?, ?> m) {
		return m == null || m.isEmpty();
	}

	public static String null2Empty(String str) {
		if (null == str || "null".equalsIgnoreCase(str)) {
			return "";
		}
		return str;
	}

	public static Date convert2Date(XMLGregorianCalendar c) {
		if (c == null) {
			return null;
		}
		GregorianCalendar cal = c.toGregorianCalendar();
		return cal.getTime();
	}

	public static Date getDate(String source, String pattern) {
		DateFormat formater = new SimpleDateFormat(pattern);
		try {
			return formater.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getStart(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getEnd(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static String genUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static boolean isToday(Date date) {
		if (date == null) {
			return false;
		}
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date);
		if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal.get(Calendar.DAY_OF_MONTH) == cal2
						.get(Calendar.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public static String encode(String str, String enc) {
		try {
			return URLEncoder.encode(str, enc);
		} catch (UnsupportedEncodingException ex) {
			return URLEncoder.encode(str);
		}
	}

	@SuppressWarnings("deprecation")
	public static String decode(String str, String enc) {
		try {
			return URLDecoder.decode(str, enc);
		} catch (UnsupportedEncodingException ex) {
			return URLDecoder.decode(str);
		}
	}

	public static String formatDate(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (isNullOrEmpty(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	public static String toUpperCase(String str) {
		if (isNullOrEmpty(str)) {
			return str;
		}
		return str.toUpperCase();
	}

	public static String toLowerCase(String str) {
		if (isNullOrEmpty(str)) {
			return str;
		}
		return str.toLowerCase();
	}

	public static String contactURL(String baseURL, String key, String value) {
		if (isNullOrEmpty(baseURL)) {
			return "/?" + key + "=" + value;
		}
		if (baseURL.contains("?")) {
			return baseURL + "&" + key + "=" + value;
		} else {
			return baseURL + "?" + key + "=" + value;
		}
	}

	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			outBuff.flush();
		} finally {
			if (inBuff != null) {
				inBuff.close();
			}
			if (outBuff != null) {
				outBuff.close();
			}
		}
	}

	public static String genEmail4Legacy(String name) {
		name = null2Empty(name);
		name = toLowerCase(name);
		return name
				+ "@qaz1wsx2edc3rfv4tgb5yhn6ujm7iko8lp9.legacy.vccloud.com.cn";
	}

}
