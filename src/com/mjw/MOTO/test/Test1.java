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

	// 访问修饰符
	public static void test1() {
		/*
		 * 访问权限 类 包 子类 其他包
		 * 
		 * 　　　　 public ∨ ∨ ∨ ∨ （对任何人都是可用的）
		 * 
		 * 　　　　 protect ∨ ∨ ∨ ×　　　 （继承的类可以访问以及和private一样的权限）
		 * 
		 * 　　　　 default ∨ ∨ × ×　　　 （包访问权限，即在整个包内均可被访问）
		 * 
		 * 　　　　 private ∨ × × ×　　　 （除类型创建者和类型的内部方法之外的任何人都不能访问的元素）
		 */
	}

	// JAVA变量的命名规则
	public static void test2() {
		/*
		 * 对于Java来说，命名规则是很明确的。 包名，使用网络地址倒置，小写，如com.myssh.action。
		 * 类名，大写开头，驼峰写法，如LoginAction。 方法名，小写开头，驼峰写法，如getUser()。
		 * 变量名，小写开头，驼峰写法，如userId。 常量名，大写开头，下划线分割，如MAX_LENGTH。
		 */
		String $persoms = "";
		// String *point = "";不合法
		String _person = "mjw";
	}

	// 反射方法集锦
	public static void test3() {
		try {
			Class<?> clazz = Class.forName("com.mjw.MOTO.test.Test1");

			Field[] sf = clazz.getFields();
			for(Field f : sf){
				System.out.println("参数名称：" + f.getName() + "参数修饰符："
						+ f.getModifiers());
			}
			System.out.println("*****************************");
			Field[] obf = clazz.getDeclaredFields();
			for (Field f : obf) {
				System.out.println("参数名称：" + f.getName() + "参数修饰符："
						+ f.getModifiers());
			}
			System.out.println("*****************************");
			Constructor<?>[] cons = clazz.getDeclaredConstructors();
			for (Constructor<?> con : cons) {
				System.out.println("参数个数：" + con.getParameterCount() + "参数修饰符："
						+ con.getModifiers());
			}
			System.out.println("*****************************");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
