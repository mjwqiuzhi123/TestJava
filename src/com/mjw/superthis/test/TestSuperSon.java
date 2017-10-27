package com.mjw.superthis.test;

public class TestSuperSon extends TestSuperFauther{
	
	private int b = 2;
	/**
	 * @param args
	 * 
	 */
	
	public TestSuperSon(){
		//super();
	}
	
	public TestSuperSon(String par){
		super(par);
		System.out.println("我是子类构造函数");
	}
	
	// 类方法体
	static{
		System.out.println("我是子类静态方法体");
	}
	
	// 对象方法体
	{
		System.out.println(super.b);// super指父类对象
		System.out.println(this.b);// this指当前对象
		System.out.println("我是子类方法体");
	}
	
}
