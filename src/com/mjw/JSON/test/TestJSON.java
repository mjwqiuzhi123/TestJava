package com.mjw.JSON.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJSON {
	
	//private static final JSONObject ArrayList = null;
	//private static JSONObject jsonObject;
	private static String arrayStr;
	
	public static void main(String[] args) throws JSONException {

		// 创建JSONObject对象
//		JSONObject json = new JSONObject();
//
//		// 向json中添加数据
//		json.put("username", "wanglihong");
//		json.put("height", 12.5);
//		json.put("age", 24);
//
//		// 创建JSONArray数组，并将json添加到数组
//		JSONArray array = new JSONArray();
//		array.put(json);
//
//		// 转换为字符串
//		String jsonStr = array.toString();
//
//		System.out.println(jsonStr);
	
		//JsonToString();
		//StringToJson();
		test();
		//StringToJson();
	}
	
	public static void JsonToString() throws JSONException{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "majunwei");
		jsonObject.put("sex", "男");
		jsonObject.put("age", 27);
		
		JSONArray array = new JSONArray();
		array.put(jsonObject);
		
		String jsonObjectStr = jsonObject.toString();
		arrayStr = array.toString();
		
		System.out.println(jsonObjectStr);
		System.out.println(arrayStr);
	}
	
	public static void StringToJson() throws JSONException{
		JSONArray array = new JSONArray(arrayStr); 
		JSONObject object = array.getJSONObject(0);
		String sex = object.getString("sex");
		String name = object.getString("name");
		int age = object.getInt("age");
		System.out.print("I am:" + sex);
		System.out.print("  " + name);
		System.out.print(" " + age);
	}
	
	public static void objectToJSONArray() throws JSONException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("compary", "huaheng");
		map.put("address", "starInternal");
		JSONArray array = new JSONArray();
		array.put(map);
		System.out.println(map.get("compary"));
		System.out.println(map.toString());
		System.out.println(array.toString());
		JSONObject object = array.getJSONObject(0);
		String address = object.getString("address");
		System.err.println(address);
	}
	
	//JSON数组也List之间的转换
	public static void testList() throws JSONException{
		List<String> list = new ArrayList<String>();
		list.add("name");
		list.add("address");
		list.add("instruction");
		
		JSONArray array = new JSONArray();
		array.put(list);
		System.out.println(array.toString());
		
		JSONArray array1 = (JSONArray) array.get(0);
		for(int i = 0;i<array1.length();i++){
			System.err.println((String)array1.get(i));
		}
	}
	
	public static void stringAndJSONObject() throws JSONException{
		String str = "{'a':'b','c':'d'}";
		String str1 = "{\"a\":\"b\", \"c\":\"d\"}";
		JSONObject jb = new JSONObject(str);
		JSONObject jb1 = new JSONObject(str1);
		System.out.println(jb.toString());
		System.out.println(jb1.toString());
	}
	
	//测试将一个简单的字符串转换为json
	public static void test() throws JSONException{
		String fail = "I am string";// 测试失败，字符串中必须包含“{}和：”才能转换为JSON，也就是说字符串格式必须为 {key:value}
		String success = "{key : I am String!}";
		JSONObject jo = new JSONObject(fail);
		System.out.println(jo.toString());
		
	}
}     
