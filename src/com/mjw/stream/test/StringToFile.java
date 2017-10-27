package com.mjw.stream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class StringToFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test5();
	}

	public static void test1() {
		String str = "i love china!\r\n fffff";
		File txt = new File("D:\\test\\sendlist.txt");
		if (!txt.exists()) {
			try {
				txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		byte[] bytes = new byte[512];
		bytes = str.getBytes(); // 新加的
		int b = bytes.length; // 改
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(txt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.write(bytes, 0, b);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test2() {
		File f = new File("D:\\test\\writer.txt");
		String str = "test fileOutputStream11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111!\r\n";
		System.out.println(str.length());
		byte[] b = new byte[512];
		b = str.getBytes();
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(f, true);
			os.write(b);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test3() {
		File f = new File("D:\\test\\output.txt");
		String str = "I am writer!";
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Writer w = null;
		try {
			w = new FileWriter(f);
			w.write(str);
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 字符流
	public static void test4() {
		File f = new File("D:\\test\\output.txt");
		File outFile = new File("D:\\test\\outFile.txt");
		try {
			Writer os = new FileWriter(outFile);
			Reader is = new FileReader(f);
			int b = 0;
			while ((b = is.read()) != -1) {
				System.out.print(b + "\40");
				os.write(b);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 字节流
	public static void test5() {
		File f = new File("D:\\test\\output.txt");
		File outFile = new File("D:\\test\\outFile.txt");
		try {
			OutputStream os = new FileOutputStream(outFile);
			InputStream is = new FileInputStream(f);
			int b = 0;
			while ((b = is.read()) != -1) {
				System.out.print(b + "\40");
				os.write(b);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
