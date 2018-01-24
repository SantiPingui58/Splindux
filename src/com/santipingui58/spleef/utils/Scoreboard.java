package com.santipingui58.spleef.utils;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;
import com.santipingui58.spleef.commands.AfkCommand;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Scoreboard {
	
	public void createScoreboardGame(Player p){
		writeGame(p);
		setTag(p);
}
	
	
	public void createScoreboard(Player p){
			write(p);
			setTag(p);
	}
		public static void setTag(Player p) {
		String prefix = ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix());
		if (AfkCommand.isAfk(p)) {
			NametagEdit.getApi().setPrefix(p, "§7§oAFK ");
		} else if (p.hasPermission("splindux.staff") || p.hasPermission("splindux.donator")) {
			NametagEdit.getApi().setPrefix(p, prefix+ " ");
		} else {
			NametagEdit.getApi().setPrefix(p.getName(), "§7");
		}
	}
	
	public static void write(Player p) {
		String displayname = "§e§lSplin§b§ldux";
		String prefix = ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix());

				String[] data = null;
				List<String> cache = new ArrayList<String>();
				cache.add(displayname);
				
				
				cache.add("§f");
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				cache.add("§fNombre: §a" + p.getName());
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					cache.add("§fName: §a" + p.getName());
				}
				
				if (p.hasPermission("splindux.staff") || p.hasPermission("splindux.donator")) {
					prefix.replace("[", "");
					prefix.replace("]", "");
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					cache.add("§fRango: " + prefix);	
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						cache.add("§fRank: " + prefix);
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					cache.add("§fRango: §3Usuario");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						cache.add("§fRank: §3User");
					}
				}
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				cache.add("§7Jugadores Online: §a" + Bukkit.getOnlinePlayers().size());
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					cache.add("§7Players online: §a" + Bukkit.getOnlinePlayers().size());
				}
				cache.add("§f§f");
				cache.add("§fRankeds: §a" + DataManager.getRankeds(p));
				cache.add("§fELO: §e" + DataManager.getElo(p));
				cache.add("§f§f§f");
				cache.add("§f§f§f§f§f");
				cache.add("§dwww.Splindux.com");
				
				
				for(int i = 0; i < cache.size(); i++){
					data = cache.toArray(new String[i]);
				}
				
				BoardAPI.ScoreboardUtil.unrankedSidebarDisplay(p, data);
	}
				 
	
	public static void writeGame(Player p) {
		String displayname = "§e§lSplin§b§ldux";
		String prefix = ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix());
					 try {
					 String[] data = null;
						List<String> cache = new ArrayList<String>();
						cache.add(displayname);		
						
					Game g = GameManager.getManager().getArenabyPlayer(p);
					if (g.getType().equalsIgnoreCase("ffaspleef")) {
						cache.add("§f");
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							cache.add("§7Tiempo: §6" + convert(g.getTime()));
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								cache.add("§7Time: §6" + convert(g.getTime()));
							}
						cache.add("§f§f");
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							cache.add("§7Jugadores vivos: §a" + g.getPlayers().size());
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							cache.add("§7Players left: §a" + g.getPlayers().size());
						}
						cache.add("§f§f§f");
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							cache.add("§fGanadas: §a" + DataManager.getFFASpleefWins(p));
							cache.add("§fJugadas: §a" + DataManager.getFFASpleefGames(p));
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							cache.add("§fWins: §a" + DataManager.getFFASpleefWins(p));
							cache.add("§fGames: §a" + DataManager.getFFASpleefGames(p));
						}
						
						cache.add("§f§f§f§f");
						cache.add("§f§f§f§f§f§f");
						cache.add("§dwww.Splindux.com");
						
						
						for(int i = 0; i < cache.size(); i++){
							data = cache.toArray(new String[i]);
						}
						
						BoardAPI.ScoreboardUtil.unrankedSidebarDisplay(p, data);
						
					} else if (g.getType().equalsIgnoreCase("spleef")){
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					cache.add("§7Tiempo: §6" + convert(g.getTime()));
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						cache.add("§7Time: §6" + convert(g.getTime()));
					}
					if (g.getPoints1() > g.getPoints2()) {
						
					cache.add("§a"+ g.getPlayer1().get(0).getName() + "§7:§b " + g.getPoints1());
					cache.add("§a"+ g.getPlayer2().get(0).getName() + "§7:§b " + g.getPoints2());
					} else {
						
						cache.add("§a"+ g.getPlayer2().get(0).getName()+ "§7:§b " + g.getPoints2());	
						cache.add("§a"+ g.getPlayer1().get(0).getName() + "§7:§b " + g.getPoints1());
					}
					
					for(int i = 0; i < cache.size(); i++){
						data = cache.toArray(new String[i]);
					}
					
					BoardAPI.ScoreboardUtil.unrankedSidebarDisplay(p, data);
					 } else if (g.getType().equalsIgnoreCase("spleef2v2")) {
						 if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								cache.add("§7Tiempo: §6" + convert(g.getTime()));
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									cache.add("§7Time: §6" + convert(g.getTime()));
								}
								if (g.getPoints1() > g.getPoints2()) {
									
								cache.add("§cRojo§7:§b " + g.getPoints1());
								cache.add("§9Azul§7:§b " + g.getPoints2());
								} else {							
									cache.add("§9Azul§7:§b " + g.getPoints2());
								cache.add("§cRojo§7:§b " + g.getPoints1());
								
								
								}
								for(int i = 0; i < cache.size(); i++){
									data = cache.toArray(new String[i]);
								}
								
								BoardAPI.ScoreboardUtil.unrankedSidebarDisplay(p, data);
					 }
					 } catch (Exception e) {
						 String[] data = null;
							List<String> cache = new ArrayList<String>();
							cache.add(displayname);
							
							
							cache.add("§f");
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							cache.add("§fNombre: §a" + p.getName());
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								cache.add("§fName: §a" + p.getName());
							}
							
							if (p.hasPermission("splindux.staff") || p.hasPermission("splindux.donator")) {
								prefix.replace("[", "");
								prefix.replace("]", "");
								if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								cache.add("§fRango: " + prefix);	
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									cache.add("§fRank: " + prefix);
								}
							} else {
								if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								cache.add("§fRango: §3Usuario");
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									cache.add("§fRank: §3User");
								}
							}
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							cache.add("§7Jugadores Online: §a" + Bukkit.getOnlinePlayers().size());
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								cache.add("§7Players online: §a" + Bukkit.getOnlinePlayers().size());
							}
							cache.add("§f§f");
							cache.add("§fRankeds: §a" + DataManager.getRankeds(p));
							cache.add("§fELO: §e" + DataManager.getElo(p));
							cache.add("§f§f§f");
							cache.add("§f§f§f§f§f");
							cache.add("§dwww.Splindux.com");
							
							
							for(int i = 0; i < cache.size(); i++){
								data = cache.toArray(new String[i]);
							}
							
							BoardAPI.ScoreboardUtil.unrankedSidebarDisplay(p, data);
					 
				 } 
				 }
	
	public static String convert(int seconds)
	  {
	    if (seconds >= 60) {
	      int segundos = seconds % 60;
	      int minutos = seconds / 60 % 60;

	      if (segundos < 10)
	      {
	        if (minutos < 10)
	        {
	          return "0" + minutos + ":0" + segundos;
	        }

	        return minutos + ":0" + segundos;
	      }

	      if (minutos < 10) {
	        return "0" + minutos + ":" + segundos;
	      }

	      return minutos + ":" + segundos;
	    }

	    int segundos = seconds % 60;
	    int minutos = seconds / 60 % 60;

	    if (segundos < 10)
	    {
	      return minutos + "0:0" + segundos;
	    }

	    return "00:" + seconds;
	  }
	
}
	

