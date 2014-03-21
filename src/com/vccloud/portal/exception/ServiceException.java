package com.vccloud.portal.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -3228922260357729819L;

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Exception e) {
		super(msg, e);
	}

}
