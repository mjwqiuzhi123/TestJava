package com.mjw.sinoSpider.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableTest {  
      
    public static void main(String[] args) {  
//      //�����̳߳�  
//      ExecutorService es = Executors.newSingleThreadExecutor();  
//      //����Callable��������  
//      CallableDemo calTask=new CallableDemo();  
//      //�ύ���񲢻�ȡִ�н��  
//      Future<Integer> future =es.submit(calTask);  
//      //�ر��̳߳�  
//      es.shutdown();  
          
        //�����̳߳�  
        ExecutorService es = Executors.newSingleThreadExecutor();  
        //����Callable��������  
        CallableDemo calTask=new CallableDemo();  
        //����FutureTask  
        FutureTask<Integer> futureTask=new FutureTask<Integer>(calTask);  
        //ִ������  
        es.submit(futureTask);  
        //�ر��̳߳�  
        es.shutdown();  
        try {  
            //Thread.sleep(2000);  
        System.out.println("���߳���ִ����������");  
          
        if(futureTask.get()!=null){  
            //�����ȡ���Ľ��  
            System.out.println("futureTask.get()-->"+futureTask.get());  
        }else{  
            //�����ȡ���Ľ��  
            System.out.println("futureTask.get()δ��ȡ�����");  
        }  
          
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("���߳���ִ�����");  
    }  
}