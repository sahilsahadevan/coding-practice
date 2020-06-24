package com.example.sahil.practice.concurrency;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableDemoTest {
    private final Logger log = LoggerFactory.getLogger(RunnableDemoTest.class);

    @Test
    public void test() throws InterruptedException {
        RunnableDemo r1 = new RunnableDemo();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
    }
}
