package com.mjw.superthis.test;

public class TestSuperSon extends TestSuperFauther{
	
	private int b = 2;
	/**
	 * @param args
	 * 
	 */
	
	public TestSuperSon(){
		//super();
	}
	
	public TestSuperSon(String par){
		super(par);
		System.out.println("�������๹�캯��");
	}
	
	// �෽����
	static{
		System.out.println("�������ྲ̬������");
	}
	
	// ���󷽷���
	{
		System.out.println(super.b);// superָ�������
		System.out.println(this.b);// thisָ��ǰ����
		System.out.println("�������෽����");
	}
	
}
