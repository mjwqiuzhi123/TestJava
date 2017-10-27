package com.mjw.servlet.test;
/**
 * 
 * @author admin
 *	servlet的单实例多线程调用
 */
public class Servlet {
	private static Servlet instance = new Servlet();

	private Servlet() {

	}

	public static Servlet getInstance() {
		return instance;
	}

	public void services() {
		System.out.println("do something");
	}

	static class Client extends Thread {
		private Servlet servlet;

		public Client(Servlet servlet,String threadName) {
			super(threadName);
			this.servlet = servlet;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName());
			servlet.services();
			// System.out.println("do something");
		}
	}

	public static void main(String[] args) {
		Servlet servlet = Servlet.getInstance();
		for (int i = 0; i < 10; i++) {
			Client client = new Client(servlet,i + "");
			client.start();
		}
	}
}