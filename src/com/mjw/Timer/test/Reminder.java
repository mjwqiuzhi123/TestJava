package com.mjw.Timer.test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
* Simple demo that uses java.util.Timer to schedule a task to execute
* once 5 seconds have passed.
*/

public class Reminder {
    Timer timer;

    public Reminder(int seconds) throws InterruptedException {
        timer = new Timer();
        timer.schedule(new RemindTask(),0,seconds*1000);
        Thread.sleep(5*1000);
        timer.cancel(); // ÖÕÖ¹¶¨Ê±Æ÷
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            //timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("About to schedule task.");
        new Reminder(2);
        System.out.println("Task scheduled."); 
    }
}
