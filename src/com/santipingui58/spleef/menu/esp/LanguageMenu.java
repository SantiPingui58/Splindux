package com.santipingui58.spleef.menu.esp;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.menu.Menu;
import com.santipingui58.spleef.menu.eng.OptionsMenu;
import com.santipingui58.spleef.utils.ItemBuilder;



public class LanguageMenu  {

	static List<String> getEspLore() {
		List<String> lore = new ArrayList<String>();
		lore.add("§7Cambia el idioma del Servidor a: §aEspañol");
		return lore;
	}
	
	static List<String> getEngLore() {
		List<String> lore = new ArrayList<String>();
		lore.add("§7Change the language from the Server to: §aEnglish");
		return lore;
	}
	
    public static Menu menu = new Menu("Idiomas", 18, new Menu.OptionClickEventHandler() {
        @Override
        public void onOptionClick(Menu.OptionClickEvent event) {
        	if (event.getName().equalsIgnoreCase("§aEnglish")) {
        		event.getPlayer().sendMessage("§aLanguage updated!");
        		Main.data.getConfig().set("data." + event.getPlayer().getUniqueId() + ".lang", "ENG");
        		Main.data.save();
        		event.getPlayer().getInventory().clear();
        		Main.giveItems(event.getPlayer());
        		event.setWillClose(true);
        	} else if (event.getName().equalsIgnoreCase("§aEspañol")) {
        		event.getPlayer().sendMessage("§aIdioma actualizado!");
        		Main.data.getConfig().set("data." + event.getPlayer().getUniqueId() + ".lang", "ESP");	
        		Main.data.save();
        		event.getPlayer().getInventory().clear();
        		Main.giveItems(event.getPlayer());
        		event.setWillClose(true);
        	} else if (event.getName().equalsIgnoreCase("§cVolver")) {
        		new OptionsMenu(event.getPlayer()).o(event.getPlayer());
        	}
            
            
        }
    }, Main.get())
    .setOption(1, Main.getSkull("http://textures.minecraft.net/texture/a9f5799dfb7de65350337e735651d4c831f1c2a827d584b02d8e875ff8eaa2"),
    		"§aEspañol",getEspLore())
    .setOption(7, Main.getSkull("http://textures.minecraft.net/texture/5d263199c737676d72cdf446d73119b58f8fe70a39bd5ab8c82724da6b4744"),
    		"§aEnglish", getEngLore())
    .setOption(17, new ItemBuilder(Material.FIREWORK_CHARGE).build(), "§cVolver", null);
	
    

}
