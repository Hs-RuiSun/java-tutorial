package com.ruby.sun.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class JThreadInner extends Thread {
    String message;

    public JThreadInner(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.message);
    }
}

public class JThreadPool extends Thread {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            JThreadInner thread = new JThreadInner(i + "");
            executor.execute(thread);
        }
        executor.shutdown();

        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread());
    }
}
