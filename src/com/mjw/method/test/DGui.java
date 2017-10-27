/*
 * 
 * 
 * µİ¹éËã·¨
 */
package com.mjw.method.test;

public class DGui {
	private static int sum = 0;
	private static int i = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sum();
		System.out.println(sum);
	}

	public static void sum() {
		sum += i;
		i++;
		if (i <= 100) {
			sum();
		}
	}

}
