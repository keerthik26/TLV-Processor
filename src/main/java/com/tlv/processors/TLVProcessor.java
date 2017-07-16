package com.tlv;



import com.tlv.processors.InputProcessor;
import com.tlv.processors.MessageProcessor;
import com.tlv.processors.OutputProcessor;
import com.tlv.strategies.ReplaceStrategy;
import com.tlv.strategies.UpperCaseStrategy;
import com.tlv.vo.enums.ProcessorType;

public class TLVProcessor {

	public static void main(String[] args) {
		
		InputProcessor inputProcessor = new InputProcessor(System.in);
		OutputProcessor outputProcessor = new OutputProcessor(System.out);
		MessageProcessor messageProcessor = new MessageProcessor(inputProcessor, outputProcessor);
		
		messageProcessor.registerStrategy(ProcessorType.REPLCE, new ReplaceStrategy());
		messageProcessor.registerStrategy(ProcessorType.UPPRCS, new UpperCaseStrategy());
		
		messageProcessor.processMessages();
		
	}

}
