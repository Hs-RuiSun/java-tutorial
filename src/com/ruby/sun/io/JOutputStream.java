package com.ruby.sun.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JOutputStream {
	public static void main(String[] args) {
		try {
			String filepath = "/Users/ruisun/Downloads/io";
			/* 
			 * fileoutputstream
			 * write byte[] or specified in to a file
			*/
			/*FileOutputStream fos = new FileOutputStream(filepath);
			fos.write(65);
			String str = "\nthis is a string";
			byte[] b = str.getBytes();
			fos.write(b);
			fos.flush();
			fos.close();*/
			
			/*
			 * BufferedOutputStream
			 * use buffer to store data
			 */
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath));
			bos.write(65);
			String str = "\nthis is a BufferedOutputStream";
			byte[] b = str.getBytes();
			bos.write(b);
			bos.flush();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
