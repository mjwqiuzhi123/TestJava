package com.mjw.md5.test;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Md5Test {
    
   public void toMD5(String plainText) {
     try {
        //����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
        MessageDigest md = MessageDigest.getInstance("MD5");  
        //ʹ��ָ�����ֽ��������ժҪ��
        md.update(plainText.getBytes());
        //ͨ��ִ���������֮������ղ�����ɹ�ϣ���㡣
        byte b[] = md.digest();
        //���ɾ����md5���뵽buf����
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
        System.out.println("32λ: " + buf.toString());// 32λ�ļ���
        System.out.println("16λ: " + buf.toString().substring(8, 24));// 16λ�ļ��ܣ���ʵ����32λ���ܺ�Ľ�ȡ
     } 
     catch (Exception e) {
       e.printStackTrace();
     }
   }
   
   
   /** 
    * md5���ܷ��� 
    * @param password 
    * @return 
    */  
   public static String md5Password(String password) {  
 
       try {  
           // �õ�һ����ϢժҪ��  
           MessageDigest digest = MessageDigest.getInstance("md5");  
           byte[] result = digest.digest(password.getBytes());  
           StringBuffer buffer = new StringBuffer();  
           // ��ûһ��byte ��һ�������� 0xff;  
           for (byte b : result) {  
               // ������  
               int number = b & 0xff;// ����  
               String str = Integer.toHexString(number);
//               String str1 = Integer.toBinaryString(number);
//               System.out.println(str1);
               if (str.length() == 1) {  
                   buffer.append("0");  
               }  
               buffer.append(str);  
           }  
 
           // ��׼��md5���ܺ�Ľ��  
           return buffer.toString();  
       } catch (NoSuchAlgorithmException e) {  
           e.printStackTrace();  
           return "";  
       }  
 
   }  
   
   public static void main(String agrs[]) {
       //new Md5Test().toMD5("MJW");//����MJW
       
       String md5Str = md5Password("aaa");
       System.out.println(md5Str);
   }
}