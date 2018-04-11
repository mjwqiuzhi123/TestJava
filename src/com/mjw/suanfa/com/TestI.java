package com.mjw.suanfa.com;

public class TestI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int a = 99;
		// test(a);
		// System.out.println(a + 100);// 199
		test1();

	}

	// 所得的值不会对其它地方造成影响
	public static int test(int i) {
		i += 100;
		return i;
	}

	public static void test1() {
		int i = 0;
		for (i = 0; i < 50; i++) {
			i = i++;
		}
		System.out.println(i);
	}
}
