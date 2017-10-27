/*
 * SynchronousQueueSynchronousQueueû������Ԫ�ص�������������isEmpty()�������Ƿ���true�����Ǹ��˵ĸо�ȴ����ֻ������һ��Ԫ�ء�size()������Զ����0
 * (�ǳ��ɹ��Ĳ���)
 */

package com.mjw.threadpool.test;
import java.util.Random;  
import java.util.concurrent.SynchronousQueue;  
import java.util.concurrent.TimeUnit;  
  
public class TestSynchronousQueue {  
    public static void main(String[] args) {  
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();  
        new Customer(queue).start();  
        new Product(queue).start();  
    }  
    static class Product extends Thread{  
        SynchronousQueue<Integer> queue;  
        public Product(SynchronousQueue<Integer> queue){  
            this.queue = queue;  
        }  
        @Override  
        public void run(){  
            while(true){  
                int rand = new Random().nextInt(1000);  
                System.out.println("������һ����Ʒ��"+rand);  
                System.out.println("�ȴ�һ������ͳ�ȥ...");  
                try {  
                    TimeUnit.SECONDS.sleep(1);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                if(queue.offer(rand))// offer ���ֵȴ����в���
                	System.out.println("���ֵȴ�����Ҫ����");
                else
                	System.out.println("�޵ȴ���������");
            }  
        }  
    }  
    static class Customer extends Thread{  
        SynchronousQueue<Integer> queue;  
        public Customer(SynchronousQueue<Integer> queue){  
            this.queue = queue;  
        }  
        @Override  
        public void run(){  
            while(true){  
                try {
                	TimeUnit.SECONDS.sleep(3); 
                    System.out.println("������һ����Ʒ:"+queue.take());// ��������ݣ������ȴ�
                    System.out.println("���������ߣ����ڵȴ���");
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                System.out.println("------------------------------------------");  
            }  
        }  
    } 
}