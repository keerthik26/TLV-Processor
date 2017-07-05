package com.tlv.common;

import com.tlv.exceptions.ExceptionType;
import com.tlv.exceptions.TLVException;
import com.tlv.vo.Request;
import com.tlv.vo.Valid;

public class Validator {

	public boolean validateRequest(String input) throws TLVException{
		//Valid validStatus = new Valid();
		boolean validStatus=false;
		String[] requestArray = input.split("-");
		
		if(requestArray.length == 3){
			validStatus = (validateType(requestArray[0]) && validateLength(requestArray[1]) && validateValue(requestArray[2]));
		}else{
			throw new TLVException(ExceptionType.INVALID_FORMAT);
		}
		return validStatus;
		
	}
	
	public Request createRequest(String input){
		
		String[] requestArray = input.split("-");
		Request req = new Request();
		req.setType(requestArray[0]);
		req.setLength(Integer.parseInt(requestArray[1]));
		req.setValue(requestArray[2]);
		
		return req;
		
	}

	private boolean validateType(String type) throws TLVException {
		boolean isValid=false;
		if(type.length() != 6){
			throw new TLVException(ExceptionType.INVALID_TYPE_FORMAT);
		}	
		try{
			ProcessorType.valueOf(type);
		}catch (Exception e){
			throw new TLVException(ExceptionType.INVALID_TYPE, e);
		}
			
		isValid=true;
		return isValid;
	}

	private boolean validateLength(String leng) throws TLVException {
		boolean isValid=false;
		
		if(leng.length() != 4){
			throw new TLVException(ExceptionType.INVALID_LENGTH_FORMAT);
		}
		
		try{
			Integer.parseInt(leng);
		}catch (Exception e){
			throw new TLVException(ExceptionType.INVALID_LENGTH, e);
		}
		
		isValid=true;
		return isValid;
	}

	private boolean validateValue(String value) throws TLVException {
		boolean isValid=false;
		if(value.length() == 0){
			throw new TLVException(ExceptionType.INVALID_VALUE);
		}
		isValid=true;
		return isValid;
	}
	
}
