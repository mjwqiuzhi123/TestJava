package com.mjw.sinoSpider.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<News> l = test();
		for (News n : l) {
			System.out.println(n.getUrl());
			System.out.println(n.getTitle());
			System.out.println("*********************");
		}
	}

	public static List<News> test() throws IOException {
		List<News> l = new ArrayList<News>();
		Connection connection = Jsoup
				.connect("http://roll.mil.news.sina.com.cn/photo_hz/photo_hdphoto/index.shtml");
		Document document = connection.get();
		Elements elementsMain = document.getElementsByClass("main");
		if (elementsMain.size() > 0) {
			for (Element main : elementsMain) {
				Elements cons = main.getElementsByClass("con");
				for (Element con : cons) {
					Elements p1 = con.getElementsByClass("p1");
					Elements as = p1.get(0).getElementsByTag("a");
					Element a = as.get(0);
					String url = a.attr("href");
					String title = a.attr("title");
					News news1 = new News();
					news1.setUrl(url);
					news1.setTitle(title);
					l.add(news1);
				}
			}
		}
		return l;
	}

}
