/*
 * jetty����������Ӻ;�̬��Դ�ķ���
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
		Server nioServer = new Server();//Ĭ�϶˿�8080
//		SelectChannelConnector connector = testConnector1();//�����˿ڴ���
//		nioServer.addConnector(connector);
		
		SelectChannelConnector[] connectorList = testConnector2();//�˿ڼ��ϴ���
		nioServer.setConnectors(connectorList);
		
		ResourceHandler handler = new ResourceHandler(); // ��̬��Դ�����handler
		handler.setDirectoriesListed(true); // ����ʾһ���ļ�Ŀ¼�б�
		//handler.setWelcomeFiles(new String[] { "hello.txt" });
		System.out.println(new File("").getAbsolutePath());//���̸�Ŀ¼
		System.out.println(new File("/").getAbsolutePath());//���̸�Ŀ¼  
		System.out.println(new File("/src").getAbsolutePath());
		System.out.println(new File("src/").getAbsolutePath());
		System.out.println(new File("workspace").getAbsolutePath());
		handler.setResourceBase("/workspace/TestServlet");
		nioServer.setHandler(handler);
		return nioServer;
	}
	
	//���õ����˿�
	public static SelectChannelConnector testConnector1(){
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(8085);//������˿ڸ���,ʧЧ
		connector.setPort(8090);//��������Ķ˿� 
		return connector;
	}
	
	//���ö˿ڼ���
	public static SelectChannelConnector[] testConnector2(){
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(8888);//�˿�һ
		SelectChannelConnector connector1 = new SelectChannelConnector();
		connector1.setPort(9999);//�˿ڶ�
		SelectChannelConnector[] connectorList = new SelectChannelConnector[]{connector,connector1};
		return connectorList;
	}
}
