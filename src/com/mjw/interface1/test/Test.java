package com.mjw.interface1.test;

public abstract class Test implements Hello {
	int a = 1;
}

interface Hello{
	public static final int a = 0;//��������̬��final
	
	public void say();
	
	public void smile();
}