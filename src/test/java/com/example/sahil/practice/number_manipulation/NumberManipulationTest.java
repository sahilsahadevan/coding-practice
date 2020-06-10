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
    public void getNumberOfDigitsTest() {
        Assertions.assertEquals(4, getNumberOfDigits(1234));
        Assertions.assertEquals(1, getNumberOfDigits(1));
        Assertions.assertEquals(1, getNumberOfDigits(0));
        Assertions.assertEquals(1, getNumberOfDigits(7));
        Assertions.assertEquals(2, getNumberOfDigits(43));

    }

    @Test
    public void getFloorOfNumTest() {
        Assertions.assertEquals(1000, getFloorOfNumber(1234));
        Assertions.assertEquals(1, getFloorOfNumber(1));
        Assertions.assertEquals(1, getFloorOfNumber(0));
        Assertions.assertEquals(1, getFloorOfNumber(7));
        Assertions.assertEquals(10, getFloorOfNumber(43));
        Assertions.assertEquals(10000, getFloorOfNumber(35672));

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
        log.info("{}", getNextLargestNumberWithoutGivenDigitUsingRecursive(1114, 4));
        Assertions.assertEquals(999, getNextLargestNumberWithoutGivenDigitUsingRecursive(1000, 1));
        Assertions.assertEquals(1113, getNextLargestNumberWithoutGivenDigitUsingRecursive(1114, 4));
        Assertions.assertEquals(1113, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(1114, 4));
        Assertions.assertEquals(1113, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration(1114, 4));
        Assertions.assertEquals(2299,getNextLargestNumberWithoutGivenDigitUsingRecursive(2345, 3));
        Assertions.assertEquals(2299, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(2345, 3));
        Assertions.assertEquals(2999,getNextLargestNumberWithoutGivenDigitUsingRecursive(3311, 3));
        Assertions.assertEquals(2999, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(3311, 3));
        Assertions.assertEquals(999,getNextLargestNumberWithoutGivenDigitUsingRecursive(1110, 0));
        Assertions.assertEquals(999, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(1110, 0));
        Assertions.assertEquals(999, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration(1110, 0));
        Assertions.assertEquals(999,getNextLargestNumberWithoutGivenDigitUsingRecursive(1110, 1));
        Assertions.assertEquals(999, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(1110, 1));
        Assertions.assertEquals(888,getNextLargestNumberWithoutGivenDigitUsingRecursive(999, 9));
        Assertions.assertEquals(888, getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(999, 9));
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
        Assertions.assertEquals(497794, addToReverseUntilPalindromeUsingRecursive(7325));
        Assertions.assertEquals(497794, addToReverseUntilPalindromeUsingLogicalIteration(7325));
        Assertions.assertEquals(6556, addToReverseUntilPalindromeUsingRecursive(1325));
        Assertions.assertEquals(6556, addToReverseUntilPalindromeUsingLogicalIteration(1325));
        Assertions.assertEquals(55, addToReverseUntilPalindromeUsingRecursive(7));
        Assertions.assertEquals(55, addToReverseUntilPalindromeUsingLogicalIteration(7));

    }

    @Test
    public void getRomanNumeralsTest() {
        Assertions.assertEquals("MMMDXLII",convertToRomanNumerals(3542));
        Assertions.assertEquals("MMMDXLII", convertToRomanNumeralsUsingTreeMapAndRecursive(3542));
        Assertions.assertEquals("XX",convertToRomanNumerals(20));
        Assertions.assertEquals("XX", convertToRomanNumeralsUsingTreeMapAndRecursive(20));
        Assertions.assertEquals("XL",convertToRomanNumerals(40));
        Assertions.assertEquals("XL", convertToRomanNumeralsUsingTreeMapAndRecursive(40));
        Assertions.assertEquals("XLI",convertToRomanNumerals(41));
        Assertions.assertEquals("XLI", convertToRomanNumeralsUsingTreeMapAndRecursive(41));
        Assertions.assertEquals("L",convertToRomanNumerals(50));
        Assertions.assertEquals("L", convertToRomanNumeralsUsingTreeMapAndRecursive(50));
        Assertions.assertEquals("LI",convertToRomanNumerals(51));
        Assertions.assertEquals("LI", convertToRomanNumeralsUsingTreeMapAndRecursive(51));
        Assertions.assertEquals("LXVII",convertToRomanNumerals(67));
        Assertions.assertEquals("LXVII", convertToRomanNumeralsUsingTreeMapAndRecursive(67));
        Assertions.assertEquals("XCVIII",convertToRomanNumerals(98));
        Assertions.assertEquals("XCVIII", convertToRomanNumeralsUsingTreeMapAndRecursive(98));
        Assertions.assertEquals("XCIX",convertToRomanNumerals(99));
        Assertions.assertEquals("XCIX", convertToRomanNumeralsUsingTreeMapAndRecursive(99));
        Assertions.assertEquals("DCCLXXX",convertToRomanNumerals(780));
        Assertions.assertEquals("DCCLXXX", convertToRomanNumeralsUsingTreeMapAndRecursive(780));
        Assertions.assertEquals("DXLI",convertToRomanNumerals(541));
        Assertions.assertEquals("DXLI", convertToRomanNumeralsUsingTreeMapAndRecursive(541));
        Assertions.assertEquals("I",convertToRomanNumerals(1));
        Assertions.assertEquals("I", convertToRomanNumeralsUsingTreeMapAndRecursive(1));

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
