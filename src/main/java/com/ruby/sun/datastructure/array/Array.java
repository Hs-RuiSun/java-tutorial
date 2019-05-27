package com.ruby.sun.datastructure.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Array {
    @Test
    public void test() {
//		assertEquals(0, arrayPairSum(new int[] {}));
//		assertEquals(4, arrayPairSum(new int[] {1, 4, 3, 2}));
//		assertEquals(7, arrayPairSum(new int[] {7}));
//		assertEquals(6, arrayPairSum(new int[] {4, 4, 3, 2}));
//		assertEquals(18, arrayPairSum(new int[] {1, 4, 6, 10, 7, 8, 3, 2}));
//      assertArrayEquals(new int[]{2, 13, 3, 11, 5, 17, 7}, increasingOrderCards(new int[]{17, 13, 11, 2, 3, 5, 7}));
        assertArrayEquals(new int[]{2, 4, 6, 7, 1, 3}, sortArrayByParity(new int[]{3, 1, 2, 4, 7, 6}));
    }

    public int fib(int N) {
        int[] output = new int[N];
        return output[N - 1];
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] output = new int[nums.length];
        int j = 0;
        int k = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                output[j++] = nums[i];
            } else {
                output[k--] = nums[i];
            }
        }
        return output;
    }

    public int[] increasingOrderCards(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(output, -1);
        boolean skip = false;
        int j = 0;
        int i = 0;
        while (i < nums.length) {
            if (output[j] == -1) {
                if (!skip) {
                    output[j] = nums[i];
                    i++;
                    skip = true;
                } else {
                    skip = false;
                }
            }
            j++;
            if (j == nums.length) {
                j = 0;
            }
        }
        System.out.println(Arrays.toString(output));
        return output;
    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i = +2) {
            sum += nums[i];
        }
        return sum;
    }
}
