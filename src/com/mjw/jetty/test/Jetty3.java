/*
 * jetty��Ƕ��ʽʹ��(4)����ContextHandler 
 * 
 * ���demo�����handlerΪContextHandler��ͬ������Ҳ��handlerWrapper��һ������
	����ʵ�ֵ��ǣ������contextHandler����������handler����ת������һ��handler������ΪhelloHandler��
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
		response.setStatus(HttpServletResponse.SC_OK);//������Ӧ״̬
		baseRequest.setHandled(true);//��������Ѵ���
		response.getWriter().write("hello world");
		response.getWriter().write("Request url��" + baseRequest);
	}
}
