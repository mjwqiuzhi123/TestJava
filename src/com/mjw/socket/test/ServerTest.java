package com.mjw.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10000);
		Socket socket = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		while (true) {
			String msg = in.readLine();
			System.out.println("服务端收到的信息:" + msg);
			out.print("<html><head>my page</head><body>");
			out.print("server receivemjw:" + msg);
			out.print("</body></html>");
			out.flush();
			if (msg == "abc") {
				break;
			}
		}
		//socket.close();
	}
}
