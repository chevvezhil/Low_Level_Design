package com.dp.abstrct_factory.util;

//concerte factory;
public class BasicMathOperation implements CalculatorFactory {

	@Override
	public Addition createAddition() {
		return new BasicAddition();
	}

	@Override
	public Subtraction createSubtraction() {
		return new BasicSubtraction();
	}

	@Override
	public Multiplication createMultiplication() {
		return new BasicMultiplication();
	}

	@Override
	public Division createDivision() {
		return new BasicDivision();
	}

}
