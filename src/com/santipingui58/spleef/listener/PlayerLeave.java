package com.santipingui58.spleef.listener;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.santipingui58.spleef.game.BowSpleefGame;
import com.santipingui58.spleef.game.BuildSpleefPvPGame;
import com.santipingui58.spleef.game.FFASpleefGame;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.RankedSpleefGame;
import com.santipingui58.spleef.game.Spleef2v2Game;
import com.santipingui58.spleef.game.SpleefGame;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.utils.Scoreboard;

public class PlayerLeave implements Listener {


	
	@EventHandler 
	public void onLeave (PlayerQuitEvent e) {
		Player p = e.getPlayer();
			e.setQuitMessage(null);	
				
				
			for (Player pa : Bukkit.getOnlinePlayers()) {
				if (GameManager.getManager().isInGame(pa) || GameManager.getManager().isSpectating(pa)) {
					 new Scoreboard().createScoreboardGame(pa);
		} else {
			 new Scoreboard().createScoreboard(pa);
		}
			}
				
				
				
				if (GameManager.getManager().isInGame(p)) {
					Game g = GameManager.getManager().getArenabyPlayer(p);
					
					if (g.getType().equalsIgnoreCase("spleef")) {
						if (GameManager.getManager().isRanked(g)) {
						Player ganador = null;
						if (g.getPlayer1().contains(p)){
							ganador = g.getPlayer2().get(0);
						} else {
							ganador = g.getPlayer1().get(0);
						}
						for (Player pa : g.getPlayer1()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						
						for (Player pa : g.getPlayer2()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						
						for (Player pa : g.getSpectators()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						RankedSpleefGame.gameOver(ganador, p, g.getId());
						} else {
							Player ganador = null;
							if (g.getPlayer1().contains(p)){
								ganador = g.getPlayer2().get(0);
							} else {
								ganador = g.getPlayer1().get(0);
							}
							for (Player pa : g.getPlayer1()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getPlayer2()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getSpectators()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							SpleefGame.gameOver(ganador, p, g.getId());
							
						}
					} else if (g.getType().equalsIgnoreCase("bowspleef")) {
						if (GameManager.getManager().isRanked(g)) {
						Player ganador = null;
						if (g.getPlayer1().contains(p)){
							ganador = g.getPlayer2().get(0);
						} else {
							ganador = g.getPlayer1().get(0);
						}
						for (Player pa : g.getPlayer1()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						
						for (Player pa : g.getPlayer2()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						
						for (Player pa : g.getSpectators()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						RankedSpleefGame.gameOver(ganador, p, g.getId());
						} else {
							Player ganador = null;
							if (g.getPlayer1().contains(p)){
								ganador = g.getPlayer2().get(0);
							} else {
								ganador = g.getPlayer1().get(0);
							}
							for (Player pa : g.getPlayer1()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getPlayer2()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getSpectators()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							BowSpleefGame.gameOver(ganador, p, g.getId());
							
						}
					}else if (g.getType().equalsIgnoreCase("BuildSpleefPvP")) {
						if (GameManager.getManager().isRanked(g)) {
						Player ganador = null;
						if (g.getPlayer1().contains(p)){
							ganador = g.getPlayer2().get(0);
						} else {
							ganador = g.getPlayer1().get(0);
						}
						for (Player pa : g.getPlayer1()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						
						for (Player pa : g.getPlayer2()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						
						for (Player pa : g.getSpectators()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
							}
						}
						RankedSpleefGame.gameOver(ganador, p, g.getId());
						} else {
							Player ganador = null;
							if (g.getPlayer1().contains(p)){
								ganador = g.getPlayer2().get(0);
							} else {
								ganador = g.getPlayer1().get(0);
							}
							for (Player pa : g.getPlayer1()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getPlayer2()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getSpectators()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							BuildSpleefPvPGame.gameOver(ganador, p, g.getId());
							
						}
					}else if (g.getType().equalsIgnoreCase("ffaspleef")) {
						try {
						g.getQueue().remove(p);
						} catch (Exception ex) {}
						
						try {
							g.getPlayers().remove(p);
						} catch (Exception ex) {}
						
						if (g.getPlayers().size() <= 1) {
							FFASpleefGame.gameOver(g.getPlayers().get(0), g.getId());
						} 
						
					} else if (g.getType().equalsIgnoreCase("spleef2v2")){
						
						try {
						g.getQueue().remove(p);
						} catch (Exception ex) {}
						
						try {
							g.getInGameSpect().remove(p);
						} catch (Exception ex) {}
						
						
						if (g.getPlayer1().contains(p)) {
							g.getTempPlayer1_2v2().add(p);
							if (g.getPlayer1().size() >= 2) {
									g.getPlayer1().remove(p);							
							} else {
								Spleef2v2Game.gameOver(g.getPlayer2(), g.getPlayer1(), g.getId());
							}
							
							for (Player pa : g.getPlayer1()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getPlayer2()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getSpectators()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
						} else if (g.getPlayer2().contains(p)) {
							g.getTempPlayer2_2v2().add(p);
							if (g.getPlayer2().size() >= 2) {
								g.getPlayer2().remove(p);							
						} else {
							Spleef2v2Game.gameOver(g.getPlayer1(), g.getPlayer2(), g.getId());
						}
							for (Player pa : g.getPlayer1()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getPlayer2()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
							
							for (Player pa : g.getSpectators()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cThe player §b" + p.getName() + " §chas disconnected!");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3["+GameManager.getManager().getGamePrefix(p)+"] §cEl jugador §b" + p.getName() + " §cse ha desconectado!");
								}
							}
						}
					}
				} 
				
				for (Game g : GameManager.getManager().getArenasList()) {
					if (g.getSpectators().contains(p)) {
						g.getSpectators().remove(p);
						
					}
					
					if (g.getQueue().contains(p)) {
						g.getQueue().remove(p);
					}
				}
				

	}
	
}
