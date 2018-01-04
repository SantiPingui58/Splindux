package com.santipingui58.spleef.menu.esp;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;



public class OptionsMenu extends MenuBuilder {

	public OptionsMenu(Player p) {
		super("§cOpciones", 3);
		
		s(0, new ItemBuilder(Material.BOOKSHELF).setTitle("§6Lenguaje").
				addLore("§aElige el idioma del Servidor").
				build());
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 0) {
			LanguageMenu.menu.open(p);
		}
	}
	

}
