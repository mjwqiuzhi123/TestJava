/**
 * @author mjw
 * @date 20161031
 */
package com.mjw.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {
	private static String mjw = "mjw"; 
	public static String mmz = "mmz"; 
	String name = null;
	int age = 0;
	
	public Person(){
		
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(int age){
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.age;
	}
}

public class Reflect1 {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1(){
		Person cn = new Person();
		Field f = cn.getClass().getFields()[0];
		String name = cn.getClass().getName();
		Method[] m = cn.getClass().getDeclaredMethods();
		for(Method mm : m){
			System.out.println(mm.getName());
		}
		System.out.println(name);
		System.out.println(f);
		System.out.println(f.getName());
	}
	
	public static void test2(){
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		Person cn1 = null;
		Person cn2 = null;
		try {
			demo1 = Class.forName("com.mjw.reflect.test.Person");
			try {
				cn1 = (Person) demo1.newInstance();
				cn2 = (Person) demo1.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		demo2 = new Person().getClass();
		demo3 = Person.class;
		System.out.println(demo1.getName());
		System.out.println(demo2.getName());
		System.out.println(demo3.getName());
		System.err.println(cn1 != cn2);
	}
	
	public static void test3(){
		Class<?> c = null;
		Person cn = null;
		try {
			c = Class.forName("com.mjw.reflect.test.Person");
			cn = (Person) c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cn.setAge(27);
		cn.setName("mjw");
		
		System.out.println(cn);
	}
	
	public static void test4(){
		Class<?> demo = null;
		Person person1 = null;
		Person person2 = null;
		Person person3 = null;
		Person person4 = null;
		try {
			demo = Class.forName("com.mjw.reflect.test.Person");
			Constructor<?>[] c = demo.getConstructors();
			person1 = (Person) c[0].newInstance(99);
			person2 = (Person) c[1].newInstance("mjw");
			person3 = (Person) c[2].newInstance();
			//person1 = (Person) demo.newInstance();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		System.out.println(person3.toString());
	}
}
