package com.mjw.md5.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;

public class TestMessageDigest {
	/*
	 * MessageDigest MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA
	 * 算法。信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。 MessageDigest 对象开始被初始化。该对象通过使用
	 * update 方法处理数据。任何时候都可以调用 reset 方法重置摘要。一旦所有需要更新的数据都已经被更新了，应该调用 digest
	 * 方法之一完成哈希计算。 对于给定数量的更新数据，digest 方法只能被调用一次。在调用 digest 之后，MessageDigest
	 * 对象被重新设置成其初始状态。
	 * JDK6.0支持MD2/MD5/SHA-1(SHA)/SHA-256/SHA-384/SHA-512六种算法，名称不区分大小写。
	 * 
	 * DigestInputStream 使用输入流的方式完成摘要更新，调用on(boolean
	 * on)方法开启和关闭摘要功能。如果on(false)，则DigestInputStream就变成了一般的输入流
	 * 。默认摘要功能是开启的，如果开启了摘要功能，调用read方法时，将调用MessageDigest
	 * 类的update方法更新摘要。输入流的内容是read的字节而不是摘要。
	 * 
	 * DigestOutputStream 使用输出流的方式完成摘要更新，调用on(boolean
	 * on)方法开启和关闭摘要功能。如果on(false)，
	 * 则DigestOutputStream就变成了一般的输出流。默认摘要功能是开启的，如果开启了摘要功能
	 * ，调用write方法时，将调用MessageDigest 类的update方法更新摘要。输出流的内容是write的字节而不是摘要。
	 */
	public static void main(String[] args) throws Exception {
		byte[] bytes = "测试".getBytes();

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(bytes);
		MessageDigest messageDigest1 = MessageDigest.getInstance("MD5");
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				bytes);
		DigestInputStream digestInputStream = new DigestInputStream(
				byteArrayInputStream, messageDigest1);
		digestInputStream.read(bytes, 0, bytes.length);
		System.out.println("摘要结果相同："
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
		System.out.println("摘要结果相同："
				+ MessageDigest.isEqual(messageDigest2.digest(),
						digestOutputStream.getMessageDigest().digest()));
		System.out.println("输出的字符串：" + byteArrayOutputStream.toString());
		digestOutputStream.flush();
		digestOutputStream.close();
	}

}
