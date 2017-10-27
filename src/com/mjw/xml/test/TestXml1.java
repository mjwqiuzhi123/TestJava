package com.mjw.xml.test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXml1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// 定义要解析的XML字符串
			String transMessage = "<?xml version=\"1.0\" encoding=\"GBK\"?>" 
					+ "<message>"
					+ "<body>"
					+ "<ticketNotify>"
					+ "<ticket id=\"6000012007051000000231\" dealTime=\"20070510165423\" status=\"0000\" message=\"成功,系统处理正常\"/>"
					+ "<ticket id=\"6000012007051000000232\" dealTime=\"20070510165424\" status=\"2012\" message=\"禁止倍投\"/>"
					+ "</ticketNotify>"
					+ "</body>" 
					+ "</message>";
			// 创建xml解析对象
			SAXReader reader = new SAXReader();
			// 定义一个文档
			Document document = null;
			// 将字符串转换为
			document = reader.read(new ByteArrayInputStream(transMessage.getBytes("GBK")));
			// 得到xml的根节点(message)
			Element root = document.getRootElement();
			// 定义子循环体的变量
			Element ticket = null;

			Iterator tickets = null;
			for (tickets = root.element("body").element("ticketNotify")
					.elementIterator(); tickets.hasNext();) {
				ticket = (Element) tickets.next();
				System.out.print(ticket.attributeValue("id") + "  ");
				System.out.print(ticket.attributeValue("dealTime") + "  ");
				System.out.println(ticket.attributeValue("status"));

			}
			// Element.asXML方法，获得包括该标签的所有XML数据
			System.out.println(root.element("body").asXML());
			Map map = new HashMap();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}