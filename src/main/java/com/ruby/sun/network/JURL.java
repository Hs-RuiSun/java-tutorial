package com.ruby.sun.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class JURL {
    public static void main(String[] args) throws IOException {
		/*URL
		URL url = new URL("http://google.com");
		System.out.println(url.getHost() + " " + url.getPort() + " " + url.getProtocol() 
		+ " " + url.getFile());
		URLConnection
		URLConnection urlc = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
		
		HttpURLConnection
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		for(int i=1;i<=8;i++){  
			System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));  
		}  
		huc.disconnect(); */

        /*InetAddress*/
		/*InetAddress iad = InetAddress.getByName("www.javatpoint.com");
		System.out.println(iad.getHostAddress() + " " + iad.getHostName()
				+ " " + iad.getLocalHost());*/
    }


}
