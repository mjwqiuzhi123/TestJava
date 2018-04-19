package com.mjw.nio.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.junit.Test;
//BIO�ͻ��˼�������
public class TestReactor {

    @Test
    public void testConnect() throws Exception{
        Socket socket=new Socket("127.0.0.1",4700);//BIO ����
        System.out.println("���ӳɹ�");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         
        //��������д�������ùرտͻ��ˣ���������Ҳ�ǿ����յ���
        {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("hi");
            printWriter.flush();
        }
        //����д������رտͻ��ˣ��������˲ſ����յ� NIO����
        {
//        socket.getOutputStream().write(new byte[]{'h','i'});
//        socket.getOutputStream().flush();
        //����ر�BIO�����������յ���Ϣ.NIO����������Ҫ�ر�
        //socket.close();
        }
        byte[] buf = new byte[2048];
        System.out.println("׼����ȡ����~~");
        
        while(true){
            try {
                //���ֶ�ȡ���ݷ�ʽ
                int count = socket.getInputStream().read(buf);        //������
                //String readFromServer = bufferedReader.readLine();//���Զ�ȡ������ ������,ֱ������\n
                //System.out.println("��ʽ���� ��ȡ����" + readFromServer);    
                System.out.println("��ʽһ�� ��ȡ����" + new String(buf) + " count = " + count);
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //break;
        }
        
    }
    
    @Test 
    public void testNioServer(){
        Thread server = new Thread(new Reactor());
        server.start();

        while(true){
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @Test
    public void testBioServer(){
        Thread server = new Thread(new BioServer());
        server.start();

        while(true){
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

