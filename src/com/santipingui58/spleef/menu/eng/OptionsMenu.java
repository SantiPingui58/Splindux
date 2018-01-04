package com.santipingui58.spleef.menu.eng;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;




public class OptionsMenu extends MenuBuilder {

	public OptionsMenu(Player p) {
		super("§cOptions", 3);
		
		s(0, new ItemBuilder(Material.BOOKSHELF).setTitle("§6Language").
				addLore("§aSelect the language of the Server").
				build());
		if (DataManager.getNightVision(p) == true) {
			
			ItemStack night = new ItemStack (Material.LAPIS_BLOCK);
			 ItemMeta meta = night.getItemMeta();
		      meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		      meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		      meta.setDisplayName("§1Night Vision");
		      List<String> lore = new ArrayList<String>();
		      lore.add("§aTurn off Night Vision in games");
		      meta.setLore(lore);      
		      night.setItemMeta(meta);     
		s(1, night);
		
	} else {
		s(1, new ItemBuilder(Material.LAPIS_BLOCK).setTitle("§1Night Vision").
				addLore("§aTurn on Night Vision in games").
				build());
	}
	}
	
	
	@Override
	public void onClick(Player p, ItemStack stack, int slot) {
		if (slot == 0) {
			LanguageMenu.menu.open(p);
		} else if (slot == 1) {
			if (DataManager.getNightVision(p) == true) {
				DataManager.falseNightVision(p);
				new OptionsMenu(p).o(p);
			} else {
				DataManager.trueNightVision(p);
				new OptionsMenu(p).o(p);
			}
		}
	}
	

}
