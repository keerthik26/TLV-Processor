package com.tlv.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.tlv.vo.Request;

public class InputProcessor {
	
	private InputStream ipStream;
	
	public InputProcessor(InputStream ipStream) {
		this.ipStream = ipStream;
	}
	
	public List<Request> readInput(){
		List<Request> inMessages = new ArrayList<Request>();
    	InputStreamReader ipReader = new InputStreamReader(ipStream);
    	BufferedReader br = new BufferedReader(ipReader);
    	String input ;
    			 
		try {
			while((input= br.readLine()) != null && !input.equals("")){
					 inMessages.add(createRequestMessage(input));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inMessages;	
	}
	
	private Request createRequestMessage(String input){		
		Request request = new Request();
		
		String[] requestArray = input.split("-");
		if(requestArray.length == 3){ 
			request.setTypeStr(requestArray[0]);
			request.setLengStr(requestArray[1]);
			request.setValue(requestArray[2]);
		}else{
			request.setValid(false);
		}
		return request;
		
	}

}
