package com.dp.abstract_factory.calculator;
import java.util.Stack;

import com.dp.abstrct_factory.util.Addition;
import com.dp.abstrct_factory.util.CalculatorFactory;
import com.dp.abstrct_factory.util.Division;
import com.dp.abstrct_factory.util.Multiplication;
import com.dp.abstrct_factory.util.Subtraction;

public class Calculator {
    public static double calculate(String expression) {
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private static String infixToPostfix(String infix) {
      
    	StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop the '('
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    private static double evaluatePostfix(String postfix) {
        Stack<Double> operandStack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                operandStack.push((double) (c - '0'));
            } else if (isOperator(c)) {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(operand1, operand2, c);
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    
    //TODO: Need to convert using factory method pattern
    private static double performOperation(double operand1, double operand2, char operator) {
       
    	CalculatorFactory basicCalculator = CalculatorFactory.createCalculatorFactory("basic");
		Addition basicAddition = basicCalculator.createAddition();
		Subtraction basicSubtraction= basicCalculator.createSubtraction();
		Multiplication basicMultiplication= basicCalculator.createMultiplication();
		Division basicDivision = basicCalculator.createDivision();
    	
    	
    	switch (operator) {
            case '+':
                return basicAddition.calculate(operand1 , operand2);
            case '-':
                return basicSubtraction.calculate(operand1, operand2);
            case '*':
                return basicMultiplication.calculate(operand1, operand2);
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return basicDivision.calculate(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "4+6*5/3-9";
        double result = calculate(expression);
        System.out.println("Result: " + result);
    }
}
