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
				socket = ss.accept();// �����Ӷ�����ȡ��һ�����ӣ����û����ȴ�
				System.out.println("�������ӣ�" + socket.getInetAddress() + ":" + socket.getPort());// ���պͷ�������
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null)
						socket.close();// ��һ���ͻ���ͨ�Ž�����Ҫ�ر�Socket
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
