package com.mjw.asyn.com;
/**
 * 初始化CallBackBody,创建线程执行CallBackBody的方法
 * @author admin
 *
 */
public class CallBackTask {
	private CallBackBody body;

	public CallBackTask(CallBackBody body) {
		this.body = body;
	}

	protected void start(final Object context) {
		final Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					body.execute(context);
				} catch (Exception e) {
					e.printStackTrace();
					body.onFailure(context);
				}
				body.onSuccess(context);
			}
		});
		t.start();
	}
}