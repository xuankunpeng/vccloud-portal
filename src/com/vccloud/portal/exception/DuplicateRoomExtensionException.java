package com.vccloud.portal.exception;

public class DuplicateRoomExtensionException extends ServiceException {

	private static final long serialVersionUID = -1058721166915845345L;

	public DuplicateRoomExtensionException(Exception e) {
		super(e);
	}

	public DuplicateRoomExtensionException(String msg) {
		super(msg);
	}

	public DuplicateRoomExtensionException(String msg, Exception e) {
		super(msg, e);
	}

}
