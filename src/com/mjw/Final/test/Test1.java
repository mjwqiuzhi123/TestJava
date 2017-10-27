package com.mjw.Final.test;

public class Test1 {
	//被final修饰的成员变量，必须被初始化
	static final int n = 2;
	private final int m = 1;
	private final String str = "must be initialized!";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int num = 0;
		//num += 1;
		final String s = "";
		//s = s + "";
	}

}
