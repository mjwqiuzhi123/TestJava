/**
 * FutureTask测试
 * get()从任务取回结果，如果有返回结果则直接返回值，如果无返回结果则阻塞等待！
 */
package com.mjw.thread.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class T {
	public static void main(String[] args) {  
        fun();  
    }  
  
    public static void fun() {
    	final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hhmmss");
        ExecutorService executor = Executors.newSingleThreadExecutor();  
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {  
  
            @Override  
            public String call() throws Exception {  
                String bg = sdf.format(new Date());
                System.out.println("call begin: " + new Date().getTime());  
                StringBuilder sb = new StringBuilder();  
                for (int i = 0; i < 10000000; i++) {  
                    sb.append(i).append(",");  
                }  
                System.out.println("call end: " + (new Date().getTime()));  
                return sb.toString();  
            }  
        });  
        executor.execute(task);  
        System.out.println("execute之后 " + new Date().getTime()); 
        long be = 0;
        try {  
            // System.out.println(task.get());
        	be = new Date().getTime();
            task.get();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
        System.out.println("第一次get():" + (new Date().getTime() - be)); 
        long be1 = 0;
        try {
        	be1 = new Date().getTime();
            task.get();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
        System.out.println("第2次get():" + (new Date().getTime() - be1)); 
        executor.shutdown();  
    }  
}
