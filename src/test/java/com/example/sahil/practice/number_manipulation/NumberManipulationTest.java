package com.example.sahil.practice.number_manipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import static com.example.sahil.practice.number_manipulation.NumberManipulation.*;

public class NumberManipulationTest {
    private static final Logger log = LoggerFactory.getLogger(NumberManipulationTest.class);

    @Test
    public void getPowerofNumTest() {
        Assertions.assertEquals(64, getPowersOfNum(8, 2));
        Assertions.assertEquals(8, getPowersOfNum(2, 3));

    }

    @Test
    public void getSumOfDigitsTest() {
        Integer input = 123;
        Assertions.assertEquals(6, getSumOfDigits(input));
        log.info("values is ===> {}", input);
    }

    @Test
    public void checkIfArmstrongNumberTest() {
        long time = System.currentTimeMillis();
        Assertions.assertTrue(isArmstrongNumberUsingIteration(153));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertTrue(isArmstrongNumberUsingMathUtil(153));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertTrue(isArmstrongNumberUsingIteration(548834));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertTrue(isArmstrongNumberUsingMathUtil(548834));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertFalse(isArmstrongNumberUsingIteration(154));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertFalse(isArmstrongNumberUsingMathUtil(154));
        executionTime(time);
    }

    @Test
    public void getNextLargestNumberWithoutGivenDigitTest() {
        long time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", getNextLargestNumberWithoutGivenDigitUsingRecursive(1114, 4));
        Assertions.assertEquals(1113, getNextLargestNumberWithoutGivenDigitUsingRecursive(1114, 4));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertEquals(2299,getNextLargestNumberWithoutGivenDigitUsingRecursive(2345, 3));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertEquals(2999,getNextLargestNumberWithoutGivenDigitUsingRecursive(3311, 3));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertEquals(999,getNextLargestNumberWithoutGivenDigitUsingRecursive(1110, 0));
        executionTime(time);
        time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        Assertions.assertEquals(999,getNextLargestNumberWithoutGivenDigitUsingRecursive(1110, 1));
        executionTime(time);
    }

    @Test
    public void isBinaryTest() {
        Assertions.assertTrue(isBinary(11101110000L));
        Assertions.assertTrue(isBinary(11100));
        Assertions.assertTrue(isBinary(1111111111111L));
        Assertions.assertTrue(isBinary(1111));
        Assertions.assertTrue(isBinary(0));
        Assertions.assertTrue(isBinary(111011L));
        Assertions.assertFalse(isBinary(12));
        Assertions.assertFalse(isBinary(121111111L));
        Assertions.assertFalse(isBinary(1239187902L));
        Assertions.assertFalse(isBinary(42L));


    }

    @Test
    public void isNumberTest() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Assertions.assertTrue(isNumber());
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Assertions.assertTrue(isNumberUsingUtils());
        System.setIn(new ByteArrayInputStream("0.0".getBytes()));
        Assertions.assertTrue(isNumber());
        System.setIn(new ByteArrayInputStream("0.0".getBytes()));
        Assertions.assertTrue(isNumberUsingUtils());
        System.setIn(new ByteArrayInputStream("121837014270982418".getBytes()));
        Assertions.assertTrue(isNumber());
        System.setIn(new ByteArrayInputStream("121837014270982418".getBytes()));
        Assertions.assertTrue(isNumberUsingUtils());
        System.setIn(new ByteArrayInputStream("123WRONG".getBytes()));
        Assertions.assertFalse(isNumber());
        System.setIn(new ByteArrayInputStream("123WRONG".getBytes()));
        Assertions.assertFalse(isNumberUsingUtils());

    }


    @Test
    public void printTrigonometricValuesTest() {
        printTrigonometricValues(0);
        printTrigonometricValues(30);
        printTrigonometricValues(60);
        printTrigonometricValues(90);
    }

    @Test
    public void getPositiveTest() {
        Assertions.assertEquals(25, getPositive(-25));
        Assertions.assertEquals(25, getPositive(25));
    }

    @Test
    public void splitDecimalTest() {
        log.info("{}", splitDecimalsInDouble(4.12));
        log.info("{}", splitBDecimalsInBigDecimal(new BigDecimal("4.12")));

    }

    @Test
    public void addToReverseUntilPalindromeTest() {
        Assertions.assertEquals(5231, addToReverseUntilPalindrome(1325));
        Assertions.assertEquals(25, addToReverseUntilPalindrome(52));

    }

    @Test
    public void test() {
        long time = System.currentTimeMillis();
        log.info("StartTime is {}", time);
        log.info("{}", 5 % 10);
        executionTime(time);
    }


    // FOR TIME TRACKING
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }
}
