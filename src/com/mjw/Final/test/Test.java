package com.mjw.Final.test;

import java.util.ArrayList;

public class Test {
	//��final���εĳ�Ա���������뱻��ʼ��,����������
	private final String name = "name";
	static final int n = 2;
	private final int m = 1;
	private final String str = "must be initialized!";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int num = 0;
		//num += 1;
		final String s = "";
		//s = s + "";
	}
	
	//final ���εķ����ǿ������ص�
	public static final void test(){
		Integer i = Integer.valueOf("123");
		Integer j = Integer.parseInt("111");
	}

	public static final void test(String a){
		ArrayList al=new ArrayList();
		int n=40;
		String name = "mjw";
		Integer nI=new Integer(n);
		al.add(name);
		al.add(n);//keyi 
		al.add(nI);//����
	}
}
