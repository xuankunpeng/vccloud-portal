package com.vccloud.portal.constant;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final class FileUploadParams {
		public static final long MAX_SIZE = 80 * 1024 * 1024;
		public static final int MAX_COUNT = 1;
	}

	public static final class SearchProps {
		public static final int DEFAULT_PAGE_SIZE = 10;
		public static final int DEFAULT_PAGE_NO = 0;
	}

	public static final class FileUploadSuffix {
		public static List<String> PHOTO = new ArrayList<String>();
		static {
			PHOTO.add(".jpg");
			PHOTO.add(".bmp");
			PHOTO.add(".png");
			PHOTO.add(".gif");
			PHOTO.add(".tif");
		}
	}

	public static final class FileUploadMaxSize {
		public static final long PHOTO = 8 * 1024 * 1024;
	}

	public static final class LogoMaxSize {
		public static final int WIDTH = 200;
		public static final int HEIGHT = 75;
	}

}
