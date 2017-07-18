package com.tlv.processors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tlv.common.Constants;
import com.tlv.strategies.ReplaceStrategy;
import com.tlv.strategies.UpperCaseStrategy;
import com.tlv.vo.Response;
import com.tlv.vo.enums.ProcessorType;

public class MessageProcessorTest {

	MessageProcessor messageProcessor ;

	@Before
	public void setUp() {
		ProcessStrategyFactory processStrategyFactory = new ProcessStrategyFactory();
		processStrategyFactory.registerStrategy(ProcessorType.REPLCE, new ReplaceStrategy());
		processStrategyFactory.registerStrategy(ProcessorType.UPPRCS, new UpperCaseStrategy());
		 messageProcessor = new MessageProcessor(processStrategyFactory);
	}

	@Test
	public void testProcessMessageWithValidMessageShouldSucceed() {
		assertEquals(Response.build(ProcessorType.UPPRCS, "ABCDE"), messageProcessor.processMessage("UPPRCS-0005-abcde"));
	}
	
	@Test
	public void testProcessMessageWithInValidMessageSucceeds() {
		assertEquals(new Response(Constants.INVALID_TYPE), messageProcessor.processMessage("UPPRC-0005-abcde"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testProcessMessageWithNullMessageThrowsException() {
		 messageProcessor.processMessage(null);
	}
	
	@Test
	public void testProcessMessageWithEmptyMessageSucceeds() {
		assertEquals(new Response(Constants.INVALID_FORMAT), messageProcessor.processMessage(""));
	}

}
