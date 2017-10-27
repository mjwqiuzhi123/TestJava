/*
 *�ػ��̣߳������ȼ����̣����Ǻ�̨���̣�������JVM�Ľ���������
 * 
 */
package com.mjw.thread.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class TestRunnable implements Runnable {
	
	public void run() {

		try {
			Thread.sleep(1000);// �ػ��߳�����1�������
			System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName());
			File f = new File("daemon.txt");
			FileOutputStream os = new FileOutputStream(f, true);
			os.write("daemon".getBytes());

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class TestDemo2 {

	public static void main(String[] args) throws InterruptedException {
		Runnable tr = new TestRunnable();
		Thread thread = new Thread(tr,"Thread daemon");
		thread.setDaemon(true); // �����ػ��߳�
		thread.start(); // ��ʼִ�зֽ���
		
		//Thread.sleep(1000);
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName());
	}
}
