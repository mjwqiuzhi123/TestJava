package com.mjw.worm.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaiduImageJsoup {

	// private static String url = "http://image.baidu.com/";
	// private static String foodUrl =
	// "http://originoo.com/ws/p.topiclist.php?cGljX2tleXdvcmRzPWNoaW5lc2UgZm9vZCZtZWRpdW1fdHlwZT1waWM=";//https://www.4493.com/meishi/
	private static String food = "https://www.4493.com/meishi/";// 美食
	private static final String rootUrl = "https://www.4493.com";
	private static List<String> fetchUrl;
	private static List<FoodModel> foodList = new ArrayList<FoodModel>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			fetchUrl = parseFood(food);
			for (String image : fetchUrl) {
				System.out.println(image);
			}
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> parse(String url) throws IOException {
		List<String> imageUrlList = new ArrayList<String>();
		Connection connection = Jsoup.connect(url);
		Document document = connection.get();
		System.out.println(document.toString());
		Element imglist = document.getElementById("imglist");
		if (imglist != null) {
			Elements imgrowList = imglist.getElementsByClass("imgrow");
			if (imgrowList.size() > 0) {
				for (Element imgrow : imgrowList) {
					Elements imgList = imgrow.getElementsByTag("img");
					if (imgList.size() > 0) {
						for (Element img : imgList) {
							String imgUrl = img.attr("src");
							imageUrlList.add(imgUrl);
						}
					}
				}
			}
		}
		return imageUrlList;
	}

	// 抓取4399美食图片
	public static List<String> parseFood(String url) throws IOException {
		List<String> foodUrlList = new ArrayList<String>();
		Connection connection = Jsoup.connect(url);
		Document document = connection.get();
		FoodModel fm = null;
		// System.out.println(document.toString());
		Elements meishilist = document.getElementsByClass("meishiul");
		if (meishilist.size() > 0) {
			for (Element meishi : meishilist) {
				Elements detailList = meishi.getElementsByTag("a");
				if (detailList.size() > 0) {
					for (Element detail : detailList) {
						String foodUrl = rootUrl + detail.attr("href");
						String title = detail.attr("title");
						Elements img = detail.getElementsByTag("img");
						String picUrl = img.get(0).attr("src");
						fm = new FoodModel(foodUrl, title, picUrl);
						System.out.println("title: " + title + "url: " + foodUrl + "Pic: " + picUrl);
						foodList.add(fm);
					}
				}
			}
		}
		return foodUrlList;
	}

	// 下载4399美食图片
	public static void downLoadPic(List<FoodModel> foodList) {
		for(FoodModel fm : foodList){
			
		}
	}
}
