package com.ruby.sun.jclass;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JCollection {
    public void testArrayCopy() {
        byte[] src = new byte[100];
        byte[] des = new byte[100];
        System.arraycopy(des, 0, src, 0, src.length);
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