package com.ruby.sun.leetcode;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class HashTable {
    @Test
    public void test(){
//        assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
//        assertEquals(0, numJewelsInStones("z", "ZZZZ"));
        assertEquals(1, singleNumber(new int[]{2,2,1}));
        assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));
    }

    //https://leetcode.com/problems/subdomain-visit-count/
    private Map<String, Integer> map;
    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>(cpdomains.length);
        for (String cpdomain : cpdomains){
            int indexOfSpace = cpdomain.indexOf(' ');
            int num = Integer.parseInt(cpdomain.substring(0, indexOfSpace));
            String domains = cpdomain.substring(indexOfSpace + 1);
            addToMap(domains, num);
            int indexOfPeriod;
            while ((indexOfPeriod = domains.indexOf('.')) > -1){
                domains = domains.substring(indexOfPeriod+1);
                addToMap(domains, num);
            }
        }
        List<String> list = new ArrayList<>(map.size());
        for (String domain : map.keySet()) {
            list.add(map.get(domain).toString() + " " + domain);
        }
        return list;
    }
    private void addToMap(String key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value + map.get(key));
        } else {
            map.put(key, value);
        }
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
