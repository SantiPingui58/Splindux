package com.santipingui58.spleef.managers;

import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;

public class HelmetsManager {

	
	public void giveGameItems(Player p) {
		
	}
	
	public static void setSelectedHelmet(Player p,String helmet) {
		if (Main.data.getConfig().contains("data."+p.getUniqueId())) {
			Main.data.getConfig().set("data."+p.getUniqueId()+".cosmetics.capsule", helmet);
			Main.data.save();
		}
		}
	
	
	
	
}
