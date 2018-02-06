package com.mjw.worm.test;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
  
/*** 
 * @author God 
 * @see javaץȡ��վ ��ŮͼƬ 
 * @info һ���򵥵����� ���漰������Ⱥ��������  ������Ϊ��� 
 */  
public class JavaReptileUtil {  
      
    // ��ַ  
    private static final String WEB_SITE = "http://www.4493.com";  
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
        URLConnection urlConnection = url.openConnection();  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
        String buffer=null;  
        StringBuffer sbf=new StringBuffer();  
        while((buffer=bufferedReader.readLine())!=null){  
            sbf.append(buffer);  
        }  
        return sbf.toString();  
    }  
      
    /** 
     * �������е�image��ǩ�ĵ�src���� 
     * @param args 
     * @throws Exception 
     */  
    public static List<String> getImageSrc(String htmlInfo){  
        Matcher matcher_image = Pattern.compile(IMAGE_TAG_REG).matcher(htmlInfo);  
        List<String> imageSrc = new ArrayList<String>();  
        while (matcher_image.find()) {  
            Matcher matcher_src = Pattern.compile(IMAGE_SRC_REG).matcher(matcher_image.group());  
            while (matcher_src.find()) {  
                imageSrc.add(matcher_src.group().substring(0, matcher_src.group().length() - 1));  
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
            URL url =null;  
            try {  
                url = new URL(src);  
            } catch (IOException e) {  
                continue;  
            }  
            // ������Դ  
            DataInputStream dataInputStream = new DataInputStream(url.openStream());  
            FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\beauty\\"/* + NetUtil.getStrName(src)*/));  
            byte[] bytes = new byte[1024];  
            int length = 0;  
            while ((length = dataInputStream.read(bytes)) != -1) {  
                fileOutputStream.write(bytes, 0, length);  
                System.out.println("������....");  
            }  
            System.out.println("�������...");  
            dataInputStream.close();  
            fileOutputStream.close();  
        }  
    }  
      
} 