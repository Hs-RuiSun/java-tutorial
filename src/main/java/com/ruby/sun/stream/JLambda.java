package com.ruby.sun.stream;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


/**
 * Lambda
 * is Java's first step into functional programming
 */
public class JLambda {
    /**
     * double colon/method reference operator::
     */
    @Test
    public void testDoubleColon(){
        //static method
        Stream.of(new Book("book1", "Ra", "Riggs", 1),
                new Book("book2", "JK", "Rowling", 2))
                .map(Book::getAuthorFName)  //instance method of an arbitrary object of a particular type
                .forEach(System.out::println); //instance method
        //constructor
        Stream.of("book1", "book2").forEach(Book::new);
    }

    @Test
    public void testRunnableComparator() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
            }
        };
        //1. Runnable interface
        StringBuilder message = new StringBuilder();
        message.append("Howdy, ");
        message.append("world!");
        Runnable r = () -> System.out.println(message);
        r.run();
        Thread t = new Thread( () -> System.out.println("runnable") );
        t.start();

        //2. Comparator interface
        List<Book> list = new ArrayList<>();
        Collections.sort(list, (Book b1, Book b2) -> b1.getPages() > b2.getPages() ? 1 : -1);
    }

    @Test
    public void testHowLambdaDeveloped(){
        List<String> names = Arrays.asList("Paul", "Jane", "Michaela", "Sam");
        //way to sort prior to Java 8 lambdas
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //now remove the return statement
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        //now remove the data types and allow the compile to infer the type
        Collections.sort(names, (a, b) -> a.compareTo(b));
    }
}