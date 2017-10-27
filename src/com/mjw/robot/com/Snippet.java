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
	
	            obj.put("key", "258e938e071f4fbfbf87e25ec119d886"); //  ������key  ��������Ļ����˶�Ӧ��key
	            obj.put("info", "���");
	            //obj.put("loc", "������");
	            //obj.put("userid", "panther");
	          
	
	            System.out.println(obj);
	            // ����url��Դ
	            URL url = new URL("http://www.tuling123.com/openapi/api");
	            // ����http����
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            // �����������
	            conn.setDoOutput(true);
	
	        //    conn.setDoInput(true);
	
	            // ���ò��û���
	        //    conn.setUseCaches(false);
	            // ���ô��ݷ�ʽ
	            conn.setRequestMethod("POST");
	            // ����ά�ֳ�����
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            // �����ļ��ַ���:
	            conn.setRequestProperty("Charset", "UTF-8");
	            // ת��Ϊ�ֽ�����
	            byte[] data = (obj.toString()).getBytes();
	            // �����ļ�����
	            conn.setRequestProperty("Content-Length", String
	                    .valueOf(data.length));
	
	            // �����ļ�����:
	            conn.setRequestProperty("Content-Type", "json");
	
	            // ��ʼ��������
	            conn.connect();
	            OutputStream out = conn.getOutputStream();
	            // д��������ַ���
	            out.write((obj.toString()).getBytes());
	            out.flush();
	            out.close();
	
	            System.out.println(conn.getResponseCode());
	
	            // ���󷵻ص�״̬
	            if (conn.getResponseCode() == 200) {
	                System.out.println("���ӳɹ�");
	                // ���󷵻ص�����
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

