package com.tlv.processor;

import com.tlv.common.ProcessorType;

public class ProcessorFactory {

	public static Processor getProcessor(ProcessorType type){
		
		Processor processor = null;
		switch (type) {
		case UPPRCS:
			processor = new UpperCaseProcessor();
			break;
			
		case REPLCE:
			processor = new ReplaceProcessor();
			break;

		default:
			break;
			
		}
		return processor;
		
	}
}
