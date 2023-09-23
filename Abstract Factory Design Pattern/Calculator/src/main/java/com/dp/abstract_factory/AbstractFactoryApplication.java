package com.dp.abstract_factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dp.abstrct_factory.util.Addition;
import com.dp.abstrct_factory.util.CalculatorFactory;
import com.dp.abstrct_factory.util.Subtraction;

@SpringBootApplication
public class AbstractFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbstractFactoryApplication.class, args);
		
		CalculatorFactory basicCalculator = CalculatorFactory.createCalculatorFactory("basic");
		
		Addition basicAddition = basicCalculator.createAddition();
		Subtraction basicSubtraction = basicCalculator.createSubtraction();
		
		System.out.println("basic addition " + basicAddition.calculate(10, 20));
		System.out.println("basic subtraction " + basicSubtraction.calculate(10, 20));
		
		CalculatorFactory scientificCalculator = CalculatorFactory.createCalculatorFactory("scientific");
		
		Addition scientificAdd = scientificCalculator.createAddition();
		Subtraction scientificSub = scientificCalculator.createSubtraction();
		
		
		System.out.println("basic addition " + scientificAdd.calculate(10, 20));
		System.out.println("basic subtraction " + scientificSub.calculate(10, 20));
		

	}

}
