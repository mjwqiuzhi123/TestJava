package com.mjw.outerInner.test;

public class Outer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer(); 
        Outer.Inner.test(); 
		Inner in = new Inner();
	}
	
	//内部类内部如果含有static修饰的变量和方法，那么这个内部类必须使用static修饰
	public static class Inner{
		static String i = "i am static var";
		public static void test(){
			System.out.println("i am static method");
			//return Outer.this;
		}
	}

	public class Inner1{
		public Outer test(){
			return Outer.this;
		}
	} 
}
