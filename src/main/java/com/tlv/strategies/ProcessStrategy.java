package com.tlv.strategies;

import com.tlv.vo.Request;
import com.tlv.vo.Response;

public interface ProcessStrategy {

	Response process(Request request);
}
