package com.ruby.sun.thread;

public class GarbageCollection {
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String[] args) {
        GarbageCollection gc = new GarbageCollection();
        gc = null;
        System.gc();
    }

}
