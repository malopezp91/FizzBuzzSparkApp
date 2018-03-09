package com.serviceflow.recruitment.fizzbuzzapp.algorithm;

import java.util.List;
import java.util.Map;

public interface FizzBuzzAlgorithmService {
	
	String createFizzBuzzForGivenNumber(Integer number);
	
	String getFizzBuzzAsFullList(Long number);
	
	Map<Long, String> getFizzBuzzAsShortList(Long number);
	
}
