package com.ruby.sun.io;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

public class JIO {
    @Test
    public void testReadBytesFromInputStream() {
        InputStream in = new ByteArrayInputStream("input stream data".getBytes());
        byte[] bytes = new byte[10];
        try {
            //End of file is detected before b length bytes data is read, EOFException is thrown
            new DataInputStream(in).readFully(bytes);
            new DataInputStream(in).read(bytes);
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFile() throws IOException {
        //read file into byte array
        File file = new File("file/data.txt");
        byte[] bytes = Files.readAllBytes(file.toPath());
        //convert byte array to string, should explicitly state the character encoding
        System.out.println(new String(bytes, "UTF-8"));  //read data
        System.out.println(Arrays.toString(bytes));  //[114, 101, 97, 100, 32, 100, 97, 116, 97]
    }

}
