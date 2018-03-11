package com.serviceflow.recruitment.fizzbuzzapp.application;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.serviceflow.recruitment.fizzbuzzapp.algorithm.FizzBuzzAlgorithmService;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.InvalidNumberParamException;
import com.serviceflow.recruitment.fizzbuzzapp.exceptions.ParamNumberExceedsLimit;
import com.serviceflow.recruitment.fizzbuzzapp.model.LongListResponse;
import com.serviceflow.recruitment.fizzbuzzapp.model.ShortListResponse;

@RunWith(MockitoJUnitRunner.class)
public class AppServiceImplTest {

	@InjectMocks
	AppServiceImpl appServiceImpl;
	
	@Mock
	FizzBuzzAlgorithmService processor;
	
	
	@Test
	(expected = InvalidNumberParamException.class)
	public void processLongListResponseThrowsInvalidNumberParamExceptionWhenParamNumberIsNotALongNumber() throws InvalidNumberParamException, ParamNumberExceedsLimit{
		
		appServiceImpl.processLongListResponse("num3");
		
	}
	
	@Test
	(expected = ParamNumberExceedsLimit.class)
	public void processLongListResponseThrowsParamNumberExceedsLimitWhenParamExceedsThreshold() throws InvalidNumberParamException, ParamNumberExceedsLimit{
		
		appServiceImpl.processLongListResponse("100000000000000");
	}
	
	@Test
	public void processLongListResponseReturnsALongListResponseThatContainsFizzBuzzFromAlgorithmService() throws InvalidNumberParamException, ParamNumberExceedsLimit {
		
		Mockito.when(processor.getFizzBuzzAsFullList(500L)).thenReturn("1 2 Fizz");
		
		LongListResponse response = appServiceImpl.processLongListResponse("500");
		
		assertNotNull(response);
		assertNotNull(response.getFizzBuzz());
		assertEquals("1 2 Fizz", response.getFizzBuzz());
	}
	
	@Test
	(expected = InvalidNumberParamException.class)
	public void processShortListResponseThrowsInvalidNumberParamExceptionWhenParamNumberIsNotALongNumber() throws InvalidNumberParamException, ParamNumberExceedsLimit{
		
		appServiceImpl.processShortListResponse("num3");
		
	}
	
	@Test
	public void processShortListResponseDoesNotThrowsParamNumberExceedsLimitWhenParamNumberIsHigh() throws InvalidNumberParamException, ParamNumberExceedsLimit{
		
		appServiceImpl.processShortListResponse("100000000000000");
		
	}
	
	@Test
	public void processShortListResponseReturnsAShortListResponseThatContainsFizzBuzzFromAlgorithmService() throws InvalidNumberParamException, ParamNumberExceedsLimit{
		Map<Long, String> mapToBeReturnedByAlgorithmService = new HashMap<>();
		mapToBeReturnedByAlgorithmService.put(5L, "Buzz");
		mapToBeReturnedByAlgorithmService.put(3L, "Fizz");
		
		Mockito.when(processor.getFizzBuzzAsShortList(8L)).thenReturn(mapToBeReturnedByAlgorithmService);
		
		ShortListResponse response = appServiceImpl.processShortListResponse("8");
		
		assertNotNull(response);
		assertNotNull(response.getFizzBuzz());
		assertEquals("Buzz", response.getFizzBuzz().get(5L));
		assertEquals("Fizz", response.getFizzBuzz().get(3L));
	}
	
}
