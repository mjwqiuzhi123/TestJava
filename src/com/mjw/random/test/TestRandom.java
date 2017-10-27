package com.mjw.random.test;

public class TestRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++){
			int num = (int)(Math.random() * 99);
			System.out.println(num);
		}
	}

}
