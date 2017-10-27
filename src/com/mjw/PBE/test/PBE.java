package com.mjw.PBE.test;
import sun.misc.BASE64Encoder;  
  
import javax.crypto.*;  
import javax.crypto.spec.PBEKeySpec;  
import javax.crypto.spec.PBEParameterSpec;  
import java.io.UnsupportedEncodingException;  
import java.security.InvalidAlgorithmParameterException;  
import java.security.InvalidKeyException;  
import java.security.Key;  
import java.security.NoSuchAlgorithmException;  
import java.security.spec.InvalidKeySpecException;  
import java.util.Random;  
  
/** 
 * Created by xiang.li on 2015/2/28. 
 * PBE �ӽ��ܹ����� 
 */  
public class PBE {  
    /** 
     * ������ܷ�ʽ 
     * ֧����������һ���㷨 
     * <p/> 
     * <pre> 
     * PBEWithMD5AndDES 
     * PBEWithMD5AndTripleDES 
     * PBEWithSHA1AndDESede 
     * PBEWithSHA1AndRC2_40 
     * </pre> 
     */  
    private final static String KEY_PBE = "PBEWITHMD5andDES";  
  
    private final static int SALT_COUNT = 100;  
  
    /** 
     * ��ʼ���Σ�salt�� 
     * 
     * @return 
     */  
    public static byte[] init() {  
        byte[] salt = new byte[8];  
        Random random = new Random();  
        random.nextBytes(salt);  
        return salt;  
    }  
  
    /** 
     * ת����Կ 
     * 
     * @param key �ַ��� 
     * @return 
     */  
    public static Key stringToKey(String key) {  
        SecretKey secretKey = null;  
        try {  
            PBEKeySpec keySpec = new PBEKeySpec(key.toCharArray());  
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_PBE);  
            secretKey = factory.generateSecret(keySpec);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (InvalidKeySpecException e) {  
            e.printStackTrace();  
        }  
        return secretKey;  
    }  
  
    /** 
     * PBE ���� 
     * 
     * @param data ��Ҫ���ܵ��ֽ����� 
     * @param key  ����(���ڻ�ȡ��Կ) 
     * @param salt �� 
     * @return 
     */  
    public static byte[] encryptPBE(byte[] data, String key, byte[] salt) {  
        byte[] bytes = null;  
        try {  
            // ��ȡ��Կ  
            Key k = stringToKey(key);  
            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, SALT_COUNT);  
            Cipher cipher = Cipher.getInstance(KEY_PBE);  
            cipher.init(Cipher.ENCRYPT_MODE, k, parameterSpec);  
            bytes = cipher.doFinal(data);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (NoSuchPaddingException e) {  
            e.printStackTrace();  
        } catch (InvalidAlgorithmParameterException e) {  
            e.printStackTrace();  
        } catch (InvalidKeyException e) {  
            e.printStackTrace();  
        } catch (BadPaddingException e) {  
            e.printStackTrace();  
        } catch (IllegalBlockSizeException e) {  
            e.printStackTrace();  
        }  
        return bytes;  
    }  
  
    /** 
     * PBE ���� 
     * 
     * @param data ��Ҫ���ܵ��ֽ����� 
     * @param key  ��Կ 
     * @param salt �� 
     * @return 
     */  
    public static byte[] decryptPBE(byte[] data, String key, byte[] salt) {  
        byte[] bytes = null;  
        try {  
            // ��ȡ��Կ  
            Key k = stringToKey(key);  
            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, SALT_COUNT);  
            Cipher cipher = Cipher.getInstance(KEY_PBE);  
            cipher.init(Cipher.DECRYPT_MODE, k, parameterSpec);  
            bytes = cipher.doFinal(data);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (NoSuchPaddingException e) {  
            e.printStackTrace();  
        } catch (InvalidAlgorithmParameterException e) {  
            e.printStackTrace();  
        } catch (InvalidKeyException e) {  
            e.printStackTrace();  
        } catch (BadPaddingException e) {  
            e.printStackTrace();  
        } catch (IllegalBlockSizeException e) {  
            e.printStackTrace();  
        }  
        return bytes;  
    }  
  
    /** 
     * BASE64 ���� 
     * 
     * @param key ��Ҫ���ܵ��ֽ����� 
     * @return �ַ��� 
     * @throws Exception 
     */  
    public static String encryptBase64(byte[] key) throws Exception {  
        return (new BASE64Encoder()).encodeBuffer(key);  
    }  
  
    /** 
     * ���Է��� 
     * 
     * @param args 
     */  
    public static void main(String[] args) {  
        // ����ǰ��ԭ��  
        String str = "hello world !!!";  
        // ����  
        String key = "qwert";  
        // ��ʼ����  
        byte[] salt = init();  
        // ����PBE�㷨����  
        byte[] encData = encryptPBE(str.getBytes(), key, salt);  
        // ����PBE�㷨����  
        byte[] decData = decryptPBE(encData, key, salt);  
        String encStr = null;  
        String decStr = null;  
        try {  
            encStr = encryptBase64(encData);  
            decStr = new String(decData, "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("����ǰ��" + str);  
        System.out.println("���ܺ�" + encStr);  
        System.out.println("���ܺ�" + decStr);  
    }  
}