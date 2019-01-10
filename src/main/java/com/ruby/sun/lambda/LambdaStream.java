package com.ruby.sun.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaStream {
    public static void main(String[] args) {
        Arrays.asList("red", "green", "blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //example of Stream.of with a filter 
        Stream.of("apple", "pear", "banana", "cherry", "apricot")
                .filter(fruit -> {
                    //  System.out.println("filter: " + fruit);
                    return fruit.startsWith("a"); //predicate
                })
                //if the foreach is removed, nothing will print,
                //the foreach makes it a terminal event
                .forEach(fruit -> System.out.println("Starts with A: " + fruit));

        //using a stream and map operation to create a list of words in caps
        List<String> collected = Stream.of("Java", " Rocks")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected.toString());

    }
}
