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
			linkedlist.add(m); // ����200000������֮ǰ����20000������ʱ��LinkedListֻ����1125��ms.�����LinkedList����������
			System.out.print(linkedlist.get(m) + " ");
		}

		System.out.println();
		System.out.println("�����еĵ�һ��Ԫ�أ�" + linkedlist.getFirst());
		System.out.println("�����е����һ��Ԫ�أ�" + linkedlist.getLast());

		long time2 = System.currentTimeMillis();
		System.out.print("batch linkedlist add:");
		System.out.println(time2 - time1);
		for (int i = 0; i < linkedlist.size(); i++) {
			System.out.print(linkedlist.get(i) + " ");
		}
		long time3 = System.currentTimeMillis();
		System.out.println("����ʱ��:" + (time3 - time2));

		// test arraylist
		long time4 = System.currentTimeMillis();
		for (int n = 0; n < 20000; n++) {
			arraylist.add(0, n); // ����200000������֮ǰ����20000������ʱ��ArrayList����18375��ms.ʱ�仨����arraylist�Ľ�20��(�Ӳ���ʱ��������)
			System.out.print(arraylist.get(0) + " ");
		}
		long time5 = System.currentTimeMillis();
		System.out.print("batch arraylist add:");
		System.out.println(time5 - time4);
		for (int i = 0; i < arraylist.size(); i++) {
			System.out.print(arraylist.get(i) + " ");
		}
		long time6 = System.currentTimeMillis();
		System.out.println("����ʱ��:" + (time6 - time5));
	}

	public static void test2() {
		LinkedList<String> lList = new LinkedList<String>();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.add("5");
		System.out.println("����ĵ�һ��Ԫ���� : " + lList.getFirst());
		System.out.println("�������һ��Ԫ���� : " + lList.getLast());
	}
}
