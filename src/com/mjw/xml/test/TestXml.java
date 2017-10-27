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
			// ����Ҫ������XML�ַ���
			String transMessage = "<?xml version=\"1.0\" encoding=\"GBK\"?><message>"
					+ "<body>"
					+ "<ticketNotify>"
					+ "<ticket id=\"6000012007051000000231\" dealTime=\"20070510165423\" status=\"0000\" message=\"�ɹ�,ϵͳ��������\"/>"
					+ "<ticket id=\"6000012007051000000232\" dealTime=\"20070510165424\" status=\"2012\" message=\"��ֹ��Ͷ\"/>"
					+ "</ticketNotify>" + "</body></message>";
			// ����xml��������
			// SAXReader reader = new SAXReader();
			// ����һ���ĵ�
			Document document = null;
			// ���ַ���ת��Ϊ
			// document = reader.read(new ByteArrayInputStream(transMessage
			// .getBytes("GBK")));

			document = DocumentHelper.parseText(transMessage);
			// �õ�xml�ĸ��ڵ�(message)
			Element root = document.getRootElement();
			//System.err.println(root.getName());
			// ������ѭ����ı���
			Element ticket = null;

			Iterator tickets = null;
			for (tickets = root.element("body").element("ticketNotify").elementIterator(); tickets.hasNext();) {
				ticket = (Element) tickets.next();
				List<String> list = new ArrayList<String>();
				list.add("age = 28");
				//ticket.setAttributes(list);
				//System.err.println(ticket.toString());
				//ticket.addAttribute("age", "28");// ��������
				System.out.print(ticket.attributeValue("id") + "  ");// ��ȡ����
				System.out.print(ticket.attributeValue("dealTime") + "  ");
				System.out.println(ticket.attributeValue("status"));
				//System.err.println(ticket.attributeValue("age"));// û�и����� ����null
			}
			System.err.println(document.asXML());
			System.err.println(document.toString());
			// Element.asXML��������ð����ñ�ǩ������XML����
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