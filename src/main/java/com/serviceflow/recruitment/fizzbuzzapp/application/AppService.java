package com.serviceflow.recruitment.fizzbuzzapp.application;

import com.serviceflow.recruitment.fizzbuzzapp.exceptions.InvalidNumberParamException;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.ParamNumberExceedsLimit;
import com.serviceflow.recruitment.fizzbuzzapp.model.LongListResponse;
import com.serviceflow.recruitment.fizzbuzzapp.model.ShortListResponse;

public interface AppService {
	
	LongListResponse processLongListResponse(String paramFromQuery) throws InvalidNumberParamException, ParamNumberExceedsLimit;

	ShortListResponse processShortListResponse(String paramFromQuery) throws InvalidNumberParamException, ParamNumberExceedsLimit;
}
