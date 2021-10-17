package com.techleads.app.service;

public class DateUtils {

	public static boolean isLeapYear(int year) {
		return isDivisibleBy(year, 4) && (!isDivisibleBy(year, 100) || isDivisibleBy(year, 400));
//		return year % 4 == 0 && year % 100 != 0 || year % 400 ==0;
	}
	
	private static boolean isDivisibleBy(int year, int divisor) {
		return year % divisor == 0;
	}

}
