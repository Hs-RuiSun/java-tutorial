package com.ruby.sun.datastructure.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Sort {
	@Test
	public void test() {
		assertArrayEquals(new int[] {5, 7, 9, 10, 15}, insertionSort(new int[] {9, 7, 15, 5, 10}));
		assertArrayEquals(new int[] {5, 5, 7}, insertionSort(new int[] {5, 7, 5}));
	}
	
	public int[] quickSort(int[] nums) {
		return nums;
	}
	
	public int[] insertionSort(int[] nums) {
		int j;
		for(int i=1; i< nums.length; i++) {
			j = i;
			while(j>0 && nums[j] < nums[j-1]) {
				int temp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = temp;
				j = j - 1;
			}
		}
		return nums;
	}
	
	public void selectionSort(int[] nums) {
		for(int i=nums.length-1; i>=0; i--) {
			int cur = 0;
			for(int j=1; j<=i; j++) {
				if(nums[cur] < nums[j]) {
					cur = j;
				}
			}
			if(cur != i) {
				int temp = nums[i];
				nums[i] = nums[cur];
				nums[cur] = temp;
			}
		}
	}
	
}
