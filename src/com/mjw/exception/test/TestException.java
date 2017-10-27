package com.mjw.exception.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		boolean temp = true;
		//当发生异常时，异常值并没有从输入管道中取走，所以下次循环时会继续发生异常，在异常中把值取走问题得到解决
		Scanner sc = new Scanner(System.in);
		while (temp) {
			System.out.println("输入整数a和b");
			try {
				a = sc.nextInt();
				b = sc.nextInt();
				System.out.println("a = " + a + "b = " + b);
				c = a + b;
				System.out.println("结果c=" + c);
			} catch (InputMismatchException ix) {
				String str = sc.next();
				System.out.println("输入错误内容：" + str + ",请输入整数");
			}
		}

	}

}
