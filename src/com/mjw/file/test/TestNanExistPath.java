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
		//���ܸ�·���Ƿ���ڣ�new file(path)֮�󶼴�����file��
		System.out.println(file.getAbsolutePath());
		//�����ʾ�ĳ���·���������Ǵ��ڵģ��򷵻�true
		boolean flag = file.exists();
		System.out.println(flag);
	}
}
