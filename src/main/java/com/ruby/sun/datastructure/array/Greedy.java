package com.ruby.sun.datastructure.array;

import org.junit.jupiter.api.*;

public class Greedy {
    @Test
    public void test(){
        getMaxSubArraySum(new int[]{5, 7, -13, 2, 9, 6, 16, -14, 10, 12});
    }

    //https://leetcode.com/problems/maximum-subarray/
    public int getMaxSubArraySum(int[] array){
        int currentMax = Integer.MIN_VALUE;
        int totalMax =  Integer.MIN_VALUE;

        for(int arr : array){
            currentMax = Math.max(currentMax, 0) + arr;
            totalMax = Math.max(totalMax, currentMax);
        }
        return totalMax;
    }

    public void getMaxSubArray(int[] array){
        int currentMax = 0;
        int totalMax = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int tempIndex = 0;

        for(int i = 0; i < array.length; i++){
            currentMax += array[i];
            if(currentMax < 0){
                currentMax = 0;
                tempIndex = i + 1;
            }
            else if(totalMax < currentMax){
                totalMax = currentMax;
                startIndex = tempIndex;
                endIndex = i;

            }
        }
        System.out.println("Start index: " + startIndex + " End index: " + endIndex);
    }
}
