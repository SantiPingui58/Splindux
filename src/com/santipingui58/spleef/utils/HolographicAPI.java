package com.santipingui58.spleef.utils;

import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.santipingui58.spleef.Main;

public class HolographicAPI {

	public static void createTopFFASpleefWins() {
		
		
		Plugin plugin = Main.get();
		Location loc = Main.getLoc(Main.arena.getConfig().getString("hologramas.ffaspleefwins"), true);
		deleteHologram(loc);
		Hologram hologram = HologramsAPI.createHologram(plugin, Main.getLoc(Main.arena.getConfig().getString("hologramas.ffaspleefwins"), true));
			
			hologram.appendTextLine("§aTop 10 Wins §b§lFFASpleef");

			
			SortMapByValue.sortMapFFASpleefWins();
			
			for(int i = 1; i < 11 ; i++){
				try {
					Entry<String, Integer> e = SortMapByValue.sortedMapFFASpleefWins.pollFirstEntry();
				String pname = e.getKey();		            	 
				Integer score = e.getValue();
				hologram.appendTextLine("§6#"+ i + "§a " + pname + "§7:§b " + score);
	              } catch (Exception ex) {
	         	  hologram.appendTextLine("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
	              }
				}	
}
	
public static void createTopELOSpleef() {
	
	
		Plugin plugin = Main.get();
		Location loc = Main.getLoc(Main.arena.getConfig().getString("hologramas.topelospleef"), true);
		deleteHologram(loc);
		Hologram hologram = HologramsAPI.createHologram(plugin, Main.getLoc(Main.arena.getConfig().getString("hologramas.topelospleef"), true));
			
			hologram.appendTextLine("§aTop 10 Elo §b§lSpleef");

			
			SortMapByValue.sortMapSpleefELO();
			
			for(int i = 1; i < 11 ; i++){
				try {
					Entry<String, Integer> e = SortMapByValue.sortedMapSpleefELO.pollFirstEntry();
				String pname = e.getKey();		            	 
				Integer score = e.getValue();
				hologram.appendTextLine("§6#"+ i + "§a " + pname + "§7:§b " + score);
	              } catch (Exception ex) {
	         	  hologram.appendTextLine("§6#"+ i + "§a NO_PLAYER" + "§7:§b 0");
	              }
				}	
}
	
	
public static void deleteHologram (Location l) {
	
	for (Hologram hologram : HologramsAPI.getHolograms(Main.get())) {
		if (hologram.getLocation().distance(l) <= 2) {
			hologram.delete();

		}
	}
	
	
}	

public static void deleteHolograms() {
	for (Hologram hologram : HologramsAPI.getHolograms(Main.get())) {
		hologram.delete();
	}
}



public static void update () {
	Location tesl = Main.getLoc(Main.arena.getConfig().getString("hologramas.topelospleef"), true);
	Location tfsw = Main.getLoc(Main.arena.getConfig().getString("hologramas.ffaspleefwins"), true);
	Main.data.save();
	deleteHologram(tesl);
	deleteHologram(tfsw);
	createTopELOSpleef();
	createTopFFASpleefWins();
}
	
	
}
