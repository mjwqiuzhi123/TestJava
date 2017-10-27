package com.mjw.other.test;
/**
 * 将两个List中对应下标索引的值合并到一个Map中
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BianBian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listToMap();
	}

	public static void listToMap() {
		Map<String, String> map = new HashMap<String, String>();
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("a");
		list1.add("a");
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(111);
		list2.add(222);
		list2.add(333);
		list2.add(444);
		list2.add(null);
		//1
//		for (int i = 0; i < list1.size(); i++) {
//			if (map.get(list1.get(i)) == null)
//				map.put(list1.get(i), list2.get(i) + "");
//			else
//				map.put(list1.get(i),
//						map.get(list1.get(i)) + "|" + list2.get(i));
//		}
		//2
		for (int i = 0; i < list1.size(); i++) {
			if (!map.containsKey(list1.get(i)))
				map.put(list1.get(i), list2.get(i) + "");
			else
				map.put(list1.get(i),
						map.get(list1.get(i)) + "|" + list2.get(i));
		}
		System.out.println("遍历一：");
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
		System.out.println("遍历二：");
		for(Map.Entry<String, String> e : map.entrySet()){
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		System.out.println("遍历三：");
		Iterator<Entry<String, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<String, String> entry = entries.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		//System.out.println("遍历四：");
	}
}
