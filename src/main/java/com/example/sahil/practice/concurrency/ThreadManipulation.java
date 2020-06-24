package com.example.sahil.practice.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadManipulation extends Thread {
    private final Logger log = LoggerFactory.getLogger(ThreadManipulation.class);

    ThreadManipulation() {
        // The compiler creates the byte code equivalent of super ();
    }

    ThreadManipulation(String name) {
        log.info("Setting a custom name to {}.", getName());
        setName(name); // Pass name to Thread superclass
    }


    @Override
    public void run() {
        log.info("My name is: {}", getName());
        log.info("Daemon is: {}", isDaemon());
        log.info("Putting {} to sleep for 5 seconds", getName());
        try {
            Thread.sleep(5000);
            log.info("{} is now awake", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{} is now in running state.", getName());
    }
}

