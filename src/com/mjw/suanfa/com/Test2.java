/**
 * �ж������ķ�������һ�����ֱ�ȥ��2��sqrt(�����)������ܱ������� ���������������������֮�������� 
 */
package com.mjw.suanfa.com;

public class Test2 {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		int count = 0;
		// ��ʼֵ��Ϊtrue
		boolean flag = true;
		for (int i = 10; i <= 100; i++) {
			
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			// ��Ϊtrueʱ��Ҳ���ǳ���1�ͱ�����ܳ���
			if (flag) {
				count++;
				System.out.print(i + " ");
			}
			flag = true;
		}
		System.out.println("\r\n" + count);
	}

}
