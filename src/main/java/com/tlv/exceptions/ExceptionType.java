package com.tlv.exceptions;

public enum ExceptionType {

	MALFORMED_MESSAGE(1,"Input is in invalid Format");
	
	 private int exId;
	 private String exDesc;
	 
	private ExceptionType(int exId, String exDesc) {
		this.exId = exId;
		this.exDesc = exDesc;
	}

	public int getExId() {
		return exId;
	}

	public String getExDesc() {
		return exDesc;
	}
	
	
}
