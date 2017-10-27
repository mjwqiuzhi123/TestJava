package com.mjw.calendar.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void addGet(){
		Calendar c = Calendar.getInstance();
		c.set(2016, 1, 30);
		System.out.println(c.getTime());
//		c.set(c.DATE, 1);
//		System.out.println(c.getTime());
		//c.set(c.MONTH, 0);
		System.out.println(c.get(c.MONTH));
		System.out.println(c.getTime());
		
//		int mon = c.get(c.MONTH) + 1;
//		System.out.println(mon + "yue");
		
	}
	
	public static void test(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH mmssSSS");
		Calendar calendar = Calendar.getInstance();
		String time = sdf.format(calendar.getTime());
		System.out.println(time);
	}

}
