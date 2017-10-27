package com.mjw.encoding.test;

import java.io.UnsupportedEncodingException;

public class Test1 {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() throws UnsupportedEncodingException{
		String chName = "Âí¿¡Î°";
		String EnName = "D";
		byte[] ch = chName.getBytes("unicode");
		byte[] en = EnName.getBytes("utf-8");
		System.out.println(ch.length);
		System.out.println(en.length);
	}
	
}
