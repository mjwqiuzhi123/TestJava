package com.mjw.array.test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tokenCount = new int[1];
		//System.out.println(tokenCount[0]);
		test1();
	}
	
	//数组转为list(Arrays)
	public static void test(){
		String[] str = {"a","b","c"};
		java.util.List<String> l = Arrays.asList(str);
		for(int i = 0; i < l.size(); i++){
			System.out.println(l.get(i));
		}
	}

	//数组转为list(Collections)
	public static void test1(){
		String[] userid = {"aa","bb","cc"};
		ArrayList<String> userList = new ArrayList<String>();
		Collections.addAll(userList, userid);
		for(String str : userList){
			System.out.println(str);
		}
		int a  = (int) (23*1.2/5);
		System.out.println(a);
		System.out.println((int)(23*1.2));
	}
	
	public static void test2() {
		if (true) {
			int a = 0;
		} else {
			int b = 0;
		}
	}
}
