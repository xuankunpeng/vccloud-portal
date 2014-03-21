package com.vccloud.portal.exception;

public class FileSizeExceededException extends ServiceException {

	private static final long serialVersionUID = 4940650295417470641L;

	public FileSizeExceededException(Exception e) {
		super(e);
	}

	public FileSizeExceededException(String msg) {
		super(msg);
	}

	public FileSizeExceededException(String msg, Exception e) {
		super(msg, e);
	}

}
