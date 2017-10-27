package com.mjw.classloader.test;

import java.net.URL;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test(){
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();    
		for (int i = 0; i < urls.length; i++) {    
		    System.out.println(urls[i].toExternalForm());    
		} 
		System.out.println(System.getProperty("sun.boot.class.path"));  
	}
}
