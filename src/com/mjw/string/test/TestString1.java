package com.mjw.string.test;

public class TestString1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	//测试如何比较两个字符串
	public static void test(){
		String a = "ac";
		String b = "ac";
		//1 找出短字符串的length
		//2依次比较两个字符串对应位置的字符，如果不相等，返回差值，如果都相等，返回两个字符串的长度差
		System.out.println(a.compareTo(b));
	}
	
	public static void test1(){
		System.out.println(String.valueOf(null)); 
	}
}
