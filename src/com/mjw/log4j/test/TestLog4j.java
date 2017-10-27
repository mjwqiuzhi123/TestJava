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

	// 利用properties文件进行日志管理
	public static void test1() {
		// 1.自动快速地使用缺省Log4j环境。
		// BasicConfigurator.configure ();
		// 2.读取properties配置
		//PropertyConfigurator.configure(new File("").getAbsolutePath() + "/src/log4j.properties");
		// 3.读取XML形式的配置文件。
		DOMConfigurator.configure (new File("").getAbsolutePath() + "/src/log4j.xml");
		// 记录debug级别的信息
		logger.debug("This is debug message.");
		// 记录info级别的信息
		logger.info("This is info message.");
		// 记录error级别的信息
		logger.error("This is error message.");
	}

	// ***********************************
	// # 自定义样式
	// # %r 时间 0
	// # %t 方法名 main
	// # %p 优先级 DEBUG/INFO/ERROR
	// # %c 所属类的全名(包括包名)
	// # %l 发生的位置，在某个类的某行
	// # %m 输出代码中指定的讯息，如log(message)中的message
	// # %n 输出一个换行
	// log4j.appender.appender1.layout.ConversionPattern=%r [%t] [%p] - %c -%l
	// -%m%n
	// ***************************************

	// 利用XML文件进行日志管理
	public static void test2() {
		// 读取properties配置
		PropertyConfigurator.configure(new File("").getAbsolutePath()
				+ "/src/log4j.properties");
		// 记录debug级别的信息
		logger.debug("This is debug message.");
		// 记录info级别的信息
		logger.info("This is info message.");
		// 记录error级别的信息
		logger.error("This is error message.");
	}
}
