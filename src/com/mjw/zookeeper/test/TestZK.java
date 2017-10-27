package com.mjw.zookeeper.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class TestZK {
	private final static int SESSION_TIMEOUT = 50000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ���������������
		ZooKeeper zk = null;
		try{
		 zk = new ZooKeeper("47.94.240.80:2180,47.94.240.80:2181,47.94.240.80:2182", SESSION_TIMEOUT, new Watcher() { 
		            // ������б��������¼�
		            public void process(WatchedEvent event) { 
		                System.out.println("�Ѿ�������" + event.getType() + "�¼���"); 
		            } 
		        }); 
		 // ����һ��Ŀ¼�ڵ�
		 zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
		   CreateMode.PERSISTENT); 
		 // ����һ����Ŀ¼�ڵ�
		 zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
		   Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
		 System.out.println(new String(zk.getData("/testRootPath",false,null))); 
		 // ȡ����Ŀ¼�ڵ��б�
		 System.out.println(zk.getChildren("/testRootPath",true)); 
		 // �޸���Ŀ¼�ڵ�����
		 zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1); 
		 System.out.println("Ŀ¼�ڵ�״̬��["+zk.exists("/testRootPath",true)+"]"); 
		 // ��������һ����Ŀ¼�ڵ�
		 zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), 
		   Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
		 System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null))); 
		 // ɾ����Ŀ¼�ڵ�
		 zk.delete("/testRootPath/testChildPathTwo",-1); 
		 zk.delete("/testRootPath/testChildPathOne",-1); 
		 // ɾ����Ŀ¼�ڵ�
		 zk.delete("/testRootPath",-1);
		 zk.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			// �ر�����
			if(zk != null)
				try {
					zk.close();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
