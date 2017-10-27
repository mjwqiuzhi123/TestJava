package com.mjw.other.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ToUtf8NoBOM {

	/**
	 * 入口函数
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 2) return;
		else {
			String strSuffix = args[0];
			String strFile = null;
			for (int i = 1; i < args.length; i++) {
				strFile = args[i];
				winToLinux(strFile, strSuffix);
			}
		}
	}

	/**
	 * 将文件转换为UTF8无BOM，若参数为文件件，则转换所有指定后缀的文件为UTF8无BOM
	 * 
	 * @param strFile 文件或文件夹
	 * @param strSuffix 后缀
	 * @throws Exception 异常
	 */
	private static void winToLinux(String strFile, String strSuffix)
			throws Exception {
		File file = new File(strFile);
		if (file.isFile()) {
			if (strFile.endsWith(strSuffix)) {
				convertToUtf8NoBOM(file);
			} else {
				return;
			}
		} else {
			for (String str : file.list()) {
				winToLinux(file.getPath() + File.separatorChar + str, strSuffix);
			}
		}
	}

	/**
	 * 将文件转化为UTF8无BOM
	 * 
	 * @param file
	 * @throws IOException
	 */
	private static void convertToUtf8NoBOM(File file) throws IOException {
		String strText = null;

		// 读取文件
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			byte[] buf = new byte[(int) file.length()];
			in.read(buf);
			if (buf.length > 3 && (byte) 0XEF == buf[0] && (byte) 0XBB == buf[1] && (byte) 0XBF == buf[2]) {
				strText = new String(buf, 3, buf.length - 3, "UTF-8");
			} else {
				strText = new String(buf);
			}
			strText.replace("\r\n", "\n");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != in) {
				in.close();
			}
		}

		// 写文件
		OutputStream out = null;
		try {
			out = new FileOutputStream("C:/hmulogs/upload/mjw3.xls");
			out.write(strText.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}
}