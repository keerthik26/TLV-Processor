package com.tlv.processors;

import java.io.InputStream;
import java.util.List;

import com.tlv.vo.Request;

public class InputProcessor {
	
	private InputStream ipStream;
	
	public InputProcessor(InputStream ipStream) {
		this.ipStream = ipStream;
	}
	
	public List<Request> readInput(){
		
		//use ipStream to read Input
		createRequestMessage(null);
		return null;	
	}
	
	private Request createRequestMessage(String input){
		
		return null;
	}

}
