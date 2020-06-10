package com.example.sahil.practice.number_manipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.example.sahil.practice.number_manipulation.NumberBaseManipulation.*;

public class NumberBaseManipulationTest {
    private static final Logger log = LoggerFactory.getLogger(NumberBaseManipulationTest.class);


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
    public void getBinaryIntUsingSimpleMathTest() {
        log.info("Expected={}, Actual={}", Integer.toBinaryString(4), getBinaryIntFromDecimalUsingSimpleMath(4));
        log.info("Expected={}, Actual={}", Integer.toBinaryString(-4), getBinaryIntFromDecimalUsingSimpleMath(-4));
        Assertions.assertEquals(Integer.toBinaryString(4), getBinaryIntFromDecimalUsingSimpleMath(4));
        Assertions.assertEquals(Integer.toBinaryString(-4), getBinaryIntFromDecimalUsingSimpleMath(-4));

    }

    @Test
    public void getBinaryDoubleUsingSimpleMathTest() {
        log.info(" Actual={}", getBinaryDoubleFromDecimalUsingSimpleMath(4.375));
        log.info(" Actual={}", getBinaryDoubleFromDecimalUsingSimpleMath(-4.375));
        log.info(" Actual={}", getBinaryDoubleFromDecimalUsingSimpleMath(-5.735));
        Assertions.assertEquals("100.011", getBinaryDoubleFromDecimalUsingSimpleMath(4.375));
        Assertions.assertEquals("11111111111111111111111111111100.011", getBinaryDoubleFromDecimalUsingSimpleMath(-4.375));
        Assertions.assertEquals("11111111111111111111111111111101.101", getBinaryDoubleFromDecimalUsingSimpleMath(-5.735));

    }

    @Test
    public void getDecimalFromBinaryTest() {
        log.info(" Actual={}", getDecimalFromBinary(0b101));
    }

    @Test
    public void getOctalFromDecimalTest() {
        log.info("Expected={}, Actual={}", Integer.toOctalString(4), getOctalFromDecimal(4));
        //log.info("Expected={}, Actual={}", Integer.toOctalString(-4), getOctalFromDecimal(-4));
        Assertions.assertEquals("4",  getOctalFromDecimal(4));

        log.info("Expected={}, Actual={}", Integer.toOctalString(5), getOctalFromDecimal(5));
        //log.info("Expected={}, Actual={}", Integer.toOctalString(-5), getOctalFromDecimal(-5));
        Assertions.assertEquals("5",  getOctalFromDecimal(5));

        log.info("Expected={}, Actual={}", Integer.toOctalString(9), getOctalFromDecimal(9));
        //log.info("Expected={}, Actual={}", Integer.toOctalString(-9), getOctalFromDecimal(-9));
        Assertions.assertEquals("11",  getOctalFromDecimal(9));

    }

    @Test
    public void getHexadecimalFromDecimalTest() {
        log.info("Expected={}, Actual={}", Integer.toHexString(4), getHexadecimalFromDecimal(4));
        //log.info("Expected={}, Actual={}", Integer.toHexString(-4), getHexadecimalFromDecimal(-4));
        Assertions.assertEquals("4",  getHexadecimalFromDecimal(4));

        log.info("Expected={}, Actual={}", Integer.toHexString(15), getHexadecimalFromDecimal(15));
        //log.info("Expected={}, Actual={}", Integer.toHexString(-15), getHexadecimalFromDecimal(-15));
        Assertions.assertEquals("f",  getHexadecimalFromDecimal(15));

        log.info("Expected={}, Actual={}", Integer.toHexString(17), getHexadecimalFromDecimal(17));
        //log.info("Expected={}, Actual={}", Integer.toHexString(-17), getHexadecimalFromDecimal(-17));
        Assertions.assertEquals("11",  getHexadecimalFromDecimal(17));

        log.info("Expected={}, Actual={}", Integer.toHexString(127), getHexadecimalFromDecimal(127));
        //log.info("Expected={}, Actual={}", Integer.toHexString(-17), getHexadecimalFromDecimal(-17));
        Assertions.assertEquals("7f",  getHexadecimalFromDecimal(127));

        log.info("Expected={}, Actual={}", Integer.toHexString(255), getHexadecimalFromDecimal(255));
        //log.info("Expected={}, Actual={}", Integer.toHexString(-17), getHexadecimalFromDecimal(-17));
        Assertions.assertEquals("ff",  getHexadecimalFromDecimal(255));

    }

    // FOR TIME TRACKING
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }
}
