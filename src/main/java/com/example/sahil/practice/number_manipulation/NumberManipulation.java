package com.example.sahil.practice.number_manipulation;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class NumberManipulation {

    private static final Logger log = LoggerFactory.getLogger(NumberManipulation.class);

//===========================How to Multiply a number with itself a certain number of time =============================

    public static int getPowersOfNum(int input, int toThePowerOf) {
        int result = 1;
        for (int i = 0; i < toThePowerOf; i++) {
            result = result * input;
        }
        return result;
    }

//===========================How to find sum of all digits of a number in java =============================

    public static Integer getSumOfDigits(Integer input) {
        int result = 0;
        while (input > 0) {
            result = (input % 10) + result;
            input = input / 10;
        }
        return result;
    }

//===========================How to find number of all digits in a given number without using String API =============================

    public static int getNumberOfDigits(int input) {
        int numOfDigit = 1;
        int base = 1;
        while (input >= base * 10) {
            base = base * 10;
            numOfDigit++;
        }
        return numOfDigit;
    }

//===========================How to find the floor/base of a given number(e.g 2 is in 1s, 68 is in 10s, 345 is in 100s, 17000 is in 10000s) ================

    //Floor/base of 1, 2, 9 etc. is 1, Floor/base of 12, 45, 99 etc is 10, Floor/base of 5789, 9999, 1000 is 1000 etc.

    public static int getFloorOfNumber(int input) {
        int base = 1;
        while (input >= base * 10) {
            base = base * 10;
        }
        return base;
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
        //To check for the excluding number at base 1.
        if (input % 10 == givenDigit) {
            input = input - 1;
        }
        int base = 1;
        //To check the base of the number -> 1, 10, 1000, 10000 etc. e.g.: 345 is in 100s , 12345 is in 10000s.
        while (input >= base * 10) {
            base = base * 10;
        }
        int diff = input;
        //To check each decimal position of the number starting from the highest.
        // by logic : second largest number to, say 1456, without 4 , would be = 1456 - (1456 % 100 + 1)
        for (int i = base; i > 0; i /= 10) {
            int digit = diff / i;
            if (digit == givenDigit) {
                diff = diff % i + 1;
                break;
            }
            diff = diff % i;
        }
        // do a recursive check of the initial result
        return getNextLargestNumberWithoutGivenDigitUsingRecursive(input - diff, givenDigit);
    }

    // Best iterative solution
    public static int getNextLargestNumberWithoutGivenDigitUsingLogicalIteration(int input, int givenDigit) {
        int result = input;
        while (String.valueOf(result).contains(String.valueOf(givenDigit))) {
            int base = 1;
            //To check the base of the number -> 1, 10, 1000, 10000 etc. e.g.: 345 is in 100s , 12345 is in 10000s.
            while (input >= base * 10) {
                base = base * 10;
            }

            int diff = 0;
            int temp = result;
            //To check each decimal position of the number starting from the highest.
            // by logic : second largest number to, say 1456, without 4 , would be = 1456 - (1456 % 100 + 1)
            while (temp >= 0) {
                int floor = temp / base * base;
                if (givenDigit == floor / base) {
                    diff = (temp - floor) + 1;
                    break;
                }
                temp = temp - floor;
                base = base / 10;
            }
            result = result - diff;
        }
        return result;
    }


    // Using ForLoop  - Not an elegant iterative solution in this case
    public static int getNextLargestNumberWithoutGivenDigitUsingLogicalIteration2(int input, int givenDigit) {
        int result = input;
        while (String.valueOf(result).contains(String.valueOf(givenDigit))) {
            //To check for the excluding number at base 1.
            if (input % 10 == givenDigit) {
                input = input - 1;
            }
            int base = 1;

            //To check the base of the number -> 1, 10, 1000, 10000 etc. e.g.: 345 is in 100s , 12345 is in 10000s.
            while (input >= base * 10) {
                base = base * 10;
            }
            int diff = result;

            //To check each decimal position of the number starting from the highest.
            // by logic : second largest number to, say 1456, without 4 , would be = 1456 - (1456 % 100 + 1)
            for (int i = base; i > 0; i /= 10) {
                int digit = diff / i;
                if (digit == givenDigit) {
                    diff = diff % i + 1;
                    break;
                }
                diff = diff % i;
            }
            result = result - diff;
        }
        return result;
    }

    public static int getNextLargestNumberWithoutGivenDigitUsingBruteForceIteration(int input, int givenDigit) {
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


// ================== How to check whether user input is number or not in java? ====================================

    public static boolean isNumber() {
        System.out.print("Print input -> ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();
        if (scanner.hasNext("")) {
            log.info("Empty input");
            return false;
        }
        value = value.replace(",", "");
        System.out.println(value);
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            log.info("{} is not a Number", value);
            return false;
        }
        log.info("{} is a Number", value);
        return true;
    }

    public static boolean isNumberUsingUtils() {
        System.out.print("Print input -> ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();
        return NumberUtils.isParsable(value);
    }

// ==================  How to find trigonometric values of an angle in java ====================================
    // sin , cos, tan, sec, cosec, tan

    public static void printTrigonometricValues(int input) {
        double sine = Math.sin(input);
        double cosine = Math.cos(input);
        double tangent = Math.tan(input);
        double sec = 1 / sine;
        double cosec = 1 / cosine;
        double cotangent = 1 / tangent;
        log.info("sine of {} is {}", input, sine);
        log.info("cosine of {} is {}", input, cosine);
        log.info("tangent of {} is {}", input, tangent);
        log.info("sec of {} is {}", input, sec);
        log.info("cosec of {} is {}", input, cosec);
        log.info("cotangent of {} is {}", input, cotangent);
    }

// ================== get Unsigned Positive numbers from negative ===================

    // unsigned number of -25 or 25 is 25.
    public static int getPositive(int number) {
        return (number < 0 ? -(number) : number);
    }


// ===================== Split decimal =============================================================================

    // unsigned number of -25 or 25 is 25.
    public static Map<String, Integer> splitDecimalsInDouble(Double decimalFraction) {
        Integer beforeDecimals = decimalFraction.intValue();
        Integer afterDecimals = (int) ((decimalFraction - beforeDecimals) * 100);
        Map<String, Integer> map = new HashMap<>();
        map.put("BeforeDecimalPoint", beforeDecimals);
        map.put("AfterDecimalPoint", afterDecimals);
        return map;
    }

    public static Map<String, BigDecimal> splitBDecimalsInBigDecimal(BigDecimal decimalFraction) {
        BigDecimal beforeDecimals = new BigDecimal(decimalFraction.intValue());
        BigDecimal afterDecimals = (decimalFraction.subtract(beforeDecimals));
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("BeforeDecimalPoint", beforeDecimals);
        map.put("AfterDecimalPoint", afterDecimals);
        return map;
    }

//===================== Reverse and add until you get a palindrome ==============================================
    /*
        Write a java program to take input number from the user, reverse it and add it to itself.
        If the sum is not a palindrome then repeat the procedure until you get a palindrome
     */

    public static int addToReverseUntilPalindromeUsingRecursive(int input) {
        if (input == 0) {
            return input;
        }

        int sum = input + getReverse(input);
        if (sum == getReverse(sum)) {
            return sum;
        }
        return addToReverseUntilPalindromeUsingRecursive(sum);
    }

    public static int addToReverseUntilPalindromeUsingLogicalIteration(int input) {
        if (input == 0) {
            return input;
        }
        int sum = input + getReverse(input);
        while (sum != getReverse(sum)) {
            sum = sum + getReverse(sum);
        }
        return sum;
    }

    // reverse of a number.
    public static int getReverse(int input) {
        int reverse = 0;
        while (input > 0) {
            int digit = input % 10;
            reverse = (reverse * 10) + digit;
            input = input / 10;
        }
        return reverse;
    }

//================== Roman equivalent of a decimal number ====================================

    // == Using Iteration ===
    public static String convertToRomanNumerals(int input) {
        int base = 1;
        while (input >= base * 10) {
            base = base * 10;
        }
        StringBuilder romanNumber = new StringBuilder();
        while (input > 0) {
            // Floor would be near multiples of 10s (for 2 digits), 100s(3 digits) or 1000s(for 4 digits)
            // e.g nearestFloor for 3452 is 3000
            int nearestFloor = input / base * base;
            romanNumber.append(getRomanNumeral(nearestFloor, base));
            input = input - nearestFloor;
            base = base / 10;
        }
        return romanNumber.toString();
    }

    private static String getRomanNumeral(int input, int base) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
        StringBuilder romanOnes = new StringBuilder();
        for (int i = input; i > 0; i -= base) {
            if (romanMap.containsKey(i)) {
                return romanMap.get(i) + romanOnes.toString();
            }
            romanOnes.append(romanMap.get(base));
        }
        return "";
    }

    // == Using Recursive ===
    public static String convertToRomanNumeralsUsingTreeMapAndRecursive(int input) {
        TreeMap<Integer, String> romanMap = new TreeMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
        int floorKey = romanMap.floorKey(input);
        if (input == floorKey) {
            return romanMap.get(input);
        }
        return romanMap.get(floorKey) + convertToRomanNumeralsUsingTreeMapAndRecursive(input - floorKey);
    }



}
