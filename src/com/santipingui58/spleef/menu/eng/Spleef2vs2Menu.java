package com.santipingui58.spleef.menu.eng;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class Spleef2vs2Menu extends MenuBuilder {

	public Spleef2vs2Menu(Player p) {
		super("§b§lSpleef 2vs2", 3);
		
		s(11, new ItemBuilder(Material.NETHER_STAR).setTitle("§aRandom map").
				build());
		
		s(15, new ItemBuilder(Material.EMPTY_MAP).setTitle("§aSelect a map").
				build());
		s(26, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cBack").
				build());
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			GameManager.getManager().addSpleef2v2Queue(p, null);
		} else if (slot == 15) {
			new MapSelector2vs2Menu(p).o(p);
		} else if (slot == 26) {
			new Unranked2vs2Menu(p).o(p);
		}
	}

}
