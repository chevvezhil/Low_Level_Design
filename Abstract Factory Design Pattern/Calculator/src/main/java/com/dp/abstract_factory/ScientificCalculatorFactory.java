package com.dp.abstract_factory;

import com.dp.abstract_factory.calculator.CalculatorOperations;
import com.dp.abstract_factory.calculator.ScientificCalculator;

public class ScientificCalculatorFactory implements CalculatorFactory {
    @Override
    public CalculatorOperations createCalculator() {
        return new ScientificCalculator();
    }
}