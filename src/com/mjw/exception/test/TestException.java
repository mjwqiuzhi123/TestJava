package com.mjw.exception.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		boolean temp = true;
		//�������쳣ʱ���쳣ֵ��û�д�����ܵ���ȡ�ߣ������´�ѭ��ʱ����������쳣�����쳣�а�ֵȡ������õ����
		Scanner sc = new Scanner(System.in);
		while (temp) {
			System.out.println("��������a��b");
			try {
				a = sc.nextInt();
				b = sc.nextInt();
				System.out.println("a = " + a + "b = " + b);
				c = a + b;
				System.out.println("���c=" + c);
			} catch (InputMismatchException ix) {
				String str = sc.next();
				System.out.println("����������ݣ�" + str + ",����������");
			}
		}

	}

}
