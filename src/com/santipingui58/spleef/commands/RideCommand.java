package com.santipingui58.spleef.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class RideCommand implements CommandExecutor {

	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("ride")){
			final Player p = (Player) sender;
			
			if (p.hasPermission("splindux.ride")) {
			if (!GameManager.getManager().isInGame(p) || !GameManager.getManager().isSpectating(p)) {
			if (args.length == 1) {
				final Player pa = Bukkit.getServer().getPlayer(args[0]);
				if (Bukkit.getOnlinePlayers().contains(pa)) {
					pa.setPassenger(p);		
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cEl jugador §b" + args[1] + "§c");
					}
				}
			}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou can't execute this command while playing a match.");
				}
			}
		}}
		}
	
	return false;
}
}
