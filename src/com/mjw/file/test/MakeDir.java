/**
 * 创建指定路径表示的文件夹
 */
package com.mjw.file.test;

import java.io.File;

public class MakeDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("D:/qqqqqqqqqqqqq/q/q/q/q.txt");
		// 如果文件出存在，返回false,不存在，创建文件夹，并返回true
		boolean flag = f.mkdirs();
		System.out.println(flag);
	}

}
