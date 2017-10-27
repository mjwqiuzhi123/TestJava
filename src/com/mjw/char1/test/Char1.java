package com.mjw.char1.test;
/**
 * 关于字符的测试
 * @author admin
 *
 */
public class Char1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test(){
		// char所表示的范围是0-65535,当定义一个变量用字符表示需要加单引号，当用数字表示时不用加单引号（0-9也可以表示为ascll字符，即可以用单引号包围）
		char b = '0';
		char a = 65;// a
		// 当与int类型相加时，自动转换为int类型(int类型的表示范围大于char的表示范围)
		System.out.println(b + 1 + "c");
		System.out.println(a + "c");
		System.out.println(a);
	}
}
