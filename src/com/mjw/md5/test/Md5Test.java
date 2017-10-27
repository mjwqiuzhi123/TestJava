package com.mjw.md5.test;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Md5Test {
    
   public void toMD5(String plainText) {
     try {
        //生成实现指定摘要算法的 MessageDigest 对象。
        MessageDigest md = MessageDigest.getInstance("MD5");  
        //使用指定的字节数组更新摘要。
        md.update(plainText.getBytes());
        //通过执行诸如填充之类的最终操作完成哈希计算。
        byte b[] = md.digest();
        //生成具体的md5密码到buf数组
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
          i = b[offset];
          if (i < 0)
            i += 256;
          if (i < 16)
            buf.append("0");
          //buf.append(Integer.toBinaryString(i));
          buf.append(Integer.toHexString(i));
        }
        System.out.println("32位: " + buf.toString());// 32位的加密
        System.out.println("16位: " + buf.toString().substring(8, 24));// 16位的加密，其实就是32位加密后的截取
     } 
     catch (Exception e) {
       e.printStackTrace();
     }
   }
   
   
   /** 
    * md5加密方法 
    * @param password 
    * @return 
    */  
   public static String md5Password(String password) {  
 
       try {  
           // 得到一个信息摘要器  
           MessageDigest digest = MessageDigest.getInstance("md5");  
           byte[] result = digest.digest(password.getBytes());  
           StringBuffer buffer = new StringBuffer();  
           // 把没一个byte 做一个与运算 0xff;  
           for (byte b : result) {  
               // 与运算  
               int number = b & 0xff;// 加盐  
               String str = Integer.toHexString(number);
//               String str1 = Integer.toBinaryString(number);
//               System.out.println(str1);
               if (str.length() == 1) {  
                   buffer.append("0");  
               }  
               buffer.append(str);  
           }  
 
           // 标准的md5加密后的结果  
           return buffer.toString();  
       } catch (NoSuchAlgorithmException e) {  
           e.printStackTrace();  
           return "";  
       }  
 
   }  
   
   public static void main(String agrs[]) {
       //new Md5Test().toMD5("MJW");//加密MJW
       
       String md5Str = md5Password("aaa");
       System.out.println(md5Str);
   }
}