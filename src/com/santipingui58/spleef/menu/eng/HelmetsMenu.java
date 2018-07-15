package com.santipingui58.spleef.menu.eng;



import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.menu.MenuBuilder;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;




public class HelmetsMenu extends MenuBuilder {

	public HelmetsMenu(Player p) {
		super("§eHelmets", 6);
		
		
		 ItemStack jukebox = new ItemStack(Material.JUKEBOX);
	        ItemMeta jukeboxMeta =  jukebox.getItemMeta();
	        List<String> jukeboxLore = new ArrayList<String>();
	        if (p.hasPermission("splindux.capsules.jukebox")) {
	        	jukeboxMeta.setDisplayName("§6Jukebox Capsule");
	        	if (Main.data.getConfig().getString("data." + p.getUniqueId() + ".cosmetics.capsule")
	        			.equalsIgnoreCase("jukebox")) {
	        		jukeboxLore.add("§aSelected!");
	        		jukeboxMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
	        		jukeboxMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	        	} else {
	        		jukeboxLore.add("§aClick to select!");
	        	}

	        } else {
	        	jukeboxMeta.setDisplayName("§6Jukebox Capsule");
	        	if (p.hasPermission("splindux.vip")) {
	        		jukeboxLore.add("§eBuy this capsule for: §610000 Coins");
	        } else {
	        	jukeboxLore.add("§cYou need to be atleast §9[Epic] §cto buy this capsule.");
	        }
	        	}
	        
	        jukeboxMeta.setLore(jukeboxLore);
	        jukebox.setItemMeta(jukeboxMeta);
	        s(12,jukebox);
		
	
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
