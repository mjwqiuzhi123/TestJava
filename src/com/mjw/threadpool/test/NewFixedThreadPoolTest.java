/*
 * 创建固定线程数的线程池
 */
package com.mjw.threadpool.test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						//System.out.println(Thread.currentThread().getName() + " " + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " " + index);
				}
			});
		}
		fixedThreadPool.shutdown();
//		List<Runnable> list= fixedThreadPool.shutdownNow();
//		for(Runnable r : list)
//			System.out.println(r.toString());
		System.out.println("end");
	}
}