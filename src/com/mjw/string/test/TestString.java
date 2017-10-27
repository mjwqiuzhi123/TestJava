package com.mjw.string.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestString {
	private static String str;
	public static void main(String[] args) {
		testNull();
	}
	
	//
	public static void testNull(){
		String a = null;
		a += "";
		a += "a";
		System.out.println(a);
		System.out.println("" + null == null);
	}
	
	//字符串的hashcode是根据字符串的内容来来级的计算的，和字符串的地址无关！
	public static void testHash(){
		String s = "abc";
		String str = new String("abc");
		System.out.println(s.hashCode());
		System.out.println(str.hashCode());
		System.out.println(s.equals(str));
		System.out.println(s == str);
	}
	
	//非字符串的hashcode测试
	public static void testHash1(){
		//map.toString()
		Map<String, String> map = new HashMap<String, String>();
		map.put("mjw", "26");
		map.put("mmz", "11");
		System.out.println(map.hashCode());
		System.out.println(map.toString());
		//list.toString();
		List<String> l = new ArrayList<String>();
		l.add("mjw");
		l.add("mmz");
		System.out.println(l.hashCode());
		System.out.println(l.toString());
		//对象.toString();
		Object ob = new Object();
		System.out.println(ob.toString());
	}
	
	//1将字符串转换为字节数组，测试不同编码格式下的字节长度！
	//2将字符串转换为字符数组
	public static void getBytes(){
		String str = "小浣熊！！！a";
		byte[] b = str.getBytes();
		for(byte bb : b){
			System.out.println(bb);
		}
		char[] ch = str.toCharArray();
		for(char c : ch){
			System.out.print(c + " ");
		}
	}
	
	public static void testSubstring(){
		System.out.println(str);
	}
	
	public static void testSpilt(){
		String str = "2,447.50,2,474.21,2,447.50,2,474.16";
		String[] strs = str.split(",");
		for(String f : strs)
			System.out.println(f);
	}
	
	public static void makeData() throws Exception {
		String imei = "N0000000000";
		String imsi = "M0000000000";
		String phone = "15845678901";
		File file = new File("C:\\Users\\admin\\Desktop\\mmz.csv");
		if (!file.exists()) {
			file.createNewFile();
		}

		// 往文件中写入字符串
		FileOutputStream fos = new FileOutputStream(file);
		for (int i = 1; i <= 1000000; i++) {
			//imei
			imei = imei.substring(0,(imei.length() - String.valueOf(i).length()));
			imei = imei + i + ",";
			//imsi
			imsi = imsi.substring(0,(imsi.length() - String.valueOf(i).length()));
			imsi = imsi + i + ",";
			//phon
			phone = phone.substring(0,(phone.length() - String.valueOf(i).length()));
			phone = phone + i + ",";
			
			imei = imei + imsi + phone;
			
			//省(奇数为北京)
			if (i % 2 != 0) {
				imei = imei + "北京,747,";
			} else {
				imei = imei + "河北,63,";
			}
			
			//省(尾数小于5的为北京)
//			if (i % 10 < 5) {
//				imei = imei + "北京,747,";
//			} else {
//				imei = imei + "河北,63,";
//			}
			
			//市
			if(i%10 == 2){
				imei = imei + "承德,82,";
			}else if(i%10 == 4){
				imei = imei + "保定,68,";
			}else if(i%10 == 6){
				imei = imei + "邯郸,74,";
			}else if(i%10 == 8){
				imei = imei + "邢台,76,";
			}else if(i%10 == 0){
				imei = imei + "廊坊,72,";
			}else{
				imei = imei + "北京,748,";
			}
			
			//local
			if(i%2 != 0){
				imei = imei + "北京星城国际大厦501室,";
			}else{
				imei = imei + "河北燕赵故地,";
			}
			
			//model
			if(i%5 == 0){
				imei = imei + "A 9+,";
			}else if(i%5 == 1){
				imei = imei + "A-7,";
			}else if(i%5 == 2){
				imei = imei + "A0001,";
			}else if(i%5 == 3){
				imei = imei + "A01,";
			}else{
				imei = imei + "a0255,";
			}
			
			//level
//			if(i%5 == 0){
//				imei = imei + "低,1,";
//			}else if(i%5 == 1){
//				imei = imei + "中,2,";
//			}else if(i%5 == 2){
//				imei = imei + "高,3,";
//			}else if(i%5 == 3){
//				imei = imei + "中,2,";
//			}else{
//				imei = imei + "高,3,";
//			}
//			
			//game
			if(i%10 == 1 || i%10 == 4 || i%10 == 6 || i%10 == 7 ||i%10 == 8){
				imei = imei + "0,";
			}else if(i%10 == 5){
				imei = imei + "-1,";
			}else{
				imei = imei + "1,";
			}
			
			//buy
			if(i%10 == 2 || i%10 == 3 || i%10 == 1 || i%10 == 6){
				imei = imei + "0,";
			}else if(i%10 == 5 || i%10 == 9){
				imei = imei + "-1,";
			}else{
				imei = imei + "1,";
			}
			
			//travel
			if(i%10 == 1 || i%10 == 2 || i%10 == 6 || i%10 == 7 ||i%10 == 9){
				imei = imei + "0\r\n";
			}else if(i%10 == 5){
				imei = imei + "-1\r\n";
			}else{
				imei = imei + "1\r\n";
			}
			System.out.println(imei);
			
			byte[] bytes = new byte[512];
			bytes = imei.getBytes(); // 新加的
			int b = bytes.length; // 改
			fos.write(bytes, 0, b);
			imei = "N0000000000";
			imsi = "M0000000000";
			phone = "15845678901";
		}
		fos.close();
	}
	
	public static void makeDate1() throws IOException{
		File file = new File("C:\\Users\\admin\\Desktop\\mmz.csv");
		if (!file.exists()) {
			file.createNewFile();
		}

		// 往文件中写入字符串
		FileOutputStream fos = new FileOutputStream(file);
		for(int i = 0;i<1000;i++){
			
		}
	}
}
