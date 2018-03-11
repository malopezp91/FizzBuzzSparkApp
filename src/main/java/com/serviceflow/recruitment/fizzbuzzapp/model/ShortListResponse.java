package com.serviceflow.recruitment.fizzbuzzapp.model;

import java.util.Map;

public class ShortListResponse {
	Map<Long, String> fizzBuzz;

	public Map<Long, String> getFizzBuzz() {
		return fizzBuzz;
	}

	public void setFizzBuzz(Map<Long, String> fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}

	public ShortListResponse(Map<Long,String> fizzBuzz){
		this.fizzBuzz = fizzBuzz;
	}
	
}
