package com.mjw.md5.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;

public class TestMessageDigest {
	/*
	 * MessageDigest MessageDigest ��ΪӦ�ó����ṩ��ϢժҪ�㷨�Ĺ��ܣ��� MD5 �� SHA
	 * �㷨����ϢժҪ�ǰ�ȫ�ĵ����ϣ�����������������С�����ݣ�������̶����ȵĹ�ϣֵ�� MessageDigest ����ʼ����ʼ�����ö���ͨ��ʹ��
	 * update �����������ݡ��κ�ʱ�򶼿��Ե��� reset ��������ժҪ��һ��������Ҫ���µ����ݶ��Ѿ��������ˣ�Ӧ�õ��� digest
	 * ����֮һ��ɹ�ϣ���㡣 ���ڸ��������ĸ������ݣ�digest ����ֻ�ܱ�����һ�Ρ��ڵ��� digest ֮��MessageDigest
	 * �����������ó����ʼ״̬��
	 * JDK6.0֧��MD2/MD5/SHA-1(SHA)/SHA-256/SHA-384/SHA-512�����㷨�����Ʋ����ִ�Сд��
	 * 
	 * DigestInputStream ʹ���������ķ�ʽ���ժҪ���£�����on(boolean
	 * on)���������͹ر�ժҪ���ܡ����on(false)����DigestInputStream�ͱ����һ���������
	 * ��Ĭ��ժҪ�����ǿ����ģ����������ժҪ���ܣ�����read����ʱ��������MessageDigest
	 * ���update��������ժҪ����������������read���ֽڶ�����ժҪ��
	 * 
	 * DigestOutputStream ʹ��������ķ�ʽ���ժҪ���£�����on(boolean
	 * on)���������͹ر�ժҪ���ܡ����on(false)��
	 * ��DigestOutputStream�ͱ����һ����������Ĭ��ժҪ�����ǿ����ģ����������ժҪ����
	 * ������write����ʱ��������MessageDigest ���update��������ժҪ���������������write���ֽڶ�����ժҪ��
	 */
	public static void main(String[] args) throws Exception {
		byte[] bytes = "����".getBytes();

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(bytes);
		MessageDigest messageDigest1 = MessageDigest.getInstance("MD5");
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				bytes);
		DigestInputStream digestInputStream = new DigestInputStream(
				byteArrayInputStream, messageDigest1);
		digestInputStream.read(bytes, 0, bytes.length);
		System.out.println("ժҪ�����ͬ��"
				+ MessageDigest.isEqual(messageDigest.digest(),
						digestInputStream.getMessageDigest().digest()));
		digestInputStream.close();

		MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
		messageDigest2.update(bytes);
		MessageDigest messageDigest3 = MessageDigest.getInstance("MD5");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DigestOutputStream digestOutputStream = new DigestOutputStream(
				byteArrayOutputStream, messageDigest3);
		digestOutputStream.write(bytes, 0, bytes.length);
		System.out.println("ժҪ�����ͬ��"
				+ MessageDigest.isEqual(messageDigest2.digest(),
						digestOutputStream.getMessageDigest().digest()));
		System.out.println("������ַ�����" + byteArrayOutputStream.toString());
		digestOutputStream.flush();
		digestOutputStream.close();
	}

}
