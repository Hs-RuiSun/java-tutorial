package com.ruby.sun.jclass;

import java.nio.ByteBuffer;

public class JPrimitiveType {
	public static void main(String[] args) {
		//1. byte int
		/*int intValue = 0x46520001;
		ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(intValue);
        byte[] array = buffer.array();
        for(byte b : array) {
        	System.out.print(b + ",");
        }
        System.out.println(ByteBuffer.wrap(array).getInt());*/
        
        //2. byte string
        String str = "16byChal";
        ByteBuffer buffer = ByteBuffer.allocate(16);
        for (char car : str.toCharArray()) {
            buffer.putChar(car);
        }
        byte[] array = buffer.array();
        for(byte b : array) {
        	System.out.print(b + ",");
        }
		
		//3. byte long
		/*int FEED_VERSION = 0x46520001;
		ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(FEED_VERSION);
		byte[] bytes = buffer.array();
		buffer = ByteBuffer.allocate(4);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();// need flip
        long i = buffer.getLong();
        System.out.println(i);*/
	}
}
