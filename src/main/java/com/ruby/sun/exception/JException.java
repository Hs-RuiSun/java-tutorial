package com.ruby.sun.exception;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Scanner;

public class JException {
    /**
     * A try-with-resources block can still have the catch and finally blocks
     * which will work in the same way as with a traditional try block.
     */
    @Test
    public void testTryWithResource() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        //equivalent to
        try(Scanner scanner2 = new Scanner(new File(""))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTryWithMultipleResource(){
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
