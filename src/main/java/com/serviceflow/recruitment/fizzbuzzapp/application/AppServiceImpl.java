package com.serviceflow.recruitment.fizzbuzzapp.application;

import com.google.inject.Inject;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;

public class AppServiceImpl implements AppService{

	@Inject
	FizzBuzzAlgorithmService processor;

	@Override
	public String process(Integer value) {
		// TODO Auto-generated method stub
		System.out.println("Inside App Service");
		
		System.out.println(processor == null);
		
		return processor.createFizzBuzzForGivenNumber(value);
	}

}
