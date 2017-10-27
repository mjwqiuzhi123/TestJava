package com.mjw.path.test;

import java.io.File;
import java.io.IOException;

public class TestPath {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		testPath();
	}
	
	public static void testPath() throws IOException{
		String path = new File("").getAbsolutePath();// ���ش˳���·�����ľ���·�����ַ�����
		String path1 = new File("/").getAbsolutePath();
		String path2 = new File("").getCanonicalPath();// ���ش˳���·�����Ĺ淶·�����ַ�����
		String path3 = new File("/hello").getPath();// ���˳���·����ת��Ϊһ��·�����ַ�����
		String path4 = new File(".").getCanonicalPath();
		String userDir = System.getProperty("user.dir");
		System.out.println(path);
		System.out.println(path1);
		System.out.println(path2);
		System.err.println(path3);
		System.out.println("path4:" + path4);
		System.out.println("userDir:" + userDir);
	}

}
