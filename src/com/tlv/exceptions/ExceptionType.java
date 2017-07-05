package com.tlv.exceptions;

public enum ExceptionType {

	INVALID_TYPE(1,"Type not valid"),INVALID_TYPE_FORMAT(2,"TYPE is not of 6 chars"),
	INVALID_LENGTH(3,"LENGTH not valid"),INVALID_LENGTH_FORMAT(4,"LENGTH is not of 4 chars"),
	INVALID_VALUE(5,"VALUE not valid"),INVALID_FORMAT(6,"Input is in invalid Format");
	
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
