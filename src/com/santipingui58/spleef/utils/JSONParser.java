package com.santipingui58.spleef.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JSONParser {
	
	
	public static String getJSONFromURL(String input, String get) {
		 String jsonS = "";
	        URL url = null;
			try {
				url = new URL(input);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
	        URLConnection conn = null;
			try {
				conn = url.openConnection();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        try {
				conn.connect();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        String inputLine;

	        try {
				while((inputLine = in.readLine()) != null) {
				    jsonS+=inputLine;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	        Gson gson = new Gson();
	        JsonObject jsonObject= gson.fromJson(jsonS, JsonObject.class);
	        String id = jsonObject.get(get).getAsString();

	        try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return id;
	}

	}

