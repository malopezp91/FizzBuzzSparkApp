package com.serviceflow.recruitment.fizzbuzzapp;

import static spark.Spark.*;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.impl.FizzBuzzAlgorithmServiceImpl;
import com.serviceflow.recruitment.fizzbuzzapp.application.AppService;
import com.serviceflow.recruitment.fizzbuzzapp.application.AppServiceImpl;



class FizzBuzzModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FizzBuzzAlgorithmService.class).to(FizzBuzzAlgorithmServiceImpl.class);	}	
}


public class App 
{
	
    public static void main( String[] args )
    {
    	Injector injector  = Guice.createInjector(new FizzBuzzModule());
    	
    	
    	get("/health", (req, res) -> "Hello World");
    	
    	post("/fizzbuzz", (request, response) -> {
    		System.out.println("Request body is: " + request.body());
    		
//    		String stuff = injector.getInstance(FizzBuzzProcessor.class).createFizzBuzzForGivenNumber(new Integer(5));
    		
    		
//    		String stuff = processor.createFizzBuzzForGivenNumber(new Integer(5));
    		try {
        		String stuff = injector.getInstance(AppServiceImpl.class).process(new Integer(5));
    			
//    			String stuff = processor.process(new Integer(5));
        		System.out.println(stuff);
    		}catch (Exception e){
    			System.out.println(e.getMessage());
    		}
    		
    		
    		
    		return "Hello World from POST";
    	});
    }
}
