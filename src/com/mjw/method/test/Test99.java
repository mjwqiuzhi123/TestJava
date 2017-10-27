/*
 * 99乘法表！
 */
package com.mjw.method.test;

public class Test99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testZS();
	}

	// 99乘法表！
	public static void test1() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
			}
			System.out.println();
		}
	}

	// 求素数(只能被1和本身整除的数称为素数)
	public static void testSS() {
		int i, n, k = 0;
		for (n = 2; n <= 100; n++) { // 3~100的所有数
			i = 2;
			while (i <= n) {
				if (n % i == 0)
					break; // 若能整除说明n不是素数，跳出循环
				i++;
			}

			if (i == n) { // 如果i==n则说明n不能被2~n-1整除，是素数
				k++; // 统计输出数的个数
				if (k % 6 == 0) // 每输出5个则换行
					System.out.println();
			}
		}
	}
	
	public static void testZS(){
		int num = 0;
		boolean b = true;
		long time = System.currentTimeMillis();
		for(int i = 2; i <= 10000; i++){
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					b = false;
					break;
				}
			}
			
			if(b == true){
				System.out.print(i + " ");
				num++;
				if(num % 5 == 0)
					System.out.println();
			}
			else
				b = true;
		}
		System.out.println(System.currentTimeMillis() - time);
	}
}
