package com.mjw.redis.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestRedis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test4();
	}

	// �������ӣ�ping������
	public static void test() {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		// �鿴�����Ƿ�����
		System.out.println("������������: " + jedis.ping());
	}

	// �������ӣ������ַ���String
	public static void test1() {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		// ���� redis �ַ�������
		jedis.set("runoobkey", "www.runoob.com");
		// ��ȡ�洢�����ݲ����
		System.out.println("redis �洢���ַ���Ϊ: " + jedis.get("runoobkey"));
	}

	// ����list
	public static void test2() {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		// �洢���ݵ��б���
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
		// ��ȡ�洢�����ݲ����
		List<String> list = jedis.lrange("site-list", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("�б���Ϊ: " + list.get(i));
		}
	}

	// ��ȡkeys
	public static void test3() {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");

		// ��ȡ���ݲ����
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}
	
	// ���hash
	public static void test4(){
		// ����redis
		Jedis jedis = new Jedis("localhost");
		System.out.println("����redis�ɹ�");
		
		// �������
		jedis.hset("hashTest", "field1", "test1");
		jedis.hset("hashTest", "field2", "test2");
		jedis.hset("hashTest", "field3", "test3");
		
		// ��ȡ����
		Map<String, String> map = jedis.hgetAll("hashTest");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String filed = it.next();
			System.out.println("field: " + filed + " value: " + map.get(filed));
		}
	}
}
