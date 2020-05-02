package com.example.sahil.practice.string_manipulation;

import com.example.sahil.practice.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StructureManipulation {

    private static final Logger log = LoggerFactory.getLogger(StructureManipulation.class);

    /**
     * QUESTION : HOW TO REVERSE A STRING IN JAVA
     */

    //Using Recursive Method 1 : ExecutionTime is 10-15 milliseconds
    public static String reverseUsingRecursive1(String input) {
        if (null == input || input.length() <= 1) {
            return input;
        }
        String a = reverseUsingRecursive1(input.substring(1)) + input.charAt(0);
        log.info("[reverseUsingRecursive1] input is {} reversed value is =>{}", input, a);
        return a;

    }

    //Using Recursive Method 2 : ExecutionTime is 9-12 milliseconds
    public static String reverseUsingRecursive2(String input) {
        if (null == input || input.length() <= 1) {
            return input;
        }
        String a = input.substring(input.length() - 1) + reverseUsingRecursive2(input.substring(0, input.length() - 1));
        log.info("[reverseUsingRecursive2] input is {} reversed value is =>{}", input, a);
        return a;
    }

    //Using Iteration Loop : ExecutionTime is around 1 millisecond. This is the fastest
    public static String reverseUsingLoopIteration(String input) {
        char[] inputCharArray = input.toCharArray();
        char[] reverseChar = new char[input.length()];
        int j = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            reverseChar[j] = inputCharArray[i];
            j++;
        }
        log.info("[reverseUsingLoopIteration] input is {} reversed value is =>{}",
                String.valueOf(inputCharArray), String.valueOf(reverseChar));
        return String.valueOf(reverseChar);
    }

    //Using Iteration Loop : ExecutionTime is around 1 millisecond. This internally uses reverseUsingLoopIteration
    public static String reverseUsingStringBuilder(String input) {
        StringBuilder inputStringBuilder = new StringBuilder(input);
        inputStringBuilder.reverse();
        log.info("[reverseUsingStringBuilder] input is {} reversed value is =>{}",
                input, inputStringBuilder);
        return new String(inputStringBuilder);
    }
}
