package com.example.sahil.practice.number_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class NumberBaseManipulation {

    private static final Logger log = LoggerFactory.getLogger(NumberBaseManipulation.class);

// ============================= Decimal To Binary, and Vice Versa ===================

    /*
        D = Dividend, d = divisor, q = quotient, r = remainder

                D  /  d  equals  q  and  r
                -----------------------------
                12 /  2  eauals  6  and  0   /\
                6  /  2  equals  3  and  0   |
                3  /  2  equals  1  and  1   |  read upwards for
                1  /  2  equals  0  and  1   |      binary result of 12 = 1100 (stored with leading zeros in 32 bit int)
        refer : https://indepth.dev/the-simple-math-behind-decimal-binary-conversion-algorithms/
     */
    // Alternative to Integer.toBinaryString(int input) or Integer.toString(int input, int radix)
    // (Please note Integer.parseInt(String input, radix) works only for octal & hexadecimal conversions)
    public static String getBinaryIntFromDecimalUsingSimpleMath(int decimalNum) {
        int temp = decimalNum;
        if (temp < 0) {
            temp = -temp;  //get binary using unsigned value.
        }
        StringBuilder binStr = new StringBuilder();
        while (temp > 0) {
            binStr.append(temp % 2);
            temp = temp / 2;
        }

        //negative numbers in 32 bit ints are basically all '1's instead of '0's(in positives) as leading values.
        // It means that if the binary of an unsigned decimal number 4 is 100 (0100 , leading 0 is ignored)
        // then the POSITIVE 32 bit int value is  00000000000000000000000000000100
        // while the NEGATIVE 32 bit int value is 11111111111111111111111111111100
        if (decimalNum < 0) {
            while (binStr.length() != 32) {
                binStr.append("1");
            }
        }

        //The binary in binStr is capture in reverse during division by 2 and appending to binStr. Hence, reversing it back
        return binStr.reverse().toString();
    }

    /*
        Values BEFORE decimals must be divided by 2 until value is zero,
        Values AFTER decimals, i.e the fraction part, must be multiplied by 2 until the fraction is zero (will not work
        if after decimal fraction value is 0.1)
        refer : https://indepth.dev/the-simple-math-behind-decimal-binary-conversion-algorithms/
     */
    public static String getBinaryDoubleFromDecimalUsingSimpleMath(Double decimalNum) {
        double unsignedDecimalNum = decimalNum.intValue() < -1 ? -(decimalNum) : decimalNum;
        int beforeDecimal = (int) unsignedDecimalNum;
        int temp = (int) ((unsignedDecimalNum - beforeDecimal) * 1000);
        BigDecimal afterDecimal = new BigDecimal("" + temp);
        int decimalPlaces = 3;
        afterDecimal = afterDecimal.movePointLeft(decimalPlaces);
        StringBuilder binStr = new StringBuilder();
        while (beforeDecimal > 0) {
            binStr.append(beforeDecimal % 2);
            beforeDecimal = beforeDecimal / 2;
        }
        if (decimalNum.intValue() < 0) {
            while (binStr.length() != 32) {
                binStr.append("1");
            }
        }
        binStr.reverse();
        if (afterDecimal.doubleValue() == 0.1D) {  // 0.1 cannot be converted to binary by the subsequent while iteration.
            return binStr.toString();
        }
        StringBuilder afterDecimalbinStr = new StringBuilder();
        int i = 0;
        // Added counter break incase the fraction result never amounts to zero (recurring)
        while (i < decimalPlaces && afterDecimal.movePointRight(decimalPlaces).intValue() > 0) {
            afterDecimal = afterDecimal.multiply(new BigDecimal("2"));
            afterDecimalbinStr.append(afterDecimal.intValue());
            if (afterDecimal.intValue() == 1) {
                afterDecimal = afterDecimal.subtract(new BigDecimal("1"));
            }
            i++;
        }
        //no need to reverse afterDecimals Binaries.
        return binStr + "." + afterDecimalbinStr;
    }

    public static String getDecimalFromBinary(int binaryNumber) {
        return String.valueOf(binaryNumber);
    }

    // ============================ Decimal To Octal, And Vice Versa =================================
    /*
        Same formula as binary-from-decimal except mod by 8 during iteration
     */
    //Alternative to Integer.toOctalString(dec)
    public static String getOctalFromDecimal(int decimalNum) {
        //Other logics remain same as getBinaryDoubleFromDecimalUsingSimpleMath()
        // like making integer unsigned and then evaluating the negative result.
        int temp = decimalNum < 0 ? -(decimalNum) : decimalNum;
        StringBuilder binStr = new StringBuilder();
        while (temp > 0) {
            binStr.append(temp % 8);
            temp = temp / 8;
        }
        /*
        if (decimalNum < 0) {
            while (binStr.length() != 32) {
                binStr.append("1");
            }
        }
        */
        return binStr.reverse().toString();
    }

    public static String getDecimalFromOctal(int octalNumber) {
        return String.valueOf(octalNumber);
    }

// ======================= Decimal To HexaDecimal, And Vice Versa ===============================================

    //Alternative to Integer.toHexString(dec)
    public static String getHexadecimalFromDecimal(int decimalNum) {
        int temp = decimalNum < 0 ? -(decimalNum) : decimalNum;
        char[] hexChart = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder binStr = new StringBuilder();
        while (temp > 0) {
            binStr.append(hexChart[temp % 16]);
            temp = temp / 16;
        }
        /*
        if (decimalNum < 0) {
            while (binStr.length() != 32) {
                binStr.append("1");
            }
        }
        */
        return binStr.reverse().toString();
    }

// ================== Octal To Binary, And Vice Versa ===================

// ================== Octal To HexaDecimal, And Vice Versa ===================

// ================== HexaDecimal to Binary, And Vice Versa ===================

// ================== Binary Addition ===================

// ================== Binary Subtraction ===================

// ================== Binary Multiplication ===================

//  ================== Binary Division ===================

// ================== HexaDecimal Addition ===================

// ================== HexaDecimal Subtraction ===================

// ================== HexaDecimal Multiplication ===================

//  ================== HexaDecimal Division ===================

// ================== Octal Addition ===================

// ================== Octal Subtraction ===================

// ================== Octal Multiplication ===================

//  ================== Octal Division ===================

}
