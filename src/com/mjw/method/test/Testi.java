package com.mjw.method.test;

public class Testi {
	
	// i++ �� ++i ������
	public static void main(String args[]) {
		int i = 1;
		int a = 0;
		int b = 0;
		int m = 1;
		int n = 1;
		//�ȸ�ֵ�������
		a = i++;
		System.out.println(i);
		//�ȼ��㣬��ֵ
		b = ++i;
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(m++);
		System.out.println(++n);
	}
}
