package com.santipingui58.spleef.menu.eng;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class UnrankedMenu extends MenuBuilder {

	public UnrankedMenu(Player p) {
		super("§b§lUnraked games", 3);
		
		s(0, new ItemBuilder(Material.DIAMOND_SPADE).setTitle("§aSpleef 1vs1").
				build());
		
		s(1, new ItemBuilder(Material.BOW).setTitle("§aBowSpleef 1vs1").
				build());
		
		
		s(18, new ItemBuilder(Material.SNOW_BLOCK).setTitle("§aSpleef FFA").
				build());
		
		s(24, new ItemBuilder(Material.REDSTONE_BLOCK).setTitle("§a1vs1").
				build());
		s(25, new ItemBuilder(Material.COAL_BLOCK).setTitle("§a2vs2").
				build());
		s(26, new ItemBuilder(Material.COAL_BLOCK).setTitle("§a3vs3").
				build());
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 0) {
			new SpleefMenu(p).o(p);
		} else if (slot == 1) {
			p.closeInventory();
			p.sendMessage("§o§cComing soon...");		
		} else if (slot == 18) {
			GameManager.getManager().addSpleefFFAQueue(p);
		} else if (slot == 25) {
			new Unranked2vs2Menu(p).o(p);
		} else if (slot == 26) {
			p.closeInventory();
			p.sendMessage("§o§cComing soon...");
		}
	}

}
