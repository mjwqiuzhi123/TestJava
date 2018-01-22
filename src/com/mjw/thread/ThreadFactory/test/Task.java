package com.mjw.thread.ThreadFactory.test;

import java.util.Currency;
import java.util.concurrent.TimeUnit;

class Task implements Runnable  
{  
   @Override  
   public void run()  
   {  
      try  
      {  
         TimeUnit.SECONDS.sleep(2);
         System.out.println(Thread.currentThread().getName());
      } catch (InterruptedException e)  
      {  
         e.printStackTrace();  
      }  
   }  
}  