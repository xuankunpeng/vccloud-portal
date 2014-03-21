package com.vccloud.portal.exception;

public class DuplicateRoomNameException extends ServiceException {

	private static final long serialVersionUID = 2751358009819738440L;

	public DuplicateRoomNameException(Exception e) {
		super(e);
	}

	public DuplicateRoomNameException(String msg) {
		super(msg);
	}

	public DuplicateRoomNameException(String msg, Exception e) {
		super(msg, e);
	}

}
