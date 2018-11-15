package com.restful.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetJavaNetClient {

	public static void main(String a[]){
		
		String url = "http://localhost/RestfulWebserviceDemo/rest/order-inventory/orderJson/1016";
		HttpURLConnection urlConn = null;
		BufferedReader reader = null;
		try {
			URL urlObj = new URL(url);
			urlConn = (HttpURLConnection) urlObj.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setConnectTimeout(15000);
			urlConn.setReadTimeout(5000);
			urlConn.setRequestProperty("Accept", "application/json");
			if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.err.println("Unable to connect to the URL...");
				return;
			}
			System.out.println("Connected to the server...");
			InputStream is = urlConn.getInputStream();
			reader = new BufferedReader(new InputStreamReader((is)));
			System.out.println("Reading data from server...");
			String tmpStr = null;
			while((tmpStr = reader.readLine()) != null){
				System.out.println(tmpStr);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) reader.close();
				if(urlConn != null) urlConn.disconnect();
			} catch(Exception ex){
				
			}
		}
	}
}