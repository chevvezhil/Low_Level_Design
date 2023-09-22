package lld.simplefactory.calculator.model;

import lombok.Data;

@Data
public class CalculatedOperations {

	private String operation;
	private double operand1;
	private double operand2;
	private double result;
}
