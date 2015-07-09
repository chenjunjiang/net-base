package com.chenjj.net.base;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class GetTest {

	@Test
	public void test() {
		QueryString query = new QueryString("search", "java");
		try {
			URL url = new URL("http://search.dmoz.org/cgi-bin/search?" + query);
			InputStream in = new BufferedInputStream(url.openStream());
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while ((c = reader.read()) != -1) {
				System.out.println((char) c);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
