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


//================ How to find largest number less than a given number and without a given digit? ==============
    //For example, If 145 is the given number and 4 is the given digit,
    // then you should find the largest number less than 145 such that it should not contain 4 in it.
    // In this case, 139 will be the answer

    public static int getNextLargestNumberWithoutGivenDigitUsingRecursive(int input, int givenDigit) {
        // To break recursive
        if (!String.valueOf(input).contains(String.valueOf(givenDigit))) {
            return input;
        }
        int temp = input;
        //To check for the excluding number at base 1.
        if (temp % 10 == givenDigit) {
            temp = temp - 1;
        }
        int length = String.valueOf(input).length();
        int base = 1;
        //To check the base of the number -> 1, 10, 1000, 10000 etc. e.g.: 345 is in 100s , 12345 is in 10000s.
        for (int i = 1; i < length; i++) {
            base = base * 10;
        }
        int diff = temp;
        //To check each decimal position of the number starting from the highest.
        // by logic : second largest number to, say 1456, without 4 , would be = 1456 - (1456 % 100 + 1)
        for (int i = base; i > 0; ) {
            int digit = diff / i;
            if (digit == givenDigit) {
                diff = diff % i + 1;
                break;
            }
            diff = diff % i;
            i = i / 10;
        }
        // do a recursive check of the initial result
        return getNextLargestNumberWithoutGivenDigitUsingRecursive(temp - diff, givenDigit);
    }

    public static int getNextLargestNumberWithoutGivenDigitUsingIteration(int input, int givenDigit) {
        for (int i = input; i > 0; i--) {
            if (!String.valueOf(i).contains(String.valueOf(givenDigit))) {
                return i;
            }
        }
        return input;
    }

    public static int test(int input, int givenDigit) {
        return String.valueOf(input).lastIndexOf(givenDigit);
    }

//================ How to check whether given number is binary or not? ==========================================


    public static boolean isBinary(long input) {
        char[] inputChar = String.valueOf(input).toCharArray();
        for (char i : inputChar) {
            if (i != '0' && i != '1') {
                return false;
            }
        }
        return true;
    }
}
