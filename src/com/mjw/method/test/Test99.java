/*
 * 99�˷���
 */
package com.mjw.method.test;

public class Test99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testZS();
	}

	// 99�˷���
	public static void test1() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
			}
			System.out.println();
		}
	}

	// ������(ֻ�ܱ�1�ͱ�������������Ϊ����)
	public static void testSS() {
		int i, n, k = 0;
		for (n = 2; n <= 100; n++) { // 3~100��������
			i = 2;
			while (i <= n) {
				if (n % i == 0)
					break; // ��������˵��n��������������ѭ��
				i++;
			}

			if (i == n) { // ���i==n��˵��n���ܱ�2~n-1������������
				k++; // ͳ��������ĸ���
				if (k % 6 == 0) // ÿ���5������
					System.out.println();
			}
		}
	}
	
	public static void testZS(){
		int num = 0;
		boolean b = true;
		long time = System.currentTimeMillis();
		for(int i = 2; i <= 10000; i++){
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					b = false;
					break;
				}
			}
			
			if(b == true){
				System.out.print(i + " ");
				num++;
				if(num % 5 == 0)
					System.out.println();
			}
			else
				b = true;
		}
		System.out.println(System.currentTimeMillis() - time);
	}
}
