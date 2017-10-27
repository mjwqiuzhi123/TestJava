package com.mjw.reflect.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DumpMethods {
	
	public static void main(String[] args) {
		getMethodAndField();
	}
	
	//获得方法名及字段名
	public static void getMethodAndField(){
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName("java.util.Calendar");
			Method m[] = clazz.getDeclaredMethods();
			Field f[] = clazz.getDeclaredFields();
			
			for(int i = 0; i < m.length; i++){
				System.out.println(m[i]);
			}
			
			System.out.println("....................................................................................");
			
			for(Field ff : f){
				System.out.println(ff);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获得类名
	public static void getClassObj(){
		Class<?> clz1 = String.class;
		Class<?> clz2 = null;
		String str = null;
		try {
			clz2 = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			str = (String) clz1.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(clz1.getName());
		System.out.println(clz2.getName());
	}
	
	public static void getConstructor(){
		String str = "aaa";
		try {
			System.out.println(String.class.getConstructor(StringBuffer.class));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
