package com.mjw.thread.test;

public class QHThread {
	public static void main(String[] aregs) {
		Thread m = new MoreThread("Thread Daemon");
		m.setDaemon(true);// ��"true"��Ϊ"false"�ͱ�Ϊ��ǰ̨�߳�.
		m.start();

		while (true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main����-->>" + Thread.currentThread().getName());
		}
		/*
		 * ע��������������:run����-->>Thread-0,ִ��һ����ͽ�����.
		 * �����ע����������������,main������run��������ѭ��ִ��.
		 */

	}
}

class MoreThread extends Thread {

	public MoreThread(String ThreadName) {
		super(ThreadName);
	}

	public void run() {
		while (true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("run����-->>" + Thread.currentThread().getName());
		}
	}
}
