package com.example.sahil.practice.string_manipulation;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class PrintEquilateralPyramidsTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(PrintEquilateralPyramidsTest.class);

    @Test
    public void printIncrementalNumberPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidIncrementalOne();
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidIncrementalTwo();
        System.setIn(new ByteArrayInputStream("9".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidIncrementalFour();
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidIncrementalFive();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    @Test
    public void test() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintEquilateralPyramids.printReversedEquilateralMirroredNumberPyramidIncrementalOne();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    @Test
    public void printStarPatternPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintEquilateralPyramids.printEquilateralStarPatternPyramid();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }

    @Test
    public void printDecrementalNumberPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidDecrementalOne();
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidDecrementalTwo();
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidDecrementalFour();
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        PrintEquilateralPyramids.printEquilateralNumberPyramidDecrementalFive();
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
