package com.mjw.thread.test;

import java.io.IOException;

public class ThreadDemo extends Thread {
	public ThreadDemo() {
		}
		/** *//**
		* �̵߳�run�����������������߳�ͬʱ����
		*/
		public void run(){
		for(int i = 1; i <= 40; i++){
		try{
		Thread.sleep(100);
		} catch (InterruptedException ex){
		ex.printStackTrace();
		}
		System.out.println("TestThread: "+Thread.currentThread().getName() +i);
		}
		}
		public static void main(String [] args){
		ThreadDemo test = new ThreadDemo();
		test.setDaemon(true);
		test.start();
		System.out.println("isDaemon = " + test.isDaemon());
		try {
		System.in.read(); // �������룬ʹ�����ڴ�ͣ�٣�һ�����յ��û����룬main�߳̽������ػ��߳��Զ�����
		} catch (IOException ex) {
		ex.printStackTrace();
		}
		}
}
