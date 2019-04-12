package com.ruby.sun.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class JStream {
    private List<Book> books = Arrays.asList(new Book("book1", "Ra", "Riggs", 1),
            new Book("book2", "JK", "Rowling", 2),
            new Book("book3", "Dr", "Seuss", 3));

    @Test
    public void testDoubleColon(){

    }

    /**
     * map(Function f): return a stream consisting of the results of applying the given function to the elements of
     * this stream
     */
    @Test
    public void testMapStream() {
        assertArrayEquals(new String[] {"RIGGS", "ROWLING", "SEUSS"},
                books.stream().map(book -> book.getAuthorLName().toUpperCase()).toArray());
        assertArrayEquals(new String[] {"Riggs", "Rowling", "Seuss"},
                books.stream().map(Book::getAuthorLName).toArray());
        assertEquals(6, books.stream().mapToInt(Book::getPages).sum());
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
        Stream.of("red", "green", "blue")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Test
    public void testCollectStream(){
        assertEquals("Riggs, Rowling, Seuss",
                books.stream().map(Book::getAuthorLName).collect(Collectors.joining(", ")));

        books.stream().map(book -> book.getAuthorLName().toUpperCase()).collect(Collectors.toList());

        //reduce
        Integer sum = Stream.of(1, 2, 3).reduce(0, Integer::sum);

        //sort


        //other
        books.stream()
                .mapToInt(Book::getPages)
                .average()
                .ifPresent(System.out::println);


    }

    @Test
    public void testPrimitiveStream(){
        IntStream.range(1, 4)
                .forEach(System.out::println);
    }
}
