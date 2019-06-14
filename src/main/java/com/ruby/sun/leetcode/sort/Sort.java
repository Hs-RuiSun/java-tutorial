package com.ruby.sun.leetcode.sort;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Sort {
    @Test
    public void test() {
        int[] array = new int[]{9, 7, 15, 5, 10};
        quickSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{5, 7, 9, 10, 15}, array);
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);

            merge(nums, l, m, r);
        }
    }
    private void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(nums, l, left, 0, n1);
        System.arraycopy(nums, m+1, right, 0, n2);

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    public int[] insertionSort(int[] nums) {
        int j;
        for (int i = 1; i < nums.length; i++) {
            j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j = j - 1;
            }
        }
        return nums;
    }

    public void selectionSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = 0;
            for (int j = 1; j <= i; j++) {
                if (nums[cur] < nums[j]) {
                    cur = j;
                }
            }
            if (cur != i) {
                int temp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = temp;
            }
        }
    }

}
