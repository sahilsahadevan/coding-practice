package com.example.sahil.practice.array_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class ArrayManipulation {

    private static final Logger log = LoggerFactory.getLogger(ArrayManipulation.class);




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


//=========================== How to find duplicate elements in an array ?  ===========================================

    public static Set<String> findDuplicatesFromArrays(String[] input) {
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String eachStr : input) {
            eachStr = eachStr.toUpperCase();
            if (uniques.contains(eachStr)) {
                duplicates.add(eachStr);
            }
            uniques.add(eachStr);
        }
        return duplicates;
    }

//======================= How to find second largest number in an integer array ? =====================================

    public static int getSecondLargestNumberUsingUtils(int[] input) {
        if (input.length <= 1) {
            return -1;
        }
        Arrays.sort(input);
        if (input.length <= 2) {
            return input[0];
        }
        return input[input.length - 2];
    }

    public static int getSecondLargestNumberUsingIteration(int[] input) {
        if (input.length <= 1) {
            return -1;
        }
        int largest = 0;
        int secondlargest = 0;
        for (int eachNum : input) {
            if (eachNum == 0) {
                continue;
            }
            if (largest < eachNum) {
                secondlargest = largest;
                largest = eachNum;
                continue;
            }

            if (largest > eachNum && secondlargest < eachNum) {
                secondlargest = eachNum;
            }
        }
        return secondlargest;
    }


//======================= How to find nth largest and nth smallest number in an integer array ? =====================================

    public static int getNthSmallestNumberUsingTreeSet(int[] input, int n) {
        if (input.length == 0 || n > input.length) {
            return -1;
        }
        Set<Integer> sortedNumber = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            sortedNumber.add(input[i]);
        }
        Integer[] a = new Integer[input.length];
        sortedNumber.toArray(a);
        //subtract with sortedNumber instead of input.length since tree set removes duplicates and thus may reduce in size.
        return a[n - 1]; //This is the only difference compared to getNthLargestNumberUsingTreeSet()
    }


    public static int getNthLargestNumberUsingTreeSet(int[] input, int n) {
        if (input.length == 0 || n > input.length) {
            return -1;
        }
        Set<Integer> sortedNumber = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            sortedNumber.add(input[i]);
        }
        Integer[] a = new Integer[input.length];
        sortedNumber.toArray(a);
        //subtract with sortedNumber instead of input.length since tree set removes duplicates and thus may reduce in size.
        return a[sortedNumber.size() - n]; //This is the only difference compared to getNthSmallestNumberUsingTreeSet()
    }


// ===================  How to perform matrix operations in java? ===============================

    // print Matrix values
    public static void printMatrixValues(int[][] twoDimMatrix) {
        int rows = twoDimMatrix.length;
        int columns = twoDimMatrix[1].length;
        log.info("rows =  {}, columns = {}", rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(twoDimMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Matric Additions
    public static int[][] addMatrix(int[][] twoDimMatrix1, int[][] twoDimMatrix2) {
        int m1RowCount = twoDimMatrix1.length;
        int m1ColumnCount = twoDimMatrix1[1].length;
        int m2RowCount = twoDimMatrix2.length;
        int m2ColumnCount = twoDimMatrix2[1].length;
        log.info("Matrix1: rows =  {}, columns = {}", m1RowCount, m1ColumnCount);
        log.info("Matrix2: rows =  {}, columns = {}", m2RowCount, m2ColumnCount);
        if (m1RowCount != m2RowCount || m1ColumnCount != m2ColumnCount) {
            log.info("Cannot add 2 differently sized matrices");
            return new int[0][0];
        }
        int[][] result = new int[m1RowCount][m1ColumnCount];
        for (int i = 0; i < m1RowCount; i++) {
            for (int j = 0; j < m1ColumnCount; j++) {
                result[i][j] = twoDimMatrix1[i][j] + twoDimMatrix2[i][j];
            }
        }
        return result;
    }

    // Matric Subtractions
    public static int[][] subtractMatrix(int[][] twoDimMatrix1, int[][] twoDimMatrix2) {
        int m1RowCount = twoDimMatrix1.length;
        int m1ColumnCount = twoDimMatrix1[1].length;
        int m2RowCount = twoDimMatrix2.length;
        int m2ColumnCount = twoDimMatrix2[1].length;
        log.info("Matrix1: rows =  {}, columns = {}", m1RowCount, m1ColumnCount);
        log.info("Matrix2: rows =  {}, columns = {}", m2RowCount, m2ColumnCount);
        if (m1RowCount != m2RowCount || m1ColumnCount != m2ColumnCount) {
            log.info("Cannot subtract between 2 differently sized matrices");
            return new int[0][0];
        }
        int[][] result = new int[m1RowCount][m1ColumnCount];
        for (int i = 0; i < m1RowCount; i++) {
            for (int j = 0; j < m1ColumnCount; j++) {
                result[i][j] = twoDimMatrix1[i][j] - twoDimMatrix2[i][j];
            }
        }
        return result;
    }

    // Matrix Multiplications
    /* 2 Matrices can be multiplied only if -> number for columns of matrix A = number of rows of matrixB
     * Therefore int[2][3] MatrixA can be multiplied with int[3][4] MatrixB but not vice versa.
     *
     * Also int[i][j] Matrix1 * [j][k] Matrix2 = int[i][k] resultMatrix
     *   int[2][3]   *    int[3][4]        =      int[2][4]
     *  -------->                       :
     * | 1  2  3 |     | 11 12 13 14 |  :    | (1*11)+(2*15)+(3*19) (1*12)+(2*16)+(3*10) (1*13)+(2*17)+(3*20) (1*14)+(2*18)+(3*21) |
     * | 4  5  6 |  *  | 15 16 17 18 |  : =  | (4*11)+(5*15)+(6*19) (4**11)+(5*15)+(6*19) (4*11)+(5*15)+(6*19) (4*11)+(5*15)+(6*19) |
     *                 | 19 10 20 21 |  V
     *
     */
    public static int[][] multiplyMatrix(int[][] twoDimMatrix1, int[][] twoDimMatrix2) {
        int m1RowCount = twoDimMatrix1.length;
        int m1ColumnCount = twoDimMatrix1[1].length;
        int m2RowCount = twoDimMatrix2.length;
        int m2ColumnCount = twoDimMatrix2[1].length;
        log.info("Matrix1: rows =  {}, columns = {}", m1RowCount, m1ColumnCount);
        log.info("Matrix2: rows =  {}, columns = {}", m2RowCount, m2ColumnCount);
        if (m1ColumnCount != m2RowCount) {
            log.info("Not eligible for Multiplication: Number of columns of twoDimMatrix1 != Number of rows of twoDimMatrix1");
            return new int[0][0];
        }
        int[][] result = new int[m1RowCount][m2ColumnCount];
        for (int i = 0; i < m1RowCount; i++) {
            for (int j = 0; j < m2ColumnCount; j++) { //note: m1ColumnCount == m2RowCount
                int value = 0;
                for (int k = 0; k < m1ColumnCount; k++) {
                   value  = twoDimMatrix1[i][k] * twoDimMatrix2[k][j];
                }
                result[i][j] = value;
            }
        }
        return result;
    }



}




