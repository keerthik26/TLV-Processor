package com.tlv.processors;

import java.util.HashMap;
import java.util.Map;

import com.tlv.common.Constants;
import com.tlv.exceptions.TLVException;
import com.tlv.strategies.ProcessStrategy;
import com.tlv.vo.enums.ProcessorType;

public class ProcessStrategyFactory {

	Map<ProcessorType, ProcessStrategy> processStrategies;
	
	public ProcessStrategyFactory() {
		this.processStrategies = new HashMap<>();
	}
	
	public void registerStrategy(ProcessorType type, ProcessStrategy processStrategy){
		processStrategies.put(type, processStrategy);
	}
	
	public ProcessStrategy getStrategy(ProcessorType type) throws TLVException {
		 ProcessStrategy processStrategy = processStrategies.get(type);
		 if(processStrategy == null){
			 throw new TLVException(Constants.UNKNOWN_STRATEGY);
		 }
		 return processStrategy;
	}

}
