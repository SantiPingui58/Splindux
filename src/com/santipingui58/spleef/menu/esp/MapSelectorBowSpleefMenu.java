package com.santipingui58.spleef.menu.esp;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class MapSelectorBowSpleefMenu extends MenuBuilder {

	public MapSelectorBowSpleefMenu(Player p) {
		super("§aSelecciona un mapa", 1);
		
		s(0, new ItemBuilder(Material.MAP).setTitle("§a§lAtomic").
				addLore("§aQueue: §b" + GameManager.getManager().getQueueMapListUnranked("Atomic")).
				build());
		
		
		s(8, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cVolver").
				build());
		
		
		
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if(slot == 0) {
			for (Game s :  GameManager.getManager().getArenasList()) {
				if (Main.containsIgnoreCase(s.getId(), "Atomic")) {
					GameManager.getManager().addBowSpleefUnrankedQueue(p, s.getId());
					break;
			
		} 
		}
	} 	
		if (slot == 8) {
		new BowSpleefMenu(p).o(p);
	}

}
}
