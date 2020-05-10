package com.example.sahil.practice.number_manipulation;

import com.example.sahil.practice.array_manipulation.ArrayManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberManipulationTest {
    private static final Logger log = LoggerFactory.getLogger(NumberManipulationTest.class);

    @Test
    public void getSumOfDigitsDigitsTest() {
        Integer input = 123;
        Assertions.assertEquals(6, NumberManipulation.getSumOfDigits(input));
        log.info("values is ===> {}", input);
    }

    @Test
    public void checkIfArmstrongNumberTest() {
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingIteration(153));
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingMathUtil(153));
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingIteration(548834));
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingMathUtil(548834));
        Assertions.assertFalse(NumberManipulation.isArmstrongNumberUsingIteration(154));
        Assertions.assertFalse(NumberManipulation.isArmstrongNumberUsingMathUtil(154));
    }

}
