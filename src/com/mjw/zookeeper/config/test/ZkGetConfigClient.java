package com.mjw.zookeeper.config.test;
import org.I0Itec.zkclient.IZkDataListener;  
import org.I0Itec.zkclient.ZkClient;  
  
public class ZkGetConfigClient {  
	private static boolean flag = true;
    private Config config;  
  
    public Config getConfig() {  
        ZkClient zk = new ZkClient("39.105.8.31:2181,39.105.8.31:2182,39.105.8.31:2183");  
        config = (Config)zk.readData("/zkConfig");  
        System.out.println("���ص����ã�"+config.toString());  
          
        //���������ļ��޸�  
        zk.subscribeDataChanges("/zkConfig", new IZkDataListener(){  
            @Override  
            public void handleDataChange(String dataPath, Object data)  
                    throws Exception {  
                config = (Config) data;  
                System.out.println("�����������ļ����޸ģ�"+config.toString());  
            }  
  
            @Override  
            public void handleDataDeleted(String dataPath) throws Exception {  
                config = null;  
                System.out.println("�����������ļ���ɾ��");  
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