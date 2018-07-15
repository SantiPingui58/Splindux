package com.santipingui58.spleef.menu.eng;



import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;




public class CosmeticsMenu extends MenuBuilder {

	public CosmeticsMenu(Player p) {
		super("§d§lCosmetics", 3);
		
		

		s(11, new ItemBuilder(Material.GLASS).setTitle("§aCapsules").
				addLore("§7Get customized Capsules as").
				addLore("§7you wait for the countdown of games!").
				build());
		
		s(13, new ItemBuilder(Material.MONSTER_EGG).setTitle("§fDisguises").
				addLore("§7Buy Disguises if you aren't").
				addLore("§7§9[Epic] §7or §5[Extreme]").
				build());
		
		s(15, new ItemBuilder(Material.GOLD_HELMET).setTitle("§bHelmets").
				addLore("§7Buy awesome Helmets and").
				addLore("§7wear them inside games!").
				build());
		
		s(26, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cBack").
				build());
		
		
	
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			CapsuleMenu.page.put(p, 1);
				new CapsuleMenu(p).o(p);
			 
		} else if (slot == 13) {
			//new HelmetsMenu(p).o(p);
			p.closeInventory();
			p.sendMessage("§cComing soon...");
			
		} else if (slot == 15) {
			//new HelmetsMenu(p).o(p);
			p.closeInventory();
			p.sendMessage("§cComing soon...");
			
		} else if (slot == 26) {
			new GadgetsMenu(p).o(p);
			
		}
	}
	

}
