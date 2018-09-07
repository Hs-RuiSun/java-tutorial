package com.ruby.sun.unittest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class TestArrayList {
    @Test
    public void size() {
        //ArrayList<String> list = Mockito.mock(ArrayList.class);
        ArrayList<String> list = Mockito.spy(ArrayList.class);
        list.add("First");
        //Mockito.when(list.size()).thenReturn(2);
        Assert.assertEquals(1, list.size());
    }
}
