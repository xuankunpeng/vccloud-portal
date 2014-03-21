package com.vccloud.portal.exception;

public class CallVidyoWebServiceException extends ServiceException {

	private static final long serialVersionUID = 2978959970915650987L;

	public CallVidyoWebServiceException(Exception e) {
		super(e);
	}

	public CallVidyoWebServiceException(String msg) {
		super(msg);
	}

	public CallVidyoWebServiceException(String msg, Exception e) {
		super(msg, e);
	}

}
