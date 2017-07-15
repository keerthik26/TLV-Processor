package com.tlv.vo;

import com.tlv.vo.enums.ProcessorType;

public class Response {
	
	private boolean isValid;
	private ProcessorType type;
	private String content;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public ProcessorType getType() {
		return type;
	}
	public void setType(ProcessorType type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		if(isValid()){
			return type.toString() + "-" + content;
		}else{
			return content;
		}
	}
	
	
}
