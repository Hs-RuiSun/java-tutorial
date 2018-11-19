package com.ruby.sun.jclass;

import org.junit.Test;

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
}
