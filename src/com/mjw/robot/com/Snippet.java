package com.mjw.robot.com;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Snippet {
	public static void main(String[] args) {
	
	        try {
	
	            JSONObject obj = new JSONObject();
	
	            obj.put("key", "258e938e071f4fbfbf87e25ec119d886"); //  机器人key  具体申请的机器人对应的key
	            obj.put("info", "你好");
	            //obj.put("loc", "北京市");
	            //obj.put("userid", "panther");
	          
	
	            System.out.println(obj);
	            // 创建url资源
	            URL url = new URL("http://www.tuling123.com/openapi/api");
	            // 建立http连接
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            // 设置允许输出
	            conn.setDoOutput(true);
	
	        //    conn.setDoInput(true);
	
	            // 设置不用缓存
	        //    conn.setUseCaches(false);
	            // 设置传递方式
	            conn.setRequestMethod("POST");
	            // 设置维持长连接
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            // 设置文件字符集:
	            conn.setRequestProperty("Charset", "UTF-8");
	            // 转换为字节数组
	            byte[] data = (obj.toString()).getBytes();
	            // 设置文件长度
	            conn.setRequestProperty("Content-Length", String
	                    .valueOf(data.length));
	
	            // 设置文件类型:
	            conn.setRequestProperty("Content-Type", "json");
	
	            // 开始连接请求
	            conn.connect();
	            OutputStream out = conn.getOutputStream();
	            // 写入请求的字符串
	            out.write((obj.toString()).getBytes());
	            out.flush();
	            out.close();
	
	            System.out.println(conn.getResponseCode());
	
	            // 请求返回的状态
	            if (conn.getResponseCode() == 200) {
	                System.out.println("连接成功");
	                // 请求返回的数据
	                InputStream in = conn.getInputStream();
	                String a = null;
	                try {
	                    byte[] data1 = new byte[in.available()];
	                    in.read(data1);
	             
	                    a = new String(data1,"utf-8");
	                    JSONObject jso = new JSONObject(a);
	                    int code = jso.getInt("code");
	                    String text = jso.getString("text");
	                    
	                    System.out.println(a);
	                    System.out.println(code);
	                    System.out.println(text);
	
	                } catch (Exception e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	            } else {
	                System.out.println("no++");
	            }
	
	        } catch (Exception e) {
	
	        }
	
	    }
}

