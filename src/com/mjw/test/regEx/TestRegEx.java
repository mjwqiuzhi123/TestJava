package com.mjw.test.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	//email's test
	public static void test(){
		// Ҫ��֤���ַ���
	    String str = "service@xsoftlab.net";
	    // ������֤����
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    // ����������ʽ
	    Pattern pattern = Pattern.compile(regEx);
	    // ���Դ�Сд��д��
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // �ַ����Ƿ���������ʽ��ƥ��
	    boolean rs = matcher.matches();
	    System.out.println(rs);
	}
}
