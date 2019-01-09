package com.ruby.sun.jclass;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class JString {
    @Test
    public void testReplace() {
        String testData = "-QU PHXTEHP\r\n" +
                "-.DDLXCXA 110226\r\n" +
                "-ARR";
        String[] fields = testData.split("-");
        // Clean fields remove line
        for (String field : fields) {
            field = field.replaceAll("(\n|\r)", "yyy");
        }
        System.out.println(Arrays.toString(fields));
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/c/Users/ruby.sun/Downloads/")));
    }
}
