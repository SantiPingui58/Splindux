package com.santipingui58.spleef.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;

public class NPCListener implements Listener {

	
	public static void updateSkins(String spleefelo, String ffaspleefwins) {
		for (NPC npc : CitizensAPI.getNPCRegistry()) {
			if (npc.getId() == 0) {
				 npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, spleefelo);
				 npc.data().set(NPC.PLAYER_SKIN_USE_LATEST, true);
				 Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "npc select 0 ");
				 Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "npc skin " + spleefelo);	
		            
			} else if (npc.getId() == 1) {
				 npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, spleefelo);
				 npc.data().set(NPC.PLAYER_SKIN_USE_LATEST, true);
				 Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "npc select 1 ");
				 Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "npc skin " + spleefelo);
			} else if (npc.getId() == 4) {
				 npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, ffaspleefwins);
				 npc.data().set(NPC.PLAYER_SKIN_USE_LATEST, true);
				 Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "npc select 4 ");
				 Bukkit.dispatchCommand(Main.get().getServer().getConsoleSender(), "npc skin " + ffaspleefwins);
			}
		}
	}
	
	
	
	 @EventHandler
	    public void OnInteract(NPCRightClickEvent e){
	        NPC npc = e.getNPC();
	        Player p = e.getClicker();
	       
	        if (npc.getId()==0) {
	        	//UnrankedSpleef1vs1
	        	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	        		new com.santipingui58.spleef.menu.esp.SpleefMenu(p).o(p);
	        	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	        		new com.santipingui58.spleef.menu.eng.SpleefMenu(p).o(p);
	        	}
	        } else if (npc.getId() == 1) {
	        	//RankedSpleef1v1
	        	if (DataManager.getRankeds(p) >= 1) {
	        	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	        		new com.santipingui58.spleef.menu.esp.RankedMenu(p).o(p);
	        	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	        		new com.santipingui58.spleef.menu.eng.RankedMenu(p).o(p);
	        	}
	        	} else {
	        		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cNo tienes más Rankeds para jugar.");
						p.sendMessage("§bVota para conseguir más Rankeds: /votar");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou do not have rankeds left to play.");
						p.sendMessage("§bVote to win more rankeds: /vote");
					}
	        	}
	        	
	        } else if (npc.getId() == 2) {
	        	//UnrankedSpleef2vs2
	        	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	        		new com.santipingui58.spleef.menu.esp.Spleef2vs2Menu(p).o(p);
	        	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	        		new com.santipingui58.spleef.menu.eng.Spleef2vs2Menu(p).o(p);
	        	}
	        	 
	        } else if (npc.getId() == 3) {
	        	//RankedSpleef2vs2
	        	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	        		p.sendMessage("§cProximamente...");
	        	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	        		p.sendMessage("§cComing soon...");
	        	}
	        	
	        }  else if (npc.getId() == 4) {
	        	//FFaSpleef
	        		GameManager.getManager().addSpleefFFAQueue(p);
	        	
	        } else if (npc.getId() == 5) {
	        	//UnrankedBowSpleef1v1
	        	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	        		p.sendMessage("§cProximamente...");
	        	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	        		p.sendMessage("§cComing soon...");
	        	}
	        } else if (npc.getId() == 6) {
	        	//UnrankedBowSpleef2v2
	        	if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
	        		p.sendMessage("§cProximamente...");
	        	} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
	        		p.sendMessage("§cComing soon...");
	        	}
	        }
	        
	    }
}
