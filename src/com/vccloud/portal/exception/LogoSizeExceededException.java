package com.vccloud.portal.exception;

public class LogoSizeExceededException extends ServiceException {

	private static final long serialVersionUID = -2224698266861859565L;

	public LogoSizeExceededException(Exception e) {
		super(e);
	}

	public LogoSizeExceededException(String msg) {
		super(msg);
	}

	public LogoSizeExceededException(String msg, Exception e) {
		super(msg, e);
	}

}
