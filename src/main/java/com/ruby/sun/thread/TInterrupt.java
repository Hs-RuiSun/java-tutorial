package com.ruby.sun.thread;

public class TInterrupt extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task");
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted..." + e);
            //System.out.println("Exception handled ");
        }
        System.out.println("thread is running...");

    }

    public static void main(String[] args) {
        TInterrupt thread = new TInterrupt();
        thread.start();
        try {
            thread.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled ");
        }
    }

}
