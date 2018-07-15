package com.santipingui58.spleef.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			return false;
		} else {
			if (cmd.getName().equalsIgnoreCase("rank")) {
				if (args.length == 3) {
			if (args[0].equalsIgnoreCase("new")) {	
				Player p = Bukkit.getServer().getPlayer(args[1]);
				if (args[2].equalsIgnoreCase("donator")) {
					Bukkit.broadcastMessage("§e§lSplin§b§ldux §aGracias a §b" + p.getName() + "§a por donar al Servidor!" );
					
				}
				else if (args[2].equalsIgnoreCase("vip")) {
				if (!p.hasPermission("splindux.staff") ||
						!PermissionsEx.getUser(p).inGroup("extreme") || 
				!PermissionsEx.getUser(p).inGroup("epic")) {
				PermissionsEx.getUser(p).addGroup("vip");
				}
				Bukkit.broadcastMessage("§e§lSplin§b§ldux §aFelicidades a §b" + p.getName() + "§a por adquirir un rango §a§l[VIP]§a!" );
			} else if (args[2].equalsIgnoreCase("epic")) {
				if (!p.hasPermission("splindux.staff") ||
						!PermissionsEx.getUser(p).inGroup("extreme")) {
				PermissionsEx.getUser(p).addGroup("epic");
				}
				Bukkit.broadcastMessage("§e§lSplin§b§ldux §aFelicidades a §b" + p.getName() + "§a por adquirir un rango §9§l[Epic]§a!" );
			} else if (args[2].equalsIgnoreCase("extreme")) {
				if (!p.hasPermission("splindux.staff")) {
				PermissionsEx.getUser(p).addGroup("extreme");
				}
				Bukkit.broadcastMessage("§e§lSplin§b§ldux §aFelicidades a §b" + p.getName() + "§a por adquirir un rango §5§l[Extreme]§a!" );	
			}
			
			
			} else if (args[0].equalsIgnoreCase("remove")) {
				if (args[2].equalsIgnoreCase("vip")) {
					Player p = Bukkit.getServer().getPlayer(args[1]);
					PermissionsEx.getUser(p).removeGroup("vip");
					DataManager.deleteNick(p);
				} else if (args[2].equalsIgnoreCase("epic")) {
					Player p = Bukkit.getServer().getPlayer(args[1]);
					PermissionsEx.getUser(p).removeGroup("epic");
					DataManager.deleteNick(p);
				} else if (args[2].equalsIgnoreCase("extreme")) {
					Player p = Bukkit.getServer().getPlayer(args[1]);
					PermissionsEx.getUser(p).removeGroup("extreme");
					DataManager.deleteNick(p);
				}
				
				
			}
		
	
	}
				}
		}
		return false;
}
}
