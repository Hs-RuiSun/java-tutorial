package com.ruby.sun.leetcode;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class HashTable {
    @Test
    public void test(){
//        assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
//        assertEquals(0, numJewelsInStones("z", "ZZZZ"));
        assertEquals(1, singleNumber(new int[]{2,2,1}));
        assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));
    }
    //https://leetcode.com/problems/single-number/
    //A ⊕ A = 0 and B ⊕ 0 = B -> A ⊕ A ⊕ B = B
    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    //https://leetcode.com/problems/jewels-and-stones/
    public int numJewelsInStones(String J, String S) {
        if(J==null || S==null || J.length()==0 || S.length()==0) return 0;
        Map<Character,Integer> jewels = new HashMap<>();
        for(char jewel : J.toCharArray()){
            jewels.put(jewel, 0);
        }
        for(char stone : S.toCharArray()){
            if(jewels.containsKey(stone)){
                jewels.put(stone, jewels.get(stone)+1);
            }
        }
        int output = 0;
        for (int i : jewels.values()){
            output += i;
        }
        return output;
    }
}
