package com.tlv.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tlv.common.Constants;
import com.tlv.strategies.ProcessStrategy;
import com.tlv.vo.Request;
import com.tlv.vo.Response;
import com.tlv.vo.enums.ProcessorType;

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
		Response resp ;
		requests = inputProcessor.readInput();
		for (Request req : requests){
			resp = validateMessage(req);
			if(resp.isValid()){
				req = formatRequest(req);
				strategy = processStrategies.get(req.getType());
				resp = strategy.process(req);
			}
			responses.add(resp);
		}
		
		outputProcessor.writeOutput(responses);
		
	}

	private Response validateMessage(Request request){
		Response response = new Response();
		if(request.isValid()){
		response = validateType(request.getTypeStr());
		if(response.isValid()){
			response = validateLength(request.getLengStr());
			if(response.isValid()){
				response = validateValue(request.getValue());
				if(response.isValid()){
					response.setValid(true);
				}
			}
		}
		}else{
			response.setContent(Constants.INVALID_FORMAT);
		}
		return response;		
	}
	
	private Request formatRequest(Request request){
		
		request.setType(ProcessorType.valueOf(request.getTypeStr()));
		request.setLength(Integer.parseInt(request.getLengStr()));
		
		return request;
	}
	
	private Response validateType(String typeStr){
		Response response = new Response();
		if(typeStr != null){
			if(typeStr.length() != 6){
				response.setContent(Constants.INVALID_TYPE_FORMAT);
			}else{
				try{
				  ProcessorType.valueOf(typeStr);
				  response.setValid(true);
				}catch (Exception e){
				 response.setContent(Constants.INVALID_TYPE);
				}
			}
		}else{
			response.setContent(Constants.INVALID_TYPE_FORMAT);
		}
			
		return response;
	}
	
	private Response validateLength(String lengStr){
		Response response = new Response();
		if(lengStr != null){
			if(lengStr.length() != 4){
				response.setContent(Constants.INVALID_LENGTH_FORMAT);
			}else{
				try{
					Integer.parseInt(lengStr);
					response.setValid(true);
				}catch (Exception e){
					response.setContent(Constants.INVALID_LENGTH);
				}
			}
		}else{
			response.setContent(Constants.INVALID_LENGTH_FORMAT);
		}
		
		return response;
	}

	private Response validateValue(String value) {
		Response response = new Response();
		if(value.length() > 0){
			response.setValid(true);
		}else{
			response.setContent(Constants.INVALID_VALUE);
		}
		
		return response;
	}

}
