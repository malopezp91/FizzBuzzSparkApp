package com.serviceflow.recruitment.fizzbuzzapp.application;

import com.serviceflow.recruitment.fizzbuzzapp.exceptions.InvalidNumberInRequestException;
import com.serviceflow.recruitment.fizzbuzzapp.model.LongListResponse;
import com.serviceflow.recruitment.fizzbuzzapp.model.ShortListResponse;

public interface AppService {
	
	LongListResponse processLongListResponse(String values) throws InvalidNumberInRequestException;

	ShortListResponse processShortListResponse(String values) throws InvalidNumberInRequestException;
}
