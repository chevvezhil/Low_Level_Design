package lld.simplefactory.calculator.factory;

import lld.simplefactory.calculator.Addition;
import lld.simplefactory.calculator.Division;
import lld.simplefactory.calculator.Multiplication;
import lld.simplefactory.calculator.Subtraction;
import lld.simplefactory.calculator.utill.ICalculateOperation;

public class CalculateFactory {
	
	//Responsible to create object

	public static ICalculateOperation createOperation(String type) {

		switch (type) {

		case "ADD":
			return new Addition();
		case "SUB":
			return new Subtraction();
		case "MUL":
			return new Multiplication();
		case "DIV" :
			return new Division();
				
		default:
			return null;

		}

	}
}
