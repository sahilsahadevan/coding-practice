package com.example.sahil.practice.data_structures_and_algorithms;

public class Sorting {

//=============== Selection sort in java ====================================================
// Selection sort first selects the lowest (or highest) element and exchanges it with the element
// in the first position. Then, again selects lowest (or highest) element in the remaining elements i.e
// in the elements between inputArray[1] and inputArray[n-1] and exchanges it with the element in the second position.
// This selection and placement is continued until all the elements are in the sorted order.

    /*
       selectionSort(int[] inputArray)
        for i = 0 to inputArray.length-1
            Select the lowest (or highest) element among inputArray[i] ....... inputArray[inputArray.length-1]
            Swap it with inputArray[i]

     */
    public static int[] doSelectionSortIntAsc(int[] inputArr) {
        int len = inputArr.length;
        for (int i = 0; i < len; i++) {
            int positionWithMinVal = i;
            for (int j = i + 1; j < len; j++) {
                if (inputArr[j] < inputArr[positionWithMinVal]) {
                    positionWithMinVal = j;
                }
            }
            if (positionWithMinVal != i) {
                int temp = inputArr[i];
                inputArr[i] = inputArr[positionWithMinVal];
                inputArr[positionWithMinVal] = temp;
            }
        }
        return inputArr;
    }

    public static int[] doSelectionSortIntDesc(int[] inputArr) {
        int len = inputArr.length;
        for (int i = 0; i < len; i++) {
            int positionWithMaxVal = i;
            for (int j = i + 1; j < len; j++) {
                if (inputArr[j] > inputArr[positionWithMaxVal]) {
                    positionWithMaxVal = j;
                }
            }
            if (positionWithMaxVal != i) {
                int temp = inputArr[i];
                inputArr[i] = inputArr[positionWithMaxVal];
                inputArr[positionWithMaxVal] = temp;
            }
        }
        return inputArr;
    }
}
