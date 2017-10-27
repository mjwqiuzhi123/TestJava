package com.mjw.other.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testDate();
		M m = new M();
	}

	// 用Calendar得到Date以及Date与字符串之间的转换！
	public static void testDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar ca = Calendar.getInstance();
		Date dt = ca.getTime();
		String dtStr = sdf.format(dt);
		Date dt1 = null;
		try {
			dt1 = sdf.parse(dtStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(dt);
		System.out.println(dtStr);
		System.out.println(dt1);
		// System.out.println(new DecimalFormat("0").format(1.11));
	}

}
