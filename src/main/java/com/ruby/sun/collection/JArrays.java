package com.ruby.sun.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class JArrays {
    @Test
    public void copy(){
        int[] nums = new int[]{1,2,3,4};
        assertArrayEquals(nums, Arrays.copyOf(nums, nums.length));
        assertArrayEquals(nums, nums.clone());
    }
}
