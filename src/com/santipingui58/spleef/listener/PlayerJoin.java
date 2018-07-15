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
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.utils.Scoreboard;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerJoin implements Listener {
	
	@EventHandler (priority=EventPriority.MONITOR)
	public void onTryJoin(PlayerLoginEvent event)  {
		Player p = event.getPlayer();
		if (!p.hasPermission("splindux.staff")) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				event.disallow(Result.KICK_OTHER, "§aEl servidor se encuentra en §c§lMANTENIMIENTO, §avolveremos pronto!");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				event.disallow(Result.KICK_OTHER, "§aThe server is currently under §c§lMAINTENANCE, §awe will be back soon!");
			}
				
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		final Player p = e.getPlayer();
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
					 new Scoreboard().createScoreboardGame(pa);
		} else {
			 new Scoreboard().createScoreboard(pa);
		}
			}
			
		if (GameManager.getManager().isInTemp(p)) {
			for (Game g : GameManager.getManager().getArenasList()) {
				if (g.getTempPlayer1_2v2().contains(p)) {
					g.getPlayer1().add(p);
					g.getTempPlayer1_2v2().remove(p);
					p.teleport(g.getSpect());
					for (Player pa : g.getPlayer1()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§3[Spleef] §aThe player §b" + p.getName() + " §ahas reconnected!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §aEl jugador §b" + p.getName() + " §ase ha reconectado!");
						}
					}
					
					for (Player pa : g.getPlayer2()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§3[Spleef] §aThe player §b" + p.getName() + " §ahas reconnected!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §aEl jugador §b" + p.getName() + " §ase ha reconectado!");
						}
					}
					
					for (Player pa : g.getSpectators()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§3[Spleef] §aThe player §b" + p.getName() + " §ahas reconnected!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §aEl jugador §b" + p.getName() + " §ase ha reconectado!");
						}
					}
					
				} else if (g.getTempPlayer2_2v2().contains(p)) {
					g.getPlayer2().add(p);
					g.getTempPlayer2_2v2().remove(p);
					p.teleport(g.getSpect());
					for (Player pa : g.getPlayer1()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§3[Spleef] §aThe player §b" + p.getName() + " §ahas reconnected!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §aEl jugador §b" + p.getName() + " §ase ha reconectado!");
						}
					}
					
					for (Player pa : g.getPlayer2()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§3[Spleef] §aThe player §b" + p.getName() + " §ahas reconnected!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §aEl jugador §b" + p.getName() + " §ase ha reconectado!");
						}
					}
					
					for (Player pa : g.getSpectators()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§3[Spleef] §aThe player §b" + p.getName() + " §ahas reconnected!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §aEl jugador §b" + p.getName() + " §ase ha reconectado!");
						}
					}
					
				}
			}
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
			
			if (p.hasPermission("splindux.fly")) {
				p.setAllowFlight(true);
				p.setFlying(true);			
			}
			
			p.setHealth(20);
			p.setFoodLevel(20);
			Main.giveItems(p);
		
	
		
		
		}
}
	}
