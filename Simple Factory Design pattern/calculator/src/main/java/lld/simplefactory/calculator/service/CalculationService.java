package lld.simplefactory.calculator.service;

import java.util.ArrayList;
import java.util.List;

import lld.simplefactory.calculator.model.CalculatedOperations;

public class CalculationService {

	
	private static List<CalculatedOperations> operations = new ArrayList<>();
	
	public static void addOperations(CalculatedOperations operation) {
		operations.add(operation);
	}
	
	public static List<CalculatedOperations> getAllOperations(){
		return operations;
	}
}
