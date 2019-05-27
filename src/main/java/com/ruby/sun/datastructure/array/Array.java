package com.ruby.sun.datastructure.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Array {
	@Test
	public void test() {
		assertEquals(0, arrayPairSum(new int[] {}));
		assertEquals(4, arrayPairSum(new int[] {1, 4, 3, 2}));
		assertEquals(7, arrayPairSum(new int[] {7}));
		assertEquals(6, arrayPairSum(new int[] {4, 4, 3, 2}));
		assertEquals(18, arrayPairSum(new int[] {1, 4, 6, 10, 7, 8, 3, 2}));
	}
	
	public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0; i< nums.length-1; i=+2) {
        	sum += nums[i];
        }
        return sum;
    }
}
