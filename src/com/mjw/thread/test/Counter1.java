/*
 * volatile 关键字可以取得被修饰变量，其他线程对该变量的修改具有可见性！
 * 
 */
package com.mjw.thread.test;

public class Counter1 {

	public volatile static int count = 0;

	public static void inc() {
		count++;
	}

	public static void main(String[] args) {

		// 同时启动1000个线程，去进行i++计算，看看实际结果

		for (int i = 0; i < 1000; i++) {
			final int temp = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					 try {
						 //if(temp == 1)
					 Thread.sleep(1000L);
					 } catch (InterruptedException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
					 }
					Counter1.inc();
					System.out.println(Thread.currentThread().getName());
				}
			}).start();
		}

		// try {
		// Thread.sleep(5 * 1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// 这里每次运行的值都有可能不同,可能为1000
		System.out.println(Thread.currentThread().getName());
		System.out.println("运行结果:Counter.count=" + Counter1.count);
	}
}