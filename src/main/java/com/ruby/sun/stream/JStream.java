package com.ruby.sun.stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class JStream {
    private List<Book> books = Arrays.asList(new Book("book1", "Ra", "Riggs", 1),
            new Book("book2", "JK", "Rowling", 2),
            new Book("book3", "JK", "Rowling", 5),
            new Book("book4", "Dr", "Seuss", 4));

    /**
     * map(Function f): return a stream consisting of the results of applying the given function to the elements of
     * this stream
     */
    @Test
    public void testMapStream() {
        assertArrayEquals(new String[] {"RIGGS", "ROWLING", "ROWLING", "SEUSS"},
                books.stream().map(book -> book.getAuthorLName().toUpperCase()).toArray());
        assertArrayEquals(new String[] {"Riggs", "Rowling", "Rowling", "Seuss"},
                books.stream().map(Book::getAuthorLName).toArray());
        assertEquals(12, books.stream().mapToInt(Book::getPages).sum());
    }

    /**
     * filter(Predicate p): returns a stream consisting of the elements of this stream that match the given predicate.
     */
    @Test
    public void testFilterStream() {
        books.stream().filter(book -> book.getPages() > 100)
                .findAny()
                .ifPresent(System.out::println);
    }

    @Test
    public void testSortStream(){
        books.stream()
                .map(Book::getPages)
                .sorted((c1, c2) -> c1 - c2).forEach(System.out::println);
        books.stream()
                .sorted(Comparator.comparing(Book::getAuthorFName))
                .sorted(Comparator.comparingInt(Book::getPages))
                .forEach(System.out::print);
        Stream.of("red", "green", "blue")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    /**
     * Collectors: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
     */
    @Test
    public void testCollectStream(){
        assertEquals("Riggs, Rowling, Rowling, Seuss",
                books.stream().map(Book::getAuthorLName).collect(joining(", ")));

        assertEquals("start Riggs, Rowling, Rowling, Seuss end",
                books.stream().map(Book::getAuthorLName).collect(joining(", ", "start ", " end")));

        Book[] objects = books.stream().filter(book -> book.getPages()>2).toArray(Book[]::new);
        assertEquals(2, objects.length);

        assertEquals(3, books.stream().map(Book::getAuthorLName).collect(toSet()).size());

        assertEquals(4, books.stream().map(book -> book.getAuthorLName().toUpperCase()).collect(toList()).size());

        System.out.println(books.stream().collect(Collectors.groupingBy(Book::getAuthorFName)));

        System.out.println(books.stream().collect(Collectors.groupingBy(Book::getAuthorFName, Collectors.summarizingInt(Book::getPages))));

        System.out.println(books.stream().collect(Collectors.partitioningBy(book -> book.getPages()>2)));

    }

    @Test
    public void testReduceStream(){
        assertEquals(12,  books.stream().map(Book::getPages).reduce(0, Integer::sum).intValue());
        assertEquals(3, books.stream().mapToInt(Book::getPages).average().getAsDouble(), 0);
    }

    @Test
    public void testPrimitiveStream(){
        IntStream.range(1, 4).forEach(System.out::print);
        (new Random()).ints(5, 0, 100).forEach(System.out::print);
        Pattern.compile(", ").splitAsStream("a, b, c").forEach(System.out::print);
    }
}
