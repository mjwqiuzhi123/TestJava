package com.mjw.reflect.test;
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Collection;  
import java.util.Properties;  
  
/** 
 * ͨ��һ��С��������ʾͨ�����似��ʵ��һ���򵥵Ŀ��. 
 *  
 * @author jnqqls 
 * @group TGB 
 * @version 1.0 
 *  
 * @comments 
 */  
public class ReflectTest {  
  
    /** 
     * @param args 
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */  
    public static void main(String[] args) throws IOException,  
            InstantiationException, IllegalAccessException,  
            ClassNotFoundException {  
  
  
        // ���ļ�����������  
        InputStream ipt = new FileInputStream("config.properties");  
        // ����Properties����  
        Properties ppt = new Properties();  
        // �����������뵽ppt������.  
        ppt.load(ipt);  
        // �ر�ռ����Դ.  
        ipt.close();  
  
        // ��ȡ�����ļ��е�����.  
        String className = ppt.getProperty("ClassName");  
        // ͨ�����䴴��className����Ӧ�����һ��ʵ��.  
        @SuppressWarnings("unchecked")  
        Collection<String> collections = (Collection<String>) Class.forName(  
                className).newInstance();  
        collections.add(new String("a"));  
        collections.add(new String("b")); 
        collections.add("c");
        System.out.println(collections.size());  
  
    }  
}  