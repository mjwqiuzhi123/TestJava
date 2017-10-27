package com.mjw.log4j.test;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class TestLog4j {
	private static Logger logger = Logger.getLogger(TestLog4j.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}

	// ����properties�ļ�������־����
	public static void test1() {
		// 1.�Զ����ٵ�ʹ��ȱʡLog4j������
		// BasicConfigurator.configure ();
		// 2.��ȡproperties����
		//PropertyConfigurator.configure(new File("").getAbsolutePath() + "/src/log4j.properties");
		// 3.��ȡXML��ʽ�������ļ���
		DOMConfigurator.configure (new File("").getAbsolutePath() + "/src/log4j.xml");
		// ��¼debug�������Ϣ
		logger.debug("This is debug message.");
		// ��¼info�������Ϣ
		logger.info("This is info message.");
		// ��¼error�������Ϣ
		logger.error("This is error message.");
	}

	// ***********************************
	// # �Զ�����ʽ
	// # %r ʱ�� 0
	// # %t ������ main
	// # %p ���ȼ� DEBUG/INFO/ERROR
	// # %c �������ȫ��(��������)
	// # %l ������λ�ã���ĳ�����ĳ��
	// # %m ���������ָ����ѶϢ����log(message)�е�message
	// # %n ���һ������
	// log4j.appender.appender1.layout.ConversionPattern=%r [%t] [%p] - %c -%l
	// -%m%n
	// ***************************************

	// ����XML�ļ�������־����
	public static void test2() {
		// ��ȡproperties����
		PropertyConfigurator.configure(new File("").getAbsolutePath()
				+ "/src/log4j.properties");
		// ��¼debug�������Ϣ
		logger.debug("This is debug message.");
		// ��¼info�������Ϣ
		logger.info("This is info message.");
		// ��¼error�������Ϣ
		logger.error("This is error message.");
	}
}
