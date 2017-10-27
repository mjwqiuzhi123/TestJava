package com.mjw.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	// UDP:发送端、接收端 (无连接)
	// TCP:客户端、服务端 (要连接)先启动服务端，在启动客户端
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// 服务端接收客户端发送过来的数据，并打印在控制台上。
		/*
		 * 建立tcp服务端的思路： 1，创建服务端socket服务。通过ServerSocket对象。
		 * 2，服务端必须对外提供一个端口，否则客户端无法连接。 3，获取连接过来的客户端对象。
		 * 4，通过客户端对象获取socket流读取客户端发来的数据 并打印在控制台上。 5，关闭资源。关客户端，关服务端。
		 */
		// 1创建服务端对象。
		ServerSocket ss = new ServerSocket(10002);
		// 监听应用所在服务器的10002端口，
		// 看有没有客户端连接过来，或者发送消息
		// 2,获取连接过来的客户端对象。
		Socket s = ss.accept();// 阻塞式.
		String ip = s.getInetAddress().getHostAddress();
		// 获取连接过来客户端的IP地址
		// 3，通过socket对象获取输入流，要读取客户端发来的数据，
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf, 0, len);
		System.out.println(ip + ":" + text);
		
		s.close();
		//ss.close();// 关闭服务器，理论上是不用关的
	}
}
