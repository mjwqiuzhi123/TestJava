package com.mjw.Timer.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String[] args) throws ParseException {
		// test();
		test();
	}

	// scheduleAtFixedRate
	public static void test() throws ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		Date startDate = dateFormatter.parse("2017/07/13 14:42:00");
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println("execute task!"+ this.scheduledExecutionTime());
				 try {
					Thread.sleep(6 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 3 * 1000);
	}

	// schedule
	public static void test1() throws ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		Date startDate = dateFormatter.parse("2017/07/13 14:10:00");
		System.out.println("3s后执行  " +  new SimpleDateFormat(
				 "HH:mm:ss").format(new Date()));
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				 System.out.println("execute task!" + new SimpleDateFormat(
				 "HH:mm:ss").format(new Date()));
				 try {
					Thread.sleep(10 * 1000); // 当任务在执行周期内未执行完毕时（任务执行时间大于周期），任务执行完毕后立即执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 3 * 1000, 1000);// 3s后执行,1s执行一次
	}
}
