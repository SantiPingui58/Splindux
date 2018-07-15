package com.santipingui58.spleef.menu.esp;



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
				addLore("§7Puedes usar estos").
				addLore("§7Cosméticos en cualquier modalidad!").
				build());
		
		s(15, new ItemBuilder(Material.NETHER_STAR).setTitle("§d§lLobby Gadgets").
				addLore("§7Puedes usar estos").
				addLore("§7Gadgets en el Lobby del Server!").
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
