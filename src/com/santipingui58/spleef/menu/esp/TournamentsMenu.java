package com.santipingui58.spleef.menu.esp;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class TournamentsMenu extends MenuBuilder {

	public TournamentsMenu(Player p) {
		super("§eEventos y Torneos", 3);
		
		s(0, new ItemBuilder(Material.SIGN).setTitle("§aTemporada actual:").
				addLore("§e ALPHA").
				addLore("§2Julio 2017/Febrero 2018").
				build());
		
		s(13, new ItemBuilder(Material.NETHER_STAR).setTitle("§5§lSplindux §cT§ao§cr§an§ce§ao §cd§ae §cN§aa§cv§ai§ad§ca§ad §6§lIV").
				addLore("§2Diciembre 2017/Enero 2018").
				build());
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		
		if (slot == 13) {
			p.closeInventory();
			p.sendMessage("§fInscripciones: §cCERRADAS");
			p.sendMessage("§aTorneo de Navidad realizado en SpleefLeague y Splindux");
			p.sendMessage("§3http://challonge.com/SplinduxNavidad");
		}
	}
	
	
}