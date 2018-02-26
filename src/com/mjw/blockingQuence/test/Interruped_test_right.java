package com.mjw.blockingQuence.test;
class Interrupted_root_make_right extends Thread{

    @Override
    public void run() {
    	boolean flag = true;
        while (flag) {

            if ( Thread.currentThread().isInterrupted() ) {
                System.out.println("i has interputed");
                break;
            }
            System.out.println("-----");
            flag = false;

            /**
             * 使用中断命令，外部只是其的一个通知命令，实际上的中断的操作还是需要内部自己判断操作，退出
             */
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            	System.out.println("test thread");
                e.printStackTrace();
            }



            Thread.yield();
        }
    }
}
public class Interruped_test_right {
    public static void main(String[] args) throws InterruptedException {
    	Interrupted_root_make_right Interrupted_root_make_right = new Interrupted_root_make_right();
    	Interrupted_root_make_right.start();
        Thread.sleep(1000);
        Interrupted_root_make_right.interrupt();

    }
}