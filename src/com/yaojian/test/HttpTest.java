package com.yaojian.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

	private static final String URL_STRING = "http://localhost:8080/yuelian/service";

	public static void main(String[] args) {
		URL url = null;
		HttpURLConnection connetion = null;
		InputStream in = null;
		OutputStream out = null;
		try {
			url = new URL(URL_STRING);
			connetion = (HttpURLConnection) url.openConnection();
			connetion.setDoInput(true);
			connetion.setDoOutput(true);
			out = connetion.getOutputStream();
			out.write(getRegisterBody().getBytes("UTF-8"));
			in = connetion.getInputStream();
			int i = -1;
			String s = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf8")); 
			
			System.out.println("=====================" + br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connetion != null) {
				connetion.disconnect();
				connetion = null;
			}
			try {
				if (out != null) {
					out.close();
					out = null;
				}
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getRegisterBody() {
		String body = "{\"version\":\"v1.0\",\"messagetype\":\"REGISTER_REQ\",\"params\":{\"username\":\"yaojian1\",\"password\":\"yaojian1\",\"usertype\":1}}";
		return body;
	}

}
