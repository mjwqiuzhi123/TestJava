/**
 * 统计指定路径下每个文件夹中的文件数量
 */
package com.mjw.file.test;

import java.io.File;

public class FileSum {
	private static int sumFile = 0;
	private static String fileName;
	private static StringBuffer context = new StringBuffer();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("D:\\test");
		fileName = file.getName();
		getFileNums(file);
		//System.out.println("普通文件数目为：" + sumFile);
	}

	public static void getFileNums(File file) {
		@SuppressWarnings("unused")
		int countDirectory = 0;
		int countFile = 0;
		if (file.isDirectory()) {
			String name = file.getName();
			File[] files = file.listFiles();
			for (File fileIndex : files) {
				if (fileIndex.isDirectory()) {
					countDirectory++;
					getFileNums(fileIndex);
				} else {
					countFile++;
				}
			}
			//如果是给定路径下的文件夹，则输出显示统计数量
			if (!"".equals(name)){
				//**********************
				context.append(name + ":" + countFile + "\r\n");
				System.out.print(context.toString());
				//将stringBuffer清空
				//(1)
				//context.setLength(0);
				//(2)
				context.delete(0, context.length());
				//(3)
				//context = new StringBuffer();
				//**********************.
				//直接使用字符串存储文件信息
				//String msg = name + ":" + countFile + "\r\n";
				//System.out.print(msg);
			}
		}
	}
}
