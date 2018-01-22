package com.mjw.tool.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import com.mjw.JDBC.test.DBUtil;

public class GetQQMessage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			readTxtFileForQQ3("D:\\QQ.txt", "2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readTxtFileForQQ3(String filePath, String search)
			throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String qqName = "";
				con = DBUtil.getConnect();
				con.setAutoCommit(false);
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.equals("")) {
						if (!checkNumber(lineTxt.trim())) {
							if (lineTxt.length() > 30) {
								System.out.println("length: " + lineTxt.length() + "content: " + lineTxt);
								String[] lineTxts = lineTxt.split("\\s+");
								String sql = "insert into qq_message values(?,?,?,?,?,now(),1,?)";
								pstmt = con.prepareStatement(sql);
								// id,name,qq,sex,age,creatime,status
								pstmt.setString(1, UUID.randomUUID().toString());
								pstmt.setString(2, qqName);
								pstmt.setString(3, lineTxts[0]);
								pstmt.setString(4, lineTxts[1]);
								pstmt.setString(5, lineTxts[2]);
								pstmt.setString(6, search);
								int result = pstmt.executeUpdate();
								qqName = "";
								if (result == 1) {
									System.out.println("添加成功！");
								} else {
									System.out.println("添加失败！");
								}
							} else {
								System.out.println(lineTxt);
								if(qqName.equals(""))
									qqName = new String(lineTxt.getBytes("gbk"),"gbk");
								//qqName = lineTxt;
							}
						}
					}
				}
				con.commit();
				read.close();
			} else {
				throw new Exception("找不到指定的文件");
			}
		} catch (Exception e) {
			e.printStackTrace();
			//throw new Exception("读取文件内容出错");
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				DBUtil.close();
		}
	}

	private static boolean checkNumber(String line) {
		try {
			Integer.parseInt(line);
			return true;
		} catch (Exception e) {
			// System.out.println("该行并非是一个整数");
		}
		return false;
	}
}
