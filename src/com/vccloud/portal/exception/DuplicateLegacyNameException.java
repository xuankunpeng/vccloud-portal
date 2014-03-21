package com.vccloud.portal.exception;

public class DuplicateLegacyNameException extends ServiceException {

	private static final long serialVersionUID = 5203041180041487772L;

	public DuplicateLegacyNameException(Exception e) {
		super(e);
	}

	public DuplicateLegacyNameException(String msg) {
		super(msg);
	}

	public DuplicateLegacyNameException(String msg, Exception e) {
		super(msg, e);
	}

}
