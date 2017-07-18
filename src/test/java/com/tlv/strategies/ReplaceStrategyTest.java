/**
 * 
 */
package com.tlv.strategies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tlv.common.Constants;
import com.tlv.exceptions.TLVException;
import com.tlv.vo.Request;
import com.tlv.vo.Response;
import com.tlv.vo.enums.ProcessorType;

/**
 * @author Keerthi
 *
 */
public class ReplaceStrategyTest {

	ReplaceStrategy replaceStrategy;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		replaceStrategy = new ReplaceStrategy(); 
	}

	/**
	 * Test method for {@link com.tlv.strategies.ReplaceStrategy#process(com.tlv.vo.Request)}.
	 * @throws TLVException 
	 */
	@Test
	public void testProcess() throws TLVException {
		Request request = Request.build(ProcessorType.REPLCE, 4, "abcedef are alphabets");
		Response response = replaceStrategy.process(request);
		String actual = response.getValue();
		String expected = "REPLCE-THIS STRING";
		assertEquals(expected,actual);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testProcess_NullValue() throws TLVException {
		replaceStrategy.process(Request.build(ProcessorType.REPLCE, 4, null));
		
	}

}
