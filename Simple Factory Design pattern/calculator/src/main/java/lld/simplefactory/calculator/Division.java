package lld.simplefactory.calculator;

import lld.simplefactory.calculator.utill.ICalculateOperation;

public class Division implements ICalculateOperation{

	@Override
	public double performOperation(double operand1, double operand2) {
		 if (operand2 != 0) {
	            return operand1 / operand2;
	        } else {
	            throw new IllegalArgumentException("Division by zero is not allowed");
	        }
	}
	

}
