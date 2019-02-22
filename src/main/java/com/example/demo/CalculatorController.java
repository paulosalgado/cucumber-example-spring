package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@GetMapping("/add")
	public int add(@RequestParam int value1, @RequestParam int value2) {
		return value1 + value2;
	}
	
}
