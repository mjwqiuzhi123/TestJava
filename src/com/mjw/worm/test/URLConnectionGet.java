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
        // TODO �Զ����ɵķ������

        System.out.println(doGet("http://www.baidu.com",""));

    }

    public static String doGet(String geturl,String params) {
        String realUrl=geturl+"?"+params;

        try {
            //1.ͨ���� URL �ϵ��� openConnection �����������Ӷ���
            URL url=new URL(realUrl);
            URLConnection conn=url.openConnection();

            //2.�������ò�����һ����������
            //2.1���ò���
            //���Ը����������Ҫ���ò��� 
            conn.setUseCaches(false);
            conn.setConnectTimeout(5000); //����ʱʱ��

            //2.2�������� 
            //����ͨ�õ��������� �����ͷ�ֶ���Ϣ���Բ���HTTPЭ��
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");

            //3.ʹ�� connect ����������Զ�̶����ʵ�����ӡ� 
            conn.connect();

            //4.Զ�̶����Ϊ���á�Զ�̶����ͷ�ֶκ����ݱ�Ϊ�ɷ��ʡ� 
            //4.1��ȡ��Ӧ��ͷ�ֶ�
            Map<String, List<String>> headers=conn.getHeaderFields();
            System.out.println(headers); //���ͷ�ֶ�

            //4.2��ȡ��Ӧ����
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
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        finally {

        }
        return null;

    }
}