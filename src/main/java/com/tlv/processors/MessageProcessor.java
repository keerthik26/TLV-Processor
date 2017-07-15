package com.tlv.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tlv.common.ProcessorType;
import com.tlv.strategies.ProcessStrategy;
import com.tlv.vo.Request;
import com.tlv.vo.Response;

public class MessageProcessor {
	
	InputProcessor inputProcessor;
	OutputProcessor outputProcessor;
	Map<ProcessorType, ProcessStrategy> processStrategies;
	
	public MessageProcessor(InputProcessor inputProcessor, OutputProcessor outputProcessor) {
		this.inputProcessor = inputProcessor;
		this.outputProcessor = outputProcessor;
		this.processStrategies = new HashMap<>();
	}
	
	public void registerStrategy(ProcessorType type, ProcessStrategy processStrategy){
		processStrategies.put(type, processStrategy);
	}
	
	public void processMessages(){
		List<Request> requests;
		List<Response> responses = new ArrayList<>();
		ProcessStrategy strategy;
		requests = inputProcessor.readInput();
		for (Request req : requests){
			Response resp = validateMessage(req);
			if(resp.isValid()){
				req = formatRequest(req);
				strategy = processStrategies.get(req.getType());
				resp = strategy.process(req);
			}
			responses.add(resp);
		}
		
		outputProcessor.writeOutput(responses);
		
	}
	
	public Response validateMessage(Request request){
		return null;
		
	}
	
	public Request formatRequest(Request request){
		
		return null;
	}

}
