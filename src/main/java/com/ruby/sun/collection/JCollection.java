package com.ruby.sun.collection;


import com.ruby.sun.stream.Book;
import org.apache.commons.lang3.ArrayUtils;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JCollection {
    public void testArrayCopy() {
        byte[] src = new byte[100];
        byte[] des = new byte[100];
        System.arraycopy(des, 0, src, 0, src.length);
    }

    @Test
    public void testList(){
        Collection<String> collection = new ArrayList<>();
    }

    @Test
    public void testMap(){

    }

    @Test
    public void testSet(){
        List<Book> books = Arrays.asList(new Book("Miss Peregrine's Home for Peculiar Children","Ranson", "Riggs", 382),
                new Book("Harry Potter and The Sorcerers Stone","JK", "Rowling", 411),
                new Book("The Cat in the Hat","Dr", "Seuss", 45),
                new Book("The Cat in the Hat","Dr", "Seuss", 45),
                new Book("The Dog in the Hat","Dr", "Seuss", 111));
        assertEquals(5, books.size());
        Collection<Book> noDups = new HashSet<>(books);
        assertEquals(5, noDups.size());
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 3, 3, 2, 1, 1, 1));
        assertEquals(4, numbers.size());
        assertArrayEquals(new Object[]{1,2,3,4}, numbers.toArray()); //sort automatically ??
    }

    @Test
    public void testQueue(){

    }

    @Test
    public void thisIsNewLine(){

    }

    @Test
    public void testSort(){
        List<String> names = Arrays.asList("Paul", "Jane", "Michaela", "Sam");
        Collections.sort(names, Comparator.naturalOrder());
        Collections.sort(names, Comparator.reverseOrder());
        Collections.sort(names);
    }

    @Test
    public void convertBetweenCollectionAndArray(){
        String[] values = {"German", "English", "French"};
        List<String> arrayToList = Arrays.asList(values);
        String[] listToArray = arrayToList.toArray(new String[arrayToList.size()]);
        assertArrayEquals(values, listToArray);
    }

    @Test
    public void compareTwoArrayEqualsIgnoreOrder(){
        String[] first = {"German", "English", "French"};
        String[] second = {"German", "French", "English"};
        assertFalse(Arrays.equals(first, second));

        Arrays.sort(first);
        Arrays.sort(second);
        assertArrayEquals(first, second);
    }

    @Test
    public void compareTwoListEqualsIgnoreOrder(){
        List<String> first = Arrays.asList(new String[]{"German", "French", "English"});
        List<String> second = Arrays.asList(new String[]{"German", "English", "French"});

        assertTrue(new HashSet<>(first).equals(new HashSet<>(second)));

        assertThat("List equality without order", second, containsInAnyOrder(first.toArray(new String[first.size()])));
    }

    @Test
    public void testConcatenateMultipleArrays() {
        String[] first = {"a"};
        String[] second = {"b"};
        //need extra dependency from apache common lang 
        String[] str3 = (String[]) ArrayUtils.addAll(first, second);

        String[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
    }

    @Test
    @Ignore
    public void testDeclareAndInstantiateListAndArray() {
        //declare and initialize an list
        List<String> list = Arrays.asList("this", "is", "a", "list");
        list.add("is it immutable?"); //yes
        List<String> list2 = new ArrayList<String>(Arrays.asList("this", "is", "a", "list"));
        list2.add("is it immutable?"); //no
        List<String> list3 = Stream.of("a", "list").collect(Collectors.toList());

        //declare and initialize an array
        String[] strings1 = new String[]{};
        String[] strings2 = {};
        String[] strings3 = new String[5];
    }

    @Test
    public void replace(){
        List<String> arrayToList = Arrays.asList("German", "English", "French");
        /* jdk1.8 add replaceAll(UnaryOperator<E> operator)
			stores the new value back into the original collection */
        arrayToList.replaceAll(value -> value + ",");
        assertArrayEquals(arrayToList.toArray(), new String[]{"German,", "English,", "French,"});

        /* 1. map
         * The stream system returns a new collection rather than changing the original.
         */
        arrayToList = Arrays.asList("German", "English", "French");
        List<String> newValues = arrayToList.stream().map(value -> value + ",").collect(Collectors.toList());
        assertArrayEquals(arrayToList.toArray(), new String[]{"German", "English", "French"});
        assertArrayEquals(newValues.toArray(), new String[]{"German,", "English,", "French,"});

        /* 2. forEach
         * doesn't return a stream, so use it
         */
        arrayToList.stream().map(value -> value + ",").forEach(System.out::print);
    }
}