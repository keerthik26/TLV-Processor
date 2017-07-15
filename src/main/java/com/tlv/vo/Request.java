package com.tlv.vo;

import com.tlv.vo.enums.ProcessorType;

public class Request {

	private String typeStr;
	private String lengStr;
	private ProcessorType type;
	private int length;
	private String value;
	private boolean isValid = true;
	
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}
	public String getLengStr() {
		return lengStr;
	}
	public void setLengStr(String lengStr) {
		this.lengStr = lengStr;
	}
	public ProcessorType getType() {
		return type;
	}
	public void setType(ProcessorType type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		return "Request [type=" + type + ", length=" + length + ", value=" + value + "]";
	}
	
	
}
