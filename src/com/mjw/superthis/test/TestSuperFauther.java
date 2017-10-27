package com.mjw.superthis.test;

public class TestSuperFauther {
	
	public static int a = 1;
	public int b = 1;

	static{
		System.out.println("我是父类静态方法体");
	}
	
	{
		System.out.println("我是父类方法体");
	}
	
	// 默认构造函数，可以不显式出现
	public TestSuperFauther(){
		System.out.println("我是父类的默认构造函数！");
	}
	
	// 可以覆盖隐式的不带参数的构造函数
	public TestSuperFauther(String param){
		System.out.println("父类接收来自子类的参数name:" + param);
	}
	
	// 子类重写父类的方法，可见性必须不小于父类的可见性
	@Override
	public String toString(){
		return "父类";
		
	}
	
	// 自定义方法不能加以下注解
	// @Override
	public void test(){
		System.out.println("@Override test");
	}
}
