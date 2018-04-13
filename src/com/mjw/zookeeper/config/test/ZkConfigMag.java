package com.mjw.zookeeper.config.test;
import org.I0Itec.zkclient.ZkClient;  
  
public class ZkConfigMag {  
  
    private Config config;  
    /** 
     * �����ݿ�������� 
     */  
    public Config downLoadConfigFromDB(){  
        //getDB  
        config = new Config("nm", "pw");  
        return config;  
    }  
      
    /** 
     * �����ļ��ϴ������ݿ� 
     */  
    public void upLoadConfigToDB(String nm, String pw){  
        if(config==null)config = new Config();  
        config.setUserNm(nm);  
        config.setUserPw(pw);  
        //updateDB  
    }  
      
    /** 
     * �����ļ�ͬ����zookeeper 
     */  
    public void syncConfigToZk(){  
        ZkClient zk = new ZkClient("39.105.8.31:2181,39.105.8.31:2182,39.105.8.31:2183");  
        if(!zk.exists("/zkConfig")){  
            zk.createPersistent("/zkConfig",true);  
        }  
        zk.writeData("/zkConfig", config);  
        zk.close();  
    }  
}  