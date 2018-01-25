package com.mjw.sinoSpider.test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest1 {  
      
    public static void main(String[] args) {  
        //�����̳߳�  
        ExecutorService es = Executors.newSingleThreadExecutor();  
        //����Callable��������  
        CallableDemo calTask=new CallableDemo();  
        //�ύ���񲢻�ȡִ�н��  
        Future<Integer> future =es.submit(calTask);  
        //�ر��̳߳�  
        es.shutdown();  
        try {  
            //Thread.sleep(2000);  
        System.out.println("���߳���ִ����������");  
        System.out.println(new Date().getTime());
        if(future.get()!=null){ // ���δȡ�������������һֱ�ȴ� 
            //�����ȡ���Ľ��  
            System.out.println("future.get()-->"+future.get());  
        }else{// ��������������,����������������@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
            // �����ȡ���Ľ��  
            System.out.println("future.get()δ��ȡ�����");  
        }  
          
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("���߳���ִ�����");  
    }  
}  