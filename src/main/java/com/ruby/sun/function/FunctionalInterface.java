package com.ruby.sun.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FunctionalInterface {
    public static void main(String[] args) {
        /**
         * one interface with only one method
         * (parameters list) -> {method body}
         */

        //1. Runnable interface
        Runnable r1 = () -> {
            System.out.println("lambda runnable interface");
        };
        Thread t = new Thread(
                () -> {
                    System.out.println("runnable");
                }
        );
        t.start();

        Runnable run = new Runnable() {
            @Override
            public void run() {

            }
        };

        //2. Comparator interface
        List<Student> list = new ArrayList<Student>();
        Collections.sort(list, (Student s1, Student s2) -> {
            return s1.id > s2.id ? 1 : -1;
        });

        StringBuilder message = new StringBuilder();
        Runnable r = () -> System.out.println(message);
        message.append("Howdy, ");
        message.append("world!");
        r.run();
    }
}
