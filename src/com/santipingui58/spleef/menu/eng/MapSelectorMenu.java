package com.santipingui58.spleef.menu.eng;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class MapSelectorMenu extends MenuBuilder {

	public MapSelectorMenu(Player p) {
		super("§aSelect a map", 2);
		
		s(0, new ItemBuilder(Material.MAP).setTitle("§a§lSCT").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("SCT")).
				build());
		
		s(1, new ItemBuilder(Material.MAP).setTitle("§a§lEnd").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("end")).
				build());
		
		s(2, new ItemBuilder(Material.MAP).setTitle("§a§lJardín").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("jardin")).
				build());
		s(3, new ItemBuilder(Material.MAP).setTitle("§a§lKraken").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("kraken")).
				build());
		s(4, new ItemBuilder(Material.MAP).setTitle("§a§lIgnition").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("ignition")).
				build());
		
		s(17, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cBack").
				build());
		
		
		
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if(slot == 0) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "SCT")) {
					GameManager.getManager().addUnrankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 
		
		if(slot == 1) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "end")) {
					GameManager.getManager().addUnrankedQueue(p, s.getId());
					break;
			
		} 
		}
	}  
		if(slot == 2) {
		for (Game s :  GameManager.getManager().getArenasList()) {
			if (Main.containsIgnoreCase(s.getId(), "jardin")) {
				GameManager.getManager().addUnrankedQueue(p, s.getId());
				break;
		
	} 
	}
} 
		
		if(slot == 3) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "kraken")) {
					GameManager.getManager().addUnrankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 
		
		if(slot == 4) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "ignition")) {
					GameManager.getManager().addUnrankedQueue(p, s.getId());
					break;
			
		} 
		}
	}  else if (slot == 17) {
		new SpleefMenu(p).o(p);
	}

}
}
