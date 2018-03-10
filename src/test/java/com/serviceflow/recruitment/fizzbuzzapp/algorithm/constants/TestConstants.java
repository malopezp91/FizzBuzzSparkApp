package com.serviceflow.recruitment.fizzbuzzapp.algorithm.constants;

import java.util.HashMap;
import java.util.Map;

public class TestConstants {
	public static final String upTo20Long = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz";
	
	public static final Map<Long, String> upTo20Short;
	
	public static final String buzz = "Buzz";
	
	public static final String fizz = "Fizz";
	
	
	static { 
		upTo20Short = new HashMap<>();
		upTo20Short.put(3L, fizz);
		upTo20Short.put(5L, buzz);
		upTo20Short.put(6L, fizz);
		upTo20Short.put(9L, fizz);
		upTo20Short.put(10L, buzz);
		upTo20Short.put(12L, fizz);
		upTo20Short.put(15L, fizz+buzz);
		upTo20Short.put(18L, fizz);
		upTo20Short.put(20L, buzz);
	}
}
