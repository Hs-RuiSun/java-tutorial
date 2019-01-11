package com.ruby.sun.collection;


import org.apache.commons.lang3.ArrayUtils;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
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

}