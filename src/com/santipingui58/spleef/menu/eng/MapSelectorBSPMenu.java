package com.santipingui58.spleef.menu.eng;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class MapSelectorBSPMenu extends MenuBuilder {

	public MapSelectorBSPMenu(Player p) {
		super("§aSelect a map", 1);
		
		s(0, new ItemBuilder(Material.MAP).setTitle("§a§lVoid").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("Void")).
				build());
		
		
		s(8, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cBack").
				build());
		
		
		
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if(slot == 0) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "Void")) {
					GameManager.getManager().addBSPUnrankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 	
		if (slot == 8) {
		new BuildSpleefPvPMenu(p).o(p);
	}

}
}
