/**
 * 工厂模式(反射机制)
 * @author mjw
 * @date 20161101
 */
package com.mjw.factory.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SimpleFactoryTest {
	public static void main(String[] args) {
		// PersonFactory pf = new PersonFactory();
		Properties p = GetProperties.property();
		PersonFactory.Who(p.getProperty("girl")).say();
		//获取类路径(含包)
		String path1 = Boy.class.getResource("").getFile();
		//获取类路径(不含包)classpath
		String path2 = Boy.class.getResource("/").getFile();
		System.out.println(path1);
		System.out.println(path2);
	}

}

interface Person {
	public void say();
}

class Boy implements Person {
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("I am boy!");
	}
}

class Girl implements Person {
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("I am girl!");
	}
}


//利用反射实现工厂模式
class PersonFactory {
	public static Person Who(String sex) {
		Person p = null;
		try {
			p = (Person) Class.forName(sex).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}

class GetProperties {
	public static Properties property() {
		Properties p = new Properties();
		try {
//			FileInputStream in = new FileInputStream("src/A.properties");
//			p.load(in);
//			in.close();
			//相对路径是相对classpath下面的路径，package可以看作是文件的前缀名，不必看成是文件夹！【new File()的时候一定要用文件确切的路径，也可以是相对的，相对的是根目录！】
			p.load(GetProperties.class.getClassLoader().getResourceAsStream("param.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
