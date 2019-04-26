package com.ruby.sun.jdk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class JDK9 {
//    /**
//     * Immutable: Elements cannot be added or removed. Calling any mutator method will always cause UnsupportedOperationException to be thrown
//     *
//     * No null Element Allowed: Attempts to create them with null elements result in NullPointerException.
//     * In the case of List and Set, no elements can be null. In the case of a Map, neither keys nor values can be null.
//     *
//     * Value-Based Instances: If we create Lists with the same values, they may or may not refer to the same object on the heap.
//     *
//     * Serialization: They are serializable if all elements are serializable.
//     *
//     * Iteration Order: The iteration order of elements is unspecified and is subject to change.
//     */
//    @Test
//    public void testImmutable(){
//        String[] array = new String[]{"a", "b", "c"};
//
//        List<String> list1 = Arrays.asList(array);
//        //list1.add("d");// UnsupportedOperationException
//        assertArrayEquals(new String[]{"a", "b", "c"}, list1.toArray());
//        array[0] = "d";
//        assertArrayEquals(new String[]{"d", "b", "c"}, list1.toArray());
//
//        List<String> ilist1 = List.of(array);
//        assertArrayEquals(new String[]{"d", "b", "c"}, ilist1.toArray());
//        array[0] = "a";
//        assertArrayEquals(new String[]{"d", "b", "c"}, ilist1.toArray());
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("a");
//        list2.add("b");
//        List<String> ilist2 = Collections.unmodifiableList(list2);
//        assertArrayEquals(new String[]{"a", "b"}, ilist2.toArray());
//        list2.add("c");
//        //ilist2.add("e"); //UnsupportedOperationException
//        assertArrayEquals(new String[]{"a", "b", "c"}, ilist2.toArray());
//    }
}
