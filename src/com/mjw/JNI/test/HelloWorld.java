package com.mjw.JNI.test;

public class HelloWorld {
    public native void displayHelloWorld();//所有native关键词修饰的都是对本地的声明
    static {
        System.loadLibrary("Hello");//载入本地库
    }
    public static void main(String[] args) {
        new HelloWorld().displayHelloWorld();
    }
}