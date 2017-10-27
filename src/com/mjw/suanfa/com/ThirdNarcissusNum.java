/**
 * 所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身
 */
package com.mjw.suanfa.com;

public class ThirdNarcissusNum {
	static int b, bb, bbb;

	public static void main(String[] args) {

		for (int num = 101; num < 1000; num++) {
			ThirdNarcissusNum tnn = new ThirdNarcissusNum();
			tnn.f(num);
		}
	}

	public void f(int m) {
		bbb = m / 100;
		bb = (m % 100) / 10;
		b = (m % 100) % 10;
		if ((bbb * bbb * bbb + bb * bb * bb + b * b * b) == m) {
			System.out.println(m);
		}
	}
}