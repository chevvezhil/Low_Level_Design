package com.dp.abstrct_factory.util;

public class BasicAddition implements Addition{

	@Override
	public double calculate(double operand1, double operand2) {
		
		return operand1+operand2;
	}

}
