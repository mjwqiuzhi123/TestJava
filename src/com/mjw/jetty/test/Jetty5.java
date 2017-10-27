package com.mjw.jetty.test;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class Jetty5 {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8082);
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/context");
		context.addServlet(new ServletHolder(new HelloServlet()), "/*");
		context.addServlet(new ServletHolder(new HelloServlet("上学")), "/school");
		context.addServlet(new ServletHolder(new HelloServlet("小明")), "/person");

		WebAppContext appContext = new WebAppContext();
		appContext.setContextPath("/appContext");
		appContext.setWar("d:/V38448-01.zip");
		// HandlerCollection handlers = new HandlerCollection();
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { context, appContext });

		server.setHandler(handlers);
		server.start();
		server.join();
	}
}
