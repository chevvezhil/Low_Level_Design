package com.dp.abstrct_factory.util;

public class ScientificSubtraction implements Subtraction{
	
	@Override
	public double calculate(double operand1, double operand2) {
		
		return operand2-operand1;
	}

}
