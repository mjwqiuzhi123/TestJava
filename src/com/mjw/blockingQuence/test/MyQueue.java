package com.mjw.blockingQuence.test;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	private final LinkedList<Object> container = new LinkedList<Object>();

	private final int minSize = 0;

	private final int maxSize;

	// 计数
	private final AtomicInteger count = new AtomicInteger(0);

	private final Object lock = new Object();

	public MyQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getSize() {
		return count.get();
	}

	public void put(Object obj) {
		synchronized (lock) {
			try {
				if (count.get() < maxSize) {
					container.add(obj);
					count.incrementAndGet();
					System.out.println("新增了一个元素：" + obj);
					lock.notify();
				} else {
					lock.wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public Object take() {
		Object ret = null;
		synchronized (lock) {
			try {
				if (count.get() > minSize) {
					ret = container.removeFirst();
					count.decrementAndGet();
					System.out.println("移除了一个元素：" + ret);
					lock.notify();
				} else {
					lock.wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		final MyQueue my = new MyQueue(3);
		my.put("a");
		my.put("b");
		my.put("c");
		System.out.println("myQueue的size ：：：" + my.getSize());
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					my.put("d");
					my.put("e");
					my.put("f");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					my.take();
					Thread.sleep(1000);
					my.take();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t2");

		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}
