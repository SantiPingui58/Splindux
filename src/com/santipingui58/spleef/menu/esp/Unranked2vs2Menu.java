package com.santipingui58.spleef.menu.esp;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class Unranked2vs2Menu extends MenuBuilder {

	public Unranked2vs2Menu(Player p) {
		super("§b§lPartidas Unranked 2vs2",3);
		
		s(0, new ItemBuilder(Material.DIAMOND_SPADE).setTitle("§aSpleef 2vs2").
				build());
		
		s(1, new ItemBuilder(Material.BOW).setTitle("§aBowSpleef 2vs2").
				build());
		
		s(24, new ItemBuilder(Material.COAL_BLOCK).setTitle("§a1vs1").
				build());
		s(25, new ItemBuilder(Material.REDSTONE_BLOCK).setTitle("§a2vs2").
				build());
		s(26, new ItemBuilder(Material.COAL_BLOCK).setTitle("§a3vs3").
				build());
		
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 0) {
			new Spleef2vs2Menu(p).o(p);
		} else if (slot == 1) {
			p.closeInventory();
			p.sendMessage("§o§cProximamente...");	
		} else if (slot == 24) {
			new UnrankedMenu(p).o(p);
		} else if (slot == 26) {
			p.closeInventory();
				p.sendMessage("§o§cProximamente...");
			
		}
	}

}
