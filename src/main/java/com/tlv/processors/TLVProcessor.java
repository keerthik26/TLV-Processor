package com.tlv.processors;



import com.tlv.exceptions.TLVException;
import com.tlv.vo.Response;

public class TLVProcessor {
	

	
	public void process(MessageProcessor messageProcessor, InputProcessor inputProcessor, OutputProcessor outputProcessor){
		String input;
	
			try {
				while((input= inputProcessor.readInput()) != null && !input.equals("")) {
				   
				        Response response = messageProcessor.processMessage(input);
				        outputProcessor.writeOutput(response);
				    
				}
			} catch (TLVException e) {
				outputProcessor.writeOutput(new Response(e.getMessage()));
			}
	}

}
