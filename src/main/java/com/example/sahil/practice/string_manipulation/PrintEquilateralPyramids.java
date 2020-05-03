package com.example.sahil.practice.string_manipulation;

import com.example.sahil.practice.util.CommonUtil;

public class PrintEquilateralPyramids {

    /**
     * QUESTION : HOW TO PRINT PYRAMIDS
     */

// ============================ UPRIGHT EQUILATERAL PYRAMIDS ===============================================
    /*
    With single spacing    |  Excluding spacing interation  |    With two spaces

                *                       *                                   *
               * *                      * *                               * *
              * * *                     * * *                           * * *
             * * * *                    * * * *                       * * * *

    Prints Equilateral Start Pyramid (RESULT ONE)
 */
    public static void printEquilateralStarPatternPyramid() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            //EXCLUDE THIS SPACING ITERATION TO ACHIEVE RESULT TWO
            for (int j = 0; j < i; j++) {
                System.out.print(" ");    //ADD TWO SPACES TO ACHIEVE RESULT THREE
            }
            for (int j = 0; j < rowCount; j++) {
                System.out.print("* ");
            }
            System.out.println();
            rowCount++;
        }
    }


    /*
    With single spacing    |  Excluding spacing interation  |    With two spaces
                    1               1                                 1
                   2 2              2 2                             2 2
                  3 3 3             3 3 3                         3 3 3
                 4 4 4 4            4 4 4 4                     4 4 4 4

        Prints incremental rowCount (one count per row) (RESULT ONE)
     */
    public static void printEquilateralNumberPyramidIncrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            //Printing i spaces at the beginning of each row
            //EXCLUDE THIS SPACING ITERATION TO ACHIEVE RESULT TWO
            for (int j = 0; j < i; j++) {
                System.out.print(" ");  //ADD TWO SPACES TO ACHIEVE RESULT THREE
            }
            //Printing 'rowCount' value 'rowCount' times at the end of each row
            for (int j = 0; j < rowCount; j++) {
                System.out.print(rowCount + " ");
            }
            System.out.println();
            //Incrementing the rowCount
            rowCount++;
        }
    }


    /*
            With single spacing    |  Excluding spacing interation  |    With two spaces

                    4                       4                                    4
                   3 3                      3 3                                3 3
                  2 2 2                     2 2 2                            2 2 2
                 1 1 1 1                    1 1 1 1                        1 1 1 1

        Prints Decremental rowCount (one count per row)
   */
    public static void printEquilateralNumberPyramidDecrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            //EXCLUDE THIS SPACING ITERATION TO ACHIEVE RESULT TWO
            for (int j = 0; j < i; j++) {
                System.out.print(" ");   //ADD TWO SPACES TO ACHIEVE RESULT THREE
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
                    1 2 1
                  1 2 3 2 1
                1 2 3 4 3 2 1
              1 2 3 4 5 4 3 2 1

            Prints Incremental Mirrored Pyramid
    */
    public static void printEquilateralMirroredNumberPyramidIncrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");     //NOTE TWO SPACES ADDED HERE
            }
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(j + " ");
            }

            for (int j = rowCount - 1; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }

    /*
                         5
                       5 4 5
                     5 4 3 4 5
                   5 4 3 2 3 4 5
                 5 4 3 2 1 2 3 4 5

            Prints Incremental Mirrored Pyramid
    */

    public static void printEquilateralMirroredNumberPyramidDecrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");      //NOTE TWO SPACES ADDED HERE
            }
            for (int j = 0; j < rowCount; j++) {
                System.out.print((rows - j) + " ");
            }
            for (int j = 1; j < rowCount; j++) {
                System.out.print((i + j) + " ");
            }
            System.out.println();
            rowCount++;
        }

    }

    /*
                         5
                       4 5 4
                     3 4 5 4 3
                   2 3 4 5 4 3 2
                 1 2 3 4 5 4 3 2 1

            Prints Incremental Mirrored Pyramid
    */

    public static void printEquilateralMirroredNumberPyramidDecrementalTwo() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");  //NOTE TWO SPACES ADDED HERE
            }
            for (int j = 0; j < rowCount; j++) {
                System.out.print((i + j) + " ");
            }
            for (int j = rows - 1; j >= i; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }

    }

    /*
        With single spacing           With two spaces
                    1                            1
                   1 2                         1 2
                  1 2 3                      1 2 3
                 1 2 3 4                   1 2 3 4

        Prints incremental numbers in each row
     */
    public static void printEquilateralNumberPyramidIncrementalTwo() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");   //ADD TWO SPACES TO ACHIEVE RESULT THREE
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
               4 3
              4 3 2
             4 3 2 1

    Prints decremental numbers in each row
 */
    public static void printEquilateralNumberPyramidDecrementalTwo() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < rowCount; j++) {
                System.out.print((rows - j) + " ");
            }
            System.out.println();
            rowCount++;
        }
    }

    /*
                1
               2 1
              3 2 1
             4 3 2 1

    Prints incremental numbers in reverse in each row
 */
    public static void printEquilateralNumberPyramidIncrementalThree() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < rowCount; j++) {
                System.out.print((rowCount - j) + " ");
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
    public static void printEquilateralNumberPyramidDecrementalThree() {
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

        Prints from 1 to max user-entered single digit number in Pyramid Shape. This method with fully
        form the last row to maintain the structure of the pyramid even if it means exceeding the
        user-entered number. In this case, the user entered number was 5, but the last row entry has
         number 6 to complete the pyramid
     */

    public static void printEquilateralNumberPyramidIncrementalFour() {
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

        Prints from max user-entered single digit number in Pyramid Shape. This method will fully
        form the last row to maintain the structure of the pyramid even if it means going below
        zero. In this case, the user entered number was 7, but the last row entry has -1 and -2
        to complete the pyramid
     */

    public static void printEquilateralNumberPyramidDecrementalFour() {
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

        Prints from 1 to max user-entered single digit number in Pyramid Shape. This method with NOT
        fully form the last row to maintain the structure of the pyramid if it means exceeding the
        user-entered number. In this case, the user entered number was 5, and the pyramid stopped short.

     */

    public static void printEquilateralNumberPyramidIncrementalFive() {
        int ceilingNumber = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        int k = 1;
        for (int i = ceilingNumber; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                if (k <= ceilingNumber) {
                    System.out.print(k + " ");
                    k++;
                }
            }
            System.out.println();
            if (k > ceilingNumber) {
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

        Prints from 1 to max user-entered single digit number in Pyramid Shape. This method with NOT
        fully form the last row to maintain the structure of the pyramid if means going below zero.
        In this case, the pyramid stopped short in the last row as soon as it reached zero
     */

    public static void printEquilateralNumberPyramidDecrementalFive() {
        int ceilingNumber = CommonUtil.getNonZeroDecrementalPyramidMaxNumberFromUser();
        int rowCount = 1;
        int k = ceilingNumber;
        for (int i = ceilingNumber; i > 0; i--) {

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


// ============================ REVERSE PYRAMIDS ================================================


    /*
         1 2 3 4 5                  1 2 3 4 5                1 2 3 4 5
          1 2 3 4                   1 2 3 4                    1 2 3 4
           1 2 3                    1 2 3                        1 2 3
            1 2                     1 2                            1 2
             1                      1                                1
     */

    public static void printReversedEquilateralNumberPyramidIncrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        //EXCLUDE THIS SPACING ITERATION TO ACHIEVE RESULT TWO
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < rowCount; j++) {
                System.out.print(" ");     // ADD TWO SPACES FOR RESULT THREE
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }


    /*

         5 4 3 2 1                  5 4 3 2 1                5 4 3 2 1
          4 3 2 1                   4 3 2 1                    4 3 2 1
           3 2 1                    3 2 1                        3 2 1
            2 1                     2 1                            2 1
             1                      1                                1
     */

    public static void printReversedEquilateralNumberPyramidDecrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < rowCount; j++) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }


     /*

             1 2 3 4 5 4 3 2 1
               2 3 4 5 4 3 2
                 3 4 5 4 3
                   4 5 4
                     5
     */

    public static void printReversedEquilateralMirroredNumberPyramidIncrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < rowCount; j++) {
                System.out.print("  "); //NOTE TWO SPACES ADDED HERE
            }
            for (int j = rowCount; j <= rows; j++) {
                System.out.print(j + " ");
            }
            for (int j = rows - 1; j >= rowCount; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }


     /*

             5 4 3 2 1 2 3 4 5
               4 3 2 1 2 3 4
                 3 2 1 2 3
                   2 1 2
                     1
     */

    public static void printReversedEquilateralMirroredNumberPyramidDecrementalOne() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < rowCount; j++) {
                System.out.print("  "); //NOTE TWO SPACES ADDED HERE
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j + " ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }

         /*

             1 2 3 4 5 4 3 2 1
               1 2 3 4 3 2 1
                 1 2 3 2 1
                   1 2 1
                     1
     */

    public static void printReversedEquilateralMirroredNumberPyramidIncrementalTwo() {
        int rows = CommonUtil.getSingleDigitNonZeroRowInputFromUser();
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < rowCount; j++) {
                System.out.print("  "); //NOTE TWO SPACES ADDED HERE
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = i - 1; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }
}
