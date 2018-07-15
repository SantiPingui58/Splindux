package com.santipingui58.spleef.menu.esp;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class BowSpleefMenu extends MenuBuilder {

	public BowSpleefMenu(Player p) {
		super("§b§lBow Spleef 1vs1", 3);
		
		s(11, new ItemBuilder(Material.NETHER_STAR).setTitle("§aMapa al azar").
				build());
		
		s(15, new ItemBuilder(Material.EMPTY_MAP).setTitle("§aSelecciona un mapa").
				build());
		
		s(26, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cVolver").
				build());
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			GameManager.getManager().addBowSpleefUnrankedQueue(p, null);
		} else if (slot == 15) {
			new MapSelectorBowSpleefMenu(p).o(p);
		}
		else if (slot == 26) {
			new UnrankedMenu(p).o(p);
		}
	}

}
