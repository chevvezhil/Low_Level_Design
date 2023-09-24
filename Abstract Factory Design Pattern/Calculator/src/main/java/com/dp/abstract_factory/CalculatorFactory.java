package com.dp.abstract_factory;

import com.dp.abstract_factory.calculator.CalculatorOperations;

public interface CalculatorFactory {

	CalculatorOperations createCalculator();
	
}
