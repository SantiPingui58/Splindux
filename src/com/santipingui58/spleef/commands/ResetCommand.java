package com.santipingui58.spleef.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class ResetCommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("reset")){
			Player p = (Player) sender;
			if (GameManager.getManager().isInGame(p)) {
				if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("spleef") ||
						GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("spleef2v2") 
						|| GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")
						|| GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("bowspleef")) {
					GameManager.getManager().resetRequest(p);
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cEste comando solo puede ejecutarse dentro de una partida.");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cThis command can only be executed in a match.");
					}
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEste comando solo puede ejecutarse dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThis command can only be executed in a match.");
				}
			}
			
			
		}
		}

		
		
		
		
		return false;
	}
	
	
	

}
