package com.mjw.reflect.test;

class Test{

}

public class ClassLoader {
	public static void main(String[] args) {
		Test test = new Test();
		String classLoader = test.getClass().getClassLoader().getClass().getName();
		System.out.println(classLoader);
		String str = new String();
	}
}
