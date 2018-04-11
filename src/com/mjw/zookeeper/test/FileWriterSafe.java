package com.mjw.zookeeper.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ʹ����ʵ���̵߳İ�ȫ��
public class FileWriterSafe {
	private FileWriter fw = null;
	private PrintWriter pw = null;
	private int lines = 0;//
	private final Lock lock = new ReentrantLock();
	private String preFile = "";
	private static final FileWriterSafe single = new FileWriterSafe(
			"SysappLogs");

	public FileWriterSafe(String preFile) {
		this.preFile = preFile;
		openTransferLogFile(preFile);
	}

	// ��������
	public static FileWriterSafe getInstance() {
		return single;
	}

	public void openTransferLogFile(String preFile) {
		lock.lock();
		System.out.println(new File("").getAbsolutePath());
		String filename = new File("").getAbsolutePath() + preFile + "-"
				+ DateUtil.getSysDateAll() + ".txt";
		try {
			// ����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
			File f = new File(filename);
			fw = new FileWriter(f, true);
			lines = 0;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void writeTransferLog(String content) {
		lock.lock();
		lines++;
		pw = new PrintWriter(fw);
		pw.println(DateUtil.GetDateTime() + " " + content);
		pw.flush();
		try {
			fw.flush();
			// ÿ���ļ�100�����л���һ���ļ���
			if (lines >= 1000000) {
				pw.close();
				fw.close();
				pw = null;
				fw = null;

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			lock.unlock();
			if (fw == null) {
				openTransferLogFile(preFile);
			}
		}
	}
}
