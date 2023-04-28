package com.rai.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	public String doSomeLogic(String input) {
		String output;
		if(input.equals("Hello")) {
			output = "World";
		}else {
			output = "Unknown";
		}
		return "Processed " + input;
	}
}
