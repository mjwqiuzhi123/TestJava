package com.mjw.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	// UDP:���Ͷˡ����ն� (������)
	// TCP:�ͻ��ˡ������ (Ҫ����)����������ˣ��������ͻ���
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// ����˽��տͻ��˷��͹��������ݣ�����ӡ�ڿ���̨�ϡ�
		/*
		 * ����tcp����˵�˼·�� 1�����������socket����ͨ��ServerSocket����
		 * 2������˱�������ṩһ���˿ڣ�����ͻ����޷����ӡ� 3����ȡ���ӹ����Ŀͻ��˶���
		 * 4��ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷��������� ����ӡ�ڿ���̨�ϡ� 5���ر���Դ���ؿͻ��ˣ��ط���ˡ�
		 */
		// 1��������˶���
		ServerSocket ss = new ServerSocket(10002);
		// ����Ӧ�����ڷ�������10002�˿ڣ�
		// ����û�пͻ������ӹ��������߷�����Ϣ
		// 2,��ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();// ����ʽ.
		String ip = s.getInetAddress().getHostAddress();
		// ��ȡ���ӹ����ͻ��˵�IP��ַ
		// 3��ͨ��socket�����ȡ��������Ҫ��ȡ�ͻ��˷��������ݣ�
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf, 0, len);
		System.out.println(ip + ":" + text);
		
		s.close();
		//ss.close();// �رշ��������������ǲ��ùص�
	}
}
