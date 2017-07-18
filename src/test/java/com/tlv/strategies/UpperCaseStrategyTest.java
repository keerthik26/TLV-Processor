package com.tlv.strategies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tlv.exceptions.TLVException;
import com.tlv.vo.Request;
import com.tlv.vo.Response;
import com.tlv.vo.enums.ProcessorType;

public class UpperCaseStrategyTest {

	ProcessStrategy upperCaseStrategy;
	@Before
	public void setUp() throws Exception {
		upperCaseStrategy = new UpperCaseStrategy();
	}

	@Test
	public void testProcessWithValidRequestSucceeds() throws TLVException {
		assertEquals(Response.build(ProcessorType.UPPRCS, "ABCDE"), upperCaseStrategy.process(Request.build("UPPRCS-0005-abcde")));
	}
	
	
	public void testProcessWithReplaceRequestSucceeds() throws TLVException {
		assertEquals(Response.build(ProcessorType.UPPRCS, "ABCDE"), upperCaseStrategy.process(Request.build("")));
	}

}
