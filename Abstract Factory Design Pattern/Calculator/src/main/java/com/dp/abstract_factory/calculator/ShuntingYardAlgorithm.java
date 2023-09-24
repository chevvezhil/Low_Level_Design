package com.dp.abstract_factory.calculator;

import java.util.Stack;

public class ShuntingYardAlgorithm {

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
				double result = PerformCalculation.performOperation(operand1, operand2, c);
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

	public static void main(String[] args) {
		String expression = "4+6*5/3-9";
		double result = calculate(expression);
		System.out.println("Result: " + result);
	}
}
