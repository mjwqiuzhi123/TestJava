package com.mjw.interface1.test;

public class NewInterface {
	public static void main(String[] args) {
		// ʵ��֤�����ӿ��ǿ���new�ģ�����һ��Ҫʵ������ĳ��󷽷�
		Inter in = new Inter() {

			@Override
			public void test() {
				// TODO Auto-generated method stub
				System.out.println("I am test()");
			}
		};
		in.test();
	}

	// �����У�û�з�����ķ���Ϊ���󷽷�������ӹؼ���abstract
	public String getString() {
		return null;
	};
}

interface Inter {
	// �ӿ��еķ���Ĭ��Ϊ���󷽷�
	public abstract void test();
}