package com.ruby.sun.leetcode;

import org.junit.jupiter.api.*;

public class DynamicProgramming {
    @Test
    public void test(){
//        assertEquals(24, uglyNumber(15));
    }
  
    //https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for(int num : nums) {
        	cur = Math.max(cur, 0) + num;
        	max = Math.max(cur, max);
        }
        return max;
    }

    private int uglyNumber(int n){
        int i=0, j=0, k=0;
        int[] uglyNums = new int[n];
        int index = 0;
        uglyNums[index] = 1;
        while (index < n - 1) {
        	int minNum2 = 2 * uglyNums[i];
        	int minNum3 = 3 * uglyNums[j];
        	int minNum5 = 5 * uglyNums[k];
        	int min = Math.min(minNum2, Math.min(minNum3, minNum5));
        	if(min == minNum2) i++;
        	if(min == minNum3) j++;
        	if(min == minNum5) k++;
            uglyNums[++index] = min;
        }
        return uglyNums[index];
    }
}
