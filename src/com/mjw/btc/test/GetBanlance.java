package com.mjw.btc.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class GetBanlance {

	// 用户名
	private static String ACCESS_KEY = null;
	// 密码
	private String SECRET_KEY = null;
	// 钱包IP地址
	private String IP = null;
	// 端口
	private String PORT = null;
	// 比特币钱包密码
	private String PASSWORD = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//getbalance("0xdC59ac181b00ecD0F09AF2923096458B80eDDF71");
		getNewaddress("mjw723318462@");
		eth_accounts();
	}
	
	public static JSONObject getbalance(String address) throws Exception {
		String s = main("eth_getBalance", "[\""+address+"\", \"latest\"]");
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}
	
	// 新建钱包
	public static JSONObject getNewaddress(String walletPassword) throws Exception {
		String s = main("personal_newAccount", "[\""+walletPassword+"\"]");
		JSONObject json = JSONObject.fromObject(s);
		System.out.println("return personal_newAccount's jsonString:" + json.toString());
        return json;
	}
	
	// 获取账户数量
	public static JSONObject eth_accounts() throws Exception {
		String s = main("eth_accounts", "[]");
		JSONObject json = JSONObject.fromObject(s);
		System.out.println("return eth_accounts's jsonString:" + json.toString());
		return json;
	}

	// '{"jsonrpc":"2.0","method":"eth_getBalance","params":["0x407d73d8a49eeb85d32cf465507dd71d507100c1",
	// "latest"],"id":1}'
	private static String main(String method, String condition) throws Exception {
		String result = "";
		String tonce = "" + (System.currentTimeMillis() * 1000);
		String params = "tonce=" + tonce.toString() + "&requestmethod=post&id=1&method=" + method
				+ "&params=" + condition;

		String url = "http://" + "localhost" + ":" + "23116";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Json-Rpc-Tonce", tonce.toString());

		String postdata = "{\"jsonrpc\":\"2.0\",\"method\":\"" + method
				+ "\", \"params\":" + condition + ", \"id\": 1}";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postdata);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		if (responseCode != 200) {
			return "{\"result\":null,\"error\":" + responseCode + ",\"id\":1}";
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		inputLine = in.readLine();
		response.append(inputLine);
		in.close();
		result = response.toString();
		System.out.println(result);
		return result;
	}
}
