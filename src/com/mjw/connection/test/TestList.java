package com.mjw.connection.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
		test2();
	}

	public static void test1() {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		// test linkedlist
		long time1 = System.currentTimeMillis();
		for (int m = 0; m < 20000; m++) {
			linkedlist.add(m); // 当在200000条数据之前插入20000条数据时，LinkedList只用了1125多ms.这就是LinkedList的优势所在
			System.out.print(linkedlist.get(m) + " ");
		}

		System.out.println();
		System.out.println("链表中的第一个元素：" + linkedlist.getFirst());
		System.out.println("链表中的最后一个元素：" + linkedlist.getLast());

		long time2 = System.currentTimeMillis();
		System.out.print("batch linkedlist add:");
		System.out.println(time2 - time1);
		for (int i = 0; i < linkedlist.size(); i++) {
			System.out.print(linkedlist.get(i) + " ");
		}
		long time3 = System.currentTimeMillis();
		System.out.println("遍历时间:" + (time3 - time2));

		// test arraylist
		long time4 = System.currentTimeMillis();
		for (int n = 0; n < 20000; n++) {
			arraylist.add(0, n); // 当在200000条数据之前插入20000条数据时，ArrayList用了18375多ms.时间花费是arraylist的近20倍(视测试时机器性能)
			System.out.print(arraylist.get(0) + " ");
		}
		long time5 = System.currentTimeMillis();
		System.out.print("batch arraylist add:");
		System.out.println(time5 - time4);
		for (int i = 0; i < arraylist.size(); i++) {
			System.out.print(arraylist.get(i) + " ");
		}
		long time6 = System.currentTimeMillis();
		System.out.println("遍历时间:" + (time6 - time5));
	}

	public static void test2() {
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.add("5");
		System.out.println("链表的第一个元素是 : " + lList.getFirst());
		System.out.println("链表最后一个元素是 : " + lList.getLast());
	}
}
