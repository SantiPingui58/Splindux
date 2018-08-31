package com.santipingui58.spleef.menu.esp;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.menu.RankingMenu;
import com.santipingui58.spleef.utils.ItemBuilder;



public class TournamentsMenu extends MenuBuilder {

	public TournamentsMenu(Player p) {
		super("§eEventos y Torneos", 3);
		
		s(0, new ItemBuilder(Material.SIGN).setTitle("§aTemporada actual:").
				addLore("§6§lSeason 1").
				addLore("§2Marzo 2018/Mayo 2018").
				build());
		
		s(1, new ItemBuilder(Material.EMERALD).setTitle("§aRanking Actual").build());
		
		s(12, new ItemBuilder(Material.NETHER_STAR).setTitle("§5§lProSpleef Tournament 1vs1").
				addLore("§2Marzo 2018").
				build());
		s(14, new ItemBuilder(Material.NETHER_STAR).setTitle("§5Spleef 2vs2 Tournament").
				addLore("§2Febrero 2018/Marzo 2018").
				build());
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		
		if (slot == 12) {
			p.closeInventory();
			p.sendMessage("§fInscripciones: §cCERRADAS");
			p.sendMessage("§aTorneo realizado en Splindux de ProSpleef");
			p.sendMessage("§3http://challonge.com/SplinduxProSpleef1v1");
			p.sendMessage("§6https://goo.gl/5FnPBs");
		} else if (slot ==1) {
			p.closeInventory();
			RankingMenu.page.put(p, 0);
			new RankingMenu(p).o(p);
		} else if (slot == 14) {
			p.closeInventory();
			p.sendMessage("§fInscripciones: §cCERRADAS");
			p.sendMessage("§aTorneo realizado en Splindux de 2vs2");
			p.sendMessage("§3http://challonge.com/Splindux2vs2");
		}
	}
	
	
}