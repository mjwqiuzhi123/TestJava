package com.mjw.suanfa.com;

import java.util.Scanner;

public class Test5 {

	/**
	 * 三目运算符的使用
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			Scanner sc = new Scanner(System.in);
			int s = sc.nextInt();
			String flag = test(s);
			System.out.println(flag);
		}
	}

	private static String test(int s) {
		// TODO Auto-generated method stub
		return s < 60 ? "C" : s < 90 ? "B" : "A";
	}

}
