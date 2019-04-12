package com.ruby.sun.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class JStream {
    @Test
    public void replace(){
        String[] values = {"German", "English", "French"};
        List<String> arrayToList = Arrays.asList(values);
        /* jdk1.8 add replaceAll(UnaryOperator<E> operator)
			stores the new value back into the original collection */
        arrayToList.replaceAll(value -> value + ",");
        assertArrayEquals(arrayToList.toArray(), values);
        assertArrayEquals(arrayToList.toArray(), new String[]{"German,", "English,", "French,"});

        /* 1. map
         * The stream system returns a new collection rather than changing the original.
         */
        values = new String[]{"German", "English", "French"};
        arrayToList = Arrays.asList(values);
        List<String> newValues = arrayToList.stream().map(value -> value + ",").collect(Collectors.toList());
        assertFalse(Arrays.equals(newValues.toArray(), values));
        assertArrayEquals(newValues.toArray(), new String[]{"German,", "English,", "French,"});

        /* 2. forEach
         * doesn't return a stream, so use it
         */
        arrayToList.stream().map(value -> value + ",").forEach(System.out::println);
    }

    public static void main(String[] args) {
        /*
         * 3. filter
         * take a value and return a boolean
         */
        Stream.of(0, 1, 2, 3, 4)
                .filter(n -> n > 2)
                .forEach(System.out::println);
        Predicate<Integer> smaller = n -> n < 2;
        Stream.of(1, 2, 3, 4, 5).filter(smaller.negate()).forEach(System.out::println);

        /*
         * 4. collect
         * convert stream into a List or Set
         */
        Stream.of("Who", "are", "you?").collect(Collectors.joining(" "));

        /*
         * 5. reduce
         * sum(1, sum(2, sum(3, 0)))
         */
        Integer sum = Stream.of(1, 2, 3).reduce(0, Integer::sum);

        /*
         * 6. sorted
         */
        Stream.of(3, 2, 4, 0).sorted((c1, c2) -> c1 - c2).forEach(System.out::println);

    }


    public static List<Integer> createList() {
        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.asList(1, 2, 3, 4);
        return list;
    }
}

