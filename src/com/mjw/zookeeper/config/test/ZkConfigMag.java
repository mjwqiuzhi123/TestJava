package com.mjw.zookeeper.config.test;
import org.I0Itec.zkclient.ZkClient;  
  
public class ZkConfigMag {  
  
    private Config config;  
    /** 
     * 从数据库加载配置 
     */  
    public Config downLoadConfigFromDB(){  
        //getDB  
        config = new Config("nm", "pw");  
        return config;  
    }  
      
    /** 
     * 配置文件上传到数据库 
     */  
    public void upLoadConfigToDB(String nm, String pw){  
        if(config==null)config = new Config();  
        config.setUserNm(nm);  
        config.setUserPw(pw);  
        //updateDB  
    }  
      
    /** 
     * 配置文件同步到zookeeper 
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