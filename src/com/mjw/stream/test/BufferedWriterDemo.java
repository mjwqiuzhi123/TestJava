package com.mjw.stream.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class BufferedWriterDemo {  
    public static void main(String[] args) {  
        BufferedWriter bufw = null;  
        try {  
            //����һ���ַ�д��������  
            FileWriter fw = new FileWriter("d:/buf.txt");  
            //Ϊ������ַ�д����Ч�ʡ������˻��弼����  
            //ֻҪ����Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯�����ɡ�  
            bufw = new BufferedWriter(fw);  
            for (int x = 1; x < 5; x++) {  
                bufw.write("abcd" + x);  
                bufw.newLine();  
                //bufw.flush();  
            }  
        } catch (IOException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            //�رջ��������������ر���ʵ�������е�������Ĺرգ���������Դ�Ѿ�����Ҫ�ر�����  
            if (bufw != null) {  
                try {  
                    bufw.close();  
                } catch (IOException e) {  
                    System.out.println(e.getMessage());  
                }  
            }  
        }  
    }  
} 