package com.mjw.char1.test;
/**
 * �����ַ��Ĳ���
 * @author admin
 *
 */
public class Char1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test(){
		// char����ʾ�ķ�Χ��0-65535,������һ���������ַ���ʾ��Ҫ�ӵ����ţ��������ֱ�ʾʱ���üӵ����ţ�0-9Ҳ���Ա�ʾΪascll�ַ����������õ����Ű�Χ��
		char b = '0';
		char a = 65;// a
		// ����int�������ʱ���Զ�ת��Ϊint����(int���͵ı�ʾ��Χ����char�ı�ʾ��Χ)
		System.out.println(b + 1 + "c");
		System.out.println(a + "c");
		System.out.println(a);
	}
}
