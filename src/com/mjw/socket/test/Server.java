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
    //public static final int PORT = 12345;//监听的端口号     
      
    public static void main(String[] args) {    
        System.out.println("服务器启动...\n");    
        Server server = new Server();    
        server.init();    
    }    
    
    public void init() {    
        try {    
            @SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(9999);    
            while (true) {    
                // 一旦有堵塞, 则表示服务器与客户端获得了连接    
                Socket client = serverSocket.accept();    
                // 处理这次连接    
                new HandlerThread(client); 
                System.out.println("init() end");
            }    
        } catch (Exception e) {    
            System.out.println("服务器异常: " + e.getMessage());    
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
                // 读取客户端数据    
//                DataInputStream input = new DataInputStream(socket.getInputStream());  
//                String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException  
//                // 处理客户端数据    
//                System.out.println("客户端发过来的内容:" + clientInputStr);    
    
                // 向客户端回复信息    
//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());    
//                System.out.print("请输入:\t");    
//                // 发送键盘输入的一行    
//                //String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
//                System.out.println("HTTP/1.1 200 OK/r/n我是服务器，响应http请求");
//                out.writeUTF("HTTP/1.1 200 OK/r/nContent-Type:text/html;charset:GBK");
//                //out.writeUTF("哈哈,测试成功！"); 
//                  
//                out.close();    
                //input.close();
            	//**************************************
            	//模拟http响应
            	PrintStream out = new PrintStream(socket.getOutputStream());
            	out.println("HTTP/1.1 500 OK");
            	out.println("Content-Type:text/html;charset:GBK");
            	out.println();
            	out.println("<html><body>哈哈测试成功</body></html>");
            	out.close();
            	System.out.println("have output datas!");
            	//*****************************************
            } catch (Exception e) {    
                System.out.println("服务器 run 异常: " + e.getMessage());    
            } finally {    
                if (socket != null) {    
                    try {    
                        socket.close();    
                    } catch (Exception e) {    
                        socket = null;    
                        System.out.println("服务端 finally 异常:" + e.getMessage());    
                    }    
                }    
            }   
        }    
    }    
}  