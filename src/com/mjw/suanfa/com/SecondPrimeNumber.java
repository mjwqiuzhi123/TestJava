package com.mjw.suanfa.com;

public class SecondPrimeNumber {
	public static int count = 0;

	public static void main(String[] args) {
		for (int i = 101; i < 200; i++) {
			boolean b = true;// Ĭ�ϴ���������
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false; // ������������
					break;
				}
			}
			if (b) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\r\n�����ĸ�����" + count);
	}
}