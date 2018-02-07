package com.mjw.worm.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectionGet {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        System.out.println(doGet("http://www.baidu.com",""));

    }

    public static String doGet(String geturl,String params) {
        String realUrl=geturl+"?"+params;

        try {
            //1.通过在 URL 上调用 openConnection 方法创建连接对象
            URL url=new URL(realUrl);
            URLConnection conn=url.openConnection();

            //2.处理设置参数和一般请求属性
            //2.1设置参数
            //可以根据请求的需要设置参数 
            conn.setUseCaches(false);
            conn.setConnectTimeout(5000); //请求超时时间

            //2.2请求属性 
            //设置通用的请求属性 更多的头字段信息可以查阅HTTP协议
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");

            //3.使用 connect 方法建立到远程对象的实际连接。 
            conn.connect();

            //4.远程对象变为可用。远程对象的头字段和内容变为可访问。 
            //4.1获取响应的头字段
            Map<String, List<String>> headers=conn.getHeaderFields();
            System.out.println(headers); //输出头字段

            //4.2获取响应正文
            BufferedReader reader = null;
            StringBuffer resultBuffer = new StringBuffer();
            String tempLine = null;

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            //System.out.println(resultBuffer);
            reader.close();
            return resultBuffer.toString();
        } catch (MalformedURLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        finally {

        }
        return null;

    }
}