package com.mjw.gc.test;

class MyObject {

	Test main; // ��¼Test������finalize��ʱ���ڻָ��ɴ���

	public MyObject(Test t)

	{

		main = t; // ����Test ����

	}

	protected void finalize()

	{

		main.ref = this;// �ָ��������ñ�����ɴ�

		System.out.println("This is finalize");// ���ڲ���finalizeֻ����һ��

	}

}

public class Test {

	MyObject ref;

	public static void main(String[] args) {

		Test test = new Test();

		test.ref = new MyObject(test);

		test.ref = null; // MyObject����Ϊ���ɴ����finalize��������

		System.gc();

		if (test.ref != null)
			System.out.println("My Object������");

	}

}
