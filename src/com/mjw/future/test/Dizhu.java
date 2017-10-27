package com.mjw.future.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Dizhu {
	public static void main(String args[]) {
		Changgong worker = new Changgong();
		FutureTask<Integer> jiangong = new FutureTask<Integer>(worker);
		// ���߳�
		new Thread(jiangong).start();
		// main�߳�
		while (!jiangong.isDone()) {
			try {
				System.out.println("������...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int amount;
		try {
			amount = jiangong.get();
			System.out.println("����������,�Ͻ���" + amount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Changgong implements Callable<Integer> {

	private int hours = 8;
	private int amount;

	@Override
	public Integer call() throws Exception {
		while (hours > 0) {
			System.out.println("���˻���������");
			amount++;
			hours--;
			Thread.sleep(1000);
		}
		return amount;
	}
}
