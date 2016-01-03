package com.prateek.designpatterns;

public class ProxyServer implements Server {

	private boolean isAdmin;
	private Server server;
	
	public ProxyServer(final String userName, final String pwd, final String url) throws Exception {
		isAdmin = isUserAdmin(userName, pwd);
	}
	
	private String processRequest(String url) throws Exception {
		server = new ServerImpl();
		return forwardRequest(url);
	}
	
	private String forwardRequest(final String url) throws Exception {
		if (isUrlContentViolatingPolicies(url)) {
			if (isAdmin) {
				return server.process(url);
			} else {
				throw new Exception("URL is not policies friendly");
			}
		} else {
			return server.process(url);
		}
	}

	private boolean isUrlContentViolatingPolicies(final String url) {
		if (url.contains("porn") || url.contains("nude") || url.contains("sex") || url.contains("facebook")) {
			return true;
		}
		return false;
	}

	public String process(String url) throws Exception {
		return processRequest(url);
	}
	
	private boolean isUserAdmin(String userName, String pwd) {
		if (userName.equals("ADMIN") && pwd.equals("ADMIN123")) {
			return true;
		}
		return false;
	}
}
