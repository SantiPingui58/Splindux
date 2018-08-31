package com.santipingui58.spleef.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.eng.MapSelectorMenu;
import com.santipingui58.spleef.menu.eng.UnrankedMenu;



public class WelcomeMenu extends MenuBuilder {

	public WelcomeMenu(Player p) {
		super("§bWelcome to §eSplin§bDux", 3);

		 
		 ItemStack spanish = Main.getSkull("http://textures.minecraft.net/texture/a9f5799dfb7de65350337e735651d4c831f1c2a827d584b02d8e875ff8eaa2");
		s(11, spanish);
		
		ItemStack english = Main.getSkull("http://textures.minecraft.net/texture/5d263199c737676d72cdf446d73119b58f8fe70a39bd5ab8c82724da6b4744");
		s (15,english);
	
	}
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 11) {
			GameManager.getManager().addUnrankedQueue(p, null);
		} else if (slot == 15) {
			new MapSelectorMenu(p).o(p);
		}
		else if (slot == 26) {
			new UnrankedMenu(p).o(p);
		}
	}

}
