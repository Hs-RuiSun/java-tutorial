package com.ruby.sun.jclass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JDate {
	public static void main(String[] args) {
		long time = 1524059124;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date(time*1000)));
	}
}
