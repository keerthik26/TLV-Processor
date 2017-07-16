package com.tlv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.tlv.processors.InputProcessor;
import com.tlv.processors.MessageProcessor;
import com.tlv.processors.OutputProcessor;
import com.tlv.processors.ProcessStrategyFactory;
import com.tlv.processors.TLVProcessor;
import com.tlv.strategies.ReplaceStrategy;
import com.tlv.strategies.UpperCaseStrategy;
import com.tlv.vo.enums.ProcessorType;

public class TLVApplication {

public static void main(String[] args) throws FileNotFoundException {
		
		File initialFile = new File("C:/Users/Keerthi/Documents/Interviews/ip.txt");
	    InputStream targetStream = new FileInputStream(initialFile);
		InputProcessor inputProcessor = new InputProcessor(targetStream);
		
		//InputProcessor inputProcessor = new InputProcessor(System.in);
		OutputProcessor outputProcessor = new OutputProcessor(System.out);
		
		ProcessStrategyFactory processStrategyFactory = new ProcessStrategyFactory();
		processStrategyFactory.registerStrategy(ProcessorType.REPLCE, new ReplaceStrategy());
		processStrategyFactory.registerStrategy(ProcessorType.UPPRCS, new UpperCaseStrategy());
		
		MessageProcessor messageProcessor = new MessageProcessor(processStrategyFactory);
		
		TLVProcessor tlvProcessor = new TLVProcessor();
		tlvProcessor.process(messageProcessor, inputProcessor, outputProcessor);
				
	}

}
