/*
 * SynchronousQueueSynchronousQueue没有容纳元素的能力，即它的isEmpty()方法总是返回true，但是给人的感觉却像是只能容纳一个元素。size()方法永远返回0
 * (非常成功的测试)
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
                System.out.println("生产了一个产品："+rand);  
                System.out.println("等待一秒后运送出去...");  
                try {  
                    TimeUnit.SECONDS.sleep(1);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                if(queue.offer(rand))// offer 发现等待进行插入
                	System.out.println("发现等待，我要插入");
                else
                	System.out.println("无等待，不插入");
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
                    System.out.println("消费了一个产品:"+queue.take());// 如果无数据，阻塞等待
                    System.out.println("我是消费者，我在等待！");
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                System.out.println("------------------------------------------");  
            }  
        }  
    } 
}