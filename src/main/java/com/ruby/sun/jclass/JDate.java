package com.ruby.sun.jclass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JDate {
    public static void main(String[] args) throws ParseException {
        DateFormat dfLocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dfUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dfUTC.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(dfLocal.parse(dfUTC.format(new Date())));
		/*long time = 1524059124;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date(time*1000)));*/
    }
}
