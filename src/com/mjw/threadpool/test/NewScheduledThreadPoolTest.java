/*
 * 定时器线程池！
 */
package com.mjw.threadpool.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
		for (int i = 0; i < 10000; i++) {
			scheduledThreadPool.schedule(new Runnable() {
				public void run() {
//					try {
//						Thread.sleep(1000L);//为什么超出队列的线程还会得到执行！？？？？？？？？
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName());
				}
			}, 3, TimeUnit.SECONDS);
		}
		//scheduledThreadPool.shutdown();
	}
}