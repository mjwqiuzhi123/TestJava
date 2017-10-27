package com.mjw.connection.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Set<String> set = new HashSet<String>();
			set = test(set);
			set = null;
			Thread.sleep(1000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Set<String> test(Set<String> set) {
		set.add("a");
		set.add("b");
		set.add("z");
		set.add("c");
		set.add("d");
		set.add("e");
		set.add("f");
		Iterator<String> i = set.iterator();// 先迭代出来
		while (i.hasNext()) {// 遍历
			System.out.println(i.next());
		}
		
		return set;
	}
}
