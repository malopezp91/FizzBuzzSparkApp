package com.serviceflow.recruitment.fizzbuzzapp.application;

import java.util.Map;

import com.google.inject.Inject;
import com.serviceflow.recruitment.fizzbuzzapp.Constants;
import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.InvalidNumberParamException;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.ParamNumberExceedsLimit;
import com.serviceflow.recruitment.fizzbuzzapp.model.LongListResponse;
import com.serviceflow.recruitment.fizzbuzzapp.model.ShortListResponse;

public class AppServiceImpl implements AppService {

	@Inject
	FizzBuzzAlgorithmService processor;

	@Override
	public LongListResponse processLongListResponse(String paramFromQuery) throws  InvalidNumberParamException, ParamNumberExceedsLimit {
		Long numberParam = validateRequestParameter(paramFromQuery, "long");
		
		String longListResponse = processor.getFizzBuzzAsFullList(numberParam);
		System.out.println("Long List generated for:" + numberParam);
		
		return new LongListResponse(longListResponse);
	}

	@Override
	public ShortListResponse processShortListResponse(String paramFromQuery) throws InvalidNumberParamException, ParamNumberExceedsLimit {
		Long numberParam = validateRequestParameter(paramFromQuery, "short");
		
		Map<Long, String> shortListResponse = processor.getFizzBuzzAsShortList(numberParam);
		System.out.println("Short List generated for:" + numberParam);
		
		return new ShortListResponse(shortListResponse);
	}

	private Long validateRequestParameter(String param, String mode)
			throws InvalidNumberParamException, ParamNumberExceedsLimit {
		// First Parse param number
		Long numberParam = null;
		try {
			numberParam = new Long(param);
		} catch (Exception e) {
			throw new InvalidNumberParamException();
		}
		if (mode == "long") {
			if (numberParam <= Constants.LONG_LIMIT) {
				return numberParam;
			} else
				throw new ParamNumberExceedsLimit();

		} else if (mode == "short") {
			return numberParam;
		}

		throw new RuntimeException();
	}

}
