package com.mjw.other.test;

public class TestInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testInt();
	}

	public static void testInt(){
		int i = 999;
		Integer j = 999;
		Integer m = new Integer(999);
		System.out.println(i == m);
		System.out.println(j == m);
		System.out.println(i == j);
	}
	
	public static void testString(){
		String a = "a";
		String b = new String("a");
		System.out.println(a == b.intern());
	}
}
