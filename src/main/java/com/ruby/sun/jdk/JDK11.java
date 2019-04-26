package com.ruby.sun.jdk;

import com.ruby.sun.stream.Book;
import org.junit.Test;

import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JDK11 {
//    @Test
//    public void testString(){
//        String lines = "abc\nefed\nfih\nlgie.";
//        assertEquals(4, "abc\nefed\nfih\nlgie.".lines().collect(Collectors.toList()).size());
//
//        String string = " abc ";
//        assertEquals("abc", " abc ".strip()); //unicode-aware
//        assertEquals("abc", " abc ".trim());
//        Character c = '\u2000';
//        assertEquals("abc", (c + "abc").strip());
//        assertNotEquals("abc", (c + "abc").trim());
//    }
//
//    @Test
//    public void testStringBuffer(){
//        assertEquals(1, new StringBuffer().append("abc").append("def").compareTo(new StringBuffer().append("abc").append("dee")));
//        assertEquals(0, new StringBuffer().append("abc").append("def").compareTo(new StringBuffer().append("abc").append("def")));
//        assertEquals(-1, new StringBuffer().append("abc").append("def").compareTo(new StringBuffer().append("abc").append("deg")));
//        assertEquals(1, new StringBuilder().append("abc").append("def").compareTo(new StringBuilder().append("abc").append("dee")));
//        assertEquals(0, new StringBuilder().append("abc").append("def").compareTo(new StringBuilder().append("abc").append("def")));
//        assertEquals(-1, new StringBuilder().append("abc").append("def").compareTo(new StringBuilder().append("abc").append("deg")));
//    }
//
//    /**
//     * Object[] toArray(java.util.function.IntFunction)
//     */
//    @Test
//    public void testCollection(){
//        List<Book> x = List.of(new Book("Harry Potter and The Sorcerers Stone","JK", "Rowling", 411),
//                new Book("The Cat in the Hat","Dr", "Seuss", 45));
//        x.toArray();
//        Book[] y = x.toArray(Book[]::new);
////        Function f = Book[]::new;
////        DoubleFunction d = e -> new Book(e);
//        IntFunction<Book[]> t = Book[]::new;
//        Book[] book = t.apply(1);
//        System.out.println(y);
//    }
}
