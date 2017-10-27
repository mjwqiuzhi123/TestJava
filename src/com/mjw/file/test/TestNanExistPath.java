package com.mjw.file.test;

import java.io.File;

public class TestNanExistPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test(){
		String fPath = "H:\\test";
		File file = new File(fPath);
		//不管该路径是否存在，new file(path)之后都存在于file中
		System.out.println(file.getAbsolutePath());
		//如果表示的抽象路径名是真是存在的，则返回true
		boolean flag = file.exists();
		System.out.println(flag);
	}
}
