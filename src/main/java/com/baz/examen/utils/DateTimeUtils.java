package com.baz.examen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	
	public static final String PATTERN_1 = "dd-MM-yyyy HH:mm:ss";
	
	public static final String PATTERN_2 = "dd-MM-yyyy";
	
	public static String getStringFromDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date getDateFromString(String date, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(date);
	}
	
}
