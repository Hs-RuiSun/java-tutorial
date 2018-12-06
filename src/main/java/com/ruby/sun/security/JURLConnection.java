package com.ruby.sun.security;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JURLConnection extends URLConnection {

    protected JURLConnection(URL arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void connect() throws IOException {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) throws Exception {
        JURLConnection urlConnection = new JURLConnection(new URL("www.google.com"));
        urlConnection.connect();
    }
}
