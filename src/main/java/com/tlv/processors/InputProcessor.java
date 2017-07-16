package com.tlv.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.tlv.exceptions.TLVException;
import com.tlv.exceptions.TLVRunTimeException;
import com.tlv.vo.Request;

public class InputProcessor {
	
	private InputStream ipStream;
	private BufferedReader br ;
	
	public InputProcessor(InputStream ipStream) {
		this.ipStream = ipStream;
		br = getReader();
	}
	
	public BufferedReader getReader(){
		BufferedReader br = new BufferedReader(new InputStreamReader(ipStream));
		return br;
	}
	
	public String readInput() throws TLVException{
    			 	
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new TLVException("Exception while reading messages");
		}	
	}
	

}
