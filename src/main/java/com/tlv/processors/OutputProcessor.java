package com.tlv.processors;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.tlv.exceptions.TLVException;
import com.tlv.exceptions.TLVRunTimeException;
import com.tlv.vo.Response;

public class OutputProcessor {
	
	OutputStream opStream;
	
	public OutputProcessor(OutputStream opStream) {
		this.opStream = opStream;
	}
	
	public void writeOutput(Response response) {
		
		try {			
			opStream.write((response.getValue() + "\n" ).getBytes());
		} catch (IOException e) {
			throw new TLVRunTimeException("Exception occurred while writing output",e);
		}
	}
}
