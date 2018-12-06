package com.ruby.sun.unittest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class URLRead {
    public static void main(String[] args) throws IOException {
        String file = "c:\\Users\\ruby.sun\\Downloads\\fr24-data.txt";
        byte[] bytes = Files.readAllBytes(Paths.get(file));
        System.out.println(Arrays.toString(bytes));
    }

    public byte[] readImage(String imageHref) {
        try {
            URL url = new URL(imageHref);
            InputStream inputStream = url.openStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int numRead;
            while ((numRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, numRead);
            }
            outputStream.close();
            inputStream.close();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
