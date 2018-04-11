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

	// server列表, 以逗号分割
	protected static String hosts = "";// "192.168.1.119:2181";//,192.168.1.31:2181,192.168.1.115:2181
	private final int SESSION_TIMEOUT = 50000;
	private CountDownLatch connectedSignal = new CountDownLatch(1);
	protected ZooKeeper zk;

	// 单点大数据的时候需要设置，包括读和写。
	// static int ZK_MAXBUFFER = 1024 * 1000000;// byte zkServer.sh 同步修改。

	/**
	 * 类的构造方法
	 * 
	 * 初始化类的相关数据。
	 */
	public CoopNodeBase() {

		// 通过配置获取 CoopNode 的Zookeeper节点服务器地址。
		//hosts = AppCfg.SYSSYNC_ZK_SERVERS;

		// 设置Java的最大Buffer大小。
		// System.setProperty("jute.maxbuffer", "" + ZK_MAXBUFFER);
		doStart();
	}

	/**
	 * 开始
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
	 * 停止
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
	 * 生成数据库表对应的路径
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
	 * 获取路径下的所有节点
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
	 * 连接zookeeper server connect
	 */
	private void connect() throws Exception {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, new ConnWatcher());
		// 等待连接完成
		// System.out.println("开始建立Zookeeper连接"+hosts);
		connectedSignal.await();
	}

	/**
	 * 监听连接状态
	 */
	private class ConnWatcher implements Watcher {
		public void process(WatchedEvent event) {
			// 连接建立, 回调process接口时, 其event.getState()为KeeperState.SyncConnected
			if (event.getState() == KeeperState.SyncConnected) {
				// 放开闸门, wait在connect方法上的线程将被唤醒
				connectedSignal.countDown();
				// System.out.println("建立Zookeeper连接");
			} else if (event.getState() == KeeperState.Expired) {
				System.out.println("Zookeeper连接超时 -- 重连");
				FileWriterSafe.getInstance().writeTransferLog(
						"Zookeeper连接超时 -- 重连");
				FileWriterSafe.getInstance().writeTransferLog(
						"Zookeeper连接超时,Base 对象:" + this);
				FileWriterSafe.getInstance().writeTransferLog(
						"Zookeeper连接超时,ZK对象:" + zk);
				coopNodeClose();
				zk = null;
				doStart();
			}
		}
	}

	/**
	 * 关闭连接 暂时没有需要关闭的地方，Zookeeper需要保持长连接
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
			System.out.println("数据库表:" + tableName + "-路径初始化完成。");
		}
	}

}
