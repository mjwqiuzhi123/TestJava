package com.mjw.socket.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s = null;
		while(true){
		try {
			Thread.sleep(1000);
			s = new Socket("localhost",10001);
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
