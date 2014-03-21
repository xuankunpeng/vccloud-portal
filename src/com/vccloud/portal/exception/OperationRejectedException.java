package com.vccloud.portal.exception;

public class OperationRejectedException extends ServiceException {

	private static final long serialVersionUID = 1752281928907779949L;

	public OperationRejectedException(Exception e) {
		super(e);
	}

	public OperationRejectedException(String msg) {
		super(msg);
	}

	public OperationRejectedException(String msg, Exception e) {
		super(msg, e);
	}

}
