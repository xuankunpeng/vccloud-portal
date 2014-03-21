package com.vccloud.portal.exception;

public class PasswordNotMatchesException extends ServiceException {

	private static final long serialVersionUID = 1931521533055442617L;

	public PasswordNotMatchesException(Exception e) {
		super(e);
	}

	public PasswordNotMatchesException(String msg) {
		super(msg);
	}

	public PasswordNotMatchesException(String msg, Exception e) {
		super(msg, e);
	}

}
