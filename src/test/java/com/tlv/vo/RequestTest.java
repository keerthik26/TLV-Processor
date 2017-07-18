package com.tlv.vo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tlv.exceptions.TLVException;
import com.tlv.vo.enums.ProcessorType;

public class RequestTest {

	@Test
	public void testBuildRequestUsingFields_Succeed() throws TLVException {
		Request request = Request.build(ProcessorType.REPLCE, 5, "abcde");
		assertEquals("Request [type=REPLCE, length=5, value=abcde]", request.toString());
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingFields_NullType() throws TLVException {
		Request.build(null, 5, "abcde");
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingFields_InvalidLength() throws TLVException {
		Request.build(ProcessorType.REPLCE, 5, "abcd");
	}

	@Test(expected=TLVException.class)
	public void testBuildStringStringString() throws TLVException {
		Request.build("UPPRCS", "0005", "ab");
	}
	
	@Test(expected=TLVException.class)
	public void testBuildStringStringString_NullValue() throws TLVException {
		Request.build("UPPRCS", "0005", "");
	}

	@Test
	public void testBuildRequestUsingInputString_Succeed() throws TLVException {
		String input = "UPPRCS-0005-abcde";
		assertEquals(Request.build(ProcessorType.UPPRCS, 5, "abcde"), Request.build(input));
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingInputString_InvalidFormat() throws TLVException {
		String input = "UPPRCS-0005-abcde-asd";
		Request.build(input);
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingInputString_NullValue() throws TLVException {
		String input = "UPPRCS-0005-";
		 Request.build(input);
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingInputString_InvalidType() throws TLVException {
		String input = "TAG-0005-abcde";
		 Request.build(input);
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingInputString_NullType() throws TLVException {
		String input = "-0005-abcde";
		 Request.build(input);
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingInputString_InvalidLengthsize() throws TLVException {
		String input = "UPPRCS-005-abcde";
		 Request.build(input);
	}
	
	@Test(expected=TLVException.class)
	public void testBuildRequestUsingInputString_InvalidLength() throws TLVException {
		String input = "UPPRCS-a05c-abcde";
		 Request.build(input);
	}

}
