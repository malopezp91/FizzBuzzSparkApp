package com.serviceflow.recruitment.fizzbuzzapp;

import static spark.Spark.*;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.impl.FizzBuzzAlgorithmServiceImpl;
import com.serviceflow.recruitment.fizzbuzzapp.application.AppServiceImpl;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.InvalidNumberParamException;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.ParamNumberExceedsLimit;
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

		// Allows to get Herokus Port, if started locally, port number is Spark
		// defaults 4567
		port(getHerokuAssignedPort());

		// CORS, origin all
		options("/*", (request, response) -> {

			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}

			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}

			return "OK";
		});

		// CORS
		before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

		// Health Endpoint
		get("/health", (req, res) -> "FizzBuzzApp is up and running!");

		get("/fizzbuzz/long", (request, response) -> {
			try {
				LongListResponse longListResponse = injector.getInstance(AppServiceImpl.class)
						.processLongListResponse(request.queryParams(Constants.PARAM_NAME));

				return longListResponse;
			} catch (InvalidNumberParamException e) {
				response.status(400);
				return new ResponseMessage(Constants.INVALID_NUMBER_PARAM_MESSAGE);
			} catch (ParamNumberExceedsLimit e) {
				response.status(400);
				return new ResponseMessage(Constants.PARAM_NUMBER_EXCEEDS_LIMIT_MESSAGE);
			} catch (Exception e) {
				response.status(500);
				return new ResponseMessage(Constants.INTERNAL_ERROR);
			}
		}, new JsonTransformer());

		get("/fizzbuzz/short", (request, response) -> {
			try {
				ShortListResponse shortListResponse = injector.getInstance(AppServiceImpl.class)
						.processShortListResponse(request.queryParams(Constants.PARAM_NAME));

				return shortListResponse;
			} catch (InvalidNumberParamException e) {
				response.status(400);
				return new ResponseMessage(Constants.INVALID_NUMBER_PARAM_MESSAGE);
			} catch (ParamNumberExceedsLimit e) {
				response.status(400);
				return new ResponseMessage(Constants.PARAM_NUMBER_EXCEEDS_LIMIT_MESSAGE);
			} catch (Exception e) {
				response.status(500);
				return new ResponseMessage(Constants.INTERNAL_ERROR);
			}
		}, new JsonTransformer());

	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			System.out.println("Heroku assigned port is: " + processBuilder.environment().get("PORT"));
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on
						// localhost)
	}
}
