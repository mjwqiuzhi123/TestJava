package com.mjw.zookeeper.config.test;
import org.I0Itec.zkclient.IZkDataListener;  
import org.I0Itec.zkclient.ZkClient;  
  
public class ZkGetConfigClient {  
	private static boolean flag = true;
    private Config config;  
  
    public Config getConfig() {  
        ZkClient zk = new ZkClient("39.105.8.31:2181,39.105.8.31:2182,39.105.8.31:2183");  
        config = (Config)zk.readData("/zkConfig");  
        System.out.println("加载到配置："+config.toString());  
          
        //监听配置文件修改  
        zk.subscribeDataChanges("/zkConfig", new IZkDataListener(){  
            @Override  
            public void handleDataChange(String dataPath, Object data)  
                    throws Exception {  
                config = (Config) data;  
                System.out.println("监听到配置文件被修改："+config.toString());  
            }  
  
            @Override  
            public void handleDataDeleted(String dataPath) throws Exception {  
                config = null;  
                System.out.println("监听到配置文件被删除");  
            }  
              
        });  
        return config;  
    }  
    public static void main(String[] args) throws InterruptedException {  
        ZkGetConfigClient client = new ZkGetConfigClient();  
        client.getConfig();  
        System.out.println(client.config.toString());
        while(flag){
        	Thread.sleep(100);
        }
    }  
  
      
}  