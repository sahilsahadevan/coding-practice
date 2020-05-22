package com.example.sahil.practice.string_manipulation;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.sahil.practice.string_manipulation.StringManipulation.*;

public class StringManipulationTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(StringManipulationTest.class);

    @Test
    public void reverseWithRecursionTest() {
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingRecursive1("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingRecursive2("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingLoopIteration("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        Assertions.assertEquals("navedahas lihas", reverseUsingStringBuilder("Sahil Sahadevan").toLowerCase());
        executionTime(time);

    }


    @Test
    public void removeAllWhiteSpaceUsingRegexTest(){
        startTime();
        removeAllWhiteSpaceUsingRegex("         THis had a lot of un even w   hit es paces         ");
        executionTime(time);
        startTime();
        removeAllWhiteSpaceUsingLoopIterations("         THis had a lot of un even w   hit es paces         ");
        executionTime(time);
    }

    @Test
    public void findAndCountDuplicateOccurencesTest() {
        findAndCountDuplicateChars("Bebbtter Butbter");
        findAndCountDuplicateChars("This one");

    }

    @Test
    public void checkIfAnagramTest() {
        Assertions.assertTrue(checkIfAnagramUsingArraysUtils("Tom Marvolo Riddle", "I am Lord Voldemort"));
        Assertions.assertTrue(checkIfAnagramUsingIterations("Tom Marvolo Riddle", "I am Lord Voldemort"));
        Assertions.assertTrue(checkIfAnagramUsingArraysUtils("This is", "Sis Hit"));
        Assertions.assertTrue(checkIfAnagramUsingIterations("This is", "Sis Hit"));
        Assertions.assertFalse(checkIfAnagramUsingArraysUtils("shabbath", "Bath Abss"));
        Assertions.assertFalse(checkIfAnagramUsingIterations("shabbath", "Bath Abss"));
        Assertions.assertFalse(checkIfAnagramUsingArraysUtils("Sis is sisi", "iiiiiiiss"));
        Assertions.assertFalse(checkIfAnagramUsingIterations("Sis is sisi", "iiiiiiiss"));
    }





    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }

}
