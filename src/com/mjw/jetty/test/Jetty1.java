/*
 * jetty中请求的连接和静态资源的访问
 */
package com.mjw.jetty.test;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

public class Jetty1 {
	public static void main(String[] args) throws Exception {
		Server nioServer = server();
		nioServer.start();
		//nioServer.join();
	}
	
	public static Server server(){
		Server nioServer = new Server();//默认端口8080
//		SelectChannelConnector connector = testConnector1();//单个端口处理
//		nioServer.addConnector(connector);
		
		SelectChannelConnector[] connectorList = testConnector2();//端口集合处理
		nioServer.setConnectors(connectorList);
		
		ResourceHandler handler = new ResourceHandler(); // 静态资源处理的handler
		handler.setDirectoriesListed(true); // 会显示一个文件目录列表
		//handler.setWelcomeFiles(new String[] { "hello.txt" });
		System.out.println(new File("").getAbsolutePath());//工程根目录
		System.out.println(new File("/").getAbsolutePath());//磁盘根目录  
		System.out.println(new File("/src").getAbsolutePath());
		System.out.println(new File("src/").getAbsolutePath());
		System.out.println(new File("workspace").getAbsolutePath());
		handler.setResourceBase("/workspace/TestServlet");
		nioServer.setHandler(handler);
		return nioServer;
	}
	
	//设置单个端口
	public static SelectChannelConnector testConnector1(){
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(8085);//被下面端口覆盖,失效
		connector.setPort(8090);//覆盖上面的端口 
		return connector;
	}
	
	//设置端口集合
	public static SelectChannelConnector[] testConnector2(){
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(8888);//端口一
		SelectChannelConnector connector1 = new SelectChannelConnector();
		connector1.setPort(9999);//端口二
		SelectChannelConnector[] connectorList = new SelectChannelConnector[]{connector,connector1};
		return connectorList;
	}
}
