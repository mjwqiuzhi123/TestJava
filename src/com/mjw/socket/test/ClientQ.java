package com.mjw.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientQ {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		// TODO Auto-generated method stub
		// �ͻ���
		// 1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
		Socket socket = new Socket("127.0.0.1", 10086);
		// 2����ȡ���������������˷�����Ϣ
		OutputStream os = socket.getOutputStream();// �ֽ������
		PrintWriter pw = new PrintWriter(os);// ���������װ�ɴ�ӡ��
		pw.write("�û�����admin;���룺admin");
		pw.flush();
		socket.shutdownOutput();
		// 3����ȡ������������ȡ�������˵���Ӧ��Ϣ
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("Hello,���ǿͻ��ˣ�������˵��" + info);
		}

		// 4���ر���Դ
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}

}
