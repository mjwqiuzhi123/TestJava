/**
 * 兔子问题
 * 兔子的规律为数列1,1,2,3,5,8,13,21....(数字代表兔子的对数) 
 */
package com.mjw.suanfa.com;

public class Practise1 {

	static int MONTH = 6; // 第几个月
	static int TYPE = 1; // 一对生几对

	private int getCount(int month, int type) {
		int sum = 0;
		if (month == 1 || month == 2) {
			sum = 1;
		} else {
			sum = getCount(month - 1, 1) + getCount(month - 2, 1) * type;
		}
		if (month == MONTH) {
			System.out.println("month=" + month + " sum=" + sum);
		}
		return sum;
	}

	public static void main(String[] args) {

		(new Practise1()).getCount(MONTH, TYPE);

	}

}