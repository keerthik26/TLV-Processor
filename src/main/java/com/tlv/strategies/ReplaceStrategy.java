package com.tlv.strategies;

import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class ReplaceStrategy implements ProcessStrategy {

	@Override
	public Response process(Request request) {
		Response resp = new Response();
		resp.setType(request.getType());
		String result =  "THIS STRING";
		//resp.setValue(result);
		return resp;
	}

	

}
