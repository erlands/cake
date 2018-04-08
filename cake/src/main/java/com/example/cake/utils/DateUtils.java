package com.example.cake.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String format = "yyyy-MM-dd HH:mm:ss";
	
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
