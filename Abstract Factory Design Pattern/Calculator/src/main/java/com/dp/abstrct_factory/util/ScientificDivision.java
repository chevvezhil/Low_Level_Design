package com.dp.abstrct_factory.util;

public class ScientificDivision implements Division{
	@Override
	public double calculate(double operand1, double operand2) {
		 if (operand2 != 0) {
	            return operand1 / operand2;
	        } else {
	            throw new IllegalArgumentException("Division by zero is not allowed");
	        }
	}

}
