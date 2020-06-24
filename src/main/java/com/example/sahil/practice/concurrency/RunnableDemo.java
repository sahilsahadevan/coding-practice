package com.example.sahil.practice.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableDemo implements Runnable{
    private final Logger log = LoggerFactory.getLogger(RunnableDemo.class);

    RunnableDemo(){
        // The compiler creates the byte code equivalent of super ();
    }

    RunnableDemo(String name) {
        log.info("Setting a custom name to {}.", Thread.currentThread().getName());
        Thread.currentThread().setName(name); // Pass name to Thread superclass
    }


    @Override
    public void run() {
        for(int i=0;i<2;i++){
            log.info("My name is: {}", Thread.currentThread().getName());
            log.info("Daemon status for {} is: {}", Thread.currentThread().getName(), Thread.currentThread().isDaemon());
            System.out.println("Thread "+ Thread.currentThread().getName() +" is running");
            try{

                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Thread "+ Thread.currentThread().getName() +" is Finished");
        log.info("{} is now in running state.", Thread.currentThread().getName());
    }
}
