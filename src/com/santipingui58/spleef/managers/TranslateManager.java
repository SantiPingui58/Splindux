package com.santipingui58.spleef.managers;


import java.net.URLEncoder;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.listener.PlayerChat;

import eu.iamgio.translator.Language;
import eu.iamgio.translator.Translator;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TranslateManager {
	
	@SuppressWarnings("deprecation")
	public static void translate(Player p,String msg,String lang,Player sender) {
		
		if (lang.equalsIgnoreCase("en")) {
			msg = Translator.translate(URLEncoder.encode(msg), Language.ENGLISH, Language.SPANISH);
		} else if (lang.equalsIgnoreCase("es")) {
			msg = Translator.translate(URLEncoder.encode(msg), Language.SPANISH, Language.ENGLISH);
		}
		

		String prefix = ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix());
		String position;
		if (Main.ranking.getConfig().contains("players."+ sender.getName() +".position")) {
			position = "§7("+Main.ranking.getConfig().getString("players."+sender.getName()+".position") + "º) ";
		} else {
			position = "";
		}
		
		
			if(sender.hasPermission("splindux.staff")){
				if (DataManager.getNick(sender) == null || DataManager.getNick(sender).isEmpty() || DataManager.getNick(sender).equalsIgnoreCase(" ")) {
				p.sendMessage(position + SpleefRankManager.getSpleefRankChat(sender)+ " " + prefix+ "§3" + sender.getName() +"§8: §b"+ ChatColor.translateAlternateColorCodes('&', msg));
				} else {
					p.sendMessage(position + SpleefRankManager.getSpleefRankChat(sender)+ " " +prefix + "§7~§3" +  DataManager.getNick(sender)+ "§8: §b"+ ChatColor.translateAlternateColorCodes('&', msg));
				}
			} else if (sender.hasPermission("splindux.donator")) {
				if (sender.hasPermission("splindux.chat.color")) {
					if (DataManager.getNick(sender) == null || DataManager.getNick(sender).isEmpty() || DataManager.getNick(sender).equalsIgnoreCase(" ")) {
						p.sendMessage(position + SpleefRankManager.getSpleefRankChat(sender)+ " " +prefix +sender.getName() +"§8: §a"+ ChatColor.translateAlternateColorCodes('&', msg));
					} else {
						p.sendMessage(position + SpleefRankManager.getSpleefRankChat(sender)+ " " +prefix + "§7~§f" + DataManager.getNick(sender) +"§8: §a"+ ChatColor.translateAlternateColorCodes('&', msg));
					}
				} else {
				if (DataManager.getNick(sender) == null || DataManager.getNick(sender).isEmpty() || DataManager.getNick(sender).equalsIgnoreCase(" ")) {
					p.sendMessage(position + SpleefRankManager.getSpleefRankChat(p)+ " " +prefix +sender.getName() +"§8: §a"+ msg);
				} else {
					p.sendMessage(position + SpleefRankManager.getSpleefRankChat(p)+ " " +prefix + "§7~§f" + DataManager.getNick(p) +"§8: §a"+ msg);
				}
				}
			} else {
				if (DataManager.getNick(sender) == null || DataManager.getNick(sender).isEmpty() || DataManager.getNick(sender).equalsIgnoreCase(" ")) {
				p.sendMessage(position + SpleefRankManager.getSpleefRankChat(sender)+ " " +prefix +sender.getName() +"§8: §7"+ msg);
				} else {
					p.sendMessage(position + SpleefRankManager.getSpleefRankChat(sender)+ " " +prefix + "§7~§f" + DataManager.getNick(sender) +"§8: §7"+ msg);
				}
			}	  	
			
			PlayerChat.cooldown.add(p);
			
			new BukkitRunnable() {
				@Override
				public void run() {
					PlayerChat.cooldown.remove(p);
				}
			}.runTaskLater(Main.get(), 60L);	
	}
	
}
