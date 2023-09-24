package com.dp.abstract_factory.calculator;

public class BasicCalculator implements CalculatorOperations{

	 @Override
	    public double add(double x, double y) {
	        return x + y;
	    }

	    @Override
	    public double subtract(double x, double y) {
	        return x - y;
	    }

	    @Override
	    public double multiply(double x, double y) {
	        return x * y;
	    }

	    @Override
	    public double divide(double x, double y) {
	        if (y == 0) {
	            throw new ArithmeticException("Division by zero");
	        }
	        return x / y;
	    }


}
