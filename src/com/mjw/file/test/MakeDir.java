/**
 * ����ָ��·����ʾ���ļ���
 */
package com.mjw.file.test;

import java.io.File;

public class MakeDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("D:/qqqqqqqqqqqqq/q/q/q/q.txt");
		// ����ļ������ڣ�����false,�����ڣ������ļ��У�������true
		boolean flag = f.mkdirs();
		System.out.println(flag);
	}

}
