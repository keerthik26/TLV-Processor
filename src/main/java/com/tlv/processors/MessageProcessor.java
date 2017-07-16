package com.tlv.processors;

import com.tlv.exceptions.TLVException;
import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class MessageProcessor {
	
	private ProcessStrategyFactory processStrategyFactory;
	
	public MessageProcessor(ProcessStrategyFactory factory) {
		this.processStrategyFactory = factory;		
	}
	
	
	public Response processMessage(String input){

		try {
			Request request = Request.build(input);
			Response response = processRequest(request);
			return response;
		} catch (TLVException e) {
			return new Response(e.getMessage());
		}
		  
		
	}
	
	private Response processRequest(Request request){

		try {
			return processStrategyFactory.getStrategy(request.getType()).process(request);
		} catch (TLVException e) {
			return new Response(e.getMessage());
		}
		  
		
	}

}
