package com.mjw.other.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MakeData {

	public static void main(String[] args) {
		try {
			makeData1();
			System.out.println("OVER!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �ֽ������
	public static void makeData() throws Exception {
		String imei = "N0000000000";
		String imsi = "M0000000000";
		String phone = "15845678901";
		File file = new File("C:\\Users\\admin\\Desktop\\mmz.csv");
		if (!file.exists()) {
			file.createNewFile();
		}

		// ���ļ���д���ַ���
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });  
		for (int i = 1; i <= 10; i++) {
			// imei
			imei = imei.substring(0, (imei.length() - String.valueOf(i)
					.length()));
			imei = imei + i + ",";
			// imsi
			imsi = imsi.substring(0, (imsi.length() - String.valueOf(i)
					.length()));
			imsi = imsi + i + ",";
			// phon
			phone = phone.substring(0, (phone.length() - String.valueOf(i)
					.length()));
			phone = phone + i + ",";

			imei = imei + imsi + phone;

			// ʡ(����Ϊ����)
			if (i % 2 != 0) {
				imei = imei + "����,747,";
			} else {
				imei = imei + "�ӱ�,63,";
			}

			// ʡ(β��С��5��Ϊ����)
			// if (i % 10 < 5) {
			// imei = imei + "����,747,";
			// } else {
			// imei = imei + "�ӱ�,63,";
			// }

			// ��
			if (i % 10 == 2) {
				imei = imei + "�е�,82,";
			} else if (i % 10 == 4) {
				imei = imei + "����,68,";
			} else if (i % 10 == 6) {
				imei = imei + "����,74,";
			} else if (i % 10 == 8) {
				imei = imei + "��̨,76,";
			} else if (i % 10 == 0) {
				imei = imei + "�ȷ�,72,";
			} else {
				imei = imei + "����,748,";
			}

			// local
			if (i % 2 != 0) {
				imei = imei + "�����ǳǹ��ʴ���501��,";
			} else {
				imei = imei + "�ӱ����Թʵ�,";
			}

			// model
			if (i % 5 == 0) {
				imei = imei + "A 9+,";
			} else if (i % 5 == 1) {
				imei = imei + "A-7,";
			} else if (i % 5 == 2) {
				imei = imei + "A0001,";
			} else if (i % 5 == 3) {
				imei = imei + "A01,";
			} else {
				imei = imei + "a0255,";
			}

			// level
			// if(i%5 == 0){
			// imei = imei + "��,1,";
			// }else if(i%5 == 1){
			// imei = imei + "��,2,";
			// }else if(i%5 == 2){
			// imei = imei + "��,3,";
			// }else if(i%5 == 3){
			// imei = imei + "��,2,";
			// }else{
			// imei = imei + "��,3,";
			// }
			//
			// game
			if (i % 10 == 1 || i % 10 == 4 || i % 10 == 6 || i % 10 == 7
					|| i % 10 == 8) {
				imei = imei + "0,";
			} else if (i % 10 == 5) {
				imei = imei + "-1,";
			} else {
				imei = imei + "1,";
			}

			// buy
			if (i % 10 == 2 || i % 10 == 3 || i % 10 == 1 || i % 10 == 6) {
				imei = imei + "0,";
			} else if (i % 10 == 5 || i % 10 == 9) {
				imei = imei + "-1,";
			} else {
				imei = imei + "1,";
			}

			// travel
			if (i % 10 == 1 || i % 10 == 2 || i % 10 == 6 || i % 10 == 7
					|| i % 10 == 9) {
				imei = imei + "0\r\n";
			} else if (i % 10 == 5) {
				imei = imei + "-1\r\n";
			} else {
				imei = imei + "1\r\n";
			}
			System.out.println(imei);

			// byte[] bytes = new byte[512];
			byte[] bytes = imei.getBytes("UTF-8"); // �¼ӵ�
			int b = bytes.length; // ��
			System.out.println(b);
			fos.write(bytes, 0, b);
			imei = "N0000000000";
			imsi = "M0000000000";
			phone = "15845678901";
		}
		fos.close();

	}

	// �ַ������
	public static void makeData1() throws Exception {
		String imei = "N0000000000";
		String imsi = "M0000000000";
		String phone = "15845678901";
		File file = new File("C:\\Users\\admin\\Desktop\\BOM_CONTENT.csv");
		if (!file.exists()) {
			file.createNewFile();
		}

		// ���ļ���д���ַ���
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		osw.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,
				(byte) 0xBF },"UTF-8"));
		for (int i = 1; i <= 10; i++) {
			// imei
			imei = imei.substring(0, (imei.length() - String.valueOf(i)
					.length()));
			imei = imei + i + ",";
			// imsi
			imsi = imsi.substring(0, (imsi.length() - String.valueOf(i)
					.length()));
			imsi = imsi + i + ",";
			// phon
			phone = phone.substring(0, (phone.length() - String.valueOf(i)
					.length()));
			phone = phone + i + ",";

			imei = imei + imsi + phone;

			// ʡ(����Ϊ����)
			if (i % 2 != 0) {
				imei = imei + "����,747,";
			} else {
				imei = imei + "�ӱ�,63,";
			}

			// ʡ(β��С��5��Ϊ����)
			// if (i % 10 < 5) {
			// imei = imei + "����,747,";
			// } else {
			// imei = imei + "�ӱ�,63,";
			// }

			// ��
			if (i % 10 == 2) {
				imei = imei + "�е�,82,";
			} else if (i % 10 == 4) {
				imei = imei + "����,68,";
			} else if (i % 10 == 6) {
				imei = imei + "����,74,";
			} else if (i % 10 == 8) {
				imei = imei + "��̨,76,";
			} else if (i % 10 == 0) {
				imei = imei + "�ȷ�,72,";
			} else {
				imei = imei + "����,748,";
			}

			// local
			if (i % 2 != 0) {
				imei = imei + "�����ǳǹ��ʴ���501��,";
			} else {
				imei = imei + "�ӱ����Թʵ�,";
			}

			// model
			if (i % 5 == 0) {
				imei = imei + "A 9+,";
			} else if (i % 5 == 1) {
				imei = imei + "A-7,";
			} else if (i % 5 == 2) {
				imei = imei + "A0001,";
			} else if (i % 5 == 3) {
				imei = imei + "A01,";
			} else {
				imei = imei + "a0255,";
			}

			// level
			// if(i%5 == 0){
			// imei = imei + "��,1,";
			// }else if(i%5 == 1){
			// imei = imei + "��,2,";
			// }else if(i%5 == 2){
			// imei = imei + "��,3,";
			// }else if(i%5 == 3){
			// imei = imei + "��,2,";
			// }else{
			// imei = imei + "��,3,";
			// }
			//
			// game
			if (i % 10 == 1 || i % 10 == 4 || i % 10 == 6 || i % 10 == 7
					|| i % 10 == 8) {
				imei = imei + "0,";
			} else if (i % 10 == 5) {
				imei = imei + "-1,";
			} else {
				imei = imei + "1,";
			}

			// buy
			if (i % 10 == 2 || i % 10 == 3 || i % 10 == 1 || i % 10 == 6) {
				imei = imei + "0,";
			} else if (i % 10 == 5 || i % 10 == 9) {
				imei = imei + "-1,";
			} else {
				imei = imei + "1,";
			}

			// travel
			if (i % 10 == 1 || i % 10 == 2 || i % 10 == 6 || i % 10 == 7
					|| i % 10 == 9) {
				imei = imei + "0\r\n";
			} else if (i % 10 == 5) {
				imei = imei + "-1\r\n";
			} else {
				imei = imei + "1\r\n";
			}
			System.out.println(imei);

			osw.write(imei);
			imei = "N0000000000";
			imsi = "M0000000000";
			phone = "15845678901";
		}
		osw.close();
		fos.close();

	}
}
