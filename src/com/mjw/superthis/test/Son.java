package com.mjw.superthis.test;

public class Son extends Fauther {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public Son() {
//		// ��ʽ����super();
//	}

	public Son(String name, int age) {
		// this()��super()�����ڹ��캯���ĵ�һ�У����Ҷ��߲���ͬʱʹ��
		//super(name, age);
		this.age = age;
		this.name = name;
	}

	// ��д������ͬ,��������ҲҪ��ͬ
	@Override
	public String toString() {
		return name + age;
	}

	public static void main(String[] args) {
		//�ھ�̬�������ǲ�����ʹ��this�ģ�this����ǰ���󣬾�̬�������ڶ�����ص��ڴ���
		//System.out.println(new Son().toString());
	}

	// ���ط�����������ͬ���������ͻ�����϶�����ͬ
	public void test() {

	}

	public void test(int age) {

	}

	protected void test(int a, int b) {

	}

	public void test(String name) {

	}
	
	private String test(String name,String sex) {
		return name + sex;
	}
}
