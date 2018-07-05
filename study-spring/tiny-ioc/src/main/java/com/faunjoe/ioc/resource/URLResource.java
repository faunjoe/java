package com.faunjoe.ioc.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLResource implements Resource {
	private URL url;
	
	public URLResource(URL url) {
		this.url = url;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		connection.connect();
		return connection.getInputStream();
	}

}
