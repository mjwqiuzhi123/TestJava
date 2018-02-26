package com.mjw.blockingQuence.test;
/**
 * 当 Thread写在哪里，当对当前的进程影响
 */

/**
 *
 */
class Interrupted_root_make extends Thread{

    @Override
    public void run() {
        while (true) {
            System.out.println("-----");


            /**
             * 使用中断命令，外部只是其的一个通知命令，实际上的中断的操作还是需要内部自己判断操作，退出
             */
//            try {
//                //Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            if ( Thread.currentThread().isInterrupted() ) {
                System.out.println("i has interputed");
                break;
            }
            System.out.println("暂停前");
            Thread.yield();
            System.out.println("暂停后");
        }
    }
}
public class Interruped_test_wrong {
    public static void main(String[] args) throws InterruptedException {
        Interrupted_root_make interrupted_root_make = new Interrupted_root_make();
        interrupted_root_make.start();
        System.out.println("中断钱");
        interrupted_root_make.interrupt();
        System.out.println("中断后");



    }
}