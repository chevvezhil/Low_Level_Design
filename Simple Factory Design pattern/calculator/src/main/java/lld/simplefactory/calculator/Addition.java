package lld.simplefactory.calculator;

import lld.simplefactory.calculator.utill.ICalculateOperation;

public class Addition implements ICalculateOperation{

	@Override
	public double performOperation(double operand1, double operand2) {
		return operand1+operand2;
	}

}


