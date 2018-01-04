package com.santipingui58.spleef.menu.eng;

import org.bukkit.Material;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.menu.Menu;
import com.santipingui58.spleef.utils.ItemBuilder;



public class LanguageMenu  {


    static Menu menu = new Menu("Idiomas", 18, new Menu.OptionClickEventHandler() {
        @Override
        public void onOptionClick(Menu.OptionClickEvent event) {
        	if (event.getName().equalsIgnoreCase("§aEnglish")) {
        		event.getPlayer().sendMessage("§aLanguage updated! Please re-join the Server and join again to see the changes.");
        		Main.data.getConfig().set("data." + event.getPlayer().getUniqueId() + ".lang", "ENG");
        		Main.data.save();
        	} else if (event.getName().equalsIgnoreCase("§aEspañol")) {
        		event.getPlayer().sendMessage("§aIdioma actualizado! Por favor vuelvea entrar al server para cargar los cambios.");
        		Main.data.getConfig().set("data." + event.getPlayer().getUniqueId() + ".lang", "ESP");	
        		Main.data.save();
        	}  else if (event.getName().equalsIgnoreCase("§cBack")) {
        		new OptionsMenu(event.getPlayer()).o(event.getPlayer());
        	}
            
            event.setWillClose(true);
        }
    }, Main.get())
    .setOption(1, Main.getSkull("http://textures.minecraft.net/texture/a9f5799dfb7de65350337e735651d4c831f1c2a827d584b02d8e875ff8eaa2"),
    		"§aEspañol","§7Cambia el idioma del Servidor a: §aEspañol")
    .setOption(7, Main.getSkull("http://textures.minecraft.net/texture/e21c2fba5d4d0846cffc9774644782f979bc0465b779ddeb23538fc9923b57"),
    		"§aEnglish", "§7Change the language from the Server to: §aEnglish")
    .setOption(17, new ItemBuilder(Material.FIREWORK_CHARGE).build(), "§cBack");
    
	
    

}
