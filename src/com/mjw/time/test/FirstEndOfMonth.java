/**
 * ��ȡĳ�µĵ�һ������һ�죡
 */
package com.mjw.time.test;

import java.text.SimpleDateFormat;

import java.util.Calendar;

public class FirstEndOfMonth {

	/**
	 * �õ�ĳ��ĳ�µĵ�һ��
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public String getFirstDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);

		cal.set(Calendar.MONTH, month - 1);

		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));

		return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
	}

	/**
	 * �õ�ĳ��ĳ�µ����һ��
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public String getLastDayOfMonth(int year, int month) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);

		cal.set(Calendar.MONTH, month - 1);

		//cal.set(Calendar.DAY_OF_MONTH, 1);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);

		return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());

	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		FirstEndOfMonth tFirstEndOfMonth = new FirstEndOfMonth();
		System.out.println(tFirstEndOfMonth.getFirstDayOfMonth(2017, 7));
		System.out.println(tFirstEndOfMonth.getLastDayOfMonth(2017, 7));

	}

}