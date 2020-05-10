package com.example.sahil.practice.string_manipulation;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class PrintPyramidsTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(PrintPyramidsTest.class);

    @Test
    public void printIncrementalNumberPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidIncrementalOne();
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidIncrementalTwo();
        System.setIn(new ByteArrayInputStream("9".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidIncrementalFour();
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidIncrementalFive();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    @Test
    public void printStarPatternPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralStarPatternPyramid();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    @Test
    public void printDecrementalNumberPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidDecrementalOne();
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidDecrementalTwo();
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidDecrementalFour();
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidDecrementalFive();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    @Test
    public void test() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintPyramids.printEquilateralMirroredNumberPyramidDecrementalTwo();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }

}
