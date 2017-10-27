package com.mjw.buffer.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() {
		FileOutputStream fos = null;
		FileChannel fcos = null;
		ByteBuffer bb = null;
		try {
			fos = new FileOutputStream("d:\\test.txt");
			fcos = fos.getChannel();
			bb = ByteBuffer.allocate(128);
			System.out.println(bb.mark() + " " + bb.position() + " "
					+ bb.limit() + " " + bb.capacity());
			bb.putInt(1);
			bb.putInt(2);
			bb.putInt(3);
			System.out.println(bb.mark() + " " + bb.position() + " "
					+ bb.limit() + " " + bb.capacity());
			bb.flip();
			System.out.println(bb.getInt());
			//bb.flip();
			System.out.println(bb.getInt());
			//bb.flip();
			System.out.println(bb.getInt());
			System.out.println(bb.mark() + " " + bb.position() + " "
					+ bb.limit() + " " + bb.capacity());
//			bb.flip();
//			System.out.println(bb.mark() + " " + bb.position() + " "
//					+ bb.limit() + " " + bb.capacity());
//			fcos.write(bb);
//			System.out.println(bb.mark() + " " + bb.position() + " "
//					+ bb.limit() + " " + bb.capacity());
//			bb.clear();
//			System.out.println(bb.mark() + " " + bb.position() + " "
//					+ bb.limit() + " " + bb.capacity());
//			bb.flip();
//			System.out.println(bb.mark() + " " + bb.position() + " "
//					+ bb.limit() + " " + bb.capacity());
//			fcos.write(bb);
//			System.out.println(bb.mark() + " " + bb.position() + " "
//					+ bb.limit() + " " + bb.capacity());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fcos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void test1() {
		ByteBuffer bb = ByteBuffer.allocate(128);
		FileChannel fc;
		try {
			fc = new FileInputStream("d:\\test.txt").getChannel();
			fc.write(bb);
			fc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
