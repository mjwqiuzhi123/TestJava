package com.mjw.thread.test;

public class SyncThreadTest {

	public static void main(String args[]) {
		final Bank bank = new Bank();

		Thread tadd = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bank.addMoney(100);
					//bank.lookMoney("��Ǯ");
					System.out.println("\n");

				}
			}
		});
		
		Thread tadd1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bank.addMoney(100);
					bank.lookMoney("��Ǯ");
					System.out.println("\n");

				}
			}
		});

		Thread tsub = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					bank.subMoney(100);
					bank.lookMoney("ȡǮ");
					System.out.println("\n");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		//tsub.start();

		tadd.start();
		tadd1.start();
	}

}

class Bank {

	private int count = 0;// �˻����

	// ��Ǯ
	public void addMoney(int money) {

		synchronized (this.getClass()) {
			count += money;
			System.out.println(System.currentTimeMillis() + "�����" + money);
			System.out.println("�˻����Ϊ��" + count);
		}
	}

	// ȡǮ
	public void subMoney(int money) {

		synchronized (this.getClass()) {
			if (count - money < 0) {
				System.out.println("����");
				return;
			}
			count -= money;
			System.out.println(+System.currentTimeMillis() + "ȡ����" + money);
		}
	}

	// ��ѯ
	public void lookMoney(String action) {
		System.out.println(action + "���˻���" + count);
	}
}
