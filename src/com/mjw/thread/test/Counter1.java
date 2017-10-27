/*
 * volatile �ؼ��ֿ���ȡ�ñ����α����������̶߳Ըñ������޸ľ��пɼ��ԣ�
 * 
 */
package com.mjw.thread.test;

public class Counter1 {

	public volatile static int count = 0;

	public static void inc() {
		count++;
	}

	public static void main(String[] args) {

		// ͬʱ����1000���̣߳�ȥ����i++���㣬����ʵ�ʽ��

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

		// ����ÿ�����е�ֵ���п��ܲ�ͬ,����Ϊ1000
		System.out.println(Thread.currentThread().getName());
		System.out.println("���н��:Counter.count=" + Counter1.count);
	}
}