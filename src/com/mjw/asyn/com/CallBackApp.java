package com.mjw.asyn.com;

/**
 * 先定义了一个CallBackTask，做为外层的面子工程，其主要工作为start
 * 开始一个异步操作，然而真正干活的是CallBackBody，它里面的execute才是真正要处理的事情
 * ，如果成功，则触发onSucess，否则触发onFailure。
 * 
 * CallBackApp做为最终的运行舞台，这里面还得单独跑一个线程，来启动CallBackTask，这样才不会阻塞后面的处理。
 * 
 * @author admin
 * 
 */
public class CallBackApp {
	//该测试的入口类
	public static void main(String[] args) {

		System.out.println("准备开始执行异步任务...");

		final Object context = "上下文信息";

		new CallBackTask(new CallBackBody() {
			@Override
			void execute(Object context) throws Exception {
				System.out.println("\n正在执行耗时操作...");
				System.out.println(context);
				Thread.sleep(5000);
				System.out.println("\n执行完成！");
			}

			void onSuccess(Object context) {
				System.out.println("\n成功后的回调函数...");
				System.out.println(context);
			}

			void onFailure(Object context) {
				System.out.println("\n失败后的回调函数...");
				System.out.println(context);
			}
		}).start(context);

		System.out.println("\n异步任务已经开始，请等待完成...");
	}
}