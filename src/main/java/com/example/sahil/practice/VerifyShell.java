package com.example.sahil.practice;

import java.util.HashMap;
import java.util.*;


public class VerifyShell {

    /*
       This is a Temperory class where my plainText IDE-unsupported code can be verified
       and validated for syntax and logical errors
     */


    public static int[][] getTranspose(int[][] input) {

        if(null == input || input.length == 0){
            return new int[0][0];
        }

        int[][] transpose = new int[input[1].length][input.length];

        for(int i=0; i< input.length; i++){
            for(int j=0; j< input[1].length; j++){
                transpose[j][i] = input[i][j];
            }
        }

        return transpose;

    }
}
