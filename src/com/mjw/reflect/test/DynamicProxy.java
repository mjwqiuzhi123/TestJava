/**
 * @author online
 */
package com.mjw.reflect.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyInvocationHandler demo = new MyInvocationHandler();
		Subject sub = (Subject) demo.bind(new RealSubject());
		String info = sub.say("Rollen", 20);
		System.out.println(info);
	}

}

interface Subject {
	public String say(String name, int age);
}

class RealSubject implements Subject {
	@Override
	public String say(String name, int age) {
		return name + "  " + age;
	}
}

class MyInvocationHandler implements InvocationHandler {
	private Object obj = null;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before");
		Object temp = method.invoke(this.obj, args);
		System.out.println("after");
		return temp;
	}

	public Object bind(Object obj) {
		this.obj = obj;
//		System.out.println(obj.getClass().getClassLoader().toString());
//		Class<?>[] clazz = obj.getClass().getInterfaces();
//		for(Class<?> c : clazz){
//			System.out.println(c.getName());
//		}
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

}
