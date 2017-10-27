package com.mjw.other.test;

public class T {
	final static int m = 2;
	final static int n = 3;

	public static void main(String[] args) {

		// final int M = 100;
		// final int N = 4;
		// final int[] array = new int[M];
		//
		// for (int b = 0; b < M; b++)
		// array[b] = b;
		//
		// for (int i = 0; i < N; i++) {
		// final int p = i;
		// new Thread(new Runnable() {
		// public void run() {
		// for (int a = p * (M / N); a < (p + 1) * (M / N); a++)
		// System.out.println("Thread " + p + ":" + array[a]);
		// // i -> cannot refer to a non-final variable inside an inner
		// // class defined in a different method
		// }
		// }).start();
		// }.
		test();
	}

	public static void test() {

		System.out.println(Thread.currentThread().getName());

		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j = 0;j < 4;j++){
						System.out.println(Thread.currentThread().getName() + "-" + j);
					}
				}

			}).start();
		}
		
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void test1(){}
}

class M{
	public static int m;
}
