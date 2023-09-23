package com.dp.abstrct_factory.util;

public interface CalculatorFactory {
	//Abstract Factory
	
	Addition createAddition();
	Subtraction createSubtraction();
	Multiplication createMultiplication();
	Division createDivision();
	
	
	public static CalculatorFactory createCalculatorFactory(String type) {
		if(type.equalsIgnoreCase("basic"))
			return new BasicMathOperation();
		else if(type.equalsIgnoreCase("scientific"))
			return new ScientificMathOperation();
		
		else 
			return null;
			
	}

}
