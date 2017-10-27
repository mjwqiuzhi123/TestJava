/**
 * FileFilter����ָ��������
 */
package com.mjw.file.test;

import java.io.File;
import java.io.FileFilter;

public class TestFileFilter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		File f = new File("D:\\BACKUP");
		File[] fileList = f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// ����txt�ļ�
				if (pathname.getName().endsWith("txt"))
					return true;
				return false;
			}
		});

		for (File file : fileList) {
			System.out.println(file.getAbsolutePath());
		}
	}

	//ʹ��lameda���ʽ--δ���
	public static void test2() {
	}
}
