package com.mjw.asyn.com;
/**
 * 实际要执行任务的类
 * @author admin
 *
 */
public abstract class CallBackBody {

	void onSuccess(Object context) {
		System.out.println("onSuccess");
	}

	void onFailure(Object context) {
		System.out.println("onFailure");
	}

	abstract void execute(Object context) throws Exception;
}