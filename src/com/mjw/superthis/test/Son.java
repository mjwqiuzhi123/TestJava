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
//		// 隐式调用super();
//	}

	public Son(String name, int age) {
		// this()和super()必须在构造函数的第一行！而且二者不可同时使用
		//super(name, age);
		this.age = age;
		this.name = name;
	}

	// 重写参数相同,返回类型也要相同
	@Override
	public String toString() {
		return name + age;
	}

	public static void main(String[] args) {
		//在静态方法中是不可以使用this的，this代表当前对象，静态方法先于对象加载到内存中
		//System.out.println(new Son().toString());
	}

	// 重载方法名必须相同，参数类型或个数肯定不相同
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
