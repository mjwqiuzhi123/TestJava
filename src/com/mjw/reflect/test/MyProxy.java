/**
 * @author mjw
 */
package com.mjw.reflect.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
	public static void main(String[] args) {
		Flower jh = new Juhua();
		MyHandler handler = new MyHandler(jh);
		Flower flo = handler.getProxy();
		flo.color();
	}
}

interface Flower{
	public void color();
}

class Juhua implements Flower{
	
	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("ºìÉ«µÄ¾Õ»¨");
	}
}

class MyHandler implements InvocationHandler{
	private Object ob;
	
	public MyHandler(Object ob){
		this.ob = ob;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("begin");
		method.invoke(ob, args);
		System.out.println("end");
		return null;
	}
	
	public Flower getProxy(){
		Flower flo = (Flower) Proxy.newProxyInstance(ob.getClass().getClassLoader(), ob.getClass().getInterfaces(), this);
		return flo;
	}
}
