/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruby.sun.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author MFihser
 */
public class Synchronizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(4);
        // create and start threads
        for (int i = 0; i < 5; ++i)
            new Thread(new Worker(start, end)).start();

        try {
            System.out.println("main thread doing something");
            Thread.sleep(1000); // sleep for 1 second
            start.countDown(); // let all threads proceed
            System.out.println("main thread doing something else");
            end.await(); // wait for all threads to finish

        } catch (InterruptedException ie) {
            System.err.println(ie);
        }
    }

}

class Worker extends Thread {
    private final CountDownLatch start;
    private final CountDownLatch end;

    Worker(CountDownLatch start, CountDownLatch end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        try {
            printInfo("thread entered run()");
            start.await(); // wait before proceeding
            printInfo("doing work");
            Thread.sleep(3000);
            end.countDown(); // reduce count
        } catch (InterruptedException ie) {
            System.err.println(ie);
        }
    }

    void printInfo(String s) {
        System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread() + ": " + s);
    }
}
