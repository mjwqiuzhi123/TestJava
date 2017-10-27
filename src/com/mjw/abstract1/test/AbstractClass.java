package com.mjw.abstract1.test;

public class AbstractClass {
	A ab = new A(){
		@Override
		public void test() {
		}
	};
	String mjw = A.test1();
	String name = C.name;
}

abstract class A{
	public abstract void test();
	
	public static String test1(){
		return "mjw";
	}
	
	public void test2(){
		
	}
}

class C{
	public static String name;
}