package com.mjw.other.test;
public class Test01 {
	//private Test01 instence = new Test01();
	private int a;
	public int b;
	private static Test01 instence21 = new Test01();

    static{  
        System.out.println(instence21);  
    }  
	
	public Test01() {

	}

	public static void main(String[] args) {
		try {
			Test01 t = new Test01();
			System.out.println("try");
		} catch (Exception e) {
			System.out.println("catch");
		}
	}
}