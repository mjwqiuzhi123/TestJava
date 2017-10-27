/**
 * 判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。 
 */
package com.mjw.suanfa.com;

public class Test2 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		int count = 0;
		// 初始值设为true
		boolean flag = true;
		for (int i = 10; i <= 100; i++) {
			
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			// 当为true时，也就是除了1和本身才能除尽
			if (flag) {
				count++;
				System.out.print(i + " ");
			}
			flag = true;
		}
		System.out.println("\r\n" + count);
	}

}
