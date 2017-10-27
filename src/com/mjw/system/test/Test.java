package com.mjw.system.test;

public class Test {

	public static void main(String[] args) {
//		String osName = System.getProperty("os.name");// 操作系统名称
//		String osVer = System.getProperty("os.version");// 操作系统版本
//		String uName = System.getProperty("user.name");// 用户名称
//		String uHome = System.getProperty("user.home");// 用户主目录
//		String uDir = System.getProperty("user.dir");// 用户当前的工作目录
//		System.out.println(osName + " v" + osVer);
//		System.out.println(uName);
//		System.out.println(uHome);
//		System.out.println(uDir);
		test();
	}
	
	// 关于可变参数的测试
	public static void test(Object...o){
		System.out.println(o.toString());
	}

}
	