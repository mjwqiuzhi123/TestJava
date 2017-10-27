package com.mjw.socket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		service();
	}

	@SuppressWarnings("resource")
	public static void service() throws IOException {
		ServerSocket ss = null;
		ss = new ServerSocket(10001);
		Socket socket = null;
		while (true) {
			try {
				socket = ss.accept();// 从连接队列中取出一个连接，如果没有则等待
				System.out.println("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());// 接收和发送数据
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null)
						socket.close();// 与一个客户端通信结束后，要关闭Socket
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
