package com.mjw.interface1.test;

public class NewInterface {
	public static void main(String[] args) {
		// 实践证明：接口是可以new的，但是一定要实现里面的抽象方法
		Inter in = new Inter() {

			@Override
			public void test() {
				// TODO Auto-generated method stub
				System.out.println("I am test()");
			}
		};
		in.test();
	}

	// 在类中，没有方法体的方法为抽象方法，必须加关键字abstract
	public String getString() {
		return null;
	};
}

interface Inter {
	// 接口中的方法默认为抽象方法
	public abstract void test();
}