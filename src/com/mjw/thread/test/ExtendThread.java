/*
 * ���̵߳Ĳ���ѧϰ���������̳��߳���Thread
 * 
 * new Thread()�½�״̬
 * Thread.start()����״̬
 * Thread.sleep(int time)����״̬
 * ������ʱ�䵽��ʱ��Thread���»ص�����״̬
 * 
 */
package com.mjw.thread.test;

public class ExtendThread {

	public static void main(String[] args) {
		new NewThread1(); // ����һ�����߳�
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}

// ͨ���̳� Thread �����߳�
class NewThread1 extends Thread {
	NewThread1() {
		// �����ڶ������߳�
		super("Demo Thread");
		System.out.println("Child thread: " + this);
		start(); // ��ʼ�߳�
	}

	// �ڶ����߳����
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				// ���߳�����һ��
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}