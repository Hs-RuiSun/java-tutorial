package com.ruby.sun.oca;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter5 {
    @Test
    public void compare(){
        String s = "String";
        String t = new String(s);
        assertNotSame(s, t);
        assertEquals(s, t);
        assertSame(s, t.intern());
        assertNotSame("String", t);
        assertSame("String", s);
        assertEquals("String", s);
        assertNotSame("String".intern(), t);

        String s2 = "String";
        assertSame(s, s2);
        assertEquals(s, s2);
        StringBuilder sb = new StringBuilder("String");
        if(s.equals(sb)){ fail();}
        //if(s == sb) { fail(); } operator == couldn't be applied between String and StringBuilder

        String t2 = new String("String");
        assertEquals(t, t2);

        StringBuilder sb2 = new StringBuilder("String");
        assertNotEquals(sb, sb2); //StringBuilder doesn't implement equals() so it will check reference equality

        int[] numbers1 = {1, 2, 3};
        int[] numbers2 = {1, 2, 3};
        assertNotEquals(numbers1, numbers2); //array doesn't implement equals() so it will check reference equality

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        assertEquals(list1, list2); //whether they contain the same elements in the same orders

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        assertEquals(set1, set2); //same as List above

        String s3 = "";
        s3 += 2;
        s3 += 'c';
        s3 += false;
        assertEquals(s3, "2cfalse");
        assertNotSame(s3, "2cfalse");
        assertSame(s3.intern(), "2cfalse");
    }

    @Test
    public void stringMethods(){
        // include the start index but not the end index
        StringBuilder sb = new StringBuilder("123456");
        assertEquals(sb.replace(2, 4, "6").toString(), "12656");
        String string = "123456";
        assertEquals(string.substring(2, 4), "34");
        assertEquals(string.substring(2, 2), "");
    }

    @Test
    public void arraysCompare(){
        String[] s1 = {"name"};
        String[] s2 = {"name", null};
        String[] s3 = {"Name"};
        //assertEquals(32, Arrays.compare(s1, s3)); //return back the character difference

        //assertEquals(-1, Arrays.compare(s1, s2));
        String[] s4 = {"name", null, null,null};
        //assertEquals(-3, Arrays.compare(s1, s4));// return the length difference

//        assertEquals(1, Arrays.mismatch(s1, s2));
//        assertEquals(0, Arrays.compare(s2, s2));
//        assertEquals(-1, Arrays.mismatch(s2, s2));

        int[] array1 ={6, 7, 8, 11, 18, 8, 2, 5};
        int[] array2 ={3, 5, 9, 13, 28, 6, 8, 9};
        int[] array3 ={3, 5, 9, 13};
        int[] array4 ={6, 7, 8, 11};
        //compare both integer array using compare method and finally print result
//        assertEquals(1, Arrays.compare(array1,array2));
//        assertEquals(1, Arrays.compare(array1,array3));
//        assertEquals(4, Arrays.compare(array1,array4));

    }
    @Test
    public void reviewQuestions(){
        /*
        * long Math.round(double d)
        * int Math.round(float f)
        * */

        List<Integer> l = Arrays.asList(1,2, 3);
        l.set(1, 9);

        //int[][] java = new int[][]; initialization expected
        Object[][][] objects = new Object[3][0][5]; //compile
        assertEquals(3, objects.length);
        assertEquals(0, objects[0].length);

        //StringBuilder stringBuilder = "value"; couldn't assign a String to a StringBuilder

        List list = new ArrayList<String >();
        list.add("value");
        for(Object s : list){} // the data type of s is Object

        //print out StringBuilder
        StringBuilder sb = new StringBuilder("ab");
        sb.append("cd");
        System.out.println(sb);
        System.out.println(sb + " " + "ef");
    }
    @Test
    public void test(){
        //convert list with array
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        Object[] objects = strings.toArray();
        String[] stringArray = strings.toArray(new String[0]);
        //autoboxing
        List list = new ArrayList<>();
        list.add("string");
        list.add(true);
        System.out.println(list.toString());

        //string sorting
        String[] values = {"10", "9", "100"};
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));//10, 100, 9

        //print array values
        int[] value = {2,3,4,4};
        System.out.println(Arrays.toString(value));

        //length doesn't consider what's in the array
        String[] names = new String[5];
        System.out.println(names.length);
        System.out.println(names[2]);

        String [] ss = {"name"};
        Object[] os = ss;
        //objects[0] = new StringBuilder(); //could compile but throw ArrayStoreException at runtime

        int ids[], type;
        int[] idss, typee; // two variables of type int[]
        String[] s1 = {"a", "b"};
        String[] s2 = s1;
        System.out.println(Arrays.equals(s1, s2));
        System.out.println(s1 == s2);

        String name = "abcd";
        //System.out.println(name.substring(1,100)); --StringIndexOutOfBoundsException
        StringBuilder stringBuilder = new StringBuilder("abcd");
        assertEquals("a", stringBuilder.delete(1,100).toString()); //StringBuilder is more flexible
        //StringBuilder insert
        StringBuilder sb = new StringBuilder("abcdef");
        //sb.insert(8, "wrong"); --StringIndexOutOfBoundsException
        //System.out.println(sb.toString()); --StringIndexOutOfBoundsException
    }
}
