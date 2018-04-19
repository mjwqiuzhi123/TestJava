package com.mjw.nio.test;

import java.io.*;
import java.net.*;
//BIO��������
public class BioServer implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Hello Server!!");

        try {
            ServerSocket server = null;
            try {
                server = new ServerSocket(4700);
                // ����һ��ServerSocket�ڶ˿�4700�����ͻ�����
            } catch (Exception e) {
                System.out.println("can not listen to:" + e);
                // ��������ӡ������Ϣ
            }
            Socket socket = null;
            try {
                socket = server.accept();
                // ʹ��accept()�����ȴ��ͻ������пͻ�
                // �����������һ��Socket���󣬲�����ִ��
            } catch (Exception e) {
                System.out.println("Error." + e);
                // ��������ӡ������Ϣ
            }
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            // ��Socket����õ�����������������Ӧ��BufferedReader����
            
            // ��Socket����õ��������������PrintWriter����
//            BufferedReader sin = new BufferedReader(new InputStreamReader(
//                    System.in));
            // ��ϵͳ��׼�����豸����BufferedReader����
            System.out.println("Client:" + is.readLine());
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            // �ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
            line = "hello";
            // �ӱ�׼�������һ�ַ���
//            while (!line.equals("bye")) {
                // ������ַ���Ϊ "bye"����ֹͣѭ��
                os.println(line);
                // ��ͻ���������ַ���
                os.flush();
                // ˢ���������ʹClient�����յ����ַ���
//                System.out.println("Server:" + line);
                // ��ϵͳ��׼����ϴ�ӡ������ַ���
//                System.out.println("Client:" + is.readLine());
                // ��Client����һ�ַ���������ӡ����׼�����
//                line = sin.readLine();
                // ��ϵͳ��׼�������һ�ַ���
//            } // ����ѭ��
//            os.close(); // �ر�Socket�����
            is.close(); // �ر�Socket������
            socket.close(); // �ر�Socket
            server.close(); // �ر�ServerSocket
        } catch (Exception e) {
            System.out.println("Error." + e);
            // ��������ӡ������Ϣ
        }

    }

}