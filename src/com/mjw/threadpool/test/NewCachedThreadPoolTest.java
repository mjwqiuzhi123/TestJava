/*
 * 创建一个可变线程池，少则新建，多则回收
 */

package com.mjw.threadpool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			 final int index = i;
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("start " + i);
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.print(Thread.currentThread().getName() + " " + index);
					System.out.println();
				}
			});
		}
	}
}