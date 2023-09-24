package com.dp.abstract_factory;

import com.dp.abstract_factory.calculator.BasicCalculator;
import com.dp.abstract_factory.calculator.Calculator;

public class BasicCalculatorFactory implements CalculatorFactory{

	@Override
	public Calculator createCalculator() {
		return new BasicCalculator();
	}

}
