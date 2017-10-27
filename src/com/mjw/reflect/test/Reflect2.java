package com.mjw.reflect.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect2 {

	private String name;
	private String sex;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		test3();
		// test2();
	}

	// 获取类的字段
	public static void test1() {
		Class<Reflect2> c = Reflect2.class;
		Field[] f = c.getDeclaredFields();
		String[] strs = new String[f.length];
		for (int i = 0; i < f.length; i++) {
			strs[i] = f[i].getName();
			System.out.println(strs[i]);
		}
	}

	// 获取类的方法
	public static void test2() {
		Class<Reflect2> c = Reflect2.class;
		Method[] m = c.getDeclaredMethods();
		String[] ms = new String[m.length];
		for (int i = 0; i < m.length; i++) {
			ms[i] = m[i].getName();
			System.out.println(ms[i]);
		}
	}

	// 获取当前对象中字段的值
	public static void test3() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class cz = Class.forName("com.mjw.reflect.test.Reflect2");
		Object ob = cz.newInstance();
		Field[] f = cz.getDeclaredFields();
		for (Field ff : f) {
			// ff.setAccessible(true);
			Object o = ff.get(ob);
			if (o == null) {
				o = "";
			}
			System.out.println(o);
		}
	}

}
