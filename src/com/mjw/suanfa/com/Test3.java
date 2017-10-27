/**
 * 水仙花数
 */
package com.mjw.suanfa.com;

public class Test3 {
	// 所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 101; i < 1000; i++)
			test3(i);
	}

	public static void test3(int num) {
		int a = num / 100;
		int b = num % 100 / 10;
		int c = num % 100 % 10;
		if (a * a * a + b * b * b + c * c * c == num)
			System.out.println(num);
	}
}
