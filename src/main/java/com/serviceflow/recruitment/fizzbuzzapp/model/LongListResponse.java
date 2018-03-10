package com.serviceflow.recruitment.fizzbuzzapp.model;

import java.util.Map;

public class LongListResponse {
	Map<Long, String> longListResponse;

	public LongListResponse (Map<Long, String> longListResponse){
		this.longListResponse = longListResponse;
	}
	
	public Map<Long, String> getLongListResponse() {
		return longListResponse;
	}

	public void setLongListResponse(Map<Long, String> longListResponse) {
		this.longListResponse = longListResponse;
	}
}
