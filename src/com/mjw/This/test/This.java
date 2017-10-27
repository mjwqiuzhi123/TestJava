/**
 * Î´Íê³É
 */
package com.mjw.This.test;

public class This {
	
	private int a;
	
//	public This(){
//		this.a = 0;
//	}
//	
	public This(int a){
		this.a = a;
	}
	
	public static void main(String[] args) {
		This t = new This(2);
		System.out.println(t.a);
	}
}
