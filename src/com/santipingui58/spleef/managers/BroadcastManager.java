package com.santipingui58.spleef.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;

public class BroadcastManager {

	public static void Broadcast() {
	
		final String prefix_esp = "§c[§2Anuncio§c]  ";
		final String prefix_eng = "§c[§2Alert§c]  ";
        
		Set<String> anuncios_esp = Main.anuncios.getConfig().getConfigurationSection("anuncios_esp").getKeys(false);
		Set<String> anuncios_eng = Main.anuncios.getConfig().getConfigurationSection("anuncios_eng").getKeys(false);
	    
	    final List<String> anuncios_esp_lista = new ArrayList<String>();
	    final List<String> anuncios_eng_lista = new ArrayList<String>();
	    
	    
	    int size = 0;
	    for (String s: anuncios_esp) {
	    	size++;
	    	
	    	anuncios_esp_lista.add(Main.anuncios.getConfig().getString("anuncios_esp."+s));
	    }
	    
	    for (String s: anuncios_eng) {
	    	anuncios_eng_lista.add(Main.anuncios.getConfig().getString("anuncios_eng." +s));
	    }


	    
	    
	  
	    final int randomNum = ThreadLocalRandom.current().nextInt(0, size);
	        for (Player p : Bukkit.getOnlinePlayers()) {
	       if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	    	   String s = anuncios_esp_lista.get(randomNum);
	    	   p.sendMessage(prefix_esp + ChatColor.translateAlternateColorCodes('&', s));  	   
	       } else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	    	   String s = anuncios_eng_lista.get(randomNum);
	    	   p.sendMessage(prefix_eng + ChatColor.translateAlternateColorCodes('&', s));  
	       } 
	        } 
	        
	        String s = anuncios_esp_lista.get(randomNum);
	        Bukkit.getConsoleSender().sendMessage(prefix_esp + ChatColor.translateAlternateColorCodes('&', s));  	   
	        	}

}