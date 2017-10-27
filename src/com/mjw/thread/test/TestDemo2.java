/*
 *守护线程（低优先级进程）：是后台进程，伴随着JVM的结束而消亡
 * 
 */
package com.mjw.thread.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class TestRunnable implements Runnable {
	
	public void run() {

		try {
			Thread.sleep(1000);// 守护线程阻塞1秒后运行
			System.out.println("当前线程：" + Thread.currentThread().getName());
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
		thread.setDaemon(true); // 设置守护线程
		thread.start(); // 开始执行分进程
		
		//Thread.sleep(1000);
		System.out.println("当前线程：" + Thread.currentThread().getName());
	}
}
