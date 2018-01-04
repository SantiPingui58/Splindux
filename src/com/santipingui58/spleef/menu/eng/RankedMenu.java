package com.santipingui58.spleef.menu.eng;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class RankedMenu extends MenuBuilder {

	public RankedMenu(Player p) {
		super("§b§lRanked games", 3);
		
		s(11, new ItemBuilder(Material.NETHER_STAR).setTitle("§aRandom map").
				build());
		
		s(15, new ItemBuilder(Material.EMPTY_MAP).setTitle("§aSelect a map").
				build());
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if(slot == 11) {
			GameManager.getManager().addRankedQueue(p, null);
		} else if (slot == 15) {
			if (p.hasPermission("splindux.mapranked")) {
			new RankedMapSelectorMenu(p).o(p);
			} else {
				p.closeInventory();
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes permiso para ejecutar este comando.");
					p.sendMessage("§aNecesitass un rango "
							+ "§a§l[VIP] §ao superior para poder usar esto, visita la tienda para más información: §bhttp://splinduxstore.buycraft.net/");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have permission to execute this command.");
					p.sendMessage("§aYou need a rank "
							+ "§a§l[VIP] §aor higher to use this, visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
				
				}
			}
		}
		
	}
	

}
