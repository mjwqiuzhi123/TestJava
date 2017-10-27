/*
 * 多线程的测试学习————实现接口Runnanle
 * 
 * new Thread()新建状态
 * Thread.start()就绪状态
 * Thread.sleep(int time)阻塞状态
 * 当阻塞时间到达时，Thread重新回到就绪状态
 * 
 */
package com.mjw.thread.test;

class NewThread  implements Runnable {
	Thread t;
	   NewThread() {
	      // 创建第二个新线程
	      t = new Thread(this, "Demo Thread");
	      System.out.println("Child thread: " + t);
	      t.start(); // 开始线程
	   }
	  
	   // 第二个线程入口
	   public void run() {
	      try {
	         for(int i = 5; i > 0; i--) {
	            System.out.println("Child Thread: " + i);
	            // 暂停线程
	            Thread.sleep(1000);
	         }
	     } catch (InterruptedException e) {
	         System.out.println("Child interrupted.");
	     }
	     System.out.println("Exiting child thread.");
	   }
}

public class ThreadDemo1 {
	   public static void main(String args[]) {
	      new NewThread(); // 创建一个新线程
	      try {
	         for(int i = 5; i > 0; i--) {
	           System.out.println("Main Thread: " + i);
	           Thread.sleep(100);
	         }
	      } catch (InterruptedException e) {
	         System.out.println("Main thread interrupted.");
	      }
	      System.out.println("Main thread exiting.");
	   }
	}