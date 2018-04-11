package com.mjw.classloader.test;

import java.net.URL;

public class Test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		test();
		while(true){
			Thread.sleep(100);
		}
	}

	public static void test(){
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();    
		for (int i = 0; i < urls.length; i++) {    
		    System.out.println(urls[i].toExternalForm());    
		} 
		System.out.println(System.getProperty("sun.boot.class.path"));  
	}
	
	static class test1{}
}
