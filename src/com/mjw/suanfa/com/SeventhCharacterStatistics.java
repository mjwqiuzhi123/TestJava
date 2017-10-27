package com.mjw.suanfa.com;

import java.util.*;

public class SeventhCharacterStatistics {
	static int digital = 0;
	static int character = 0;
	static int other = 0;
	static int blank = 0;

	public static void main(String[] args) {
		char[] ch = null;
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		ch = s.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				digital++;
			} else if ((ch[i] >= 'a' && ch[i] <= 'z') || ch[i] > 'A'
					&& ch[i] <= 'Z') {
				character++;
			} else if (ch[i] == ' ') {
				blank++;
			} else {
				other++;
			}

		}

		System.out.println("���ָ���: " + digital);
		System.out.println("Ӣ����ĸ����: " + character);
		System.out.println("�ո����: " + blank);
		System.out.println("�����ַ�����:" + other);
	}

}