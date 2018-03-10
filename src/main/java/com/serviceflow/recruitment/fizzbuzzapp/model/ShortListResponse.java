package com.serviceflow.recruitment.fizzbuzzapp.model;

import java.util.Map;

public class ShortListResponse {
	Map<Long, Map<Long, String>> shortListResponse;

	public ShortListResponse(Map<Long, Map<Long, String>> shortListResponse){
		this.shortListResponse = shortListResponse;
	}
	
	public Map<Long, Map<Long, String>> getShortListResponse() {
		return shortListResponse;
	}

	public void setShortListResponse(Map<Long, Map<Long, String>> shortListResponse) {
		this.shortListResponse = shortListResponse;
	}
}
