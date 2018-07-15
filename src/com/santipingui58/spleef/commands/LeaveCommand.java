package com.santipingui58.spleef.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class LeaveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("leave")) {
			if (p.hasPermission("splindux.fly")) {
				p.setAllowFlight(true);
				p.setFlying(true);		
			}
			p.setGameMode(GameMode.SURVIVAL);
			GameManager.getManager().leave(p);
			p.teleport(Main.getLoc(Main.arena.getConfig().getString("lobby")));
			Main.giveItems(p);
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")){
				p.sendMessage("§aHas salido de todas las partidas y/o colas.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§aYou have been removed from all games or queues");
			}
			
			
			}
		}
		return false;
	} 
	

}
