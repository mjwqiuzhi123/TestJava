package com.mjw.interface1.test;

public class TestInterface extends TestFinalField implements Say{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestInterface();
		System.out.println("over!");
		System.out.println(num);
		test();
	}
	
//	override����д��
//
//	���� 1��������������������ֵ��ͬ��
//
//	���� 2�����෽��������С���෽���ķ���Ȩ�ޡ�
//
//	���� 3�����෽�������׳��ȸ��෽��������쳣(�����෽�����Բ��׳��쳣)��
//
//	���� 4�������ڸ��������֮�䡣
//
//	���� 5������������Ϊfinal���ܱ���д��
	public void test1(String name){//������
		
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello word");
	}

}

interface Say{
	public void say();
}

class Test1 extends Test{
	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void smile() {
		// TODO Auto-generated method stub
		
	}
	
}

class TestFinalField{
	final static int num = 5;
	public static final void test(){
		System.out.println("I am static final method!");
	}
	
	public final void test1(){
		System.out.println("I am final method!");
	}
}