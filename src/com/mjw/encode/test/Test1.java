package com.mjw.encode.test;

import java.io.UnsupportedEncodingException;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	//字符如何编码，就怎么解码，编码解码格式需一致
	public static void test() {
		try {
			String name = "马甲";
			byte[] bName = name.getBytes("utf-8");//编码
			String newName = new String(bName, "utf-8");//解码
			System.out.println(newName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
