package com.mjw.string.test;

public class TestString1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	//������αȽ������ַ���
	public static void test(){
		String a = "ac";
		String b = "ac";
		//1 �ҳ����ַ�����length
		//2���αȽ������ַ�����Ӧλ�õ��ַ����������ȣ����ز�ֵ���������ȣ����������ַ����ĳ��Ȳ�
		System.out.println(a.compareTo(b));
	}
	
	public static void test1(){
		System.out.println(String.valueOf(null)); 
	}
}
