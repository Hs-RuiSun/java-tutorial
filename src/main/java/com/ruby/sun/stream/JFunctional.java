package com.ruby.sun.stream;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * one interface with only one method
 * (parameters list) -> {method body}
 */
public class JFunctional {
    @Test
    public void testPredicate(){
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
