package com.tlv.processor;

import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class ReplaceProcessor implements Processor {

	@Override
	public Response process(Request request) {
		Response resp = new Response();
		resp.setType(request.getType());
		String result =  "THIS STRING";
		resp.setValue(result);
		return resp;
	}

	

}
