package com.mjw.other.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StrToFile {
	 public static void main(String[] args) {
	        String str="张三 0 3000\r\n李四 1 5000\r\n王五 0 4000";
	        //FileOutputStream stream;
	        FileWriter writer;
	        OutputStreamWriter writer2;
	        try {
	        	writer = new FileWriter("C:\\Users\\admin\\Desktop\\toFile.txt");
//	            writer2 = new OutputStreamWriter(writer,"uft-8");
	            writer.write(str);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
