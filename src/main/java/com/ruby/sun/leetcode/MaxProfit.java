package com.ruby.sun.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MaxProfit {
    @Test
    public void test(){
//    	assertEquals(7, maxSubArray(new int[] {-2,1,-3,-1,5,-1,2,1,-5,4}));
//    	assertEquals(5, maxProfit(new int[] {7,1,5,3,6,4}));
//    	assertEquals(0, maxProfit(new int[] {7,6,4,3,1}));
//    	assertEquals(3, maxProfit(new int[] {7,2,5,1,3,2}));
    	assertEquals(8, maxProfitII(new int[]{7,1,5,5,6,9}));
    	assertEquals(0, maxProfitII(new int[]{7,6,4,3,1}));
    	assertEquals(4, maxProfitII(new int[]{1,2,3,4,5}));
    	assertEquals(2, maxProfitII(new int[]{2,1,2,0,1}));

    }
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfitII(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int buy = -1;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(buy == -1){
                buy = prices[i];
            }
            else if(buy > prices[i]){
                buy = prices[i];
            } else if(buy<prices[i] &&
                    (i+1==prices.length || (i+1<prices.length && prices[i]>prices[i+1]))) {
                profit += prices[i] - buy;
                buy = -1;
            }
        }
        return profit;
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
