package com.mjw.MOTO.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test1 {
	
	public static final String fauther = "mgl";
	protected static final String mother = "ly";
	
	private String name = "mjw";
	private int age = 28;
	private String sex = "boy";

	Test1() {
	}

	public Test1(String name) {
		this.name = name;
	}

	protected Test1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@SuppressWarnings("unused")
	private Test1(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public static void main(String[] args) {
		test3();
	}

	// �������η�
	public static void test1() {
		/*
		 * ����Ȩ�� �� �� ���� ������
		 * 
		 * �������� public �� �� �� �� �����κ��˶��ǿ��õģ�
		 * 
		 * �������� protect �� �� �� �������� ���̳е�����Է����Լ���privateһ����Ȩ�ޣ�
		 * 
		 * �������� default �� �� �� �������� ��������Ȩ�ޣ������������ھ��ɱ����ʣ�
		 * 
		 * �������� private �� �� �� �������� �������ʹ����ߺ����͵��ڲ�����֮����κ��˶����ܷ��ʵ�Ԫ�أ�
		 */
	}

	// JAVA��������������
	public static void test2() {
		/*
		 * ����Java��˵�����������Ǻ���ȷ�ġ� ������ʹ�������ַ���ã�Сд����com.myssh.action��
		 * ��������д��ͷ���շ�д������LoginAction�� ��������Сд��ͷ���շ�д������getUser()��
		 * ��������Сд��ͷ���շ�д������userId�� ����������д��ͷ���»��߷ָ��MAX_LENGTH��
		 */
		String $persoms = "";
		// String *point = "";���Ϸ�
		String _person = "mjw";
	}

	// ���䷽������
	public static void test3() {
		try {
			Class<?> clazz = Class.forName("com.mjw.MOTO.test.Test1");

			Field[] sf = clazz.getFields();
			for(Field f : sf){
				System.out.println("�������ƣ�" + f.getName() + "�������η���"
						+ f.getModifiers());
			}
			System.out.println("*****************************");
			Field[] obf = clazz.getDeclaredFields();
			for (Field f : obf) {
				System.out.println("�������ƣ�" + f.getName() + "�������η���"
						+ f.getModifiers());
			}
			System.out.println("*****************************");
			Constructor<?>[] cons = clazz.getDeclaredConstructors();
			for (Constructor<?> con : cons) {
				System.out.println("����������" + con.getParameterCount() + "�������η���"
						+ con.getModifiers());
			}
			System.out.println("*****************************");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
