package com.ruby.sun.io;

import java.io.File;

public class LoadResourcesFile {
    public static void main(String[] args) {
        try {
            String file = LoadResourcesFile.class.getResource("/keystore.jks").getFile();
            System.out.println(file);
            String storeLoc = System.getProperty("java.class.path");
            System.out.println(storeLoc);
            System.setProperty("javax.net.ssl.keyStore", "/C:/Users/ruby.sun/Downloads/keystore.jks");
            String trustStore = System.getProperty("javax.net.ssl.keyStore");
            System.out.println(trustStore);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
