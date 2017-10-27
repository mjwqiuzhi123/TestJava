package com.mjw.future.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
	  
    public static void main(String[] args) {  
        // ��ʼ��һ��Callable�����FutureTask����  
        Callable<Integer> pAccount = new PrivateAccount();  
        FutureTask<Integer> futureTask = new FutureTask<Integer>(pAccount);  
        // ʹ��futureTask����һ���߳�  
        Thread pAccountThread = new Thread(futureTask);  
        System.out.println("futureTask�߳����ڿ�ʼ����������ʱ��Ϊ��" + System.nanoTime()); 
        System.out.println("futureTask�߳����ڿ�ʼ����������ʱ��Ϊ��" + new Date().getTime()); 
        pAccountThread.start();  
        System.out.println("���߳̿�ʼִ����������");  
        // �������˻���ȡ�ܽ��  
        int totalMoney = new Random().nextInt(100000);  
        System.out.println("�������������˻��е��ܽ��Ϊ" + totalMoney);  
        System.out.println("�ȴ�˽���˻��ܽ��ͳ�����...");  
        // ���Ժ�̨�ļ����߳��Ƿ���ɣ����δ�����ȴ�  
        while (!futureTask.isDone()) {  
            try {  
                Thread.sleep(500);  
                System.out.println("˽���˻�����δ��ɼ����ȴ�...");  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("futureTask�̼߳�����ϣ���ʱʱ��Ϊ" + System.nanoTime());  
        Integer privateAccountMoney = null;  
        try {  
            privateAccountMoney = (Integer) futureTask.get();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
        System.out.println("�����ڵ��ܽ��Ϊ��" + (totalMoney + privateAccountMoney.intValue()));  
    }  
}  
  
@SuppressWarnings("all")  
class PrivateAccount implements Callable {  
    Integer totalMoney;  
  
    @Override  
    public Object call() throws Exception {  
        Thread.sleep(5000);  
        totalMoney = new Integer(new Random().nextInt(10000));  
        System.out.println("����ǰ��" + totalMoney + "������˽���˻���");  
        return totalMoney;  
    }  
  
}
