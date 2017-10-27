/*
 *jetty中servlet的实现 
 *
 */
package com.mjw.jetty.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Jetty2 {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8082);
		System.out.println(ServletContextHandler.SESSIONS); // 1
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("");
		System.out.println(new File("").getAbsolutePath());// E:\workspace\TestJetty
		System.out.println(new File("/content").getAbsolutePath());
		context.addServlet(new ServletHolder(new HelloServlet()), "/*");
		context.addServlet(new ServletHolder(new HelloServlet("小学")), "/school");
		context.addServlet(new ServletHolder(new HelloServlet("小明")), "/person");
		context.addServlet(new ServletHolder(new HelloServlet("last")), "/*");
		context.addServlet(new ServletHolder(new HelloServlet("中学")), "/school");//覆盖相同路径
		server.setHandler(context);
		server.start();
		// server.join();
	}
}

class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7808492770939619932L;
	String greeting = "55.5万";

	public HelloServlet() {
	}

	public HelloServlet(String greeting) {
		this.greeting = greeting;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<h1>" + greeting + "</h1>");
		HttpSession session = request.getSession(false);
		if (session == null)
			response.getWriter().write("HttpSession为null");
		else
			response.getWriter().write(
					"session= " + session.getId());
	}

}
