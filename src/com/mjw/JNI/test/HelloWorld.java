package com.mjw.JNI.test;

public class HelloWorld {
    public native void displayHelloWorld();//����native�ؼ������εĶ��ǶԱ��ص�����
    static {
        System.loadLibrary("Hello");//���뱾�ؿ�
    }
    public static void main(String[] args) {
        new HelloWorld().displayHelloWorld();
    }
}