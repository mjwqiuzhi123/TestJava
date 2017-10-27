package com.mjw.md5.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ParseMD5 {
	
	public static void main(String agrs[]){
		int par = (int)'a';
		byte[] param = "aaa".getBytes();
		String MD5Str = parseStrToMd5L32("aaa");
		System.out.println(MD5Str);
	}

	/**
	 * @param str
	 * @return
	 * @Description: 32位小写MD5
	 */
	public static String parseStrToMd5L32(String str) {
		String reStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(str.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for (byte b : bytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					stringBuffer.append(0);
				}
				stringBuffer.append(Integer.toHexString(bt));
			}
			reStr = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return reStr;
	}
	
	//仿写
	public static String parseStrToMD5L32_1(String str){
		String reStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(str.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for(byte b : bytes){
				int bt = b & 0xff;
				if(bt < 16)
					stringBuffer.append("0");
				stringBuffer.append(Integer.toHexString(bt));
			}
			reStr = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
		
	}

	/**
	 * @param str
	 * @return
	 * @Description: 32位大写MD5
	 */
	public static String parseStrToMd5U32(String str) {
		String reStr = parseStrToMd5L32(str);
		if (reStr != null) {
			reStr = reStr.toUpperCase();
		}
		return reStr;
	}

	/**
	 * @param str
	 * @return
	 * @Description: 16位小写MD5
	 */
	public static String parseStrToMd5U16(String str) {
		String reStr = parseStrToMd5L32(str);
		if (reStr != null) {
			reStr = reStr.toUpperCase().substring(8, 24);
		}
		return reStr;
	}

	/**
	 * @param str
	 * @return
	 * @Description: 16位大写MD5
	 */
	public static String parseStrToMd5L16(String str) {
		String reStr = parseStrToMd5L32(str);
		if (reStr != null) {
			reStr = reStr.substring(8, 24);
		}
		return reStr;
	}
}