package com.mjw.system.test;

public class Test {

	public static void main(String[] args) {
//		String osName = System.getProperty("os.name");// ����ϵͳ����
//		String osVer = System.getProperty("os.version");// ����ϵͳ�汾
//		String uName = System.getProperty("user.name");// �û�����
//		String uHome = System.getProperty("user.home");// �û���Ŀ¼
//		String uDir = System.getProperty("user.dir");// �û���ǰ�Ĺ���Ŀ¼
//		System.out.println(osName + " v" + osVer);
//		System.out.println(uName);
//		System.out.println(uHome);
//		System.out.println(uDir);
		test();
	}
	
	// ���ڿɱ�����Ĳ���
	public static void test(Object...o){
		System.out.println(o.toString());
	}

}
	