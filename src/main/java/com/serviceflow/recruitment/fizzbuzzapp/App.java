package com.serviceflow.recruitment.fizzbuzzapp;

import static spark.Spark.*;

import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.impl.FizzBuzzAlgorithmServiceImpl;
import com.serviceflow.recruitment.fizzbuzzapp.application.AppService;
import com.serviceflow.recruitment.fizzbuzzapp.application.AppServiceImpl;
import com.serviceflow.recruitment.fizzbuzzapp.marshallers.JsonTransformer;
import com.serviceflow.recruitment.fizzbuzzapp.model.LongListResponse;
import com.serviceflow.recruitment.fizzbuzzapp.model.ResponseMessage;
import com.serviceflow.recruitment.fizzbuzzapp.model.ShortListResponse;

class FizzBuzzModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FizzBuzzAlgorithmService.class).to(FizzBuzzAlgorithmServiceImpl.class);
	}
}

public class App {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new FizzBuzzModule());

		get("/health", (req, res) -> "Hello World");

		post("/fizzbuzz/long", (request, response) -> {
			System.out.println("Request body is: " + request.body());

			try {
				LongListResponse stuff = injector.getInstance(AppServiceImpl.class)
						.processLongListResponse(request.body());

				System.out.println(stuff);

				// response.status(404);

				return stuff;
				// return new ResponseMessage(stuff);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return new ResponseMessage("empty");

		}, new JsonTransformer());

		post("/fizzbuzz/short", (request, response) -> {
			try {
				ShortListResponse shortListResponse = injector.getInstance(AppServiceImpl.class)
						.processShortListResponse(request.body());
				
				return shortListResponse;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return new ResponseMessage("Error");
		}, new JsonTransformer());
	}
}
