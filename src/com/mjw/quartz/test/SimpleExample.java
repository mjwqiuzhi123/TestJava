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

		// 1������ģʽ(��ȡ������)
		// ����Scheduler��Factory������STDΪQuartzĬ�ϵ�Factory���������������ʵ���Լ���Factory;Job��Trigger�����
		SchedulerFactory sf = new StdSchedulerFactory();
		// 2��ͨ��SchedulerFactory���Scheduler����
		Scheduler sched = sf.getScheduler();

		log.info("------- Initialization Complete -----------");

		// 3��org.quartz.DateBuilder.evenMinuteDate <��һ����> -- ͨ��DateBuilder����Date
		Date runTime = DateBuilder.evenMinuteDate(new Date()); // ��ǰʱ�����һ����

		log.info("------- Scheduling Job  -------------------");

		// 4��org.quartz.JobBuilder.newJob --ͨ��JobBuilder����Job
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job1", "group1").build();

		// 5��ͨ��TriggerBuilder���й���
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1").startAt(runTime).build();

		// 6������ģʽ����װ�������<JOB��Trigger>
		sched.scheduleJob(job, trigger);

		// [group1.job1] will run at:
		log.info(job.getKey() + " will run at: " + runTime);

		// 7��start
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
		// 8��ͨ��Scheduler�������õ�Trigger��Job
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {
		SimpleExample example = new SimpleExample();
		example.run();
	}
}
