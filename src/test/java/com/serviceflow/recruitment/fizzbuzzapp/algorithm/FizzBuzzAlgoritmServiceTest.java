package com.serviceflow.recruitment.fizzbuzzapp.algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.junit.Before;
import org.junit.Test;

import com.serviceflow.recruitment.fizzbuzzapp.algorithm.impl.FizzBuzzAlgorithmServiceImpl;

public class FizzBuzzAlgoritmServiceTest {
	
	FizzBuzzAlgorithmService algorithmService;
	
	List<String> listWithOnlyZeroValue;
	
	List<String> listAsNull;
	
	List<String> fullListUpTo20;
	
	Map<Long, String> shortListUpTo20;
	
	
	
	@Before
	public void setup(){
		algorithmService = new FizzBuzzAlgorithmServiceImpl();
		
		listWithOnlyZeroValue = new ArrayList<String>();
		listWithOnlyZeroValue.add(new Integer(0).toString());
		
		listAsNull = null;
		
		fullListUpTo20 = Arrays.asList(TestConstants.upTo20Long.split(" "));
		
		shortListUpTo20 = TestConstants.upTo20Short;
	}
	
	@Test
	public void whenGetFizzBuzzAsFullListIsCalledWith20ResultEqualsExpectedList(){
		String response = algorithmService.getFizzBuzzAsFullList(20L);
		
		assertNotNull(response);
		assertEquals(response, TestConstants.upTo20Long);
	}
	
	@Test
	public void whenGetFizzBuzzAsShortListIsCalledWith20ResultEqualsExpectedMap(){
		Map<Long, String> response = algorithmService.getFizzBuzzAsShortList(20L);
		
		assertNotNull(response);
		assertEquals(9, response.keySet().size());
		System.out.println(response.keySet());
		
		response.keySet().forEach(key -> {
			System.out.println(response.get(key));
			assertNotNull(TestConstants.upTo20Short.get(key));
			assertEquals(TestConstants.upTo20Short.get(key), response.get(key));
		});
	}
	
	@Test
	public void for1000000FizzBuzz(){
		Map<Long, String> response = algorithmService.getFizzBuzzAsShortList(10000L);
		System.out.println(response.keySet().size());
	}
}
