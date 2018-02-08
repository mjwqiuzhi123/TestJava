package com.mjw.worm.test;

/**
 * 4399√¿ ≥Model
 * 
 * @author mjw
 * 
 */
public class FoodModel {

	private String url;
	private String title;
	private String picUrl;

	public FoodModel(String url, String title, String picUrl){
		this.url = url;
		this.title = title;
		this.picUrl = picUrl;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
