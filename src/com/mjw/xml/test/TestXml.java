package com.mjw.xml.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TestXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
		try {
			// TODO Auto-generated method stub
			// 定义要解析的XML字符串
			String transMessage = "<?xml version=\"1.0\" encoding=\"GBK\"?><message>"
					+ "<body>"
					+ "<ticketNotify>"
					+ "<ticket id=\"6000012007051000000231\" dealTime=\"20070510165423\" status=\"0000\" message=\"成功,系统处理正常\"/>"
					+ "<ticket id=\"6000012007051000000232\" dealTime=\"20070510165424\" status=\"2012\" message=\"禁止倍投\"/>"
					+ "</ticketNotify>" + "</body></message>";
			// 创建xml解析对象
			// SAXReader reader = new SAXReader();
			// 定义一个文档
			Document document = null;
			// 将字符串转换为
			// document = reader.read(new ByteArrayInputStream(transMessage
			// .getBytes("GBK")));

			document = DocumentHelper.parseText(transMessage);
			// 得到xml的根节点(message)
			Element root = document.getRootElement();
			//System.err.println(root.getName());
			// 定义子循环体的变量
			Element ticket = null;

			Iterator tickets = null;
			for (tickets = root.element("body").element("ticketNotify").elementIterator(); tickets.hasNext();) {
				ticket = (Element) tickets.next();
				List<String> list = new ArrayList<String>();
				list.add("age = 28");
				//ticket.setAttributes(list);
				//System.err.println(ticket.toString());
				//ticket.addAttribute("age", "28");// 增加属性
				System.out.print(ticket.attributeValue("id") + "  ");// 获取属性
				System.out.print(ticket.attributeValue("dealTime") + "  ");
				System.out.println(ticket.attributeValue("status"));
				//System.err.println(ticket.attributeValue("age"));// 没有该属性 返回null
			}
			System.err.println(document.asXML());
			System.err.println(document.toString());
			// Element.asXML方法，获得包括该标签的所有XML数据
			System.out.println(root.element("body").asXML());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test(){
		char b = '0';
		char a = 97;
		System.out.println(b + 1 + "c");
	}
}