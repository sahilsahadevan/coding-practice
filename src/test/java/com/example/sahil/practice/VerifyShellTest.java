package com.example.sahil.practice;

import com.example.sahil.practice.array_manipulation.ArrayManipulationTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.sahil.practice.VerifyShell.*;

public class VerifyShellTest {
    private final Logger log = LoggerFactory.getLogger(ArrayManipulationTest.class);

    /*
       This is a Temperory Test class where my plainText IDE-unsupported code can be verified
       and validated for syntax and logical errors
     */

    @Test
    public void test() {
        log.info("{}", 0XF); //means the number is a decimal 1
        log.info("{}", Integer.toBinaryString(15)); //means the number is a decimal 1
        log.info("{}", 0b0100/0b0010); //means the number is a decimal 1

    }
}

