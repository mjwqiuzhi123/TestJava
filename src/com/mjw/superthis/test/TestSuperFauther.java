package com.mjw.superthis.test;

public class TestSuperFauther {
	
	public static int a = 1;
	public int b = 1;

	static{
		System.out.println("���Ǹ��ྲ̬������");
	}
	
	{
		System.out.println("���Ǹ��෽����");
	}
	
	// Ĭ�Ϲ��캯�������Բ���ʽ����
	public TestSuperFauther(){
		System.out.println("���Ǹ����Ĭ�Ϲ��캯����");
	}
	
	// ���Ը�����ʽ�Ĳ��������Ĺ��캯��
	public TestSuperFauther(String param){
		System.out.println("���������������Ĳ���name:" + param);
	}
	
	// ������д����ķ������ɼ��Ա��벻С�ڸ���Ŀɼ���
	@Override
	public String toString(){
		return "����";
		
	}
	
	// �Զ��巽�����ܼ�����ע��
	// @Override
	public void test(){
		System.out.println("@Override test");
	}
}
