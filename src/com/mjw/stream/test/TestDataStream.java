package com.mjw.stream.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestDataStream  
{  
    public static void main(String[] args) throws Exception  
    {  
        TestDataStream t = new TestDataStream();  
        t.write();  
        t.read();  
    }  
  
    public void write() throws Exception  
    {  
        //String path = this.getClass().getClassLoader().getResource("D:\\test\\sendlist.txt").toURI().getPath();  
    	String path = "D:\\test\\sendlist.txt";
        OutputStream os = new FileOutputStream(path);  
        DataOutputStream dos = new DataOutputStream(os);  
        dos.writeDouble(Math.random());  
        dos.writeBoolean(true);  
        dos.writeInt(1000);  
        dos.writeInt(2000);  
        dos.flush();  
        os.close();  
        dos.close();  
    }  
  
    public void read() throws Exception  
    {  
        InputStream instream = this.getClass().getClassLoader().getResourceAsStream("D:\\test\\sendlist.txt");  
        DataInputStream dis = new DataInputStream(instream);  
        double d = dis.readDouble();  
        boolean b = dis.readBoolean();  
        // 先写的先被读出来  
        int i1 = dis.readInt();  
        int i2 = dis.readInt();  
        instream.close();  
        dis.close();  
        System.out.println(d);  
        System.out.println(b);  
        System.out.println(i1);  
        System.out.println(i2);  
    }  
}  