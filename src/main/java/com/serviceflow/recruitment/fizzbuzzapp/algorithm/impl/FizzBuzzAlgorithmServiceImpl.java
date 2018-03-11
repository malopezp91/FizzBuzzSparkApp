package com.serviceflow.recruitment.fizzbuzzapp.algorithm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.serviceflow.recruitment.fizzbuzzapp.Constants;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;

public class FizzBuzzAlgorithmServiceImpl implements FizzBuzzAlgorithmService {

	@Override
	public String getFizzBuzzAsFullList(Long number) {
		StringBuilder fizzBuzzString = new StringBuilder();
		
		for (long i = 1; i <= number; i++){
			
			if (i % 3 == 0 || i % 5 == 0){
				if (i % 3 == 0){
					fizzBuzzString.append(Constants.FIZZ);
				} 
				if (i % 5 == 0){
					fizzBuzzString.append(Constants.BUZZ);
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
				fizzBuzzMap.put(i, Constants.FIZZ + Constants.BUZZ);
			}
			else if (i % 3 == 0){
				fizzBuzzMap.put(i, Constants.FIZZ);
			}
			else if (i % 5 == 0){
				fizzBuzzMap.put(i, Constants.BUZZ);
			}
		}
		return fizzBuzzMap;
	}

	
}
