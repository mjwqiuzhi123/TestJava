package com.mjw.zookeeper.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class CoopNodeBase {

	// server�б�, �Զ��ŷָ�
	protected static String hosts = "";// "192.168.1.119:2181";//,192.168.1.31:2181,192.168.1.115:2181
	private final int SESSION_TIMEOUT = 50000;
	private CountDownLatch connectedSignal = new CountDownLatch(1);
	protected ZooKeeper zk;

	// ��������ݵ�ʱ����Ҫ���ã���������д��
	// static int ZK_MAXBUFFER = 1024 * 1000000;// byte zkServer.sh ͬ���޸ġ�

	/**
	 * ��Ĺ��췽��
	 * 
	 * ��ʼ�����������ݡ�
	 */
	public CoopNodeBase() {

		// ͨ�����û�ȡ CoopNode ��Zookeeper�ڵ��������ַ��
		//hosts = AppCfg.SYSSYNC_ZK_SERVERS;

		// ����Java�����Buffer��С��
		// System.setProperty("jute.maxbuffer", "" + ZK_MAXBUFFER);
		doStart();
	}

	/**
	 * ��ʼ
	 *
	 */
	public void doStart() {
		try {
			connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ֹͣ
	 *
	 */
	public void doStop() {
		try {
			coopNodeClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �������ݿ���Ӧ��·��
	 */
	public String generatePath(String tableName, int maxVolume, String tableKey) {
		String tableNamePath = "/" + tableName;
		if (maxVolume == 1) {
			int imeiHashcode = Math.abs(tableKey.hashCode()) % 1000 + 1000;
			return tableNamePath + "/" + imeiHashcode + "/" + tableKey;
		} else {
			return tableNamePath + "/" + tableKey;
		}
	}

	/**
	 * ��ȡ·���µ����нڵ�
	 *
	 */
	public ArrayList<String> getAllChildrenNodes(String tableName, int maxVolume) {
		String tableNamePath = "/" + tableName;
		ArrayList<String> allPathArray = new ArrayList<String>();
		try {
			if (maxVolume == 1) {
				for (int i = 1000; i < 2000; i++) {
					List<String> pathList = zk.getChildren(tableNamePath + "/"
							+ i, false);
					for (int l = 0; l < pathList.size(); l++) {
						String key = pathList.get(l);
						allPathArray.add(key);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allPathArray;

	}

	/**
	 * ����zookeeper server connect
	 */
	private void connect() throws Exception {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, new ConnWatcher());
		// �ȴ��������
		// System.out.println("��ʼ����Zookeeper����"+hosts);
		connectedSignal.await();
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
	public void coopNodeClose() {
		try {
			zk.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void initTable(String tableName, int maxVolume, String tableColumns) {
		String tableNamePath = "/" + tableName;
		try {
			if (maxVolume == 1) {
				Stat re = zk.exists(tableNamePath, null);
				if (re == null) {
					zk.create(tableNamePath, tableColumns.getBytes(),
							Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
					for (int i = 1000; i < 2000; i++) {
						zk.create(tableNamePath + "/" + i, "".getBytes(),
								Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
					}
				}
			} else {
				Stat re = zk.exists(tableNamePath, null);
				if (re == null) {
					zk.create(tableNamePath, tableColumns.getBytes(),
							Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("���ݿ��:" + tableName + "-·����ʼ����ɡ�");
		}
	}

}
