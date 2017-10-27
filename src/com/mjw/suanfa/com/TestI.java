package com.mjw.suanfa.com;

public class TestI {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 99;
		test(a);
		System.out.println(a + 100);// 199

	}
	
	// 所得的值不会对其它地方造成影响
	public static int test(int i){
		i += 100;
		return i;
	}

}
