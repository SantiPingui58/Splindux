package com.santipingui58.spleef.menu.eng;



import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;




public class GadgetsMenu extends MenuBuilder {

	public GadgetsMenu(Player p) {
		super("§dGadgets", 3);
		
		

		s(11, new ItemBuilder(Material.MAP).setTitle("§a§lGame Cosmetics").
				addLore("§7You can use those").
				addLore("§7Cosmetics playing any game!").
				build());
		
		s(15, new ItemBuilder(Material.NETHER_STAR).setTitle("§d§lLobby Gadgets").
				addLore("§7You can use those").
				addLore("§7Gadgets in the Hub of the Server!").
				build());
		
		
	
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			new CosmeticsMenu(p).o(p);
			 
		} else if (slot == 15) {
			GadgetsMenuAPI.goBackToMainMenu(p);
			
		}
	}
	

}
