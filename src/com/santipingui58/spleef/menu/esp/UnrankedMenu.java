package com.santipingui58.spleef.menu.esp;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class UnrankedMenu extends MenuBuilder {

	public UnrankedMenu(Player p) {
		super("§b§lPartidas Unranked", 3);
		
		s(0, new ItemBuilder(Material.DIAMOND_SPADE).setTitle("§aSpleef 1vs1").
				build());
		
		s(18, new ItemBuilder(Material.SNOW_BLOCK).setTitle("§aSpleef FFA").
				build());
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 0) {
			new SpleefMenu(p).o(p);
		} else if (slot == 18) {
			GameManager.getManager().addSpleefFFAQueue(p);
		}
	}

}
