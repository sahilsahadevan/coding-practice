package com.example.sahil.practice.string_manipulation;

import com.example.sahil.practice.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintPyramids {

    private static final Logger log = LoggerFactory.getLogger(PrintPyramids.class);

    /**
     * QUESTION : HOW TO FORM STRING PYRAMIDS
     */


    /*
                      1
                     2 2
                    3 3 3
                   4 4 4 4

        Prints incremental rowCount (one count per row)
     */
    public static void printEquilateralNumberPyramidOneIncremental() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            //Printing i spaces at the beginning of each row
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //Printing 'rowCount' value 'rowCount' times at the end of each row
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(rowCount + " ");
            }
            System.out.println();
            //Incrementing the rowCount
            rowCount++;
        }
    }


    /*
                    4
                   3 3
                  2 2 2
                 1 1 1 1

        Prints Decremental rowCount (one count per row)
   */
    public static void printEquilateralNumberPyramidOneDecremental() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
            rowCount++;
        }
    }


    /*
                   1
                  1 2
                 1 2 3
                1 2 3 4

        Prints incremental numbers in each row
     */
    public static void printEquilateralNumberPyramidTwoIncremental() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //Printing 'rowCount' value 'rowCount' times at the end of each row
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
            rowCount++;

        }
    }

    /*
                4
               3 4
              2 3 4
             1 2 3 4

    Prints Decremental numbers in each row
   */
    public static void printEquilateralNumberPyramidTwoDecremental() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < rowCount; j++) {
                System.out.print((i + j) + " ");
            }
            System.out.println();
            rowCount++;
        }
    }

     /*
             1
            2 3
           4 5 6

        Prints from 1 to max user-entered single digit number in Pyramid Shape.
        This method with fully form the last row to maintain the structure of the pyramid even if it means exceeding
        the user-entered number. In this case, the user entered number was 5, but the last row entry has 6 to complete the pyramid
     */

    public static void printEquilateralNumberPyramidThreeIncremental() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        int k = 1;
        for (int i = rows; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
            if (k > rows) {
                break;
            }
            rowCount++;
        }
    }


         /*
                   7
                  6 5
                 4 3 2
                1 0 -1 -2

        Prints from max user-entered single digit number in Pyramid Shape.
        This method with fully form the last row to maintain the structure of the pyramid even if it means going below
        zero. In this case, the user entered number was 7, but the last row entry has -1 and -2 to complete the pyramid
     */

    public static void printEquilateralNumberPyramidThreeDecremental() {
        int rows = CommonUtil.getNonZeroDecrementalPyramidMaxNumberFromUser();
        int rowCount = 1;
        int k = rows;
        for (int i = rows; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(k + " ");
                k--;
            }
            System.out.println();
            if (k < 0) {
                break;
            }
            rowCount++;
        }
    }

    /*
            1
           2 3
          4 5

        Prints from 1 to max user-entered single digit number in Pyramid Shape.
        This method with NOT fully form the last row to maintain the structure of the pyramid if it means exceeding
        the user-entered number. In this case, the user entered number was 5, and the pyramid stopped short.
     */

    public static void printEquilateralNumberPyramidFourIncremental() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        int k = 1;
        for (int i = rows; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                if (k <= rows) {
                    System.out.print(k + " ");
                    k++;
                }
            }
            System.out.println();
            if (k > rows) {
                break;
            }
            rowCount++;
        }
    }

             /*

                   7
                  6 5
                 4 3 2
                1 0

        Prints from 1 to max user-entered single digit number in Pyramid Shape.
        This method with NOT fully form the last row to maintain the structure of the pyramid if means going below
        zero. In this case, the pyramid stopped short in the last row as soon as it reached zero
     */

    public static void printEquilateralNumberPyramidFourDecremental() {
        int rows = CommonUtil.getNonZeroDecrementalPyramidMaxNumberFromUser();
        int rowCount = 1;
        int k = rows;
        for (int i = rows; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                if (k >= 0) {
                    System.out.print(k + " ");
                    k--;
                }
            }
            System.out.println();
            if (k == 0) {
                break;
            }
            rowCount++;
        }
    }


}
