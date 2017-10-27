package com.mjw.interface1.test;

public class TestInterface implements Say{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestInterface();
		System.out.println("over!");
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