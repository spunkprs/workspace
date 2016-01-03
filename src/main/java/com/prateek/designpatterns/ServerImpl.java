package com.prateek.designpatterns;

public class ServerImpl implements Server {

	public String process(String url) {
		return url + " " + "processed";
	}
}
