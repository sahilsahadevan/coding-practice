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

    // Matrix Additions
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

    // Matrix Subtractions
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
                    value = twoDimMatrix1[i][k] * twoDimMatrix2[k][j];
                }
                result[i][j] = value;
            }
        }
        return result;
    }

    //Transpose of a matrix is formed by turning all rows of a matrix into columns and columns into rows
    /*
        Transpose of  |3 1 2|  = |3 4|
                      |4 5 6|    |1 5|
                                 |2 6|
     */
    public static int[][] getTranspose(int[][] input) {

        if (null == input || input.length == 0) {
            return new int[0][0];
        }

        int[][] transpose = new int[input[1].length][input.length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[1].length; j++) {
                transpose[j][i] = input[i][j];
            }
        }

        return transpose;

    }

//=================== How to find all pairs of elements in an array whose sum is equal to given number? ===========
    //For example, if {4, 5, 7, 11, 9, 13, 8, 12} is an array and 20 is the given number,
    // then you have to find all pairs of elements in this array whose sum must be 20.
    // In this example, (9, 11), (7, 13) and (8, 12) are such pairs whose sum is 20

    public static int[][] getSumPairOfGivenNumber(int[] inputArr, int expectedTotal) {
        int[][] pairs = new int[inputArr.length / 2][2];
        int x = 0;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[i] + inputArr[j] == expectedTotal) {
                    pairs[x][0] = inputArr[i];
                    pairs[x][1] = inputArr[j];
                    x++;
                }
            }
        }
        return pairs;
    }

//=================== How to find continuous sub array whose sum is equal to given number ===========
    //For example, If {12, 5, 31, 9, 21, 8} is the given array and 45 is the given number,
    // then you have to find continuous sub array in this array such that whose elements add up to 45.
    // In this case, {5, 31, 9} is such sub array whose elements add up to 45

    public static List<List<Integer>> getSubArraySumPairOfGivenNumber(int[] inputArr, int expectedTotal) {
        List<List<Integer>> continuousSubArrayList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            int sum = 0;
            int j = i;

            while (j < inputArr.length) {
                sum = sum + inputArr[j];
                if (sum == expectedTotal) {
                    List<Integer> subArray = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        subArray.add(inputArr[k]);
                    }
                    continuousSubArrayList.add(subArray);
                    break;
                }
                j++;
            }
        }
        return continuousSubArrayList;
    }

//=================== How to remove duplicate elements from ArrayList in java ===========

    //mutating method -> modify the orginal input object arrayList
    public static void removeDuplicatesFromList1(List<String> input) {
        Set<String> uniqueSet = new HashSet<>(input);
        input.clear();
        input.addAll(uniqueSet);
    }

    //mutating method -> modify the original input object arrayList
    public static List<String> removeDuplicatesFromList2(List<String> input) {
        //Used linked HashSet since Entry is FIFO thus predictible while Asserting in Junit
        Set<String> uniqueSet = new LinkedHashSet<>(input);
        return new ArrayList<>(uniqueSet);
    }

//=================  How to find intersection of two arrays in java ======================

    public static List<String> getArrayIntersectionUsingUtils(String[] arr1, String[] arr2) {
        List<String> arr1List = new ArrayList<>(Arrays.asList(arr1));
        List<String> interSectList = new ArrayList<>();
        Arrays.stream(arr2)
                .forEach(x -> {
                    if (arr1List.contains(x)) {
                        interSectList.add(x);
                    }
                });
        return interSectList;

    }

    public static List<String> getArrayIntersectionUsingIteration(String[] arr1, String[] arr2) {
        List<String> interSectList = new ArrayList<>();
        for (String s : arr1) {
            for (String value : arr2) {
                if (s.equalsIgnoreCase(value)) {
                    interSectList.add(s);
                }
            }
        }
        return interSectList;

    }

//=========================  How to separate zeros/ numberX from non-zeros in an array? ==============--
    //Write a java program to separate zeros from non-zeros in the given array.
    // You have to move zeros either to end of the array or bring them to beginning of the array.
    // For example, if {14, 0, 5, 2, 0, 3, 0} is the given array, then moving zeros to end of the array will result
    // {14, 5, 2, 3, 0, 0, 0} and bringing zeros to front will result {0, 0, 0, 14, 5, 2,

    public static int[] moveAllZerosToFirstArrayPositions(int[] input) {
        int[] result = new int[input.length];
        int j = input.length - 1;
        for (int value : input) {
            if (value != 0) {
                result[j] = value;
                j--;
            }
        }
        return result;
    }

    public static int[] moveAllZerosToLastArrayPositions(int[] input) {
        int[] result = new int[input.length];
        int j = 0;
        for (int value : input) {
            if (value != 0) {
                result[j] = value;
                j++;
            }
        }
        return result;
    }

    //========
    //Write a java program to separate Number X from other numbers in the given array. You have to move X either
    // to end of the array or bring them to beginning of the array. For example, if x is 22 and
    // if {0, 10, 0, 22, 45, 22, 0, 100, 0, 22} is the given array,
    // then moving zeros to end of the array will result [0, 10, 0, 45, 0, 100, 0, 22, 22, 22] and
    // bringing zeros to front will result [22, 22, 22, 0, 10, 0, 45, 0, 100, 0]

    public static int[] moveAllXToFirstArrayPositions(int[] input, int x) {
        int[] result = new int[input.length];
        int j = 0;
        for (int value : input) {
            if (value == x) {
                result[j] = value;
                j++;
            }
        }
        for (int value : input) {
            if (value != x) {
                result[j] = value;
                j++;
            }
        }
        return result;
    }

    public static int[] moveAllXToLastArrayPositions(int[] input, int x) {
        int[] result = new int[input.length];
        int j = 0;
        for (int value : input) {
            if (value != x) {
                result[j] = value;
                j++;
            }
        }
        for (int value : input) {
            if (value == x) {
                result[j] = value;
                j++;
            }
        }
        return result;
    }
}






