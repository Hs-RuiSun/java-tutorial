package com.ruby.sun.leetcode.array;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.*;

public class Array {
	@Test
	public void test() {
		// assertEquals(0, arrayPairSum(new int[] {}));
		// assertEquals(4, arrayPairSum(new int[] {1, 4, 3, 2}));
		// assertEquals(7, arrayPairSum(new int[] {7}));
		// assertEquals(6, arrayPairSum(new int[] {4, 4, 3, 2}));
		// assertEquals(18, arrayPairSum(new int[] {1, 4, 6, 10, 7, 8, 3, 2}));
		// assertArrayEquals(new int[]{2, 13, 3, 11, 5, 17, 7}, increasingOrderCards(new
		// int[]{17, 13, 11, 2, 3, 5, 7}));
		// assertArrayEquals(new int[]{2, 4, 6, 7, 1, 3}, sortArrayByParity(new int[]{3,
		// 1, 2, 4, 7, 6}));
		// assertEquals(0, fib(0));
		// assertEquals(1, fib(1));
		// assertEquals(1, fib(2));
		// assertEquals(2, fib(3));
		// assertEquals(55, fib(10));
//		assertArrayEquals(new int[] { 8, 6, 2, 4 }, sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
//				new int[][] { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } }));
//		assertArrayEquals(new int[] { 2 }, sumEvenAfterQueries(new int[] { 1 },
//				new int[][] { { 1, 0 }}));
//		assertArrayEquals(new int[] { 0 }, sumEvenAfterQueries(new int[] { 2 },
//				new int[][] { { 1, 0 }}));
//		assertArrayEquals(new int[] {-1,3,-1}, nextGreaterElement(new int[] { 4,1,2}, new int[]{1,3,4,2}));
//		assertArrayEquals(new int[] {-1}, nextGreaterElement(new int[] {2}, new int[]{2}));
//		assertArrayEquals(new int[] {2,3,3,-1}, nextGreaterElement(new int[] {1,2,1,3}));
		assertArrayEquals(new int[]{0,1}, twoSum(new int[]{2,7,11,15},9));
		assertArrayEquals(new int[]{1,2}, twoSum(new int[]{3,2,4},6));
		assertArrayEquals(new int[]{0,1}, twoSum(new int[]{3,3},6));
	}

	//https://leetcode.com/problems/trapping-rain-water/
	public int trap(int[] height) {
		if (height.length < 3) return 0;
		int output = 0;
		for(int i=1; i<height.length-1; i++){
			if(height[i-1] > 0){
				while (i < height.length && height[i]==0){
					i++;
				}
				if(i == height.length) return output;

			}
		}
		return output;
	}

	//https://leetcode.com/problems/two-sum/
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(target-nums[i])){
				return new int[]{map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
	public static int[] nextGreaterElement(int[] nums) {
		int[] output = new int[nums.length];
		Arrays.fill(output, -1);
		for(int i=0; i<nums.length; i++) {
			int j = i+1;
			while(j<nums.length && nums[j]<=nums[i]) {
				j++;
			}
			if(j < nums.length) {
				output[i] = nums[j];
			} else {
				j = 0;
				while(j<i && nums[j]<=nums[i]) {
					j++;
				}
				if(j < i) {
					output[i] = nums[j];
				}
			}
			
		}
		return output;
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        Arrays.fill(output, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++) {
        	int j = i + 1;
        	while(j < nums2.length && nums2[j] < nums2[i]) {
        		j++;
        	}
        	if(j < nums2.length) {
        		map.put(nums2[i], nums2[j]);
        	}
        }
        for(int i=0;i<nums1.length;i++) {
        	if(map.containsKey(nums1[i])) {
        		output[i] = map.get(nums1[i]);
        	}
        }
        return output;
    }

	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
       int[] output = new int[A.length];
       int sum = 0;
       for(int i=0;i<A.length;i++) {
    	   if(A[i] % 2 == 0) {
    		   sum += A[i];
    	   }
       }
       for(int i=0;i<A.length;i++) {
    	   if(A[queries[i][1]]%2 == 0) {
    		   if(queries[i][0]%2 == 0) {
    			   sum += queries[i][0];
    		   } else {
    			   sum -= A[queries[i][1]];
    		   }
    	   } else if (queries[i][0]%2 != 0) {
    			sum += A[queries[i][1]] + queries[i][0];
    	   }
    	   A[queries[i][1]] += queries[i][0];
    	   output[i] = sum;
       }
       return output;
    }

	public int fib(int N) {
		if (N == 0) {
			return 0;
		}
		if (N == 1) {
			return 1;
		}
		int index = 2;
		int a = 0;
		int b = 1;
		while (index <= N) {
			int temp = b;
			b = a + b;
			a = temp;
			index++;
		}
		return b;
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
