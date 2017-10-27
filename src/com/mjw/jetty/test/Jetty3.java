/*
 * jetty的嵌入式使用(4)——ContextHandler 
 * 
 * 这个demo里面的handler为ContextHandler，同样，他也是handlerWrapper的一个子类
	这里实现的是，在这个contextHandler里面再设置handler，将转发给另一个handler（这里为helloHandler）
 * 
 */
package com.mjw.jetty.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;

public class Jetty3 {
	public static void main(String[] args) {
		Server server = new Server(8080); // server
		ContextHandler context = new ContextHandler(); // handler
		context.setContextPath("/hello");
		// context.setClassLoader(Thread.currentThread().getContextClassLoader());
		context.setHandler(new HelloHandler());
		server.setHandler(context);
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class HelloHandler extends AbstractHandler {
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);//设置响应状态
		baseRequest.setHandled(true);//标记请求已处理
		response.getWriter().write("hello world");
		response.getWriter().write("Request url：" + baseRequest);
	}
}
