package com.tlv;



import java.util.Scanner;

import com.tlv.common.ProcessorType;
import com.tlv.common.Validator;
import com.tlv.exceptions.TLVException;
import com.tlv.processor.Processor;
import com.tlv.processor.ProcessorFactory;
import com.tlv.vo.Request;
import com.tlv.vo.Response;
import com.tlv.vo.Valid;

public class TLVProcessor {

	public static void main(String[] args) {
		
		//String input ="UPPRCS-0005-abcde";
		//String input = "REPLCE-0003-123";
		//String input = "UPPRCS-0004-1234";
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
				
		while(scanner.hasNextLine()){
			input = scanner.nextLine();
		Validator validator = new Validator();
		
			try {
				if(validator.validateRequest(input)){
					Request req = validator.createRequest(input);
					ProcessorType type = ProcessorType.valueOf(req.getType());
					Processor processor = ProcessorFactory.getProcessor(type);
					Response resp = processor.process(req);
					System.out.println(resp.getType() + "-" + resp.getValue());
				}
			} catch (TLVException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
	}

}
