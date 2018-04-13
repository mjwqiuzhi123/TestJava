package com.mjw.zookeeper.config.test;

public class ZkConfigTest {  
  
    public static void main(String[] args) {  
        ZkConfigMag mag = new ZkConfigMag();  
        Config config = mag.downLoadConfigFromDB();  
        System.out.println("....�������ݿ�����...."+config.toString());  
        mag.syncConfigToZk();  
        System.out.println("....ͬ�������ļ���zookeeper....");  
          
        //Ъ�ᣬ�������Ƚ�����  
        try {  
            Thread.sleep(10000);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
        mag.upLoadConfigToDB("mjwqiuzhi123", "endeavor");  
        System.out.println("....�޸������ļ�...."+config.toString());  
        mag.syncConfigToZk();  
        System.out.println("....ͬ�������ļ���zookeeper....");  
          
          
    }  
      
} 