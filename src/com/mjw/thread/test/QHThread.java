package com.mjw.thread.test;

public class QHThread {
	public static void main(String[] aregs) {
		Thread m = new MoreThread("Thread Daemon");
		m.setDaemon(true);// 把"true"改为"false"就变为了前台线程.
		m.start();

		while (true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main方法-->>" + Thread.currentThread().getName());
		}
		/*
		 * 注释这两行输出结果:run方法-->>Thread-0,执行一会儿就结束了.
		 * 如果不注释这两行输出结果是,main方法和run方法交替循环执行.
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
			System.err.println("run方法-->>" + Thread.currentThread().getName());
		}
	}
}
