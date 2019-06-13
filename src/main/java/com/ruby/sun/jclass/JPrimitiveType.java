package com.ruby.sun.jclass;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class JPrimitiveType {
    @Test
    public void testEqual(){
        Integer num1 = 3;
        Integer num2 = 3;
        assertEquals(num1, num2);
        assertSame(num1, num2);
    }
    public static void main(String[] args) {
        System.out.println(String.format("%06X", 3950690));
        System.out.println(Integer.parseInt("2C4862", 16));
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
//        String str = "16byChal";
//        ByteBuffer buffer = ByteBuffer.allocate(16);
//        for (char car : str.toCharArray()) {
//            buffer.putChar(car);
//        }
//        byte[] array = buffer.array();
//        for (byte b : array) {
//            System.out.print(b + ",");
//        }

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
