package com.dp.abstrct_factory.util;

//concrete Factory
public class ScientificMathOperation implements CalculatorFactory {

	@Override
	public Addition createAddition() {
		return new ScientificAddition();
	}

	@Override
	public Subtraction createSubtraction() {
		return new ScientificSubtraction();
	}

	@Override
	public Multiplication createMultiplication() {
		return new ScientificMultiplication();
	}

	@Override
	public Division createDivision() {
		return new ScientificDivision();
	}

}
