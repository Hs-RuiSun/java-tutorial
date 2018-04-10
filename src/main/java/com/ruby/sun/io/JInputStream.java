package com.ruby.sun.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;

public class JInputStream {
	public static void main(String[] args) {
		try {
			String filepath = "/Users/ruisun/Downloads/io";
			/*
			 * fileinputstream read data from a file
			 * reading byte-oriented data (streams of raw bytes) such as image data, audio, video etc
			 */
			FileInputStream fis = new FileInputStream(filepath);
			/*int i = fis.read();
			System.out.print((char)i);
			while((i=fis.read())!=-1) {
				System.out.print((char)i);
			}*/
			byte[] b = new byte[fis.available()];
			fis.read(b);
			for(byte bt : b)
				System.out.print((char)bt);
			fis.close();
			
			/*
			 * bufferedinputstream
			 */
			
			/*
			 * sequenceinputstream
			 * read data from multiple files
			 */
			/*FileInputStream fis1 = new FileInputStream(filepath);
			FileInputStream fis2 = new FileInputStream(filepath);
			FileInputStream fis3 = new FileInputStream(filepath);
			FileInputStream fis4 = new FileInputStream(filepath);
			Vector v = new Vector();
			v.add(fis1);
			v.add(fis2);
			v.add(fis3);
			v.add(fis4);
			SequenceInputStream sis = new SequenceInputStream(v.elements());*/
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
