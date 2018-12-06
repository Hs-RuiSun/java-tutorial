package com.ruby.sun.thread;

public class Cooperation {
    public static Integer amount = 0;

    public synchronized void deposit(int num) {
        amount += num;
        System.out.println("deposit completed, num=" + amount);
        notify();
    }

    public synchronized void withdraw(int num) {
        while (amount < num) {
            System.out.println("not enough money, please wait...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        amount -= num;
        System.out.println("withdraw completed, num=" + amount);
    }

    public static void main(String[] args) {
        final Cooperation coop = new Cooperation();
        Thread t1 = new Thread() {
            public void run() {
                coop.withdraw(1000);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                coop.deposit(500);
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                coop.deposit(500);
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }

}
