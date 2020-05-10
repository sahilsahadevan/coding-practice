package com.example.sahil.practice.string_manipulation;


import com.example.sahil.practice.array_manipulation.ArrayManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringManipulationTest {
    long time;

    private final Logger log = LoggerFactory.getLogger(StringManipulationTest.class);

    @Test
    public void reverseWithRecursionTest() {
        startTime();
        Assertions.assertEquals("navedahas lihas", StringManipulation.reverseUsingRecursive1("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        Assertions.assertEquals("navedahas lihas", StringManipulation.reverseUsingRecursive2("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        startTime();
        Assertions.assertEquals("navedahas lihas", StringManipulation.reverseUsingLoopIteration("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        Assertions.assertEquals("navedahas lihas", StringManipulation.reverseUsingStringBuilder("Sahil Sahadevan").toLowerCase());
        executionTime(time);

    }


    @Test
    public void removeAllWhiteSpaceUsingRegexTest(){
        startTime();
        StringManipulation.removeAllWhiteSpaceUsingRegex("         THis had a lot of un even w   hit es paces         ");
        executionTime(time);
        startTime();
        StringManipulation.removeAllWhiteSpaceUsingLoopIterations("         THis had a lot of un even w   hit es paces         ");
        executionTime(time);
    }

    @Test
    public void findAndCountDuplicateOccurencesTest() {
        StringManipulation.findAndCountDuplicateChars("Bebbtter Butbter");
        StringManipulation.findAndCountDuplicateChars("This one");

    }

    @Test
    public void checkIfAnagramTest() {
        Assertions.assertTrue(StringManipulation.checkIfAnagramUsingArraysUtils("Tom Marvolo Riddle", "I am Lord Voldemort"));
        Assertions.assertTrue(StringManipulation.checkIfAnagramUsingIterations("Tom Marvolo Riddle", "I am Lord Voldemort"));
        Assertions.assertTrue(StringManipulation.checkIfAnagramUsingArraysUtils("This is", "Sis Hit"));
        Assertions.assertTrue(StringManipulation.checkIfAnagramUsingIterations("This is", "Sis Hit"));
        Assertions.assertFalse(StringManipulation.checkIfAnagramUsingArraysUtils("shabbath", "Bath Abss"));
        Assertions.assertFalse(StringManipulation.checkIfAnagramUsingIterations("shabbath", "Bath Abss"));
        Assertions.assertFalse(StringManipulation.checkIfAnagramUsingArraysUtils("Sis is sisi", "iiiiiiiss"));
        Assertions.assertFalse(StringManipulation.checkIfAnagramUsingIterations("Sis is sisi", "iiiiiiiss"));
    }

    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }
    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }

}
