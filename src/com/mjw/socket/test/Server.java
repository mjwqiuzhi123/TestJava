package com.mjw.socket.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {  
    //public static final int PORT = 12345;//�����Ķ˿ں�     
      
    public static void main(String[] args) {    
        System.out.println("����������...\n");    
        Server server = new Server();    
        server.init();    
    }    
    
    public void init() {    
        try {    
            @SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(9999);    
            while (true) {    
                // һ���ж���, ���ʾ��������ͻ��˻��������    
                Socket client = serverSocket.accept();    
                // �����������    
                new HandlerThread(client); 
                System.out.println("init() end");
            }    
        } catch (Exception e) {    
            System.out.println("�������쳣: " + e.getMessage());    
        }    
    }    
    
    private class HandlerThread implements Runnable {    
        private Socket socket;    
        public HandlerThread(Socket client) {    
            socket = client;    
            new Thread(this).start();    
        }    
    
        public void run() {    
            try {    
                // ��ȡ�ͻ�������    
//                DataInputStream input = new DataInputStream(socket.getInputStream());  
//                String clientInputStr = input.readUTF();//����Ҫע��Ϳͻ����������д������Ӧ,������� EOFException  
//                // ����ͻ�������    
//                System.out.println("�ͻ��˷�����������:" + clientInputStr);    
    
                // ��ͻ��˻ظ���Ϣ    
//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());    
//                System.out.print("������:\t");    
//                // ���ͼ��������һ��    
//                //String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
//                System.out.println("HTTP/1.1 200 OK/r/n���Ƿ���������Ӧhttp����");
//                out.writeUTF("HTTP/1.1 200 OK/r/nContent-Type:text/html;charset:GBK");
//                //out.writeUTF("����,���Գɹ���"); 
//                  
//                out.close();    
                //input.close();
            	//**************************************
            	//ģ��http��Ӧ
            	PrintStream out = new PrintStream(socket.getOutputStream());
            	out.println("HTTP/1.1 500 OK");
            	out.println("Content-Type:text/html;charset:GBK");
            	out.println();
            	out.println("<html><body>�������Գɹ�</body></html>");
            	out.close();
            	System.out.println("have output datas!");
            	//*****************************************
            } catch (Exception e) {    
                System.out.println("������ run �쳣: " + e.getMessage());    
            } finally {    
                if (socket != null) {    
                    try {    
                        socket.close();    
                    } catch (Exception e) {    
                        socket = null;    
                        System.out.println("����� finally �쳣:" + e.getMessage());    
                    }    
                }    
            }   
        }    
    }    
}  