package com.dp.abstract_factory.calculator;
import com.dp.abstract_factory.BasicCalculatorFactory;
import com.dp.abstract_factory.CalculatorFactory;

public class PerformCalculation {
    
    //TODO: Need to convert using factory method pattern
    public static double performOperation(double operand1, double operand2, char operator) {
       
    	CalculatorFactory calculatorFactory = new BasicCalculatorFactory();
    	Calculator calculator = calculatorFactory.createCalculator();
		
    	
    	switch (operator) {
            case '+':
                return calculator.add(operand1 , operand2);
            case '-':
                return calculator.subtract(operand1, operand2);
            case '*':
                return calculator.multiply(operand1, operand2);
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return calculator.divide(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
