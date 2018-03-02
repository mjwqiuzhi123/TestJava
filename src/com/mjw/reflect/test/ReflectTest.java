package com.mjw.reflect.test;
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Collection;  
import java.util.Properties;  
  
/** 
 * 通过一个小例子来演示通过反射技术实现一个简单的框架. 
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
  
  
        // 将文件读入数据流  
        InputStream ipt = new FileInputStream("config.properties");  
        // 创建Properties对象  
        Properties ppt = new Properties();  
        // 将数据流载入到ppt对象中.  
        ppt.load(ipt);  
        // 关闭占用资源.  
        ipt.close();  
  
        // 获取配置文件中的名字.  
        String className = ppt.getProperty("ClassName");  
        // 通过反射创建className所对应的类的一个实例.  
        @SuppressWarnings("unchecked")  
        Collection<String> collections = (Collection<String>) Class.forName(  
                className).newInstance();  
        collections.add(new String("a"));  
        collections.add(new String("b")); 
        collections.add("c");
        System.out.println(collections.size());  
  
    }  
}  