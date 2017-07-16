package com.tlv.vo;

import com.tlv.common.Constants;
import com.tlv.exceptions.TLVException;
import com.tlv.vo.enums.ProcessorType;

public class Request {

	private final ProcessorType type;
	private final int length;
	private final String value;
	
	private Request(ProcessorType type, int length, String value) {
		this.type = type;
		this.length = length;
		this.value = value;
	}
	
	public static Request build(ProcessorType type, int length, String value) throws TLVException{
		if(type == null){
			throw new TLVException(Constants.INVALID_TYPE);
		}
		if(value.length() < length){
			throw new TLVException(Constants.INVALID_VALUE_LENGTH);
		}
		return new Request(type, length, value);
	}
	
	public static Request build(String typeString, String lengthString, String value) throws TLVException{
		ProcessorType type = getProcessType(typeString);
		int length = getMsgLength(lengthString);
		if(value.length() <= 0){
			throw new TLVException(Constants.INVALID_VALUE);
		}
		return Request.build(type, length, value);
		
	}
	
	public static Request build(String input) throws TLVException{
		String[] requestArray = input.split("-");
		if(requestArray.length == 3){ 
			return Request.build(requestArray[0], requestArray[1], requestArray[2]);
			
		}else{
			throw new TLVException(Constants.INVALID_FORMAT);
		}	
	}
	
	private static ProcessorType getProcessType(String typeString) throws TLVException{
		try{
		return ProcessorType.valueOf(typeString);
		}catch (Exception e){
			throw new TLVException(Constants.INVALID_TYPE);
		}
	}
	
	private static int getMsgLength(String lengthString) throws TLVException{
		if(lengthString.length() != 4){
			throw new TLVException(Constants.INVALID_LENGTH_FORMAT);
		}
		try{
		return Integer.parseInt(lengthString);
		}catch (Exception e){
			throw new TLVException(Constants.INVALID_LENGTH);
		}
	}
	
	public ProcessorType getType() {
		return type;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Request [type=" + type + ", length=" + length + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Request other = (Request) obj;
		if (length != other.length)
			return false;
		if (type != other.type)
			return false;
		return value != null ? value.equals(other.value) : other.value == null;
	}
	
	
}
