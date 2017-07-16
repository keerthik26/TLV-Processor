package com.tlv.strategies;

import com.tlv.exceptions.TLVException;
import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class UpperCaseStrategy implements ProcessStrategy {

	@Override
	public Response process(Request request) throws TLVException{
		try{
		String result = request.getValue().substring(0, request.getLength()).toUpperCase();
		return Response.build(request.getType(), result);
		}catch (Exception e){
			throw new TLVException(e.getMessage(), e);
		}
	}



}
