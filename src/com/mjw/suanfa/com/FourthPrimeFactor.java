package com.mjw.suanfa.com;

import java.util.Scanner;

public class FourthPrimeFactor {
	static int n;

	public static void main(String[] args) {
		while (true) {
			int k = 2;
			Scanner s = new Scanner(System.in);
			n = s.nextInt();
			System.out.print(n + "=");
			FourthPrimeFactor fpf = new FourthPrimeFactor();
			fpf.f(n,k);
		}
	}

	public void f(int n, int k) {
		while (k <= n) {
			if (k == n) {
				System.out.println(n);
				break;
			} else if (n > k && n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
				f(n, k);
				break;
			} else if (n > k && n % k != 0) {
				k++;
				f(n, k);
				break;
			}
		}
	}

}