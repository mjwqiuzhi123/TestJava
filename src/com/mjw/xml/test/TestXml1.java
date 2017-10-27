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
			// ����Ҫ������XML�ַ���
			String transMessage = "<?xml version=\"1.0\" encoding=\"GBK\"?>" 
					+ "<message>"
					+ "<body>"
					+ "<ticketNotify>"
					+ "<ticket id=\"6000012007051000000231\" dealTime=\"20070510165423\" status=\"0000\" message=\"�ɹ�,ϵͳ��������\"/>"
					+ "<ticket id=\"6000012007051000000232\" dealTime=\"20070510165424\" status=\"2012\" message=\"��ֹ��Ͷ\"/>"
					+ "</ticketNotify>"
					+ "</body>" 
					+ "</message>";
			// ����xml��������
			SAXReader reader = new SAXReader();
			// ����һ���ĵ�
			Document document = null;
			// ���ַ���ת��Ϊ
			document = reader.read(new ByteArrayInputStream(transMessage.getBytes("GBK")));
			// �õ�xml�ĸ��ڵ�(message)
			Element root = document.getRootElement();
			// ������ѭ����ı���
			Element ticket = null;

			Iterator tickets = null;
			for (tickets = root.element("body").element("ticketNotify")
					.elementIterator(); tickets.hasNext();) {
				ticket = (Element) tickets.next();
				System.out.print(ticket.attributeValue("id") + "  ");
				System.out.print(ticket.attributeValue("dealTime") + "  ");
				System.out.println(ticket.attributeValue("status"));

			}
			// Element.asXML��������ð����ñ�ǩ������XML����
			System.out.println(root.element("body").asXML());
			Map map = new HashMap();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}