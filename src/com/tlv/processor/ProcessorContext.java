package com.tlv.processor;

import com.tlv.common.ProcessorType;
import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class ProcessorContext {
	
	ProcessStrategy strategy;
	
	public Response processInput(Request request){
		strategy = getStrategy(request.getType());
		return strategy.process(request);
	}

	public ProcessStrategy getStrategy(String typ){
		
		ProcessorType type = ProcessorType.valueOf(typ);
		switch (type) {
		case UPPRCS:
			return new UpperCaseProcessStrategy();
			
			
		case REPLCE:
			return new ReplaceProcessStrategy();

		default:
			break;
			
		}
		return null;
		
	}

	public static ProcessStrategy getProcessor(ProcessorType type){
		
		ProcessStrategy processor = null;
		switch (type) {
		case UPPRCS:
			processor = new UpperCaseProcessStrategy();
			break;
			
		case REPLCE:
			processor = new ReplaceProcessStrategy();
			break;

		default:
			break;
			
		}
		return processor;
		
	}
}
