package com.dp.abstract_factory.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dp.abstract_factory.calculator.ShuntingYardAlgorithm;

@Controller
public class CalculatorController {

	HashMap<String, String> storeOperations = new HashMap<>();

	@PostMapping("/Calculate")
	public ResponseEntity<Double> performCalculation(@RequestBody String expression) {
		Double result = ShuntingYardAlgorithm.calculate(expression);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/Save")
	public ResponseEntity<String> saveOperation(@RequestBody Map<String, String> requestBody) {

		String name = requestBody.get("name");
		String expression = requestBody.get("expression");

		if (storeOperations.containsKey("name"))
			return ResponseEntity.ok("Please choose different name");

		else
			storeOperations.put(name, expression);

		return ResponseEntity.ok("Success");
	}

	@PostMapping("/Get")
	public ResponseEntity<String> getExpression(@RequestBody String key) {
		return ResponseEntity.ok(storeOperations.get(key));
	}
}
