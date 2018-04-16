package com.ruby.sun.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class JOutputStream {
	public static void main(String[] args) throws Exception {
		/*
		 * fileoutputstream write byte[] or specified in to a file
		 */
		/*
		 * FileOutputStream fos = new FileOutputStream(filepath); fos.write(65); String
		 * str = "\nthis is a string"; byte[] b = str.getBytes(); fos.write(b);
		 * fos.flush(); fos.close();
		 */

		/*
		 * BufferedOutputStream use buffer to store data
		 */
		/*
		 * BufferedOutputStream bos = new BufferedOutputStream(new
		 * FileOutputStream(filepath)); bos.write(65); String str =
		 * "\nthis is a BufferedOutputStream"; byte[] b = str.getBytes(); bos.write(b);
		 * bos.flush(); bos.close();
		 */
		
		File file = new File("C:\\Users\\ruby.sun\\Downloads\\io.txt");
		
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		compress(data);
	}
	
	public static byte[] compress(byte[] data) throws IOException {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		deflater.finish();
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer); // returns the generated //
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();
		System.out.println("Original: " + data.length / 1024 + " Kb");
		System.out.println("Compressed: " + output.length / 1024 + " Kb");
		return output;
	}
}
