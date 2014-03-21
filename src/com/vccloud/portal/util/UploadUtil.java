package com.vccloud.portal.util;

import com.vccloud.portal.constant.Constants;
import com.vccloud.portal.util.IdProtector.IdType;

public class UploadUtil {

	public static String getLogoDir(long id) {
		String path = System.getProperty("user.home").replace('\\', '/');
		return path + "/data/logo/" + getSubFolderById(id);
	}

	public static String getLogoFileName(long id, String suffix, IMAGE_TYPE type) {
		return getMediaIdWithSkey(id) + "_" + type.getValue() + suffix;
	}

	public static String getLogoFilePath(long id, String suffix, IMAGE_TYPE type) {
		return getLogoDir(id) + "/" + getLogoFileName(id, suffix, type);
	}

	public static String getLogoFilePathByLogoUrl(long id, String logoUrl) {
		return getLogoDir(id) + "/" + logoUrl;
	}

	public static boolean checkLogoFileSuffix(String suffix) {
		suffix = CommonUtil.toLowerCase(suffix);
		return Constants.FileUploadSuffix.PHOTO.contains(suffix);
	}

	public static boolean checkLogoFileSize(long size) {
		return size <= Constants.FileUploadMaxSize.PHOTO;
	}

	public static String getMediaIdWithSkey(long id) {
		return IdProtector.protectId(IdType.LOGO_PIC_ID, id);
	}

	public enum IMAGE_TYPE {
		ORIGINAL("o"), NORMAL("n"), THUMB("t");

		private String value;

		IMAGE_TYPE(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	private static String getSubFolderById(long id) {
		return (id / 1000) + "";
	}

}
