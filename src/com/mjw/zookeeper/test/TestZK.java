package com.mjw.zookeeper.test;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class TestZK {
	//private static TestZK tz;
	private static CountDownLatch connectedSignal = new CountDownLatch(1);
	private final static int SESSION_TIMEOUT = 50000;
	protected static ZooKeeper zk;
	private static String hosts = "39.105.8.31:2181,39.105.8.31:2182,39.105.8.31:2183";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ���������������
		//ZooKeeper zk = null;
		
		try{
			doStart();
/*		 zk = new ZooKeeper("39.105.8.31:2181,39.105.8.31:2182,39.105.8.31:2183", SESSION_TIMEOUT, new Watcher() { 
		            // ������б��������¼�
		            public void process(WatchedEvent event) { 
		                System.out.println("�Ѿ�������" + event.getType() + "�¼���"); 
		            } 
		        });*/
		 if(zk.exists("/testRootPath/testChildPathTwo", null) != null)
			 zk.delete("/testRootPath/testChildPathTwo",-1);
		 if(zk.exists("/testRootPath/testChildPathOne", null) != null)
			 zk.delete("/testRootPath/testChildPathOne",-1); 
		 // ɾ����Ŀ¼�ڵ�
		 if(zk.exists("/testRootPath", null) != null)
			 zk.delete("/testRootPath",-1);
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

	/**
	 * ��������״̬
	 */
	private class ConnWatcher implements Watcher {
		public void process(WatchedEvent event) {
			// ���ӽ���, �ص�process�ӿ�ʱ, ��event.getState()ΪKeeperState.SyncConnected
			if (event.getState() == KeeperState.SyncConnected) {
				// �ſ�բ��, wait��connect�����ϵ��߳̽�������
				connectedSignal.countDown();
				// System.out.println("����Zookeeper����");
			} else if (event.getState() == KeeperState.Expired) {
				System.out.println("Zookeeper���ӳ�ʱ -- ����");
				FileWriterSafe.getInstance().writeTransferLog(
						"Zookeeper���ӳ�ʱ -- ����");
				FileWriterSafe.getInstance().writeTransferLog(
						"Zookeeper���ӳ�ʱ,Base ����:" + this);
				FileWriterSafe.getInstance().writeTransferLog(
						"Zookeeper���ӳ�ʱ,ZK����:" + zk);
				coopNodeClose();
				zk = null;
				doStart();
			}
		}
	}
	
	/**
	 * �ر����� ��ʱû����Ҫ�رյĵط���Zookeeper��Ҫ���ֳ�����
	 */
	public static void coopNodeClose() {
		try {
			zk.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void doStart() {
		try {
			connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����zookeeper server connect
	 */
	private static void connect() throws Exception {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, new TestZK().new ConnWatcher());
		// �ȴ��������
		// System.out.println("��ʼ����Zookeeper����"+hosts);
		connectedSignal.await();
	}
}
