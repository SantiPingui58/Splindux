package com.santipingui58.spleef.menu.esp;



import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.santipingui58.spleef.menu.MenuBuilder;
import com.santipingui58.spleef.utils.ItemBuilder;




public class CosmeticsMenu extends MenuBuilder {

	public CosmeticsMenu(Player p) {
		super("§d§lCosmetics", 3);
		
		

		s(11, new ItemBuilder(Material.GLASS).setTitle("§aCápsulas").
				addLore("§7Consigue Cápsulas personalizadas").
				addLore("§7para la cuenta regresiva de las modalidades!").
				build());
		
		s(13, new ItemBuilder(Material.MONSTER_EGG).setTitle("§fDisfraces").
				addLore("§7Compra disguises de comando /d si no eres").
				addLore("§7§9[Epic] §7o §5[Extreme]").
				build());
		
		s(15, new ItemBuilder(Material.GOLD_HELMET).setTitle("§bCascos").
				addLore("§7Compra asombrosos cascos y").
				addLore("§7úsalos en las modalidades!").
				build());
		
		s(26, new ItemBuilder(Material.FIREWORK_CHARGE).setTitle("§cVolver").
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
