package com.serviceflow.recruitment.fizzbuzzapp.algorithm;

import java.util.Map;

public interface FizzBuzzAlgorithmService {
	
	String getFizzBuzzAsFullList(Long number);
	
	Map<Long, String> getFizzBuzzAsShortList(Long number);
	
}
