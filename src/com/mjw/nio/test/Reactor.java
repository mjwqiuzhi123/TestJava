package com.mjw.nio.test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
//NIO��������
public class Reactor implements Runnable {
    public int id = 100001;
    public int bufferSize = 2048;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        init();
    }

    public void init() {
        try {
            // ����ͨ����ѡ����
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(
                    InetAddress.getLocalHost(), 4700);
            socketChannel.socket().bind(inetSocketAddress);
            // ����ͨ�������� ��ѡ����
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT).attach(
                    id++);
            System.out.println("Server started .... port:4700");
            listener(selector);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void listener(Selector in_selector) {
        try {
            while (true) {
                Thread.sleep(1*1000);
                in_selector.select(); // ���� ֱ���о����¼�Ϊֹ
                Set<SelectionKey> readySelectionKey = in_selector
                        .selectedKeys();
                Iterator<SelectionKey> it = readySelectionKey.iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    // �ж����ĸ��¼�
                    if (selectionKey.isAcceptable()) {// �ͻ���������
                        System.out.println(selectionKey.attachment()
                                + " - ���������¼�");
                        // ��ȡͨ�� ��������,
                        // ���÷�����ģʽ�����룩��ͬʱ��Ҫע�� ��д���ݵ��¼�����������Ϣ����ʱ���ܲ���
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey
                                .channel();
                        serverSocketChannel
                                .accept()
                                .configureBlocking(false)
                                .register(
                                        in_selector,
                                        SelectionKey.OP_READ
                                                | SelectionKey.OP_WRITE).attach(id++);
                        System.out
                                .println(selectionKey.attachment() + " - ������");

                        // ��������д����������� ��Ӧ����serverSocketChannel����ע��
                        /*
                         * serverSocketChannel.configureBlocking(false);
                         * serverSocketChannel.register(in_selector,
                         * SelectionKey.OP_READ);
                         * serverSocketChannel.register(in_selector,
                         * SelectionKey.OP_WRITE);
                         */
                    }
                    if (selectionKey.isReadable()) {// ������
                        System.out.println(selectionKey.attachment()
                                + " - �������¼�");
                        SocketChannel clientChannel=(SocketChannel)selectionKey.channel();
                        ByteBuffer receiveBuf = ByteBuffer.allocate(bufferSize);
                        clientChannel.read(receiveBuf);
                        System.out.println(selectionKey.attachment()
                                + " - ��ȡ���ݣ�" + getString(receiveBuf));
                    }
                    if (selectionKey.isWritable()) {// д����
                        System.out.println(selectionKey.attachment()
                                + " - д�����¼�");
                        SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer sendBuf = ByteBuffer.allocate(bufferSize);
                        String sendText = "hello\n";
                        sendBuf.put(sendText.getBytes());
                        sendBuf.flip();        //д�����ݺ���ô˷���
                        clientChannel.write(sendBuf);
                    }
                    if (selectionKey.isConnectable()) {
                        System.out.println(selectionKey.attachment()
                                + " - �����¼�");
                    }
                    // ����removed �����������ڣ���һ��ѭ���������,
                    // ע��removed ��λ�ã����һ��.next() removeһ��
                    it.remove(); 
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error - " + e.getMessage());
            e.printStackTrace();
        }

    }
    /**
     * ByteBuffer ת�� String
     * @param buffer
     * @return
     */
    public static String getString(ByteBuffer buffer)
    {
        String string = "";
        try
        {
            for(int i = 0; i<buffer.position();i++){
                string += (char)buffer.get(i);
            }
            return string;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }
    
//    public static void main(String[] args){
//    	new Thread(new Reactor()).start();
//    }
}

