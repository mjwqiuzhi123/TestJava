package com.mjw.colne.test;

public class ColneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test(){
		Person p = new Person("xx", 30);
		Person p1 = p.clone();
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		p.setAge(15);
		p.setName("yy");
		System.out.println("初始对象改变后，观察克隆对象。。。。。。。。。。。");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println("end");
	}

}

class Person implements Cloneable{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
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
	
	public Person clone(){
		Person p = null;
		try {
			p = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
