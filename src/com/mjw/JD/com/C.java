package com.mjw.JD.com;

import java.util.concurrent.CountDownLatch;


public class C extends F{

	/**
	 * @param args
	 */
	private static CountDownLatch cdl = new CountDownLatch(1);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new C();
			System.out.println("再次调用new C()");
			new C();
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static {
		System.out.println("c1");
	}
	
	static {
		System.out.println("c2");
	}
}
