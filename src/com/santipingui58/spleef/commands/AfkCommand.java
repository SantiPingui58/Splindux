package com.santipingui58.spleef.commands;


import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.FriendsManager;

public class AfkCommand implements CommandExecutor {

	private static ArrayList<Player> afk = new ArrayList<Player>();
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("afk")){
			final Player p = (Player) sender;
			if (p.hasPermission("splindux.afk")) {
				if (afk.contains(p)) {
					removeAfk(p);
				} else {
						addAfk(p);
				}
				
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes permiso para ejecutar este comando.");
					p.sendMessage("§aNecesitass un rango "
							+ "§a§l[VIP]§a o superior para poder usar esto, visita la tienda para más información: §bhttp://splinduxstore.buycraft.net/");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have permission to execute this command.");
					p.sendMessage("§aYou need a rank "
							+ "§a§l[VIP] §aor higher to use this, visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
				
				} 
			}
			
}
}
		
		
		return false;
	}
	
	
	public static void addAfk (Player p) {
		afk.add(p);
		
		for (String fr : FriendsManager.getFriends(p)) {
			Player target = Bukkit.getServer().getPlayer(UUID.fromString(fr));
			if (Bukkit.getServer().getOnlinePlayers().contains(target)) {
				if (DataManager.getLang(target).equalsIgnoreCase("ESP")) {
					target.sendMessage("§dTu amigo §b" + p.getName() + "§d ahora se encuentra §7AFK");
				} else if (DataManager.getLang(target).equalsIgnoreCase("ENG")) {
					target.sendMessage("§dYour friend §b" + p.getName() + "§d is now §7AFK");
				}
				
			}
		}
		
		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
		p.sendMessage("§7Ahora te encuentras AFK");
		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			p.sendMessage("§7You are now AFK");
		}
	}
	
	public static void removeAfk (Player p) {
		afk.remove(p);
		for (String fr : FriendsManager.getFriends(p)) {
			Player target = Bukkit.getServer().getPlayer(UUID.fromString(fr));
			if (Bukkit.getServer().getOnlinePlayers().contains(target)) {
				if (DataManager.getLang(target).equalsIgnoreCase("ESP")) {
					target.sendMessage("§dTu amigo §b" + p.getName() + "§d ya no se encuentra §7AFK");
				} else if (DataManager.getLang(target).equalsIgnoreCase("ENG")) {
					target.sendMessage("§dYour friend §b" + p.getName() + "§d is not longer §7AFK");
				}
				
			
		}
		}
		
		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) { 
		p.sendMessage("§7Ya no te encuentras AFK");
		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			p.sendMessage("§7You are not longer AFK");
		}
	}
	
	
	public static boolean isAfk (Player p) {
		if (afk.contains(p)) {
			return true;
		}
		return false;
	}
	
	
}