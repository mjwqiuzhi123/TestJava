package com.mjw.other.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChangeEncoding {

	public static void changeEncoding(String inEncoding, String outEncoding,

	String inFileName, String outFileName) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(inFileName), inEncoding));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(outFileName), outEncoding));
		String s = null;
		while ((s = reader.readLine()) != null) {
			writer.write(s, 0, s.length());
			writer.newLine();
		}
		writer.flush();
		writer.close();
		reader.close();
	}

	public static void main(String[] args) {
		try {
			changeEncoding("GBK", "UTF-8", "C:\\hmulogs\\upload\\mjw2.xls",
					"C:\\hmulogs\\upload\\mjw3.xls");
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println("×ª»»Ê§°Ü£¬Ô­Òò£º" + e.getMessage());
		}
	}
}
