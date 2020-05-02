package com.example.sahil.practice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CommonUtil {

    private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public static int getSingleDigitNonZeroRowInputFromUser() {
        log.info("[{}]", Thread.currentThread().getStackTrace()[2].getMethodName());

        Scanner scanner = new Scanner(System.in);
        String errorMessage = "";
        int rows;
        do {
            log.info("{}Please Enter the number of rows to print (between 1 to 9) => ", errorMessage);
            rows = scanner.nextInt();
            errorMessage = "Incorrect Range! ";
        } while (rows > 9 || rows == 0);
        log.info("{} \nHere it is : \n", rows);
        return rows;
    }


    public static int getNonZeroDecrementalPyramidMaxNumberFromUser() {
        log.info("[{}]", Thread.currentThread().getStackTrace()[2].getMethodName());
        Scanner scanner = new Scanner(System.in);
        String errorMessage = "";
        int rows;
        do {
            log.info("{}Please Enter the non-zero number you want to start your decremental pyramid from => ", errorMessage);
            rows = scanner.nextInt();
            errorMessage = "Zero not allowed!";
        } while (rows == 0);
        log.info("{} \nHere it is : \n", rows);
        return rows;
    }
}


