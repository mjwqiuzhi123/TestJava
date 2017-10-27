package com.mjw.thread.test;
public class Test {  
  
	 private int a = 1;  
	 private boolean ready; 
    
	 private class PrintA extends Thread{  
        @Override  
        public void run() {  
            while(!ready){  
                Thread.yield();
                System.out.println("000");
            }  
            System.out.println(a);  
        }  
    }  
    public static void main(String[] args) throws InterruptedException {  
        Test t = new Test();  
        t.new PrintA().start();  
        //���������������volatile�Ļ���ִ�е��Ⱥ�˳���ǲ���Ԥ��ġ������������ж���ԭ�Ӳ�����������������Ϊһ������Ļ��Ͳ���һ��ԭ�Ӳ�����  
        //t.a = 48; //����һ��ԭ�Ӳ���������������һ�����пɼ��ԡ�����volatile��;߱��˿ɼ��ԡ�  
        t.ready = true;//ͬ��
        //Thread.sleep(1000);
        t.a = 48;
        System.out.println("end");
    }  
  
}  