package com.tlv.exceptions;

public class TLVException extends Exception {

	public TLVException() {
	}

	public TLVException(ExceptionType exType) {
		super(exType.getExDesc());
	}


	public TLVException(ExceptionType exType, Throwable cause) {
		super(exType.getExDesc(), cause);
		
	}

	public TLVException(Exception cause) {
		super(cause);
	}

}
