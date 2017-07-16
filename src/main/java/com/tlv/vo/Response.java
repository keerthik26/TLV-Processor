package com.tlv.vo;

import com.tlv.vo.enums.ProcessorType;

public class Response {
	
	private final String value;
	
	public Response(String value) {
		this.value = value;
	}
	
	public static Response build(ProcessorType type, String value){
		return new Response(type.toString() + "-" + value);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Response [value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Response response = (Response) o;

		return value != null ? value.equals(response.value) : response.value == null;
	}
	
	
}
