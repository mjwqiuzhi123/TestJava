package com.mjw.quartz.test;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleExample {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(SimpleExample.class);

		log.info("------- Initializing ----------------------");

		// 1、工厂模式(获取调度器)
		// 构建Scheduler的Factory，其中STD为Quartz默认的Factory，开发者亦可自行实现自己的Factory;Job、Trigger等组件
		SchedulerFactory sf = new StdSchedulerFactory();
		// 2、通过SchedulerFactory获得Scheduler对象
		Scheduler sched = sf.getScheduler();

		log.info("------- Initialization Complete -----------");

		// 3、org.quartz.DateBuilder.evenMinuteDate <下一分钟> -- 通过DateBuilder构建Date
		Date runTime = DateBuilder.evenMinuteDate(new Date()); // 当前时间的下一分钟

		log.info("------- Scheduling Job  -------------------");

		// 4、org.quartz.JobBuilder.newJob --通过JobBuilder构建Job
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job1", "group1").build();

		// 5、通过TriggerBuilder进行构建
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1").startAt(runTime).build();

		// 6、工厂模式，组装各个组件<JOB，Trigger>
		sched.scheduleJob(job, trigger);

		// [group1.job1] will run at:
		log.info(job.getKey() + " will run at: " + runTime);

		// 7、start
		sched.start();

		log.info("------- Started Scheduler -----------------");

		log.info("------- Waiting 65 seconds... -------------");
		try {
			// wait 65 seconds to show job
			Thread.sleep(65L * 1000L);
			// executing...
		} catch (Exception e) {
			//
		}

		// shut down the scheduler
		log.info("------- Shutting Down ---------------------");
		// 8、通过Scheduler销毁内置的Trigger和Job
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {
		SimpleExample example = new SimpleExample();
		example.run();
	}
}
