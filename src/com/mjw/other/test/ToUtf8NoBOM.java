package com.mjw.other.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ToUtf8NoBOM {

	/**
	 * ��ں���
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
	 * ���ļ�ת��ΪUTF8��BOM��������Ϊ�ļ�������ת������ָ����׺���ļ�ΪUTF8��BOM
	 * 
	 * @param strFile �ļ����ļ���
	 * @param strSuffix ��׺
	 * @throws Exception �쳣
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
	 * ���ļ�ת��ΪUTF8��BOM
	 * 
	 * @param file
	 * @throws IOException
	 */
	private static void convertToUtf8NoBOM(File file) throws IOException {
		String strText = null;

		// ��ȡ�ļ�
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

		// д�ļ�
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