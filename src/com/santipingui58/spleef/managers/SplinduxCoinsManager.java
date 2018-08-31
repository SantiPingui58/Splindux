package com.santipingui58.spleef.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SplinduxCoinsManager {

	public static void addSplinduxCoins (String UUID, int coins) {
		Player p = Bukkit.getServer().getPlayer(UUID);
				if (Bukkit.getOnlinePlayers().contains(p)) {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§e§lSplin§b§ldux §aHas recibido §3" + coins + "SplinduxCoins§a!");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§e§lSplin§b§ldux §aYou have received §3" + coins + "SplinduxCoins§a!");
					}
				}
				
				DataManager.addSC(UUID, coins);
}
}
