/**
 * ͳ��ָ��·����ÿ���ļ����е��ļ�����
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
		//System.out.println("��ͨ�ļ���ĿΪ��" + sumFile);
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
			//����Ǹ���·���µ��ļ��У��������ʾͳ������
			if (!"".equals(name)){
				//**********************
				context.append(name + ":" + countFile + "\r\n");
				System.out.print(context.toString());
				//��stringBuffer���
				//(1)
				//context.setLength(0);
				//(2)
				context.delete(0, context.length());
				//(3)
				//context = new StringBuffer();
				//**********************.
				//ֱ��ʹ���ַ����洢�ļ���Ϣ
				//String msg = name + ":" + countFile + "\r\n";
				//System.out.print(msg);
			}
		}
	}
}
