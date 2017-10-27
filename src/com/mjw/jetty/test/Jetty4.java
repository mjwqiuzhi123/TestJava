package com.mjw.jetty.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Jetty4 {
	public static void main(String[] args) throws Exception {
		 Server server  = new Server(8080);
		 WebAppContext context = new WebAppContext();
		 context.setContextPath("/hello");
		 //context.setClassLoader(Thread.currentThread().getContextClassLoader());
		 context.setWar("d:/V38448-01.zip");
		 server.setHandler(context);
		 server.start();
		 server.join();
		  }
}
