package com.mjw.suanfa.com;

import java.util.Scanner;

public class Test4 {

	/**
	 * ��Ŀ����һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5�� 
		�����������n���зֽ���������Ӧ���ҵ�һ����С������k��Ȼ������������ɣ� 
		(1)����������ǡ����n����˵���ֽ��������Ĺ����Ѿ���������ӡ�����ɡ� 
		(2)���n>k����n�ܱ�k��������Ӧ��ӡ��k��ֵ������n����k����,��Ϊ�µ���������n,�ظ�ִ�е�һ���� 
		(3)���n���ܱ�k����������k+1��Ϊk��ֵ,�ظ�ִ�е�һ���� 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			int n, k = 2;
			Scanner s = new Scanner(System.in);
			n = s.nextInt();
			if(n < k){
				System.out.println("���������ڵ���2");
				continue;
			}
			System.out.print(n + "=");
			FourthPrimeFactor fpf = new FourthPrimeFactor();
			fpf.f(n, k);
		}
	}

	public static void test(int n, int k) {
		while (k <= n) {
			if (n <= k) {
				System.out.print(k);
				break;
			} else if (n > k && n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
				test(n, k);
				break;
			} else if(n > k && n % k != 0) {
				k++;
				test(n, k);
				break;
			}
		}
	}

}
