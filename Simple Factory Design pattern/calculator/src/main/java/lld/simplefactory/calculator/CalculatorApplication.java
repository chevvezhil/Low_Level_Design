package lld.simplefactory.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lld.simplefactory.calculator.factory.CalculateFactory;
import lld.simplefactory.calculator.utill.ICalculateOperation;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		
	}

}
