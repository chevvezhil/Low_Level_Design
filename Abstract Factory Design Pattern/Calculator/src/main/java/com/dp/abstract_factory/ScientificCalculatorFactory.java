package com.dp.abstract_factory;

import com.dp.abstract_factory.calculator.Calculator;
import com.dp.abstract_factory.calculator.ScientificCalculator;

public class ScientificCalculatorFactory implements CalculatorFactory {
    @Override
    public Calculator createCalculator() {
        return new ScientificCalculator();
    }
}