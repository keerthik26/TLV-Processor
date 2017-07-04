package com.tlv.common;

import com.tlv.vo.Request;
import com.tlv.vo.Valid;

public class Validator {

	public Valid validateRequest(String input){
		Valid validStatus = new Valid();
		String[] requestArray = input.split("-");
		
		if(requestArray.length == 3){
			validStatus = validateType(requestArray[0]);
			if(validStatus.isValid()){
				validStatus = validateLength(requestArray[1]);
				if(validStatus.isValid()){
					validStatus = validateValue(requestArray[2]);
				}
			}
		}else{
			validStatus.setValid(false);
			validStatus.setInvalidReason("Invalid format");
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

	private Valid validateType(String type) {
		Valid valid = new Valid();
		valid.setValid(true);;
		if(type.length() != 6){
			valid.setValid(false);
			valid.setInvalidReason("Invalid Format: TYPE is not of 6 chars");
			return valid;
		}	
		try{
			ProcessorType.valueOf(type);
		}catch (Exception e){
			valid.setValid(false);
			valid.setInvalidReason("Type not valid");
		}
					
		return valid;
	}

	private Valid validateLength(String leng) {
		Valid valid = new Valid();
		valid.setValid(true);;
		if(leng.length() != 4){
			valid.setValid(false);
			valid.setInvalidReason("Invalid Format: LENGTH is not of 4 chars");
			return valid;
		}
		
		try{
			Integer.parseInt(leng);
		}catch (Exception e){
			valid.setValid(false);
			valid.setInvalidReason("LENGTH not valid");
		}
		return valid;
	}

	private Valid validateValue(String value) {
		Valid valid = new Valid();
		valid.setValid(true);;
		if(value.length() == 0){
			valid.setValid(false);
			valid.setInvalidReason("VALUE not valid");
		}
		return valid;
	}
	
}
