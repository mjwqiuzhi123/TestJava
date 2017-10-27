package com.mjw.suanfa.com;

import java.util.Scanner;

public class FifthCondition {
	// public static final int S1 = 90;
	// public static final int S2 = 60;
	static int grade;

	public static void main(String[] args) {
		while (true) {
			Scanner str = new Scanner(System.in);
			int s = str.nextInt();
			FifthCondition fc = new FifthCondition();
			grade = fc.compare(s);
			if (grade == 1) {
				System.out.print('A');
			} else if (grade == 2) {
				System.out.print('B');
			} else {
				System.out.println('C');
			}
		}
	}

	public int compare(int s) {
		return s > 90 ? 1 : s > 60 ? 2 : 3;
	}
}