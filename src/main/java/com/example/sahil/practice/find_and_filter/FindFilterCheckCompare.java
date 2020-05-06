package com.example.sahil.practice.find_and_filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class FindFilterCheckCompare {

    private static final Logger log = LoggerFactory.getLogger(FindFilterCheckCompare.class);


// ================= How to find and count duplicate characters and occurences in a string in java? ==================

    public static void findAndCountDuplicateChars(String input) {
        log.info("Counting all dupicate characters in '{}'", input);

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


// ================= How do you check the equality of two arrays in java? ====================================

    // Check if array 1 and array 2 has same entries regardless of the position (size must be same)==========
    // === e.g {1, 2, 3} == {3, 1, 2},  {1, 2, 3} != {3, 1, 4},  {1, 2} != {1, 2, 3}

    public static boolean weakCompareArraysUsingIteration(String[] array1, String[] array2, boolean isCaseSensitive) {
        if (null == array1 || null == array2 || Arrays.asList(array1.length, array2.length).contains(0)) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        Map<Boolean, Integer> check = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (isCaseSensitive) {
                    if (array1[i] == array2[j]) {
                        check.put(true, check.getOrDefault(true, 0) + 1);
                    }
                } else {
                    if (array1[i].equalsIgnoreCase(array2[j])) {
                        check.put(true, check.getOrDefault(true, 0) + 1);
                    }
                }

            }
        }
        if (check.containsKey(true) && check.get(true).equals(array1.length)) {
            return true;
        }
        return false;
    }

    //using utils. This is strictly case sensitive
    public static boolean weakCompareArraysUsingUtil(String[] array1, String[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    // Check if array 1 and array 2 has same entries in the exact same order
    // === e.g {1, 2, 3} == {1, 2, 3},  {1, 2, 3} != {3, 1, 2},  {1, 2, 3} != {1, 2}


    public static boolean exactCompareArraysUsingIteration(String[] array1, String[] array2, boolean isCaseSensitive) {
        if (null == array1 || null == array2 || Arrays.asList(array1.length, array2.length).contains(0)) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (isCaseSensitive) {
                if (!array1[i].equals(array2[i])) {
                    return false;
                }
            } else {
                if (!array1[i].equalsIgnoreCase(array2[i])) {
                    return false;
                }
            }

        }
        return true;
    }

    //using utils. This is strictly case sensitive
    public static boolean exactCompareArraysUsingUtil(String[] array1, String[] array2) {
        return Arrays.equals(array1, array2);

    }


//=========================== Anagram program in java   =============================================

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
        phrase1Counter.entrySet()
                .forEach(eachSet -> {
                    if (!phrase2Counter.containsKey(eachSet.getKey()) ||
                            !phrase2Counter.get(eachSet.getKey()).equals(eachSet.getValue())) {
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


