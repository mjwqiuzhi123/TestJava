package com.mjw.blockingQuence.test;
/**
 * �� Threadд��������Ե�ǰ�Ľ���Ӱ��
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
             * ʹ���ж�����ⲿֻ�����һ��֪ͨ���ʵ���ϵ��жϵĲ���������Ҫ�ڲ��Լ��жϲ������˳�
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
            System.out.println("��ͣǰ");
            Thread.yield();
            System.out.println("��ͣ��");
        }
    }
}
public class Interruped_test_wrong {
    public static void main(String[] args) throws InterruptedException {
        Interrupted_root_make interrupted_root_make = new Interrupted_root_make();
        interrupted_root_make.start();
        System.out.println("�ж�Ǯ");
        interrupted_root_make.interrupt();
        System.out.println("�жϺ�");



    }
}