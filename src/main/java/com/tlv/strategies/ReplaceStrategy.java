package com.tlv.strategies;

import com.tlv.common.Constants;
import com.tlv.exceptions.TLVException;
import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class ReplaceStrategy implements ProcessStrategy {

	@Override
	public Response process(Request request) throws TLVException{
		try{
		String value = request.getValue();
		String result  = value.replaceFirst(value.substring(0, value.length()), Constants.REPLACE_STRING);
		return Response.build(request.getType(), result);
		}catch (Exception e){
			throw new TLVException(e.getMessage(),e);
		}
	}

	

}
