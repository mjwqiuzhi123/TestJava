package com.mjw.suanfa.com;

import java.util.Scanner;

public class Test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc1.nextInt();
			int max = test(a, b);// ���Լ��
			int min = a * b / max;// ��С������
			System.out.println("���Լ��: " + max);
			System.out.println("��С������: " + min);
		}
	}

	public static int test(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (b != 0) {
			if (a == b)
				return 1;
			else {
				int k = a % b;
				a = b;
				b = k;
			}
		}
		return a;
	}
}
