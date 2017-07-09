package com.tlv.processor;

import com.tlv.vo.Request;
import com.tlv.vo.Response;

public interface ProcessStrategy {

	Response process(Request request);
}
