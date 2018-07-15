package com.santipingui58.spleef.managers;



import java.util.Collections;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.BowSpleefGame;
import com.santipingui58.spleef.game.BuildSpleefPvPGame;
import com.santipingui58.spleef.game.FFASpleefGame;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.RankedSpleefGame;
import com.santipingui58.spleef.game.Spleef2v2Game;
import com.santipingui58.spleef.game.SpleefGame;

public class DeathManager {

	
	public static void onWalk(Player p) {
		
			Game g = GameManager.getManager().getArenabyPlayer(p);
			if (g.getType().equalsIgnoreCase("spleef")) {
				
					if (getDeath(p.getLocation(),g)) {
						
				Player player1 = g.getPlayer1().get(0);
				Player player2 = g.getPlayer2().get(0);
							
				if (p == player1) {
					g.addPoints2();
								
					if (g.getPoints2() >= g.getWin()) {	
						
						 if (player2.getInventory().contains(SpleefGame.pala)) {
						 player2.getInventory().removeItem(SpleefGame.pala);
						 }
						 if (p.getInventory().contains(SpleefGame.pala)) {
						 p.getInventory().removeItem(SpleefGame.pala);
						 }
						 if (GameManager.getManager().isRanked(g)) {
							  Main.get().getLogger().info("ranked terminado");
							 RankedSpleefGame.gameOver(player2, player1, g.getId());
						 } else {
							  Main.get().getLogger().info("Spleef normal terminado");
							SpleefGame.gameOver(player2, player1, g.getId());
						 }
						 
						
						 	p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));		
							player2.teleport(Main.getLoc(Main.arena.get("lobby"), true));		
									
					} else {		
						p.teleport(g.getSpawn1());	
						player2.teleport(g.getSpawn2());
						
						try {
						for (Player sp : g.getSpectators()) {		
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
							sp.sendMessage("§3[Spleef] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
							} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
								sp.sendMessage("§3[Spleef] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
							}
						}
							if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
							player1.sendMessage("§3[Spleef] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
							 } else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
							player1.sendMessage("§3[Spleef] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
							 }
							
							if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
								player2.sendMessage("§3[Spleef] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
								 } else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
								player2.sendMessage("§3[Spleef] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
								 }
						} catch (Exception e) {}
 						GameManager.getManager().Countdown(g);
						
						
						}
					
			
			
			} else if (p == player2) {
				g.addPoints1();
				if (g.getPoints1() >= g.getWin()) {	
					
						 if (player1.getInventory().contains(SpleefGame.pala)) {
						player1.getInventory().removeItem(SpleefGame.pala);
						 }
						 if (p.getInventory().contains(SpleefGame.pala)) {
						 p.getInventory().removeItem(SpleefGame.pala);
						 }
						 if (GameManager.getManager().isRanked(g)) {
							 Main.get().getLogger().info("ranked terminado");
							 RankedSpleefGame.gameOver(player1, player2,g.getId());
						 } else {
							 Main.get().getLogger().info("normal terminado");
						SpleefGame.gameOver(player1, player2,g.getId());
						 }
						 
						 	p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));
							player1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
				} else {		
					p.teleport(g.getSpawn2());
					player1.teleport(g.getSpawn1());
									try {
					for (Player sp : g.getSpectators()) {		
						if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
						sp.sendMessage("§3[Spleef] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
						} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
							sp.sendMessage("§3[Spleef] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
						}
					}
					
					if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
						player1.sendMessage("§3[Spleef] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
						} else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
							player1.sendMessage("§3[Spleef] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
						}
					if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
						player2.sendMessage("§3[Spleef] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
						} else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
							player2.sendMessage("§3[Spleef] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
						}
			} catch (Exception e) {}
									
													
					GameManager.getManager().Countdown(g);
				}
				}
				
					g.getReset().clear();
					g.getCrumble().clear();
					g.getEndGame().clear();
					g.addRounds();	
				}
			
					
					
					
		} else if (g.getType().equalsIgnoreCase("BuildSpleefPvP")) {
			
			if (getDeath(p.getLocation(),g)) {
				
		Player player1 = g.getPlayer1().get(0);
		Player player2 = g.getPlayer2().get(0);
					
		if (p == player1) {
			g.addPoints2();
						
			if (g.getPoints2() >= g.getWin()) {	
				

				 if (GameManager.getManager().isRanked(g)) {
					  Main.get().getLogger().info("ranked terminado");
				 } else {
					  Main.get().getLogger().info("Spleef normal terminado");
					BuildSpleefPvPGame.gameOver(player2, player1, g.getId());
				 }
				 
				
				 	p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));		
					player2.teleport(Main.getLoc(Main.arena.get("lobby"), true));		
							
			} else {		
				p.teleport(g.getSpawn1());	
				player2.teleport(g.getSpawn2());
				BuildSpleefPvPGame.giveGameItems(p);
				BuildSpleefPvPGame.giveGameItems(player2);
				
				try {
				for (Player sp : g.getSpectators()) {		
					if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
					sp.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
					} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
						sp.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
					}
				}
					if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
					player1.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
					 } else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
					player1.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
					 }
					
					if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
						player2.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
						 } else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
						player2.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
						 }
				} catch (Exception e) {}
					GameManager.getManager().Countdown(g);
				
				
				}
			
	
	
	} else if (p == player2) {
		g.addPoints1();
		if (g.getPoints1() >= g.getWin()) {	
			
				 if (GameManager.getManager().isRanked(g)) {
					 Main.get().getLogger().info("ranked terminado");
				 } else {
					 Main.get().getLogger().info("normal terminado");
					 BuildSpleefPvPGame.gameOver(player1, player2,g.getId());
				 }
				 
				 	p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));
					player1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
		} else {		
			p.teleport(g.getSpawn2());
			player1.teleport(g.getSpawn1());
			BuildSpleefPvPGame.giveGameItems(p);
			BuildSpleefPvPGame.giveGameItems(player1);
							try {
			for (Player sp : g.getSpectators()) {		
				if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
				sp.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
				} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
					sp.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
				}
			}
			
			if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
				player1.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
				} else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
					player1.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
				}
			if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
				player2.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
				} else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
					player2.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
				}
	} catch (Exception e) {}
							
											
			GameManager.getManager().Countdown(g);
		}
		}
		
			g.getReset().clear();
			g.getCrumble().clear();
			g.getEndGame().clear();
			g.addRounds();	
		}
	
			
			
			
} else if (g.getType().equalsIgnoreCase("bowspleef")) {
			
			if (getDeath(p.getLocation(),g)) {
				
		Player player1 = g.getPlayer1().get(0);
		Player player2 = g.getPlayer2().get(0);
					
		if (p == player1) {
			g.addPoints2();
						
			if (g.getPoints2() >= g.getWin()) {	
				

				 if (GameManager.getManager().isRanked(g)) {
					  Main.get().getLogger().info("ranked terminado");
				 } else {
					  Main.get().getLogger().info("Spleef normal terminado");
					BowSpleefGame.gameOver(player2, player1, g.getId());
				 }
				 
				
				 	p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));		
					player2.teleport(Main.getLoc(Main.arena.get("lobby"), true));		
							
			} else {		
				p.teleport(g.getSpawn1());	
				player2.teleport(g.getSpawn2());
				
				try {
				for (Player sp : g.getSpectators()) {		
					if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
					sp.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
					} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
						sp.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
					}
				}
					if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
					player1.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
					 } else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
					player1.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
					 }
					
					if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
						player2.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
						 } else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
						player2.sendMessage("§3[BuildSpleefPvP] §b" + player2.getName() + "§a has won the round §c" + g.getRounds());
						 }
				} catch (Exception e) {}
					GameManager.getManager().Countdown(g);
				
				
				}
			
	
	
	} else if (p == player2) {
		g.addPoints1();
		if (g.getPoints1() >= g.getWin()) {	
			
				 if (GameManager.getManager().isRanked(g)) {
					 Main.get().getLogger().info("ranked terminado");
				 } else {
					 Main.get().getLogger().info("normal terminado");
					 BowSpleefGame.gameOver(player1, player2,g.getId());
				 }
				 
				 	p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));
					player1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
		} else {		
			p.teleport(g.getSpawn2());
			player1.teleport(g.getSpawn1());
							try {
			for (Player sp : g.getSpectators()) {		
				if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
				sp.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
				} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
					sp.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
				}
			}
			
			if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
				player1.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
				} else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
					player1.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
				}
			if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
				player2.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a ha ganado la Ronda §c" + g.getRounds());
				} else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
					player2.sendMessage("§3[BuildSpleefPvP] §b" + player1.getName() + "§a has won the round §c" + g.getRounds());
				}
	} catch (Exception e) {}
							
											
			GameManager.getManager().Countdown(g);
		}
		}
		
			g.getReset().clear();
			g.getCrumble().clear();
			g.getEndGame().clear();
			g.addRounds();	
		}
	
			
			
			
} else if (g.getType().equalsIgnoreCase("spleef2v2")) {
			
			if (getDeath(p.getLocation(),g)) {
				
				if (g.getPlayer1().contains(p)) {					
					if (isTeamDead(g.getPlayer1(),g)) {
						g.addPoints2();
						
						
						if (g.getPoints2() >= g.getWin()) {	
							Spleef2v2Game.gameOver(g.getPlayer2(), g.getPlayer1(), g.getId());		
						} else {
							g.getInGameSpect().clear();
						    for (Player p1 : g.getPlayer1()) {
						    	p1.setGameMode(GameMode.SURVIVAL);
						    }
						    for (Player p2 : g.getPlayer2()) {
						    	p2.setGameMode(GameMode.SURVIVAL);
						    }
						    
							Spleef2v2Game.teamTeleport(g.getPlayer1(), g.getSpawn1());
							Spleef2v2Game.teamTeleport(g.getPlayer2(), g.getSpawn2());
							
							for (Player sp : g.getSpectators()) {		
								if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
								sp.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer2()) + "§a han ganado la Ronda §c" + g.getRounds());
								} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
									sp.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer2()) + "§a has won the round §c" + g.getRounds());
								}
							}
							for (Player pa : g.getPlayer1()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer2()) + "§a han ganado la Ronda §c" + g.getRounds());
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer2()) + "§a has won the round §c" + g.getRounds());
								}
							}
					
							for (Player pa : g.getPlayer2()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer2()) + "§a han ganado la Ronda §c" + g.getRounds());
									} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
										pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer2()) + "§a has won the round §c" + g.getRounds());
									}
								}
						//	} catch (Exception e) {}
							
							g.addRounds();	
							GameManager.getManager().Countdown(g);
						}
					} else {
						g.getInGameSpect().add(p);
						p.setGameMode(GameMode.SPECTATOR);
						p.teleport(g.getSpect());
						
						try {
						for (Player sp : g.getSpectators()) {
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
								sp.sendMessage("§3[Spleef] §c" + p.getName() + "§a ha caído! ");
								} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
									sp.sendMessage("§3[Spleef] §b" + p.getName() + "§a has fallen!");  
								}
						}
						for (Player pa : g.getPlayer1()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3[Spleef] §c" + p.getName() + "§a ha caído! ");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3[Spleef] §b" + p.getName() + "§a has fallen!");  
								}
						}
						
						
						for (Player pa : g.getPlayer2()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3[Spleef] §c" + p.getName() + "§a ha caído! ");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3[Spleef] §b" + p.getName() + "§a has fallen!");  
								}
						}
						
						} catch (Exception e) {}
					}
				
		} else if (g.getPlayer2().contains(p)) {
						
				if (isTeamDead(g.getPlayer2(),g)) {
					g.addPoints1();
					if (g.getPoints1() >= g.getWin()) {	
						Spleef2v2Game.gameOver(g.getPlayer1(), g.getPlayer2(), g.getId());		
					} else {
						g.getInGameSpect().clear();
					    for (Player p1 : g.getPlayer1()) {
					    	p1.setGameMode(GameMode.SURVIVAL);
					    }
					    for (Player p2 : g.getPlayer2()) {
					    	p2.setGameMode(GameMode.SURVIVAL);
					    }
					    
						Spleef2v2Game.teamTeleport(g.getPlayer1(), g.getSpawn1());
						Spleef2v2Game.teamTeleport(g.getPlayer2(), g.getSpawn2());
						
						try {
						for (Player sp : g.getSpectators()) {		
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
							sp.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer1()) + "§a han ganado la Ronda §c" + g.getRounds());
							} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
								sp.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer1()) + "§a has won the round §c" + g.getRounds());
							}
						}
						for (Player pa : g.getPlayer1()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer1()) + "§a han ganado la Ronda §c" + g.getRounds());
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer1()) + "§a has won the round §c" + g.getRounds());
							}
						}
				
						for (Player pa : g.getPlayer2()) {
							if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer1()) + "§a han ganado la Ronda §c" + g.getRounds());
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3[Spleef] §b" + Spleef2v2Game.teamNames(g.getPlayer1()) + "§a has won the round §c" + g.getRounds());
								}
							}
						} catch (Exception e) {}
						
						g.addRounds();	
						GameManager.getManager().Countdown(g);
					}
				} else {
					g.getInGameSpect().add(p);
					p.setGameMode(GameMode.SPECTATOR);
					p.teleport(g.getSpect());
					
					try {
					for (Player sp : g.getSpectators()) {
						if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
							sp.sendMessage("§3[Spleef] §c" + p.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
								sp.sendMessage("§3[Spleef] §b" + p.getName() + "§a has fallen!");  
							}
					}
					for (Player pa : g.getPlayer1()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §c" + p.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3[Spleef] §b" + p.getName() + "§a has fallen!");  
							}
					}
					
					
					for (Player pa : g.getPlayer2()) {
						if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§3[Spleef] §c" + p.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
								pa.sendMessage("§3[Spleef] §b" + p.getName() + "§a has fallen!");  
							}
					}
					
					} catch (Exception e) {}
				}
			
	} 
			
			}
		}  else if (g.getType().equalsIgnoreCase("ffaspleef")) {
			
			
			if (GameManager.getManager().isInGame(p)) {
				if (getDeath(p.getLocation(),g)) {
						SpleefRankManager.giveExp(p, 1);
						g.getPlayers().remove(p);
						g.getQueue().add(p);
						p.getInventory().clear();
						Main.givequeueItems(p);
						p.setGameMode(GameMode.ADVENTURE);
						p.teleport(g.getSpect());
						DataManager.addFFASpleefGames(p);
					if (g.getPlayers().size() <= 1) {
						try {
						FFASpleefGame.gameOver(g.getPlayers().get(0), g.getId());
						} catch (Exception e) {
							FFASpleefGame.gameOver(null, g.getId());
						}
				} else {
					
				
					for (Player pl : g.getPlayers()) {
						if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
							pl.sendMessage("§3[SpleefFFA] §b" + p.getName() + " §7ha caído! Quedan §a " + g.getPlayers().size() + " §7jugadores restantes!");
						} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
							pl.sendMessage("§3[SpleefFFA] §b" + p.getName() + " §7has fallen! There are §a " + g.getPlayers().size() + " §7players left!");	
					}
				}
					
					for (Player pl : g.getQueue()) {
						if (DataManager.getLang(pl).equalsIgnoreCase("ESP")) {
							pl.sendMessage("§3[SpleefFFA] §b" + p.getName() + " §7ha caído! Quedan §a " + g.getPlayers().size() + " §7jugadores restantes!");
						} else if (DataManager.getLang(pl).equalsIgnoreCase("ENG")) {
							pl.sendMessage("§3[SpleefFFA] §b" + p.getName() + " §7has fallen! There are §a " + g.getPlayers().size() + " §7players left!");	
						}
					}
						}							}		
			}
		}
					}

	
	 public static boolean contains(Location loc, Location l1, Location l2) {
		  int x1 = Math.min(l1.getBlockX(), l2.getBlockX());
		  int y1 = Math.min(l1.getBlockY(), l2.getBlockY());
		  int z1 = Math.min(l1.getBlockZ(), l2.getBlockZ());
		  int x2 = Math.max(l1.getBlockX(), l2.getBlockX());
		  int y2 = Math.max(l1.getBlockY(), l2.getBlockY());
		  int z2 = Math.max(l1.getBlockZ(), l2.getBlockZ());
		  l1 = new Location(loc.getWorld(), x1, y1, z1);
		  l2 = new Location(loc.getWorld(), x2, y2, z2);
		  
		    return loc.getBlockX() >= l1.getBlockX() && loc.getBlockX() <= l2.getBlockX()
		        && loc.getBlockY() >= l1.getBlockY() && loc.getBlockY() <= l2.getBlockY()
		        && loc.getBlockZ() >= l1.getBlockZ() && loc.getBlockZ() <= l2.getBlockZ();
		  }
	 
	 
	 
	 public static boolean getDeath(Location l, Game g) {
		  	if (l.getY() >= g.getArena1().getBlockY()-1) {
		  		return false;
		  	} 
		  	return true;
		  }
	 

	public static boolean isTeamDead(List<Player> list, Game g) {		
		if (list.size()<=1) {
			return true;
		} else {
			if (!Collections.disjoint(g.getInGameSpect(), list)) {
				return true;
			}
		}
		
		return false;
		
	}
}
