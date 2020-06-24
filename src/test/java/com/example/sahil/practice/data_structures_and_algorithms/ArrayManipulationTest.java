package com.example.sahil.practice.data_structures_and_algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.example.sahil.practice.data_structures_and_algorithms.ArrayManipulation.*;


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
        Assertions.assertTrue(weakCompareArraysUsingIteration(array1, array2, true));
        Assertions.assertTrue(weakCompareArraysUsingUtil(array1, array2));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array2, array3, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array2, array3));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array2, array4, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array2, array4));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array2, array5, true));
        Assertions.assertTrue(weakCompareArraysUsingUtil(array2, array5));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array2, array6, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array2, array6));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array3, array4, true));
        Assertions.assertTrue(weakCompareArraysUsingUtil(array3, array4));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array3, array5, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array3, array5));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array3, array6, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array3, array6));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array3, array7, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array3, array7));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array3, array8, true));
        Assertions.assertFalse(weakCompareArraysUsingUtil(array3, array8));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array4, array5, true));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array4, array6, true));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array6, array7, true));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array6, array8, true));

        // CASE_SENSITIVE IS FALSE
        Assertions.assertTrue(weakCompareArraysUsingIteration(array1, array2, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array2, array3, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array2, array4, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array2, array5, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array2, array6, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array3, array4, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array3, array5, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array3, array6, false));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array3, array7, false));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array3, array8, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array4, array5, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array4, array6, false));
        Assertions.assertTrue(weakCompareArraysUsingIteration(array5, array6, false));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array6, array7, false));
        Assertions.assertFalse(weakCompareArraysUsingIteration(array6, array8, false));

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
        Assertions.assertTrue(exactCompareArraysUsingIteration(array1, array2, true));
        Assertions.assertTrue(exactCompareArraysUsingUtil(array1, array2));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array3, true));
        Assertions.assertFalse(exactCompareArraysUsingUtil(array2, array3));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array4, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array5, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array6, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array4, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array5, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array6, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array7, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array8, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array4, array5, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array4, array6, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array5, array6, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array6, array7, true));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array6, array8, true));

        // CASE_SENSITIVE IS FALSE
        Assertions.assertTrue(exactCompareArraysUsingIteration(array1, array2, false));
        Assertions.assertTrue(exactCompareArraysUsingIteration(array2, array3, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array4, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array5, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array2, array6, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array4, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array5, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array6, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array7, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array3, array8, false));
        Assertions.assertTrue(exactCompareArraysUsingIteration(array4, array5, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array4, array6, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array5, array6, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array6, array7, false));
        Assertions.assertFalse(exactCompareArraysUsingIteration(array6, array8, false));

    }


    @Test
    public void findDuplicatesFromArraysTest() {
        String[] fruits = {"Apple", "Mango", "apple", "Banana", "MANGO", "Lichi"};
        String[] superheros = {"Batman", "Rorschach", "Glasses Man", "Inspector SpaceTime"};
        Assertions.assertEquals(
                new HashSet<>(Arrays.asList("APPLE", "MANGO")),
                findDuplicatesFromArrays(fruits));
        Assertions.assertEquals(
                new HashSet<>(),
                findDuplicatesFromArrays(superheros));
    }

    @Test
    public void getSecondLargestNumberTest() {
        int[] a = {15, 17, 16, 4, 18, 3, 2};
        int[] b = {16, 15, 17, 2, 0, 2, 18};
        int[] c = {17, 18};
        int[] d = {17};
        int[] e = {};
        Assertions.assertEquals(17, getSecondLargestNumberUsingUtils(a));
        Assertions.assertEquals(17, getSecondLargestNumberUsingIteration(a));
        Assertions.assertEquals(17, getSecondLargestNumberUsingUtils(b));
        Assertions.assertEquals(17, getSecondLargestNumberUsingIteration(b));
        Assertions.assertEquals(17, getSecondLargestNumberUsingUtils(c));
        Assertions.assertEquals(17, getSecondLargestNumberUsingIteration(c));
        Assertions.assertEquals(-1, getSecondLargestNumberUsingUtils(d));
        Assertions.assertEquals(-1, getSecondLargestNumberUsingIteration(d));
        Assertions.assertEquals(-1, getSecondLargestNumberUsingUtils(e));
        Assertions.assertEquals(-1, getSecondLargestNumberUsingIteration(e));

    }

    @Test
    public void getNthLargestAndNthSmallestNumberTest() {
        int[] a = {20, 18, 19, 15, 17, 16, 10, 14, 13, 11, 12, 9, 7, 5, 6, 8, 4, 2, 3, 1};
        int[] b = {16, 15, 17, 2, 0, 2, 18};
        int[] c = {17, 18};
        int[] d = {17};
        int[] e = {};
        //nth largest
        Assertions.assertEquals(17, getNthLargestNumberUsingTreeSet(a, 4));
        Assertions.assertEquals(16, getNthLargestNumberUsingTreeSet(b, 3));
        Assertions.assertEquals(17, getNthLargestNumberUsingTreeSet(c, 2));
        Assertions.assertEquals(17, getNthLargestNumberUsingTreeSet(d, 1));
        Assertions.assertEquals(-1, getNthLargestNumberUsingTreeSet(d, 10));
        Assertions.assertEquals(-1, getNthLargestNumberUsingTreeSet(e, 0));

        //nth smallest
        Assertions.assertEquals(4, getNthSmallestNumberUsingTreeSet(a, 4));
        Assertions.assertEquals(15, getNthSmallestNumberUsingTreeSet(b, 3));
        Assertions.assertEquals(18, getNthSmallestNumberUsingTreeSet(c, 2));
        Assertions.assertEquals(17, getNthSmallestNumberUsingTreeSet(d, 1));
        Assertions.assertEquals(-1, getNthSmallestNumberUsingTreeSet(d, 10));
        Assertions.assertEquals(-1, getNthSmallestNumberUsingTreeSet(e, 0));

    }

    @Test
    public void printMatricesTest() {
        int[][] a = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] b = new int[][]{{16, 10}, {8, 18}, {15, 18}, {16, 18}, {15, 17}}; // 5 rows, 2 columns
        int[][] c = new int[][]{{16, 10, 11}, {8, 18, 20}, {15, 17, 2}}; // 3 rows, 3 columns

        printMatrixValues(a);
        printMatrixValues(b);
        printMatrixValues(c);

    }

    @Test
    public void addAndSubtractMatricesTest() {
        int[][] a = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] b = new int[][]{{23, 1, 14, 10, 49}, {34, 99, 78, 63, 81}}; // 2 rows, 5 column
        int[][] c = new int[][]{{16, 10}, {8, 18}, {15, 18}, {16, 18}, {15, 17}}; // 5 rows, 2 columns
        int[][] resultAdd1 = addMatrix(a, b);
        int[][] resultSubtract1 = subtractMatrix(a, b);
        int[][] resultAdd2 = addMatrix(a, c);
        int[][] resultSubtract2 = subtractMatrix(a, c);
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
        int[][] resultMultiply1 = multiplyMatrix(a, b);
        int[][] resultMultiply2 = multiplyMatrix(a, c);
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
        int[][] transpose = getTranspose(input);
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

    @Test
    public void getSumPairOfGivenNumberTest() {
        int[] input1 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] input2 = new int[]{15, 12, 0, 12, 4, 0, 3, 9, 10};
        Assertions.assertArrayEquals(new int[][]{{2, 10}, {3, 9}, {4, 8}, {5, 7}},
                getSumPairOfGivenNumber(input1, 12));
        Assertions.assertArrayEquals(new int[][]{{15, 0}, {15, 0}, {12, 3}, {12, 3}},
                getSumPairOfGivenNumber(input2, 15));
    }

    @Test
    public void getSubArraySumPairOfGivenNumberTest() {
        int[] input1 = new int[]{2, 3, 4, 5, 2, 1, 9, 2};
        Assertions.assertEquals("[[3, 4, 5], [4, 5, 2, 1], [2, 1, 9], [1, 9, 2]]",
                getSubArraySumPairOfGivenNumber(input1, 12).toString());
    }

    @Test
    public void removeDuplicatesFromListTest() {
        List<String> integerList = new ArrayList<>(Arrays.asList("Sahil", "Varsha", "Sagil", "Sahil", "Sagil"));
        Assertions.assertEquals("[Sahil, Varsha, Sagil]", removeDuplicatesFromList2(integerList).toString());
    }


    @Test
    public void getArrayIntersectionTest() {
        String[] arr1 = new String[]{"Sahil", "Varsha", "Sagil", "Mummy", "Papa"};
        String[] arr2 = new String[]{"Mummy", "Papa"};
        Assertions.assertEquals("[Mummy, Papa]", getArrayIntersectionUsingUtils(arr1, arr2).toString());
        Assertions.assertEquals("[Mummy, Papa]", getArrayIntersectionUsingIteration(arr1, arr2).toString());
    }

    @Test
    public void moveAllXTests() {
        int[] input1 = new int[]{0, 10, 0, 22, 45, 0, 0, 100, 0, 5};
        int[] input2 = new int[]{0, 10, 0, 22, 45, 22, 0, 100, 0, 22};
        int[] input3 = new int[]{0, 10, 0, 22, 10, 0, 0, 10, 0, 5};
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 5, 100, 45, 22, 10},
                moveAllZerosToFirstArrayPositions(input1));

        Assertions.assertArrayEquals(new int[]{10, 22, 45, 100, 5, 0, 0, 0, 0, 0},
                moveAllZerosToLastArrayPositions(input1));

        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 10, 22, 45, 100, 5},
                moveAllXToFirstArrayPositions(input1, 0));

        Assertions.assertArrayEquals(new int[]{10, 22, 45, 100, 5, 0, 0, 0, 0, 0},
                moveAllXToLastArrayPositions(input1, 0));

        Assertions.assertArrayEquals(new int[]{22, 22, 22, 0, 10, 0, 45, 0, 100, 0},
                moveAllXToFirstArrayPositions(input2, 22));

        Assertions.assertArrayEquals(new int[]{0, 10, 0, 45, 0, 100, 0, 22, 22, 22},
                moveAllXToLastArrayPositions(input2, 22));

        Assertions.assertArrayEquals(new int[]{10, 10, 10, 0, 0, 22, 0, 0, 0, 5},
                moveAllXToFirstArrayPositions(input3, 10));

        Assertions.assertArrayEquals(new int[]{0, 0, 22, 0, 0, 0, 5, 10, 10, 10},
                moveAllXToLastArrayPositions(input3, 10));

    }

    @Test
    public void getLeaderNumberTest() {
        int[] input1 = new int[]{0, 10, 45, 22, 41, 0, 0, 100, 95, 5};
        log.info("{}", getLeaderNumbers(input1));
        Assertions.assertEquals("[45, 41, 100, 95, 5]", getLeaderNumbers(input1).toString());
    }

    @Test
    public void findMissingNumTest() {
        int[] input1 = new int[]{3, 4, 7, 6, 5, 1, 8};
        int[] input2 = new int[]{3, 4, 7, 2, 6, 5, 1, 8};
        Assertions.assertEquals("2", findMissingNum(input1));
        Assertions.assertEquals("All Numbers Present!", findMissingNum(input2));
    }

    @Test
    public void convertTheseMultiDArraysToStringTest() {
        String[][] input1Str = new String[][]{{"A1", "A2", "A3"}, {"B1", "B2", "B3"}};
        Map<String, String> resultMap = convertTheseMultiDArraysToString(input1Str);
        log.info("{}", resultMap);
        Assertions.assertNotEquals("[[A1, A2, A3], [B1, B2, B3]]", resultMap.get("Object.toString()"));
        Assertions.assertNotEquals("[[A1, A2, A3], [B1, B2, B3]]", resultMap.get("String.valueOf()"));
        Assertions.assertNotEquals("[[A1, A2, A3], [B1, B2, B3]]", resultMap.get("Arrays.toString()"));
        Assertions.assertEquals("[[A1, A2, A3], [B1, B2, B3]]", resultMap.get("Arrays.deepToString()"));
    }

    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }

    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }


}
