package com.prateek.enumconceptsbrushup;

public enum SearchEngines {
GOOGLE("www.google.com"),
BING("www.bing.com"),
BAIDU("www.baidu.com"),
YAHOO("www.yahoo.com"),
UNKNOWN("");

private String url;

private SearchEngines(final String url) {
	this.url = url;
}

public String getUrl() {
	return url;
}

public static SearchEngines getByUrl(final String url) {
	for (SearchEngines searchEngine : SearchEngines.values()) {
		if (searchEngine.getUrl().equals(url)) {
			return searchEngine;
		}
	}
	return SearchEngines.UNKNOWN;
}
}
