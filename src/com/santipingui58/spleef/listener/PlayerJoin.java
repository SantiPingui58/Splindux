package com.santipingui58.spleef.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.utils.Scoreboard;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerJoin implements Listener {
	
	@EventHandler (priority=EventPriority.MONITOR)
	public void onTryJoin(PlayerLoginEvent event)  {
		Player p = event.getPlayer();
		if (!p.hasPermission("splindux.joinfull")) {
			if (Bukkit.getOnlinePlayers().size() >= Main.getMaxPlayers()) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				event.disallow(Result.KICK_OTHER, "§cEl servidor está en estado §a§lALPHA§c, para entrar necesitar ser donador. Visita la tienda para más info: §ehttp://splinduxstore.buycraft.net/");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				event.disallow(Result.KICK_OTHER, "§cThe server is on §a§lALPHA§c, to join you need to have a donator rank. Visit the store for more info: §ehttp://splinduxstore.buycraft.net/");
			}
				}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		
		p.teleport(Main.getLoc(Main.arena.getConfig().getString("lobby")));
		final String prefix = ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix());
		e.setJoinMessage(null);
		Scoreboard.setTag(p);
		DataManager.onCreateData(p);
		DataManager.updateName(p);
		DataManager.updateLastConnection(p);
		 new Scoreboard().createScoreboard(e.getPlayer());
			for (Player pa : Bukkit.getOnlinePlayers()) {
				if (GameManager.getManager().isInGame(pa) || GameManager.getManager().isSpectating(pa)) {
		} else {
			 new Scoreboard().createScoreboard(pa);
		}
			}
			
		if (GameManager.getManager().isInGame(p)) {
		
		} else {
			
			
			if (p.hasPermission("splindux.joinmsg")) {
				for (Player pa : Bukkit.getOnlinePlayers()) {
					if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
				pa.sendMessage(prefix +" §3" +  p.getName() + "§a ha entrado al servidor!");
				} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
					pa.sendMessage(prefix +" §3" +  p.getName() +"§a has joined the server!");
				}
				}
			} 
			
			p.setLevel(DataManager.getLevel(p));
			p.setHealth(20);
			p.setFoodLevel(20);
			Main.giveItems(p);
		
		
		
		}
}
	}
