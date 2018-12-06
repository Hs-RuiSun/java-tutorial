package com.ruby.sun.thread;

public class ThreadState {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.printf("%s is running, %salive state %s priority %d",
                thread.getName(),
                thread.isAlive() ? "" : "not ",
                thread.getState(),
                thread.getPriority());
    }
}
