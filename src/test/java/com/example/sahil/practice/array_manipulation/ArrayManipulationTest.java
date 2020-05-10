package com.example.sahil.practice.array_manipulation;

import com.example.sahil.practice.VerifyShell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayManipulationTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(ArrayManipulationTest.class);


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
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array1, array2, true));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingUtil(array1, array2));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array2, array3, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array2, array3));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array2, array4, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array2, array4));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array2, array5, true));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingUtil(array2, array5));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array2, array6, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array2, array6));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array3, array4, true));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingUtil(array3, array4));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array3, array5, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array3, array5));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array3, array6, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array3, array6));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array3, array7, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array3, array7));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array3, array8, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingUtil(array3, array8));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array4, array5, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array4, array6, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array6, array7, true));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array6, array8, true));

        // CASE_SENSITIVE IS FALSE
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array1, array2, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array2, array3, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array2, array4, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array2, array5, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array2, array6, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array3, array4, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array3, array5, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array3, array6, false));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array3, array7, false));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array3, array8, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array4, array5, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array4, array6, false));
        Assertions.assertTrue(ArrayManipulation.weakCompareArraysUsingIteration(array5, array6, false));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array6, array7, false));
        Assertions.assertFalse(ArrayManipulation.weakCompareArraysUsingIteration(array6, array8, false));

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
        Assertions.assertTrue(ArrayManipulation.exactCompareArraysUsingIteration(array1, array2, true));
        Assertions.assertTrue(ArrayManipulation.exactCompareArraysUsingUtil(array1, array2));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array3, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingUtil(array2, array3));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array4, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array5, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array6, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array4, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array5, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array6, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array7, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array8, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array4, array5, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array4, array6, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array5, array6, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array6, array7, true));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array6, array8, true));

        // CASE_SENSITIVE IS FALSE
        Assertions.assertTrue(ArrayManipulation.exactCompareArraysUsingIteration(array1, array2, false));
        Assertions.assertTrue(ArrayManipulation.exactCompareArraysUsingIteration(array2, array3, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array4, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array5, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array2, array6, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array4, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array5, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array6, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array7, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array3, array8, false));
        Assertions.assertTrue(ArrayManipulation.exactCompareArraysUsingIteration(array4, array5, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array4, array6, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array5, array6, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array6, array7, false));
        Assertions.assertFalse(ArrayManipulation.exactCompareArraysUsingIteration(array6, array8, false));

    }


    @Test
    public void findDuplicatesFromArraysTest() {
        String[] fruits = {"Apple", "Mango", "apple", "Banana", "MANGO", "Lichi"};
        String[] superheros = {"Batman", "Rorschach", "Glasses Man", "Inspector SpaceTime"};
        Assertions.assertEquals(
                new HashSet<>(Arrays.asList("APPLE", "MANGO")),
                ArrayManipulation.findDuplicatesFromArrays(fruits));
        Assertions.assertEquals(
                new HashSet<>(),
                ArrayManipulation.findDuplicatesFromArrays(superheros));
    }

    @Test
    public void getSecondLargestNumberTest() {
        int[] a = {15, 17, 16, 4, 18, 3, 2};
        int[] b = {16, 15, 17, 2, 0, 2, 18};
        int[] c = {17, 18};
        int[] d = {17};
        int[] e = {};
        Assertions.assertEquals(17, ArrayManipulation.getSecondLargestNumberUsingUtils(a));
        Assertions.assertEquals(17, ArrayManipulation.getSecondLargestNumberUsingIteration(a));
        Assertions.assertEquals(17, ArrayManipulation.getSecondLargestNumberUsingUtils(b));
        Assertions.assertEquals(17, ArrayManipulation.getSecondLargestNumberUsingIteration(b));
        Assertions.assertEquals(17, ArrayManipulation.getSecondLargestNumberUsingUtils(c));
        Assertions.assertEquals(17, ArrayManipulation.getSecondLargestNumberUsingIteration(c));
        Assertions.assertEquals(-1, ArrayManipulation.getSecondLargestNumberUsingUtils(d));
        Assertions.assertEquals(-1, ArrayManipulation.getSecondLargestNumberUsingIteration(d));
        Assertions.assertEquals(-1, ArrayManipulation.getSecondLargestNumberUsingUtils(e));
        Assertions.assertEquals(-1, ArrayManipulation.getSecondLargestNumberUsingIteration(e));

    }

    @Test
    public void getNthLargestAndNthSmallestNumberTest() {
        int[] a = {20, 18, 19, 15, 17, 16, 10, 14, 13, 11, 12, 9, 7, 5, 6, 8, 4, 2, 3, 1};
        int[] b = {16, 15, 17, 2, 0, 2, 18};
        int[] c = {17, 18};
        int[] d = {17};
        int[] e = {};
        //nth largest
        Assertions.assertEquals(17, ArrayManipulation.getNthLargestNumberUsingTreeSet(a, 4));
        Assertions.assertEquals(16, ArrayManipulation.getNthLargestNumberUsingTreeSet(b, 3));
        Assertions.assertEquals(17, ArrayManipulation.getNthLargestNumberUsingTreeSet(c, 2));
        Assertions.assertEquals(17, ArrayManipulation.getNthLargestNumberUsingTreeSet(d, 1));
        Assertions.assertEquals(-1, ArrayManipulation.getNthLargestNumberUsingTreeSet(d, 10));
        Assertions.assertEquals(-1, ArrayManipulation.getNthLargestNumberUsingTreeSet(e, 0));

        //nth smallest
        Assertions.assertEquals(4, ArrayManipulation.getNthSmallestNumberUsingTreeSet(a, 4));
        Assertions.assertEquals(15, ArrayManipulation.getNthSmallestNumberUsingTreeSet(b, 3));
        Assertions.assertEquals(18, ArrayManipulation.getNthSmallestNumberUsingTreeSet(c, 2));
        Assertions.assertEquals(17, ArrayManipulation.getNthSmallestNumberUsingTreeSet(d, 1));
        Assertions.assertEquals(-1, ArrayManipulation.getNthSmallestNumberUsingTreeSet(d, 10));
        Assertions.assertEquals(-1, ArrayManipulation.getNthSmallestNumberUsingTreeSet(e, 0));

    }

    @Test
    public void printMatricesTest() {
        int[][] a = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] b = new int[][]{{16, 10}, {8, 18}, {15, 18}, {16, 18}, {15, 17}}; // 5 rows, 2 columns
        int[][] c = new int[][]{{16, 10, 11}, {8, 18, 20}, {15, 17, 2}}; // 3 rows, 3 columns

        ArrayManipulation.printMatrixValues(a);
        ArrayManipulation.printMatrixValues(b);
        ArrayManipulation.printMatrixValues(c);

    }

    @Test
    public void addAndSubtractMatricesTest() {
        int[][] a = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] b = new int[][]{{23, 1, 14, 10, 49}, {34, 99, 78, 63, 81}}; // 2 rows, 5 column
        int[][] c = new int[][]{{16, 10}, {8, 18}, {15, 18}, {16, 18}, {15, 17}}; // 5 rows, 2 columns
        int[][] resultAdd1 = ArrayManipulation.addMatrix(a, b);
        int[][] resultSubtract1 = ArrayManipulation.subtractMatrix(a, b);
        int[][] resultAdd2 = ArrayManipulation.addMatrix(a, c);
        int[][] resultSubtract2 = ArrayManipulation.subtractMatrix(a, c);
        Assertions.assertArrayEquals(new int[][]{{39, 16, 32, 27, 59}, {42, 99, 83, 78, 99}}, resultAdd1);
        Assertions.assertArrayEquals(new int[][]{{-7, 14, 4, 7, -39}, {-26, -99, -73, -48, -63}}, resultSubtract1);
        Assertions.assertArrayEquals(new int[][]{}, resultAdd2);
        Assertions.assertArrayEquals(new int[][]{}, resultSubtract2);

        int i = 0;
        while (i < resultAdd1.length) {
            log.info("{}", resultAdd1[i]);
            i++;
        }
        i = 0;
        System.out.println();
        while (i < resultSubtract1.length) {
            log.info("{}", resultSubtract1[i]);
            i++;
        }
        i = 0;
        System.out.println();
        while (i < resultAdd2.length) {
            log.info("{}", resultAdd2[i]);
            i++;
        }
        i = 0;
        System.out.println();
        while (i < resultSubtract2.length) {
            log.info("{}", resultSubtract2[i]);
            i++;
        }
    }

    @Test
    public void multiplyMatricesTest() {
        int[][] a = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] b = new int[][]{{23, 1, 14, 10, 49}, {34, 99, 78, 63, 81}}; // 2 rows, 5 column
        int[][] c = new int[][]{{16, 10, 6}, {8, 18, 28}, {15, 18, 21}, {16, 18, 20}, {15, 17, 19}}; // 5 rows, 3 columns
        int[][] resultMultiply1 = ArrayManipulation.multiplyMatrix(a, b);
        int[][] resultMultiply2 = ArrayManipulation.multiplyMatrix(a, c);
        Assertions.assertArrayEquals(new int[][]{}, resultMultiply1);
        Assertions.assertArrayEquals(new int[][]{{150, 170, 190}, {270, 306, 342}}, resultMultiply2);

        int i = 0;
        while (i < resultMultiply1.length) {
            log.info("{}", resultMultiply1[i]);
            i++;
        }
        i = 0;
        while (i < resultMultiply2.length) {
            log.info("{}", resultMultiply2[i]);
            i++;
        }
    }

    @Test
    public void transposeMatricesTest() {
        int[][] input = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] transpose = VerifyShell.getTranspose(input);
        Assertions.assertArrayEquals(new int[][]{{16, 8}, {15, 0}, {18, 5}, {17, 15}, {10, 18}}, transpose);
        int i = 0;
        while (i < input.length) {
            log.info("{}", input[i]);
            i++;
        }
        i = 0;
        while (i < transpose.length) {
            log.info("{}", transpose[i]);
            i++;
        }
    }


    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }

    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }

}