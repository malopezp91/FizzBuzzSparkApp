package com.serviceflow.recruitment.fizzbuzzapp.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.InvalidNumberInRequestException;
import com.serviceflow.recruitment.fizzbuzzapp.model.LongListResponse;
import com.serviceflow.recruitment.fizzbuzzapp.model.RequestNumbers;
import com.serviceflow.recruitment.fizzbuzzapp.model.ShortListResponse;

public class AppServiceImpl implements AppService{

	@Inject
	FizzBuzzAlgorithmService processor;

	private Gson gson = new Gson();
	
	@Override
	public LongListResponse processLongListResponse(String values) throws InvalidNumberInRequestException {
		
		Long[] numbers = null;
		//Extract Values from request
		try{
			numbers = validateBodyRequestContainsValidNumbers(values);
		}
		catch(InvalidNumberInRequestException e){
			throw e;
		}
		
		Map<Long, String> mapOfResponses = new HashMap<>();
		
		Arrays.stream(numbers).forEach( number -> {
			mapOfResponses.put(number, processor.getFizzBuzzAsFullList(number));
		});
		
		return new LongListResponse(mapOfResponses);
	}

	@Override
	public ShortListResponse processShortListResponse(String values) throws InvalidNumberInRequestException{
		Long[] numbers = null;
		//Extract Values from request
		try{
			numbers = validateBodyRequestContainsValidNumbers(values);
		}
		catch(InvalidNumberInRequestException e){
			throw e;
		}
		
		Map<Long, Map<Long, String>> mapOfResponses = new HashMap<>();
		Arrays.stream(numbers).forEach( number -> {
			mapOfResponses.put(number, processor.getFizzBuzzAsShortList(number));
		});
		
		return new ShortListResponse(mapOfResponses);
		
		
	}
	
	private Long[] validateBodyRequestContainsValidNumbers(String values) throws InvalidNumberInRequestException{
		
		RequestNumbers numbersFromRequest = gson.fromJson(values, RequestNumbers.class);
		
		Long[] numbers = numbersFromRequest.getNumber();
		
		for(int i = 0; i< numbers.length; i++){
			if (numbers[i] == 0 || !(numbers[i] instanceof Long) ){
				throw new InvalidNumberInRequestException();
			}
		}
		
		return numbers;
	}

}
