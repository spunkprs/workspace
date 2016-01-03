package com.prateek.designpatterns;

public class ProxyDesignPattern {
	
	private Server server;
	public String processRequest(final String userName, final String pwd, final String url) throws Exception {
			server = new ProxyServer(userName, pwd, url);
			return server.process(url);
	}
}
