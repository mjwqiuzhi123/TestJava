/*
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
1 6 15 20 15 6 1 
1 7 21 35 35 21 7 1 
Ñî»ÔÈý½Ç
 */
package com.mjw.method.test;

import java.util.Scanner;

public class TestTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		test(row);
	}

	public static void test(int row) {
		int arr[][] = new int[row][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0 || j == arr[i].length - 1)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
