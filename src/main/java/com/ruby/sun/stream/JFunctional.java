package com.ruby.sun.stream;

import org.junit.Test;

import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * one interface with only one method
 * (parameters list) -> {method body}
 */
public class JFunctional {
    @Test
    public void testIntFunction(){
        IntFunction array = t -> new Book[]{};
        IntFunction bookArray = Book[]::new;
        assertTrue(array.apply(3) instanceof Book[]);
        Function<Book, String> funcBookToString = Book::getAuthorLName;
        Function<String, String> funcStringToString = String::toUpperCase;
        BiFunction<String, String, Integer> f = (string1, string2) -> string1.length() + string2.length();
    }

    /**
     * represent a type-level solution for representing optional values instead of null references
     */
    @Test
    public void testOptional() {
        Optional<String> empty = Optional.empty();
        assertTrue(empty.isEmpty());
        Optional<String> optional = Optional.of("optional");
        assertEquals("optional", optional.get());
        //Optional.of(null); //NullPointerException
        assertTrue(Optional.ofNullable(null).isEmpty()); //isEmpty is from JDK 11
        assertFalse(Optional.ofNullable(null).isPresent());

        Optional.of("optional").ifPresent(System.out::println); //conditional action with ifPresent
        assertEquals("empty", Optional.ofNullable(null).orElse("empty")); //default value with orElse
        assertEquals("empty", Optional.ofNullable(null).orElseGet(() -> "empty")); //default value with orElse
        assertTrue(Optional.ofNullable(100)
                .filter(value -> value > 10)
                .filter(value -> value < 200).
                        isPresent());
        assertFalse(Optional.ofNullable((Integer) null).filter(value -> value > 10).isPresent());
        Optional.of(new Book("book2", "JK", "Rowling", 2)).map(Book::getAuthorFName).orElse("");
    }

    @Test
    public void testPredicate() {
        Predicate<Integer> smaller = n -> n < 2;
        Stream.of(1, 2, 3, 4, 5).filter(smaller.negate()).forEach(System.out::println);
    }
    @Test
    public void testInterfaces(){
        //using the test method of Predicate
        Predicate<String> stringLen = (s) -> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        //Consumer example uses accept method
        Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
        consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

        //Function example
        Function<Integer, String> converter = (num) -> Integer.toString(num);
        System.out.println("length of 26: " + converter.apply(26).length());

        //Supplier example
        Supplier<String> s = () -> "Java is fun";
        System.out.println(s.get());

        //Binary Operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));

        //Unary Operator example
        UnaryOperator<String> str = (msg) -> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));

        //own functional interface
//        Calculate cadd = (a, b) -> a + b;
//        Calculate difference = (a, b) -> Math.abs(a - b);
//        Calculate divide = (a, b) -> (b != 0 ? a / b : 0);
//
//        System.out.println(cadd.calc(3, 2));
//        System.out.println(difference.calc(5, 10));
//        System.out.println(divide.calc(5, 0));
    }
}
