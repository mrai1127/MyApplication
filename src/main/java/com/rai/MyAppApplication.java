package com.rai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rai.exception.MyAppException;
import com.rai.service.MyService;

@SpringBootApplication
@RestController
public class MyAppApplication {
	
	@Autowired
	private MyService myService;
	
	@GetMapping("/")
	public String hello() {
		return "Hello, world!";
	}
	
	@GetMapping("/error")
	public void error() {
		throw new MyAppException("This is a test exception.");
	}
	
	@GetMapping("/process")
	public String process() {
		return myService.doSomeLogic("input");
	}
	
	@ExceptionHandler(MyAppException.class)
	public ResponseEntity<String> handleException(MyAppException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

}
