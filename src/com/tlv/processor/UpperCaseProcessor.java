package com.tlv.processor;

import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class UpperCaseProcessor implements Processor {

	@Override
	public Response process(Request request) {
		Response resp = new Response();
		resp.setType(request.getType());
		String result = request.getValue().substring(0, request.getLength()).toUpperCase();
		resp.setValue(result);
		return resp;
	}



}
