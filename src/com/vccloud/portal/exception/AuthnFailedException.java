package com.vccloud.portal.exception;

public class AuthnFailedException extends ServiceException {

	private static final long serialVersionUID = 906947311151083656L;

	public AuthnFailedException(Exception e) {
		super(e);
	}

	public AuthnFailedException(String msg) {
		super(msg);
	}

	public AuthnFailedException(String msg, Exception e) {
		super(msg, e);
	}

}
