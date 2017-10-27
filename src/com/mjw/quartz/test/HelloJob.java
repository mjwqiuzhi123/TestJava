package com.mjw.quartz.test;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob implements Job{

	private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  
	  
    /** 
     * Job，Job需要一个公有的构造函数，否则Factory无法构建 
     */  
    public HelloJob() {  
    }  
  
    /** 
     * 实现execute方法 
     */  
    public void execute(JobExecutionContext context) throws JobExecutionException {  
    	_log.debug("test");
        _log.info( "Hello World! - " + new Date()); 
        System.out.println("hello");
    }  

}
