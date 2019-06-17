package com.ruby.sun.collection;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class JMap {
    @Test
    public void testContains(){
        Map<String, String> map = new HashMap<>();
        map.put("key1", null);
        assertNull(map.get("key1"));
        assertNull(map.get("key2"));
        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key2"));
    }
    @Test
    public void testPutReturnValue(){
        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");
        String rtnVal = map.put("key1", "val2");
        assertEquals("val1", rtnVal);
        assertNull(map.put("key2", "val"));
        assertEquals("val2", map.get("key1"));
    }
    @Test
    public void testIterateMap(){
        Map<String, String> map = new HashMap<>();
        map.put("A", "AAA");
        map.forEach((k,v)->System.out.println(v));
    }
}
