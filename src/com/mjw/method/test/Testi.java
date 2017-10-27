package com.mjw.method.test;

public class Testi {
	
	// i++ 与 ++i 的区别
	public static void main(String args[]) {
		int i = 1;
		int a = 0;
		int b = 0;
		int m = 1;
		int n = 1;
		//先赋值，后计算
		a = i++;
		System.out.println(i);
		//先计算，后赋值
		b = ++i;
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(m++);
		System.out.println(++n);
	}
}
