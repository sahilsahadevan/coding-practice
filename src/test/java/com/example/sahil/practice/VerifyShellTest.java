package com.example.sahil.practice;

import com.example.sahil.practice.array_manipulation.ArrayManipulationTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyShellTest {
    private final Logger log = LoggerFactory.getLogger(ArrayManipulationTest.class);

    /*
       This is a Temperory Test class where my plainText IDE-unsupported code can be verified
       and validated for syntax and logical errors
     */


    @Test
    public void test(){
        int[][] a = new int[][]{{16, 15, 18, 17, 10}, {8, 0, 5, 15, 18}}; // 2 rows, 5 column
        int[][] transpose =  VerifyShell.getTranspose(a);
        int i = 0;
        while (i < a.length ){
            log.info("{}",a[i]);
            i++;
        }
        i = 0;
        while (i < transpose.length ){
                log.info("{}",transpose[i]);
                i++;
        }
    }
}

