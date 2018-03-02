package com.mjw.interface1.test;

public class TestInterface extends TestFinalField implements Say{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestInterface();
		System.out.println("over!");
		System.out.println(num);
		test();
	}
	
//	override（重写）
//
//	　　 1、方法名、参数、返回值相同。
//
//	　　 2、子类方法不能缩小父类方法的访问权限。
//
//	　　 3、子类方法不能抛出比父类方法更多的异常(但子类方法可以不抛出异常)。
//
//	　　 4、存在于父类和子类之间。
//
//	　　 5、方法被定义为final不能被重写。
	public void test1(String name){//父类中
		
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello word");
	}

}

interface Say{
	public void say();
}

class Test1 extends Test{
	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void smile() {
		// TODO Auto-generated method stub
		
	}
	
}

class TestFinalField{
	final static int num = 5;
	public static final void test(){
		System.out.println("I am static final method!");
	}
	
	public final void test1(){
		System.out.println("I am final method!");
	}
}