package com.tlv.exceptions;

public class TLVException extends Exception {

	public TLVException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public TLVException(String reason) {
        super(reason);
    }

}
