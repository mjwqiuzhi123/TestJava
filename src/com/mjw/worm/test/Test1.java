package com.mjw.worm.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url = "http://www.xicidaili.com/nn/";
		Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
//		Elements pagination = document.getElementsByClass("pagination");
//		String tmp = pagination.get(0).getElementsByClass("next_page").get(0).attr("href");
		System.out.println(document.toString());
	}

}
