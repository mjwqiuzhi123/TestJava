package com.mjw.reflect.test;

public class Test20180228 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//���ַ�ʽ��ȡClass����
	public static void test() throws ClassNotFoundException{
		String s = "aaa";  
		  Class cls1 = s.getClass();//�����ȡ  
		  Class cls2 = String.class;//���ȡ  
		  Class cls3 = Class.forName("java.lang.String");//��������  
		  if (cls1 == cls2) {  
		   System.out.println(cls1 == cls2);  
		  }  
		  if (cls2 == cls3) {  
		   System.out.println(cls2 == cls3);  
		  }
		  System.out.println(cls1.getName());
		  System.out.println(cls2.getName());
		  System.out.println(cls3.getName());
	}
	
}
