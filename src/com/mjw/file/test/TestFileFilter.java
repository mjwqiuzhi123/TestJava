/**
 * FileFilter拦截指定的内容
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
				// 拦截txt文件
				if (pathname.getName().endsWith("txt"))
					return true;
				return false;
			}
		});

		for (File file : fileList) {
			System.out.println(file.getAbsolutePath());
		}
	}

	//使用lameda表达式--未完成
	public static void test2() {
	}
}
