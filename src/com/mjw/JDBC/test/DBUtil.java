package com.mjw.JDBC.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBUtil {
	public static final String url = "jdbc:mysql://127.0.0.1/test";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "mjw";
	public static final String password = "123456";
	public static Lock lock = new ReentrantLock();

	public static Connection conn = null;

	private DBUtil() {
		try {
			Class.forName(name);// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);// 获取连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		lock.lock();
		if (conn == null)
			new DBUtil();
		lock.unlock();
		return conn;
	}

	public static void close() {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}