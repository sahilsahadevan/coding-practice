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
    public void reverseStringTest() {
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingRecursive1("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingRecursive2("Sahil Sahadevan").toLowerCase());
        executionTime(time);
        startTime();
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingLoopIteration1("Sahil Sahadevan"));
        executionTime(time);
        startTime();
        Assertions.assertEquals("navedahas lihas", reverseUsingLoopIteration2("Sahil Sahadevan"));
        executionTime(time);
        Assertions.assertEquals("navedahas lihas", reverseUsingStringBuilder("Sahil Sahadevan").toLowerCase());
        executionTime(time);

    }

    @Test
    public void reverseStringWhilePreservingSpaceTest() {
        Assertions.assertEquals("naved ahaSlihaS", reverseWhilePreservingSpace("Sahil Sahadevan"));
        Assertions.assertEquals("n av edaha SlihaSmaI", reverseWhilePreservingSpace("I am Sahil Sahadevan"));

    }

    @Test
    public void removeAllWhiteSpaceUsingRegexTest() {
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

    @Test
    public void measurePercentageOfCharsInStringTest() {
        measureCharsInString("This is Test no. 12345 ");
    }

    @Test
    public void checkIfImmutableTest() {
        Assertions.assertTrue(checkIfImmutable("I am told this is immutable"));
    }

    @Test
    public void test() {
        String check = "This is America";
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (char i : check.toCharArray()) {
            string1.append(i);
            string2.insert(0, i);
        }
        log.info("Orig = '{}', string1 = '{}', string2 = '{}'", check, string1, string2);
    }

    // FOR TIME TRACKING
    public void startTime() {
        time = System.currentTimeMillis();
    }

    public void executionTime(long startTime) {
        log.info("ExecutionTime is {} milliseconds", System.currentTimeMillis() - startTime);
    }


}
