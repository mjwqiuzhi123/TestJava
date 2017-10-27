/**
 * ����ģʽ(�������)
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
		//��ȡ��·��(����)
		String path1 = Boy.class.getResource("").getFile();
		//��ȡ��·��(������)classpath
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


//���÷���ʵ�ֹ���ģʽ
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
			//���·�������classpath�����·����package���Կ������ļ���ǰ׺�������ؿ������ļ��У���new File()��ʱ��һ��Ҫ���ļ�ȷ�е�·����Ҳ��������Եģ���Ե��Ǹ�Ŀ¼����
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
