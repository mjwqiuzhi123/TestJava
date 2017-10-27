package com.mjw.other.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParseDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = parseDate("2015-10-01");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);// ��������������һ��.����������,������ǰ�ƶ�
		date = calendar.getTime(); // ���ʱ���������������һ��Ľ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date);
		System.out.println(date.getTime());
		System.out.println(str);
	}

	public static Date parseDate(String s) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date addDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);// ��������������һ��.����������,������ǰ�ƶ�
		date = calendar.getTime(); // ���ʱ���������������һ��Ľ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date);
		return date;
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(date);
		return str;
	}
	
	public static void test(){
		Object o = new Object();
		String str = new String();
	}


}
