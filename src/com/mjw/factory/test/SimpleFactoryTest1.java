/**
 * 简单工厂模式
 */
package com.mjw.factory.test;

public class SimpleFactoryTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fruit f1=Factory.getInstance("Orange");
		Fruit f2=Factory.getInstance("Orange");
        f1.eat();
        System.out.println(f1);
        System.out.println(f2);
	}

}

interface Fruit {
	public abstract void eat();
}

class Apple implements Fruit {
	public void eat() {
		System.out.println("Apple");
	}
}

class Orange implements Fruit {
	public void eat() {
		System.out.println("Orange");
	}
}

// 构造工厂类
// 也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
class Factory {
	public static Fruit getInstance(String fruitName) {
		Fruit f = null;
		if ("Apple".equals(fruitName)) {
			f = new Apple();
		}
		if ("Orange".equals(fruitName)) {
			f = new Orange();
		}
		return f;
	}
}
