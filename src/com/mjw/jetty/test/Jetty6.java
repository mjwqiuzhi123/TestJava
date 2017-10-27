package com.mjw.jetty.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

public class Jetty6 {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		SelectChannelConnector connector1 = new SelectChannelConnector();
		connector1.setPort(9000);
		SelectChannelConnector connector2 = new SelectChannelConnector();
		connector2.setPort(9001);
		server.addConnector(connector1);
		server.addConnector(connector2);
		server.setHandler(new HelloHandler());
		server.start();
		server.join();
	}
}