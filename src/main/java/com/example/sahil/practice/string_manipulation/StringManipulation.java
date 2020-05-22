package com.example.sahil.practice.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class StringManipulation {

    private static final Logger log = LoggerFactory.getLogger(StringManipulation.class);


//================= QUESTION : HOW TO REVERSE A STRING IN JAVA ============================
    /*
        Input = "Sahil Sahadevan"
        output = "navedahas lihas"
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


//================= QUESTION : HOW TO REMOVE WHITESPEACES ============================
    /*
        Input = "         THis had a lot of un even w   hit es paces         "
        output = "THishadalotofunevenwhitespaces"
     */

    //Using Iteration Loop : ExecutionTime is around 1 millisecond. This internally uses reverseUsingLoopIteration
    public static void removeAllWhiteSpaceUsingLoopIterations(String input) {
        char[] inputChar = input.toCharArray();
        char[] knitChar = new char[inputChar.length];
        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] != ' ') {
                knitChar[i] = inputChar[i];
            }
        }
        System.out.println(String.valueOf(knitChar));
    }

    //Using ReplaceAll : ExecutionTime is around 1 millisecond, but this is slightly faster than iteration
    public static void removeAllWhiteSpaceUsingRegex(String input) {
        if (input != null) {
            System.out.println(input.replaceAll(" ",""));
        }
    }

// ================= How to find and count duplicate characters and occurences in a string in java? ==================

    public static void findAndCountDuplicateChars(String input) {
        log.info("Counting all duplicate characters in '{}'", input);

        String inputCapitalized = input.toUpperCase();
        char[] inputChar = inputCapitalized.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        boolean noDuplicates = true;
        for (char eachChar : inputChar) {
            if (eachChar == ' ') {
                continue;
            }
            counter.put(eachChar, counter.getOrDefault(eachChar, 0) + 1);
            if (counter.containsKey(eachChar) && counter.get(eachChar) > 1) {
                noDuplicates = false;
            }
        }

        if (noDuplicates) {
            log.info("No duplicates present. All characters are unique in the entry -> '{}'", input);
            return;
        }
        log.info("Here are the Duplicates:");
        counter.entrySet().stream()
                .filter(entry -> 1 != entry.getValue())
                .forEach(entry -> log.info("{}: {}", entry.getKey(), entry.getValue()));
    }



//=========================== Anagram program in java [Mother in Law = Hitler Woman]  =================================
//== Rephrased Question : How to check whether one string is a rotation of another in java [JavaJ2eeStruts = StrutsJavaJ2ee = J2eeStrutsJava]========


    public static boolean checkIfAnagramUsingArraysUtils(String phrase1, String phrase2) {
        String phrase1WithoutSpaces = phrase1.replaceAll(" ", "").toLowerCase();
        String phrase2WithoutSpaces = phrase2.replaceAll(" ", "").toLowerCase();
        if (phrase1WithoutSpaces.length() != phrase2WithoutSpaces.length()) {
            log.info("No, '{}' is NOT an anagram of '{}', since the lengths don't match", phrase1, phrase2);
            return false;
        }

        char[] phrase1Arr = phrase1WithoutSpaces.toCharArray();
        char[] phrase2Arr = phrase2WithoutSpaces.toCharArray();

        Arrays.sort(phrase1Arr);
        Arrays.sort(phrase2Arr);

        boolean isAnagram = Arrays.equals(phrase1Arr, phrase2Arr);
        if (Arrays.equals(phrase1Arr, phrase2Arr)) {
            log.info("Yes, '{}' is an anagram of '{}'", phrase1, phrase2);
        } else {
            log.info("No, '{}' is NOT an anagram of '{}'", phrase1, phrase2);
        }
        log.info("{} : {}", phrase1Arr, phrase2Arr);
        return isAnagram;
    }


    public static boolean checkIfAnagramUsingIterations(String phrase1, String phrase2) {
        String phrase1WithoutSpaces = phrase1.replaceAll(" ", "").toLowerCase();
        String phrase2WithoutSpaces = phrase2.replaceAll(" ", "").toLowerCase();
        if (phrase1WithoutSpaces.length() != phrase2WithoutSpaces.length()) {
            log.info("No, '{}' is NOT an anagram of '{}', since the lengths don't match", phrase1, phrase2);
            return false;
        }
        Map<Character, Integer> phrase1Counter = new TreeMap<>();
        Map<Character, Integer> phrase2Counter = new TreeMap<>();
        char[] phrase1Arr = phrase1WithoutSpaces.toCharArray();
        char[] phrase2Arr = phrase2WithoutSpaces.toCharArray();
        for (int i = 0; i < phrase1Arr.length; i++) {
            phrase1Counter.put(phrase1Arr[i], phrase1Counter.getOrDefault(phrase1Arr[i], 0) + 1);
            phrase2Counter.put(phrase2Arr[i], phrase2Counter.getOrDefault(phrase2Arr[i], 0) + 1);
        }
        AtomicBoolean isAnagram = new AtomicBoolean(true);
        phrase1Counter.forEach((key, value) -> {
            if (!phrase2Counter.containsKey(key) ||
                    !phrase2Counter.get(key).equals(value)) {
                isAnagram.compareAndSet(true, false);
            }
        });
        if (isAnagram.get()) {
            log.info("Yes, '{}' is an anagram of '{}'", phrase1, phrase2);
        } else {
            log.info("No, '{}' is NOT an anagram of '{}'", phrase1, phrase2);
        }
        log.info("{} : {}", phrase1Arr, phrase2Arr);
        log.info("{} : {}", phrase1Counter, phrase2Counter);
        return isAnagram.get();
    }
}
