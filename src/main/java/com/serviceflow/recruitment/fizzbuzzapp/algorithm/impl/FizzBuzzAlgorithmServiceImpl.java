package com.serviceflow.recruitment.fizzbuzzapp.algorithm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;

public class FizzBuzzAlgorithmServiceImpl implements FizzBuzzAlgorithmService {

	@Override
	public String createFizzBuzzForGivenNumber(Integer number) {
		return "1 2 3 4";
	}

	@Override
	public String getFizzBuzzAsFullList(Long number) {
		StringBuilder fizzBuzzString = new StringBuilder();
		
		for (long i = 1; i <= number; i++){
			
			if (i % 3 == 0 || i % 5 == 0){
				if (i % 3 == 0){
					fizzBuzzString.append(Constants.fizz);
				} 
				if (i % 5 == 0){
					fizzBuzzString.append(Constants.buzz);
				}
			}
			
			else {
				fizzBuzzString.append(i);
			}
			fizzBuzzString.append(" ");
		}
		
		return fizzBuzzString.toString().trim();
	}

	@Override
	public Map<Long, String> getFizzBuzzAsShortList(Long number) {
		Map<Long, String> fizzBuzzMap = new HashMap<>();
		
		for (long i = 1; i <= number; i++){
			if (i % 3 == 0 && i % 5 == 0){
				fizzBuzzMap.put(i, Constants.fizz + Constants.buzz);
			}
			else if (i % 3 == 0){
				fizzBuzzMap.put(i, Constants.fizz);
			}
			else if (i % 5 == 0){
				fizzBuzzMap.put(i, Constants.buzz);
			}
		}
		return fizzBuzzMap;
	}

	
}
