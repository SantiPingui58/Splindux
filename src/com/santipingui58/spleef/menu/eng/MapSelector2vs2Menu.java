package com.santipingui58.spleef.menu.eng;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class MapSelector2vs2Menu extends MenuBuilder {

	public MapSelector2vs2Menu(Player p) {
		super("§aSelect a map", 2);
		
		s(0, new ItemBuilder(Material.MAP).setTitle("§a§lIce Palace").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("icepalace")).
				build());
		s(17, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cBack").
				build());
		
		
		
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if(slot == 0) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "icepalace")) {
					GameManager.getManager().addSpleef2v2Queue(p, "icepalace");
					break;
			
		} 
		}
	}  else if (slot == 17) {
		new Spleef2vs2Menu(p).o(p);
	}
		
}
}
