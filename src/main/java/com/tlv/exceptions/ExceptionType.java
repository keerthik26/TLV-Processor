package com.tlv.exceptions;

public enum ExceptionType {

	MALFORMED_MESSAGE("1","Input is in invalid Format");
	
	 private String exId;
	 private String exDesc;
	 
	private ExceptionType(String exId, String exDesc) {
		this.exId = exId;
		this.exDesc = exDesc;
	}

	public String getExId() {
		return exId;
	}

	public String getExDesc() {
		return exDesc;
	}
	
	
}
