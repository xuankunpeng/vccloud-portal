package com.vccloud.portal.exception;

public class FileTypeInvalidException extends ServiceException {

	private static final long serialVersionUID = -5589361177212198526L;

	public FileTypeInvalidException(Exception e) {
		super(e);
	}

	public FileTypeInvalidException(String msg) {
		super(msg);
	}

	public FileTypeInvalidException(String msg, Exception e) {
		super(msg, e);
	}

}
