package com.santipingui58.spleef.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.commands.AfkCommand;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.PartyManager;
import com.santipingui58.spleef.managers.SpleefRankManager;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerChat implements Listener {
	
	public static List<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerchat(AsyncPlayerChatEvent event) {
		final Player p = event.getPlayer();
		
		PlayerListener.afkqueue.remove(p);
		
		if (AfkCommand.isAfk(p)) {
			AfkCommand.removeAfk(p);
		}
		if (PartyManager.getManager().isInPartyMode(p)) {
			
		}
		
		if (!p.hasPermission("splindux.chatcooldown")) {
			if (cooldown.contains(p)) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEspera 3 segundos entre mensajes.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cWait 3 seconds between messages.");
				}
				event.setCancelled(true);
				return;
			}
			
		}
		String msg = event.getMessage().replaceAll("%", "%%");
		String prefix = ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix());
		
			if(p.hasPermission("splindux.staff")){
				if (DataManager.getNick(p) == null || DataManager.getNick(p).isEmpty() || DataManager.getNick(p).equalsIgnoreCase(" ")) {
				event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " + prefix+ "§3" + p.getName() +"§8: §b"+ ChatColor.translateAlternateColorCodes('&', msg));
				} else {
					event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix + "§7~§3" +  DataManager.getNick(p)+ "§8: §b"+ ChatColor.translateAlternateColorCodes('&', msg));
				}
			} else if (p.hasPermission("splindux.donator")) {
				if (p.hasPermission("splindux.chat.color")) {
					if (DataManager.getNick(p) == null || DataManager.getNick(p).isEmpty() || DataManager.getNick(p).equalsIgnoreCase(" ")) {
						event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix +p.getName() +"§8: §a"+ ChatColor.translateAlternateColorCodes('&', msg));
					} else {
						event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix + "§7~" + DataManager.getNick(p) +"§8: §a"+ ChatColor.translateAlternateColorCodes('&', msg));
					}
				} else {
				if (DataManager.getNick(p) == null || DataManager.getNick(p).isEmpty() || DataManager.getNick(p).equalsIgnoreCase(" ")) {
					event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix +p.getName() +"§8: §a"+ msg);
				} else {
					event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix + "§7~" + DataManager.getNick(p) +"§8: §a"+ msg);
				}
				}
			} else {
				if (DataManager.getNick(p) == null || DataManager.getNick(p).isEmpty() || DataManager.getNick(p).equalsIgnoreCase(" ")) {
				event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix +p.getName() +"§8: §7"+ msg);
				} else {
					event.setFormat(SpleefRankManager.getSpleefRank(p)+ " " +prefix + "§7~" + DataManager.getNick(p) +"§8: §7"+ msg);
				}
			}	  	
			
			cooldown.add(p);
			
			new BukkitRunnable() {
				@Override
				public void run() {
					cooldown.remove(p);
				}
			}.runTaskLater(Main.get(), 60L);	
	}
	
	
}

