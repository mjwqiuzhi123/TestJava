package com.mjw.worm.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Image4399Jsoup {

	// private static String url = "http://image.baidu.com/";
	// private static String foodUrl =
	// "http://originoo.com/ws/p.topiclist.php?cGljX2tleXdvcmRzPWNoaW5lc2UgZm9vZCZtZWRpdW1fdHlwZT1waWM=";//https://www.4493.com/meishi/
	private static String food = "https://www.4493.com/meishi/";// ��ʳ
	private static final String rootUrl = "https://www.4493.com";
	private static List<String> fetchUrl;
	private static List<FoodModel> foodList = new ArrayList<FoodModel>();
	private static Set<String> picUrlSet = new HashSet<String>();// ��������set��ͼƬȥ��

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			fetchUrl = parseFood(food);
			for (String image : fetchUrl) {
				System.out.println(image);
			};
			//downLoadPic(foodList);
			downLoadPic1(picUrlSet);
		} catch (IOException e) {
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

	// ץȡ4399��ʳͼƬ
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
						picUrlSet.add(picUrl);
					}
				}
			}
		}
		return foodUrlList;
	}

	// ����4399��ʳͼƬ(��ȥ�ش���)
	public static void downLoadPic(List<FoodModel> foodList) {
		for(FoodModel fm : foodList){
			try {
				URL url = new URL(fm.getPicUrl());
				//���������ַ  
				URLConnection uc = url.openConnection();
				//��ȡ���ӵ������  
	            InputStream is = uc.getInputStream();
	            File dir = new File("F:\\aaaaa");
	          //�ж��ļ�Ŀ¼�Ƿ����
	            boolean createFlag = false;
	            if(!dir.exists()){
	            	createFlag = dir.mkdir();
	            }
	            System.out.println(createFlag);
	            File file = new File("F:\\aaaaa\\" + fm.getPicUrl().substring(fm.getPicUrl().lastIndexOf("/") + 1)/*NetUtil.getStrName(src)*/); 
	            DataInputStream dataInputStream = new DataInputStream(is);  
	            FileOutputStream fileOutputStream = new FileOutputStream(file);  
	            byte[] bytes = new byte[1024];  
	            int length = 0;  
	            while ((length = dataInputStream.read(bytes)) != -1) {  
	                fileOutputStream.write(bytes, 0, length);  
	                //System.out.println("������....");  
	            }
	            System.out.println("�������...");  
	            dataInputStream.close();  
	            fileOutputStream.close();
	            
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// ����4399��ʳͼƬ(����ȥ�ش���)
		public static void downLoadPic1(Set<String> set) {
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String picUrl = it.next();
				try {
					URL url = new URL(picUrl);
					//���������ַ  
					URLConnection uc = url.openConnection();
					//��ȡ���ӵ������  
		            InputStream is = uc.getInputStream();
		            File dir = new File("F:\\4399");
		          //�ж��ļ�Ŀ¼�Ƿ����
		            boolean createFlag = false;
		            if(!dir.exists()){
		            	createFlag = dir.mkdir();
		            }
		            System.out.println(createFlag);
		            File file = new File("F:\\4399\\" + picUrl.substring(picUrl.lastIndexOf("/") + 1)/*NetUtil.getStrName(src)*/); 
		            DataInputStream dataInputStream = new DataInputStream(is);  
		            FileOutputStream fileOutputStream = new FileOutputStream(file);  
		            byte[] bytes = new byte[1024];  
		            int length = 0;  
		            while ((length = dataInputStream.read(bytes)) != -1) {  
		                fileOutputStream.write(bytes, 0, length);  
		                //System.out.println("������....");  
		            }
		            System.out.println("�������...");  
		            dataInputStream.close();  
		            fileOutputStream.close();
		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			for(FoodModel fm : foodList){
				try {
					URL url = new URL(fm.getPicUrl());
					//���������ַ  
					URLConnection uc = url.openConnection();
					//��ȡ���ӵ������  
		            InputStream is = uc.getInputStream();
		            File dir = new File("F:\\aaaaa");
		          //�ж��ļ�Ŀ¼�Ƿ����
		            boolean createFlag = false;
		            if(!dir.exists()){
		            	createFlag = dir.mkdir();
		            }
		            System.out.println(createFlag);
		            File file = new File("F:\\aaaaa\\" + fm.getPicUrl().substring(fm.getPicUrl().lastIndexOf("/") + 1)/*NetUtil.getStrName(src)*/); 
		            DataInputStream dataInputStream = new DataInputStream(is);  
		            FileOutputStream fileOutputStream = new FileOutputStream(file);  
		            byte[] bytes = new byte[1024];  
		            int length = 0;  
		            while ((length = dataInputStream.read(bytes)) != -1) {  
		                fileOutputStream.write(bytes, 0, length);  
		                //System.out.println("������....");  
		            }
		            System.out.println("�������...");  
		            dataInputStream.close();  
		            fileOutputStream.close();
		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
