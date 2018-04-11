package com.mjw.gc.test;
/**
 * 在配置中加入参数(run configurations)
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