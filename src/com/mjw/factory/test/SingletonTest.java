package com.mjw.factory.test;

import java.io.File;
import java.io.IOException;

public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("");
		String path = f.getAbsolutePath();
		String path1 = f.getPath();
		String path2 = "";
		try {
			path2 = f.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path3 = f.getName();
		System.out.println(path);
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);
		
//		Fruit1 f1 = Factory1.getInstance("Banana");
//		f1.eat();
//		System.out.println(Factory1.getInstance("Banana"));
	}
}

	interface Fruit1 {
		public void eat();
	}

	//饿汉氏
	class Apple1 implements Fruit1 {
		private static Apple1 a = new Apple1();
		
		private Apple1(){}
		
		public static Apple1 getInstance(){
			return a;
		}
		
		public void eat() {
			System.out.println("Apple");
		}
	}

	//饿汉氏
	class Orange1 implements Fruit1 {
		
		private static Orange1 o = new Orange1();
		
		private Orange1(){}
		
		public static Orange1 getInstance(){
			return o;
		}
		
		public void eat() {
			System.out.println("Orange");
		}
	}
	
	//懒汉式
	class Banana implements Fruit1{
		private static Banana b = null;
		
		private Banana(){
			
		}
		
		public static synchronized Banana getInstance(){
			if(b == null){
				b = new Banana();
				return b;
			}else
			return b;
		}

		@Override
		public void eat() {
			System.out.println("吃香蕉！");
		}
	}

	// 构造工厂类(传统工厂方法)
	// 也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
	class Factory1 {
		public static Fruit1 getInstance(String fruitName) {
			Fruit1 f = null;
			if ("Apple".equals(fruitName)) {
				f = Apple1.getInstance();
			}
			if ("Orange".equals(fruitName)) {
				f = Orange1.getInstance();
			}
			if ("Banana".equals(fruitName)) {
				f = Banana.getInstance();
			}
			return f;
		}
	}

	class Factory2{
		public static Fruit1 getInstance(String fruitName){
			Fruit1 f = null;
			try {
				f = (Fruit1) Class.forName(fruitName).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return f;
		}
	}

