package com.ruby.sun.thread;

public class BasicThread {
    public static void main(String[] args) {
        (new Thread()).start();

        (new Thread("new thread")).start();

        (new MyThread()).start();

        (new Thread(new MyRunnable())).start();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("create thread throungh runnable");
            }
        };
        (new Thread(r1, "using runnable")).start();

        (new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("create thread throungh anonymous runnable");
            }
        })).start();
        ;

        Runnable r2 = () -> System.out.println("create thread throungh runnable lambda");
        (new Thread(r2)).start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("create thread throung self-defined thread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("create thread through self-defined runnable");
    }
}
