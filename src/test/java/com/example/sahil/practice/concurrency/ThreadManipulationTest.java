package com.example.sahil.practice.concurrency;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class ThreadManipulationTest {
    private final Logger log = LoggerFactory.getLogger(ThreadManipulationTest.class);

    @Test
    public void test() throws InterruptedException {
        ThreadManipulation t1 = new ThreadManipulation();
        t1.start();

        //"The current thread must own this object's monitor." else it throws IllegalMonitorStateException"
        // if the current thread is not the owner of the object's monitor."
        // That is, you need to synchronize on the object you are going to call wait on.
        synchronized (t1) {
            t1.wait(1000);
        }
        ThreadManipulation t2 = new ThreadManipulation("MyCustomThreadName");
        t2.start();
    }

    @Test
    public void isThreadAliveTest() throws InterruptedException {
        ThreadManipulation t1 = new ThreadManipulation();
        log.info("{} not started yet. Is Thread alive? ->{}", t1.getName(), t1.isAlive());
        t1.start();
        log.info("{} is started now.Is the Thread alive now? ->{}", t1.getName(), t1.isAlive());
        while (t1.isAlive()) {
            Thread.sleep(5000);
        }
        log.info("{} has reached the end of execution. is the Thread Alive now? ->{}", t1.getName(), t1.isAlive());
        log.info("That is all. Thanks");
    }

    @Test
    public void ThreadJoinTest() throws InterruptedException {
        ThreadManipulation t1 = new ThreadManipulation();
        ThreadManipulation t2 = new ThreadManipulation();
        ThreadManipulation t3 = new ThreadManipulation();
        log.info("Current Thread: {}", Thread.currentThread().getName());
        t1.start();
        log.info("{} is started now", t1.getName());
        // ensures t1 thread is done executing as is dead before t2 thread starts
        t1.join();
        // starting t2 thread
        t2.start();
        log.info("thread {} isAlive status is now {}, {} started ", t1.getName(), t1.isAlive(), t2.getName());
        // ensures t2 thread is done executing as is dead before t3 thread starts
        t2.join();
        // starting t3 thread
        t3.start();
        log.info("thread {} isAlive status is now {}, {} started ", t2.getName(), t2.isAlive(), t3.getName());
        log.info("That is all. Thanks");
    }



    @Test
    public void DaemonThreadTest() throws InterruptedException {
        ThreadManipulation t1 = new ThreadManipulation();
        t1.setDaemon(true);
        t1.start();
        log.info("{} is started now", t1.getName());
    }

}
