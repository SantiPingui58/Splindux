package com.santipingui58.spleef.managers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class VotifierListener {
	
	
	
	public static boolean ona() {
		 boolean ret = false;
		try { 
			URL url = new URL("https://api.namemc.com/server/mc.splindux.com/likes?profile=403e6cb7-a6ca-440a-8041-7fb1e579b5a5");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String str = null;
	        while ((str = in.readLine()) != null) {
	            str = str.toLowerCase();
	            if (str.contains("true")) {
	                ret = true;
	                break;
	            }
	        }
	        in.close();
	} catch (Exception e) {}
		return ret;

}
}
