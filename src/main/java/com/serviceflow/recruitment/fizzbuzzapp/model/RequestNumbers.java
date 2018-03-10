package com.serviceflow.recruitment.fizzbuzzapp.model;

public class RequestNumbers {
	private Long[] number;
	
	RequestNumbers(Long[] number){
		this.setNumber(number);
	}

	public Long[] getNumber() {
		return number;
	}

	public void setNumber(Long[] number) {
		this.number = number;
	}
	
	
}
