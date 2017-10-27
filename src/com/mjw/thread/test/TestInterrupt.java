package com.mjw.thread.test;

class TestInterrupt extends Thread {
	//volatile用于修饰共享变量，用于多线程之间数据的同步（轻量级的同步），相对于synchroized开销小的多！
	volatile boolean stop = false;

	public static void main(String args[]) throws Exception {
		TestInterrupt thread = new TestInterrupt();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		thread.stop = true;// 如果线程阻塞，将不会检查此变量
		Thread.sleep(3000);
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit( 0 );
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
		System.out.println("Thread exiting under request...");
	}
}