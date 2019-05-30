package com.ruby.sun.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicProgramming {
    @Test
    public void test(){
        assertEquals(24, uglyNumber(15));
    }
    private int uglyNumber(int n){
        int i=0, j=0, k=0;
        int[] uglyNums = new int[n];
        int index = 0;
        uglyNums[index] = 1;
        while (index < n - 1) {
            if(2 * uglyNums[i] == 3 * uglyNums[j]) {
                i++;
            } else if(2 * uglyNums[i] == 5 * uglyNums[k]){
                i++;
            } else if(3 * uglyNums[j] == 5 * uglyNums[k]){
                j++;
            } else if (2 * uglyNums[i] < 3 * uglyNums[j] && 2 * uglyNums[i] < 5 * uglyNums[k]) {
                index++;
                uglyNums[index] = 2 * uglyNums[i];
                i++;
            } else if (3 * uglyNums[j] < 2 * uglyNums[i] && 3 * uglyNums[j] < 5 * uglyNums[k]){
                index++;
                uglyNums[index] = 3 * uglyNums[j];
                j++;
            } else if (5 * uglyNums[k] < 2 * uglyNums[i] && 5 * uglyNums[k] < 3 * uglyNums[j]){
                index++;
                uglyNums[index] = 5 * uglyNums[k];
                k++;
            }
        }
        return uglyNums[index];
    }
}
