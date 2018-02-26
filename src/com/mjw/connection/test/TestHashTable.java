package com.mjw.connection.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	// hashtable's test
	public static void test(){
		Map<String, String> map = new Hashtable<String, String>();
		map.put("aaa", "bbb");//hashtable的key和value都不能为NULL
		Iterator<Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Object o = it.next();
			String[] strArray = o.toString().split("=");
			System.out.println("key:" + strArray[0] + " value:" +strArray[1]);
		}
	}
	
	public static void test1(){
		Map map = new HashMap();
		map.put(null, null);// hashmap的key和value均可为Null
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Object o = it.next();
			String[] strArray = o.toString().split("=");
			System.out.println("key:" + strArray[0] + " value:" +strArray[1]);
		}
	}
	
	public static void test2(){
		Map hashMap = new HashMap();
		Map m = Collections.synchronizedMap(hashMap);
	}
}
