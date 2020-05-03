package com.example.sahil.practice.string_manipulation;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }

}
