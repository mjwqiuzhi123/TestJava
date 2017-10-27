/*
 * 默认的构造函数被覆盖，导致不可调用
 */
package com.mjw.other.test;

public class TestConstructor {
	public static void main(String[] args) {
		new Test1(99);//此处不可调用默认的构造函数
	}
}

class Test1{
	public Test1(int i){
		System.out.println(i);
	}
}
