package com.example.sahil.practice.number_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberManipulation {

    private static final Logger log = LoggerFactory.getLogger(NumberManipulation.class);

//===========================How to find sum of all digits of a number in java =============================

    public static Integer getSumOfDigits(Integer input) {
        int result = 0;
        while (input > 0) {
            result = (input % 10) + result;
            input = input / 10;
        }
        return result;
    }

//=========================== Armstrong number program in java  =============================================
    //e.g 153 = 1^3 + 5^3 + 3^3

    // check if Armstrong number (vanilla)
    public static boolean isArmstrongNumberUsingIteration(int num) {
        int length = String.valueOf(num).length();
        int temp = num;
        int result = 0;
        while (temp > 0) {
            int digit = temp % 10;
            int poweredResult = 1;
            // This loop is alternative of Math.pow()
            for (int i = 0; i < length; i++) {
                poweredResult = poweredResult * digit;
            }
            result = result + poweredResult;
            temp = temp / 10;
        }
        log.info("[{}] Input = {}, Result = {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(), num, result);
        return num == result;
    }

    // check if Armstrong number (using Math utils )
    public static boolean isArmstrongNumberUsingMathUtil(int num) {
        double length = String.valueOf(num).length();
        int temp = num;
        double resultDouble = 0;
        while (temp > 0) {
            double tempDouble = temp % 10.0;
            double exponential = Math.pow(tempDouble, length);
            resultDouble = resultDouble + exponential;
            temp = temp / 10;
        }
        int result = (int) resultDouble;
        log.info("[{}] Input = {}, Result = {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(), num, result);
        return num == result;
    }

}
