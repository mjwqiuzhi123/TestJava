package com.mjw.socket.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	/** 
	   * @param args 
	   * @throws IOException 
	   * @throws UnknownHostException 
	   */
	  public static void main(String[] args) throws UnknownHostException, IOException { 
	    //�ͻ��˷����ݵ������ 
	    /* 
	     * Tcp���䣬�ͻ��˽����Ĺ��̡� 
	     * 1������tcp�ͻ���socket����ʹ�õ���Socket���� 
	     *   ����ö���һ��������ȷĿ�ĵء�Ҫ���ӵ������� 
	     * 2��������ӽ����ɹ���˵�����ݴ���ͨ���ѽ����� 
	     *   ��ͨ������socket�� ,�ǵײ㽨���õġ� ��Ȼ������˵������������룬��������� 
	     *   ��Ҫ���������������󣬿�����Socket����ȡ�� 
	     *   ����ͨ��getOutputStream(),��getInputStream()����ȡ�����ֽ����� 
	     * 3��ʹ���������������д���� 
	     * 4���ر���Դ�� 
	     */
	    //�����ͻ���socket���� 
	    //����Ŀ��������ĵ�ַ��192.168.1.100��Ŀ��������ĵ�ַ��10002��Ŀ��������Ķ˿� 
	    Socket socket = new Socket("localhost",10002); 
	    //��ȡsocket���е�������� ������������Ϣ��������Ϣ�������� 
	    OutputStream out = socket.getOutputStream(); 
	    //ʹ���������ָ��������д��ȥ�� 
	    out.write("tcp��ʾ������������!".getBytes()); 
	    System.out.println("client");
	    //�ر���Դ�� 
	    socket.close(); 
	  } 

}
