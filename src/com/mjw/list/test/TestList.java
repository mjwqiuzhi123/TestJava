package com.mjw.list.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		List<String> list = new MyList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		test(list);
		test1();
	}

	public static void test(List<String> list) {
		List<String> l = new ArrayList<String>();
		l.add("A");
		l.addAll(list);
		for (String str : l) {
			System.out.println(str);
		}
	}
	
	public static void test1(){
		LinkedList<String> l = new LinkedList<String>();
		l.add("m");
		l.add("J");
		l.add("W");
	}
}
