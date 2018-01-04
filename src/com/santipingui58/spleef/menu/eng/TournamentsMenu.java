package com.santipingui58.spleef.menu.eng;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class TournamentsMenu extends MenuBuilder {

	public TournamentsMenu(Player p) {
		super("§eEvents and Tournaments", 3);
		
		s(0, new ItemBuilder(Material.SIGN).setTitle("§aCurrent season:").
				addLore("§eSeason 0").
				addLore("§2July 2017/Febrary 2018").
				build());
		

		
		s(13, new ItemBuilder(Material.NETHER_STAR).setTitle("§5§lSplindux §cC§ah§cr§ai§cs§at§cm§aa§cs §aT§co§au§cr§an§ca§am§ce§an§ct §6§lIV").
				addLore("§2December 2017/January 2018").
				build());
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		
		if (slot == 13) {
			p.closeInventory();
			p.sendMessage("§fIncriptions: §cCLOSED");
			p.sendMessage("§aChristmas Tourney realized in SpleefLeague-Splindux server.");
			p.sendMessage("§3http://challonge.com/SplinduxNavidad");
		}
	}
	

}
