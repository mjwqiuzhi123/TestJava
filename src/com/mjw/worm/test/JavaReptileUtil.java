package com.mjw.worm.test;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
  
  
/*** 
 * @author God 
 * @see javaץȡ��վ ��ŮͼƬ 
 * @info һ���򵥵����� ���漰������Ⱥ��������  ������Ϊ��� 
 */  
public class JavaReptileUtil {  
      
    // ��ַ  
    private static final String WEB_SITE = "http://image.baidu.com/";  
    // ��ȡimg��ǩ����  
    private static final String IMAGE_TAG_REG = "<img.*src=(.*?)[^>]*?>";  
    // ��ȡsrc·��������  
    private static final String IMAGE_SRC_REG = "http:\"?(.*?)(\"|>|\\s+)";  
    /** 
     * ����С���� 
     * @param args 
     * @throws Exception  
     */  
    public static void main(String[] args) throws Exception {  
        // 1.��ȡ��ŮͼƬ������ַ  
        String htmlInfo = getHtmlInfo(WEB_SITE);
        //System.out.println("htmlInfo:" + htmlInfo);
        //��ȡͼƬurl���ӵ�ַ  
        List<String> imageSrc = getImageSrc(htmlInfo);  
        //������ŮͼƬ  
        downloadImage(imageSrc);  
          
    }  
    /** 
     * ����htmlҳ�� 
     * @param host 
     * @return 
     * @throws Exception 
     */  
    public static String getHtmlInfo(String host) throws Exception{  
        URL url=new URL(host);  
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        //2.�������ò�����һ����������
//        //2.1���ò���
//        //���Ը����������Ҫ���ò��� 
//        urlConnection.setUseCaches(false);
//        urlConnection.setConnectTimeout(5000); //����ʱʱ��
//
//        //2.2�������� 
//        //����ͨ�õ��������� �����ͷ�ֶ���Ϣ���Բ���HTTPЭ��
//        urlConnection.setRequestProperty("accept", "*/*");
//        urlConnection.setRequestProperty("connection", "Keep-Alive");
//
//        urlConnection.connect();
//        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
        urlConnection.setRequestProperty("Charset", "UTF-8");
//        Map<String, List<String>> headers=urlConnection.getHeaderFields();
//        System.out.println(headers); //���ͷ�ֶ�
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
        String buffer=null;  
        StringBuffer sbf=new StringBuffer();  
        while((buffer=bufferedReader.readLine())!=null){  
            sbf.append(buffer);  
        }
        bufferedReader.close();
        return sbf.toString();  
    }  
      
    /** 
     * �������е�image��ǩ�ĵ�src���� 
     * @param args 
     * @throws Exception 
     */  
    public static List<String> getImageSrc(String htmlInfo){  
        Matcher matcher_image = Pattern.compile(IMAGE_TAG_REG).matcher(htmlInfo); // <img.*src=(.*?)[^>]*?> 
        List<String> imageSrc = new ArrayList<String>();  
        while (matcher_image.find()) {  
            Matcher matcher_src = Pattern.compile(IMAGE_SRC_REG).matcher(matcher_image.group());
            System.out.println(matcher_image.group());
            System.out.println();
            while (matcher_src.find()) {  
                imageSrc.add(matcher_src.group().substring(0, matcher_src.group().length() - 1));
                System.out.println(matcher_src.group().substring(0, matcher_src.group().length() - 1));
            }  
        }  
        return imageSrc;  
    }  
      
    /** 
     * ����������url���� 
     * @param imageSrc 
     * @throws Exception  
     */  
    public static void downloadImage(List<String> imageSrc) throws IOException {  
        for (String src : imageSrc) {
        	if(!src.contains(".jpg"))
        		continue;
            URL url =null;  
            try {
            	//src = src.replaceAll("\\","");
            	System.out.println("replace:" + src);
                url = new URL(src);  
            } catch (IOException e) {  
                continue;  
            }  
            // ������Դ  
            System.out.println(src);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());  
            FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\PIC\\" + src.substring(src.lastIndexOf("/") + 1)/*NetUtil.getStrName(src)*/));  
            byte[] bytes = new byte[1024];  
            int length = 0;  
            while ((length = dataInputStream.read(bytes)) != -1) {  
                fileOutputStream.write(bytes, 0, length);  
                //System.out.println("������....");  
            }
            System.out.println("�������...");  
            dataInputStream.close();  
            fileOutputStream.close();
            try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  
    }  
      
} 