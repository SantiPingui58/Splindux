package com.santipingui58.spleef.menu.esp;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class SpleefMenu extends MenuBuilder {

	public SpleefMenu(Player p) {
		super("§b§lSpleef 1vs1", 3);
		
		s(11, new ItemBuilder(Material.NETHER_STAR).setTitle("§aMapa al azar").
				build());
		
		s(15, new ItemBuilder(Material.EMPTY_MAP).setTitle("§aSelecciona un mapa").
				build());
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			GameManager.getManager().addUnrankedQueue(p, null);
		} else if (slot == 15) {
			new MapSelectorMenu(p).o(p);
		}
	}

}
