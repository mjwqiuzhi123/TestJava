package com.mjw.MOTO.test;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(0x10 + 010 + 10);
		int p = 0;
		test1(p);
	}
	
	public static void test1(int x){
		if(x > 0)
			System.out.println("first");
		else if(x > -3)
			System.out.println("second");
		else
			System.out.println("third");
	}
}
