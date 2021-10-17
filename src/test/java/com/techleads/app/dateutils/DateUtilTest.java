package com.techleads.app.dateutils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.techleads.app.service.DateUtils;	

public class DateUtilTest {
	@Test
	public void normalLeapYear() {
		assertTrue(DateUtils.isLeapYear(1992));
	}
	
	@Test
	public void normalLeapYearEg1() {
		assertTrue(DateUtils.isLeapYear(1996));
	}
	
	@Test
	public void normalLeapYearEg2() {
		assertFalse(DateUtils.isLeapYear(1991));
	}
	
	@Test
	public void centuryYearsAreNotLeap() {
		assertFalse(DateUtils.isLeapYear(1900));
	}
	
	@Test
	public void year200wasLeap() {
		assertTrue(DateUtils.isLeapYear(2000));
	}

}
