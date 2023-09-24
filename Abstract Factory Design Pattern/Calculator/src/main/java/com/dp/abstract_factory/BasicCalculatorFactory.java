package com.dp.abstract_factory;

import com.dp.abstract_factory.calculator.BasicCalculator;
import com.dp.abstract_factory.calculator.CalculatorOperations;

public class BasicCalculatorFactory implements CalculatorFactory{

	@Override
	public CalculatorOperations createCalculator() {
		return new BasicCalculator();
	}

}
