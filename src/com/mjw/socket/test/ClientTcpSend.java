package com.mjw.socket.test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpSend {

    public static void main(String[] args) {
        int length = 0;
        byte[] sendByte = null;
        Socket socket = null;
        DataOutputStream dout = null;
        FileInputStream fin = null;
        try {
          try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 33456),10 * 1000);
            dout = new DataOutputStream(socket.getOutputStream());
            File file = new File("D:\\Log4JDemo02.log");
            fin = new FileInputStream(file);
            sendByte = new byte[1024];
            dout.writeUTF(file.getName());
            while((length = fin.read(sendByte, 0, sendByte.length))>0){
                dout.write(sendByte,0,length);
                dout.flush();
            }
            } catch (Exception e) {
            	System.out.println(e.toString());
            } finally{
                if (dout != null)
                    dout.close();
                if (fin != null)
                    fin.close();
                if (socket != null)
                    socket.close();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}