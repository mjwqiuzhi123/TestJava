package com.mjw.zookeeper.test;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class TestZK_WATCHER {
	// private static TestZK tz;
	private static CountDownLatch connectedSignal = new CountDownLatch(1);
	private final static int SESSION_TIMEOUT = 50000;
	protected static ZooKeeper zk;
	private static String hosts = "39.105.8.31:2181,39.105.8.31:2182,39.105.8.31:2183";
	private static final NodeWatcher nodeWatcher = new TestZK_WATCHER().new NodeWatcher();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// 创建一个与服务器的连接
			doStart();
//			if(zk.exists("/work", null) != null)
//				zk.delete("/work", -1);
//			zk.create("/work", "hard".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//			byte[] bt = zk.getData("/work", nodeWatcher, null);
//			System.out.println(new String(bt));
//			zk.setData("/work", "harder".getBytes(), -1);
			createNode();
			/*if (zk.exists("/testRootPath/testChildPathTwo", null) != null)
				zk.delete("/testRootPath/testChildPathTwo", -1);
			if (zk.exists("/testRootPath/testChildPathOne", null) != null)
				zk.delete("/testRootPath/testChildPathOne", -1);
			// 删除父目录节点
			if (zk.exists("/testRootPath", null) != null)
				zk.delete("/testRootPath", -1);
			// 创建一个目录节点
			zk.create("/testRootPath", "testRootData".getBytes(),
					Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			// 创建一个子目录节点
			zk.create("/testRootPath/testChildPathOne",
					"testChildDataOne".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
			System.out.println(new String(zk.getData("/testRootPath", false,
					null)));
			// 取出子目录节点列表
			System.out.println(zk.getChildren("/testRootPath", true));
			// 修改子目录节点数据
			zk.setData("/testRootPath/testChildPathOne",
					"modifyChildDataOne".getBytes(), -1);
			System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true)
					+ "]");
			// 创建另外一个子目录节点
			zk.create("/testRootPath/testChildPathTwo",
					"testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
			System.out.println(new String(zk.getData(
					"/testRootPath/testChildPathTwo", true, null)));
			// 删除子目录节点
			zk.delete("/testRootPath/testChildPathTwo", -1);
			zk.delete("/testRootPath/testChildPathOne", -1);
			// 删除父目录节点
			zk.delete("/testRootPath", -1);*/
			zk.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			if (zk != null)
				try {
					zk.close();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
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
	 * 监听连接状态
	 */
	private class NodeWatcher implements Watcher {
		public void process(WatchedEvent event) {
			try {
				// 连接建立, 回调process接口时,
				// 其event.getState()为KeeperState.SyncConnected
				if (event.getState() == KeeperState.SyncConnected) {
					if (event.getType() == EventType.NodeDataChanged) {
						System.out.println("改变后的数据："
								+ new String(zk.getData("/create", false, null)));
					}else if(event.getType() == EventType.NodeChildrenChanged){
						System.out.println("相关路径：" + event.getPath());
					}else if(event.getType() == EventType.NodeCreated){
						System.out.println("监控的节点被创建: " + event.getPath());
					}else if(event.getType() == EventType.NodeDeleted){
						System.out.println("监控节点被删除" + event.getPath());
					}
				}
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭连接 暂时没有需要关闭的地方，Zookeeper需要保持长连接
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
	 * 连接zookeeper server connect
	 */
	private static void connect() throws Exception {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT,
				new TestZK_WATCHER().new ConnWatcher());
		// 等待连接完成
		// System.out.println("开始建立Zookeeper连接"+hosts);
		connectedSignal.await();
	}
	
	// 创建节点事件
	private static void createNode() throws KeeperException, InterruptedException{
		System.out.println("createNode start********************************");
		if(zk.exists("/create", nodeWatcher) != null){
			System.out.println("node删除触发");
			zk.delete("/create", -1);
		}
		zk.exists("/create", nodeWatcher);
		System.out.println("node创建触发");
		zk.create("/create", "create".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		if(zk.exists("/create", nodeWatcher) != null){
			System.out.println("node数据触发");
			zk.setData("/create", "update".getBytes(), -1);
		}
		System.out.println("createNode end**************************************");
	}
	
	private static void getChildNodes(){
		try {
			zk.getChildren("/father", nodeWatcher);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
