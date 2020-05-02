package com.example.sahil.practice.string_manipulation;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class StructureManipulationTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(StructureManipulationTest.class);

    @Test
    public void reverseWithRecursionTest() {
        startTime();
        Assertions.assertEquals("navedahas lihas", StructureManipulation.reverseUsingRecursive1("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        Assertions.assertEquals("navedahas lihas", StructureManipulation.reverseUsingRecursive2("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        startTime();
        Assertions.assertEquals("navedahas lihas", StructureManipulation.reverseUsingLoopIteration("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        Assertions.assertEquals("navedahas lihas", StructureManipulation.reverseUsingStringBuilder("Sahil Sahadevan").toLowerCase());
        executionTime(time);

    }

    @Test
    public void printIncrementalPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidOneIncremental();
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidTwoIncremental();
        System.setIn(new ByteArrayInputStream("9".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidThreeIncremental();
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidFourIncremental();
        //reset SystemInput for fresh inputs [Optional]
        System.setIn(System.in);

    }


    @Test
    public void printDecrementalPyramidsWithUserInputs() {
        //simulate userInput (new Scanner(System.in))
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidOneDecremental();
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidTwoDecremental();
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidThreeDecremental();
        System.setIn(new ByteArrayInputStream("7".getBytes()));
        PrintPyramids.printEquilateralNumberPyramidFourDecremental();
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
