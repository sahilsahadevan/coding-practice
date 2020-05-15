package com.example.sahil.practice.number_manipulation;

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
        long time = System.currentTimeMillis();
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingIteration(153));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingMathUtil(153));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingIteration(548834));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertTrue(NumberManipulation.isArmstrongNumberUsingMathUtil(548834));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertFalse(NumberManipulation.isArmstrongNumberUsingIteration(154));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertFalse(NumberManipulation.isArmstrongNumberUsingMathUtil(154));
        executionTime(time);
    }

    @Test
    public void getNextLargestNumberWithoutGivenDigitTest() {
        long time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", NumberManipulation.getNextLargestNumberWithoutGivenDigitUsingRecursive(1114, 4));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", NumberManipulation.getNextLargestNumberWithoutGivenDigitUsingRecursive(2345, 3));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", NumberManipulation.getNextLargestNumberWithoutGivenDigitUsingRecursive(3311, 3));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", NumberManipulation.getNextLargestNumberWithoutGivenDigitUsingRecursive(1110, 0));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", NumberManipulation.getNextLargestNumberWithoutGivenDigitUsingRecursive(1110, 1));
        executionTime(time);
    }


    @Test
    public void isBinaryTest() {
        Assertions.assertTrue(NumberManipulation.isBinary(11101110000L));
        Assertions.assertTrue(NumberManipulation.isBinary(11100));
        Assertions.assertTrue(NumberManipulation.isBinary(1111111111111L));
        Assertions.assertTrue(NumberManipulation.isBinary(1111));
        Assertions.assertTrue(NumberManipulation.isBinary(0));
        Assertions.assertTrue(NumberManipulation.isBinary(111011L));
        Assertions.assertFalse(NumberManipulation.isBinary(12));
        Assertions.assertFalse(NumberManipulation.isBinary(121111111L));
        Assertions.assertFalse(NumberManipulation.isBinary(1239187902L));
        Assertions.assertFalse(NumberManipulation.isBinary(42L));


    }

    @Test
    public void test() {
        long time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", NumberManipulation.isBinary(19991));
        executionTime(time);
    }


    // FOR TIME TRACKING
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }
}
