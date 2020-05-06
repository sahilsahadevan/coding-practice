package com.example.sahil.practice.find_and_filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindFilterCheckCompareTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(FindFilterCheckCompareTest.class);

    @Test
    public void findAndCountDuplicateOccurencesTest() {
        FindFilterCheckCompare.findAndCountDuplicateChars("Bebbtter Butbter");
        FindFilterCheckCompare.findAndCountDuplicateChars("This one");

    }

    @Test
    public void weakCompareArraysTest() {
        String[] array1 = {"a", "b", "c", "d", "e", "f"};
        String[] array2 = {"a", "b", "c", "d", "e", "f"};
        String[] array3 = {"A", "B", "C", "D", "E", "F"};
        String[] array4 = {"F", "E", "D", "C", "B", "A"};
        String[] array5 = {"f", "e", "d", "c", "b", "a"};
        String[] array6 = {"C", "F", "e", "B", "d", "A"};
        String[] array7 = {"e", "J", "B", "g", "H", "a"};
        String[] array8 = {"G", "H", "I", "J", "K", "L"};

        // CASE_SENSITIVE IS TRUE
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array1, array2, true));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingUtil(array1, array2));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array3, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array2, array3));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array4, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array2, array4));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array5, true));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingUtil(array2, array5));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array2, array6));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array4, true));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingUtil(array3, array4));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array5, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array3, array5));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array3, array6));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array7, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array3, array7));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array8, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingUtil(array3, array8));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array4, array5, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array4, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array6, array7, true));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array6, array8, true));

        // CASE_SENSITIVE IS FALSE
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array1, array2, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array3, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array4, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array5, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array2, array6, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array4, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array5, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array6, false));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array7, false));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array3, array8, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array4, array5, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array4, array6, false));
        Assertions.assertTrue(FindFilterCheckCompare.weakCompareArraysUsingIteration(array5, array6, false));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array6, array7, false));
        Assertions.assertFalse(FindFilterCheckCompare.weakCompareArraysUsingIteration(array6, array8, false));

    }

    @Test
    public void exactCompareIntArraysTest() {
        String[] array1 = {"a", "b", "c", "d", "e", "f"};
        String[] array2 = {"a", "b", "c", "d", "e", "f"};
        String[] array3 = {"A", "B", "C", "D", "E", "F"};
        String[] array4 = {"F", "E", "D", "C", "B", "A"};
        String[] array5 = {"f", "e", "d", "c", "b", "a"};
        String[] array6 = {"C", "F", "e", "B", "d", "A"};
        String[] array7 = {"e", "J", "B", "g", "H", "a"};
        String[] array8 = {"G", "H", "I", "J", "K", "L"};

        // CASE_SENSITIVE IS TRUE
        Assertions.assertTrue(FindFilterCheckCompare.exactCompareArraysUsingIteration(array1, array2, true));
        Assertions.assertTrue(FindFilterCheckCompare.exactCompareArraysUsingUtil(array1, array2));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array3, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingUtil(array2, array3));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array4, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array5, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array4, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array5, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array7, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array8, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array4, array5, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array4, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array5, array6, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array6, array7, true));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array6, array8, true));

        // CASE_SENSITIVE IS FALSE
        Assertions.assertTrue(FindFilterCheckCompare.exactCompareArraysUsingIteration(array1, array2, false));
        Assertions.assertTrue(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array3, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array4, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array5, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array2, array6, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array4, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array5, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array6, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array7, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array3, array8, false));
        Assertions.assertTrue(FindFilterCheckCompare.exactCompareArraysUsingIteration(array4, array5, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array4, array6, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array5, array6, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array6, array7, false));
        Assertions.assertFalse(FindFilterCheckCompare.exactCompareArraysUsingIteration(array6, array8, false));

    }


    @Test
    public void checkIfAnagramTest() {
        Assertions.assertTrue(FindFilterCheckCompare.checkIfAnagramUsingArraysUtils("Tom Marvolo Riddle", "I am Lord Voldemort"));
        Assertions.assertTrue(FindFilterCheckCompare.checkIfAnagramUsingIterations("Tom Marvolo Riddle", "I am Lord Voldemort"));
        Assertions.assertTrue(FindFilterCheckCompare.checkIfAnagramUsingArraysUtils("This is", "Sis Hit"));
        Assertions.assertTrue(FindFilterCheckCompare.checkIfAnagramUsingIterations("This is", "Sis Hit"));
        Assertions.assertFalse(FindFilterCheckCompare.checkIfAnagramUsingArraysUtils("shabbath", "Bath Abss"));
        Assertions.assertFalse(FindFilterCheckCompare.checkIfAnagramUsingIterations("shabbath", "Bath Abss"));
        Assertions.assertFalse(FindFilterCheckCompare.checkIfAnagramUsingArraysUtils("Sis is sisi", "iiiiiiiss"));
        Assertions.assertFalse(FindFilterCheckCompare.checkIfAnagramUsingIterations("Sis is sisi", "iiiiiiiss"));
    }

    @Test
    public void checkIfArmstrongNumberTest() {
        Assertions.assertTrue(FindFilterCheckCompare.isArmstrongNumberUsingIteration(153));
        Assertions.assertTrue(FindFilterCheckCompare.isArmstrongNumberUsingMathUtil(153));
        Assertions.assertTrue(FindFilterCheckCompare.isArmstrongNumberUsingIteration(548834));
        Assertions.assertTrue(FindFilterCheckCompare.isArmstrongNumberUsingMathUtil(548834));
        Assertions.assertFalse(FindFilterCheckCompare.isArmstrongNumberUsingIteration(154));
        Assertions.assertFalse(FindFilterCheckCompare.isArmstrongNumberUsingMathUtil(154));
    }

    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }

    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }

}
