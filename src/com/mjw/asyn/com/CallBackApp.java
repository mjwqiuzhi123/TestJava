package com.mjw.asyn.com;

/**
 * �ȶ�����һ��CallBackTask����Ϊ�������ӹ��̣�����Ҫ����Ϊstart
 * ��ʼһ���첽������Ȼ�������ɻ����CallBackBody���������execute��������Ҫ���������
 * ������ɹ����򴥷�onSucess�����򴥷�onFailure��
 * 
 * CallBackApp��Ϊ���յ�������̨�������滹�õ�����һ���̣߳�������CallBackTask�������Ų�����������Ĵ���
 * 
 * @author admin
 * 
 */
public class CallBackApp {
	//�ò��Ե������
	public static void main(String[] args) {

		System.out.println("׼����ʼִ���첽����...");

		final Object context = "��������Ϣ";

		new CallBackTask(new CallBackBody() {
			@Override
			void execute(Object context) throws Exception {
				System.out.println("\n����ִ�к�ʱ����...");
				System.out.println(context);
				Thread.sleep(5000);
				System.out.println("\nִ����ɣ�");
			}

			void onSuccess(Object context) {
				System.out.println("\n�ɹ���Ļص�����...");
				System.out.println(context);
			}

			void onFailure(Object context) {
				System.out.println("\nʧ�ܺ�Ļص�����...");
				System.out.println(context);
			}
		}).start(context);

		System.out.println("\n�첽�����Ѿ���ʼ����ȴ����...");
	}
}