package com.ruby.sun.datastructure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MaxProfit {
    @Test
    public void test(){
//    	assertEquals(7, maxSubArray(new int[] {-2,1,-3,-1,5,-1,2,1,-5,4}));
//    	assertEquals(5, maxProfit(new int[] {7,1,5,3,6,4}));
//    	assertEquals(0, maxProfit(new int[] {7,6,4,3,1}));
//    	assertEquals(3, maxProfit(new int[] {7,2,5,1,3,2}));
    	assertEquals(7, maxProfitII(new int[]{7,1,5,3,6,4}));
    	assertEquals(0, maxProfitII(new int[]{7,6,4,3,1}));
    	assertEquals(4, maxProfitII(new int[]{1,2,3,4,5}));
    }
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfitII(int[] prices) {
        return 0;
    }
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
    	if(prices==null || prices.length==0 || prices.length == 1) return 0;
        int max = 0;
        int buy = Integer.MAX_VALUE;
        int i = 0;
        while(i < prices.length) {
        	if(prices[i] < buy) {
        		buy = prices[i];
        	} else {
        		max = Math.max(max, prices[i] - buy);
        	}
        	i++;
        }
        return max;
    }
}
