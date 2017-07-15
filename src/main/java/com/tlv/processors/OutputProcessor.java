package com.tlv.processors;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.tlv.vo.Response;

public class OutputProcessor {
	
	OutputStream opStream;
	
	public OutputProcessor(OutputStream opStream) {
		this.opStream = opStream;
	}
	
	public void writeOutput(List<Response> responses){
		
		try {
			for(Response resp : responses){
			opStream.write((resp.toString() + "\n" ).getBytes());
			}
		} catch (IOException e) {
		}
	}
}
