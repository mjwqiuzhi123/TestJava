package com.mjw.gc.test;
/**
 * �������м������(run configurations)
 * @author admin
 *
 */
class HelloApp {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}