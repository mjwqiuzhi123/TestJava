package com.mjw.lock.test;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();//��1 ����һ�����Զ��жϽ�����Ҫ�������붯��!
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();//��2 ����
            } else {
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();//��1 ����
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) { //�жϳ����Լ������߳��Ƿ��ǵ�ǰ�߳�
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + ":�߳��˳�");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);//�߳�ʵ�� 1
        IntLock r2 = new IntLock(2);//�߳�ʵ�� 2
        Thread t1 = new Thread(r1,"Thread-1");//�߳�1
        Thread t2 = new Thread(r2,"Thread-2");//�߳�2
        t1.start();
        t2.start();
        Thread.sleep(1000);//Main�߳� ����1s

        //t2.interrupt();//�ж�����һ���߳�

    }
}