package com.mjw.other.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Code {
	public static void main(String[] args) {
		try {
			codeString("C:\\Users\\admin\\Desktop\\mmz.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String codeString(String fileName) throws Exception {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(
				fileName));
//		int a = bin.read() << 8;
//		int b = bin.read();
		int p = (bin.read() << 8) + bin.read();
		String code = null;
		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			System.out.println(code);
			break;
		case 0xfffe:
			code = "Unicode";
			System.out.println(code);
			break;
		case 0xfeff:
			code = "UTF-16BE";
			System.out.println(code);
			break;
		default:
			code = "GBK";
			System.out.println(code);
		}
		return code;
	}
}
