package com.santipingui58.spleef.menu.eng;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class RankedMapSelectorMenu extends MenuBuilder {

	public RankedMapSelectorMenu(Player p) {
		super("§aSelect a map", 1);
		
		s(0, new ItemBuilder(Material.MAP).setTitle("§a§lSCT").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListRanked("SCT")).
				build());
		
		s(1, new ItemBuilder(Material.MAP).setTitle("§a§lEnd").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListRanked("end")).
				build());
		
		s(2, new ItemBuilder(Material.MAP).setTitle("§a§lJardín").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListRanked("jardin")).
				build());
		
		s(3, new ItemBuilder(Material.MAP).setTitle("§a§lKraken").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListRanked("kraken")).
				build());
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if(slot == 0) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "SCT")) {
					GameManager.getManager().addRankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 
		if(slot == 1) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "end")) {
					GameManager.getManager().addRankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 

		if(slot == 2) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "jardin")) {
					GameManager.getManager().addRankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 
		if(slot == 3) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "kraken")) {
					GameManager.getManager().addRankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 
}
}
