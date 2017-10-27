package com.mjw.cycle.test;

public class TestWhile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3();
	}

	// while
	public static void test() {
		int num = 1;
		while (true) {// 无限循环！
			System.out.println(num++);
		}
	}

	// do...while
	public static void test1() {
		do {
			System.out.println("hello");
		} while (false);
	}

	// return结束循环
	public static void test2() {
		int i = 0;
		while (true) {
			System.out.println(i);
			i++;
			if(i == 10)
				return;
		}
	}
	
	// break跳出指定标记处
	public static void test3(){
		for(int i = 0; i < 30; i++){
			int j = 0;
			over:while(true){// 标记为over
				j++;
				if(j == 3)
					break over;
				System.out.println(i);
			}
		}
	}
}
