package com.santipingui58.spleef.managers;


import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.FFASpleefGame;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.Spleef2v2Game;
import com.santipingui58.spleef.game.SpleefGame;

public class DeathManager {

	
	public static void onWalk(Player p) {
		
			Game g = GameManager.getManager().getArenabyPlayer(p);
			if (g.getType().equalsIgnoreCase("spleef")) {
					if (getDeath(p.getLocation(),g)) {
				Player player1 = g.getPlayer1().get(0);
				Player player2 = g.getPlayer2().get(0);
				g.addRounds();				
				if (p == player1) {
					g.addPoints2();
					if (g.getPoints2() >= g.getWin()) {	
						
						
						
						p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));		
						player1.teleport(Main.getLoc(Main.arena.get("lobby"), true));				
						 if (player2.getInventory().contains(SpleefGame.pala)) {
						 player2.getInventory().removeItem(SpleefGame.pala);
						 }
						 if (p.getInventory().contains(SpleefGame.pala)) {
						 p.getInventory().removeItem(SpleefGame.pala);
							SpleefGame.gameOver(player2, player1, g.getId());
						 }	
						
									
					} else {		
						p.teleport(g.getSpawn1());	
						player2.teleport(g.getSpawn2());
						for (Player sp : g.getSpectators()) {		
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
							sp.sendMessage("§3[Spleef] §b" + player2.getName() + "§a ha ganado la Ronda " + g.getRounds());
							} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
								sp.sendMessage("§3[Spleef] §b" + player2.getName() + "§a has won the round " + g.getRounds());
							}
						}
							if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
							player1.sendMessage("§3[Spleef] §b" + player2.getName() + "§a ha ganado la Ronda " + g.getRounds());
							 } else if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
							player1.sendMessage("§3[Spleef] §b" + player2.getName() + "§a has won the round " + g.getRounds());
							 }
							if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
								player2.sendMessage("§3[Spleef] §b" + player2.getName() + "§a ha ganado la Ronda " + g.getRounds());
								 } else if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
								player2.sendMessage("§3[Spleef] §b" + player2.getName() + "§a has won the round " + g.getRounds());
								 }
							
 						GameManager.getManager().Countdown(g);
						
						
						}
					
			
			
			} else if (p == player2) {
				g.addPoints1();
				if (g.getPoints1() >= g.getWin()) {	
					p.teleport(Main.getLoc(Main.arena.get("lobby" ), true));
					player2.teleport(Main.getLoc(Main.arena.get("lobby"), true));
						 if (player1.getInventory().contains(SpleefGame.pala)) {
						player1.getInventory().removeItem(SpleefGame.pala);
						 }
						 if (p.getInventory().contains(SpleefGame.pala)) {
						 p.getInventory().removeItem(SpleefGame.pala);
						 }
						 
						SpleefGame.gameOver(player1, player2,g.getId());
								
				} else {		
					p.teleport(g.getSpawn2());
					player1.teleport(g.getSpawn1());
									
					for (Player sp : g.getSpectators()) {		
						if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
						sp.sendMessage("§3[Spleef] §b" + player1.getName() + "§a ha ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
							sp.sendMessage("§3[Spleef] §b" + player1.getName() + "§a has won the round " + g.getRounds());
						}
					}
					
					if (DataManager.getLang(player1).equalsIgnoreCase("ESP")) {
						player1.sendMessage("§3[Spleef] §b" + player1.getName() + "§a ha ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(player1).equalsIgnoreCase("ENG")) {
							player1.sendMessage("§3[Spleef] §b" + player1.getName() + "§a has won the round " + g.getRounds());
						}
					if (DataManager.getLang(player2).equalsIgnoreCase("ESP")) {
						player2.sendMessage("§3[Spleef] §b" + player1.getName() + "§a ha ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(player2).equalsIgnoreCase("ENG")) {
							player2.sendMessage("§3[Spleef] §b" + player1.getName() + "§a has won the round " + g.getRounds());
						}
					
					GameManager.getManager().Countdown(g);
				}
				}
				
					g.getReset().clear();
					g.getCrumble().clear();
					g.getEndGame().clear();
				}
			
		} else if (g.getType().equalsIgnoreCase("spleef2vs2")) {
			
			
			if (getDeath(p.getLocation(),g)) {
				Player player1A = g.getPlayer1().get(0);
				Player player1B = g.getPlayer1().get(1);
				Player player2A = g.getPlayer2().get(0);
				Player player2B = g.getPlayer2().get(1);
				g.addRounds();				
				if (p == player1A) {
					
					if (g.getInGameSpect().contains(player1B)) {
						if (g.getPoints2() >= g.getWin()) {	
							Spleef2v2Game.gameOver(g.getPlayer2(), g.getPlayer1(), g.getId());
							
						} else {
							g.addPoints2();
							g.getSpectators().clear();
							Spleef2v2Game.teamTeleport(player1A, player1B, g.getSpawn1());
							Spleef2v2Game.teamTeleport(player2A, player2B, g.getSpawn2());
							
							for (Player sp : g.getSpectators()) {		
								if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
								sp.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
									sp.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
								}
							}
							
							if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
								player1A.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
									player1A.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
								}
							
							if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
								player1B.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player1B).equalsIgnoreCase("ENG")) {
									player1B.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
								}
							
							if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
								player2A.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
									player2A.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
								}
							
							if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
								player2B.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
									player2B.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
								}
							
							
							
							GameManager.getManager().Countdown(g);
						}
					} else {
						g.getInGameSpect().add(p);
						for (Player sp : g.getSpectators()) {
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
								sp.sendMessage("§3[Spleef] §c" + player1A.getName() + "§a ha caído! ");
								} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
									sp.sendMessage("§3[Spleef] §b" + player1A.getName() + "§a has fallen!");  
								}
						}
						if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
							player1A.sendMessage("§3[Spleef] §c" + player1A.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
								player1A.sendMessage("§3[Spleef] §b" + player1A.getName() + "§a has fallen!");  
							}
						
						if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
							player1B.sendMessage("§3[Spleef] §c" + player1A.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player1B).equalsIgnoreCase("ENG")) {
								player1B.sendMessage("§3[Spleef] §b" + player1A.getName() + "§a has fallen!");  
							}
						
						if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
							player2A.sendMessage("§3[Spleef] §c" + player1A.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
								player2A.sendMessage("§3[Spleef] §b" + player1A.getName() + "§a has fallen!");  
							}
						
						if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
							player2B.sendMessage("§3[Spleef] §c" + player1A.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
								player2B.sendMessage("§3[Spleef] §b" + player1A.getName() + "§a has fallen!");  
							}
						
						
					}
		} else if (p == player1B) {
			
			if (g.getInGameSpect().contains(player1A)) {
				if (g.getPoints2() >= g.getWin()) {	
					Spleef2v2Game.gameOver(g.getPlayer2(), g.getPlayer1(), g.getId());
					
				} else {
					g.addPoints2();
					g.getSpectators().clear();
					Spleef2v2Game.teamTeleport(player1A, player1B, g.getSpawn1());
					Spleef2v2Game.teamTeleport(player2A, player2B, g.getSpawn2());
					
					for (Player sp : g.getSpectators()) {		
						if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
						sp.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
							sp.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
						}
					}
					
					if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
						player1A.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
							player1A.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
						}
					
					if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
						player1B.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(player1B).equalsIgnoreCase("ENG")) {
							player1B.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
						}
					
					if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
						player2A.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
							player2A.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
						}
					
					if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
						player2B.sendMessage("§3[Spleef] §b" + player2A.getName() + "-" + player2B.getName() + "§a han ganado la Ronda " + g.getRounds());
						} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
							player2B.sendMessage("§3[Spleef] §b" + player2A.getName()  + "-" + player2B.getName() + "§a has won the round " + g.getRounds());
						}
					
					
					
					GameManager.getManager().Countdown(g);
				}
			} else {
				g.getInGameSpect().add(p);
				for (Player sp : g.getSpectators()) {
					if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
						sp.sendMessage("§3[Spleef] §c" + player1B.getName() + "§a ha caído! ");
						} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
							sp.sendMessage("§3[Spleef] §b" + player1B.getName() + "§a has fallen!");  
						}
				}
				if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
					player1A.sendMessage("§3[Spleef] §c" + player1B.getName() + "§a ha caído! ");
					} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
						player1A.sendMessage("§3[Spleef] §b" + player1B.getName() + "§a has fallen!");  
					}
				
				if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
					player1B.sendMessage("§3[Spleef] §c" + player1B.getName() + "§a ha caído! ");
					} else if (DataManager.getLang(player1B).equalsIgnoreCase("ENG")) {
						player1B.sendMessage("§3[Spleef] §b" + player1B.getName() + "§a has fallen!");  
					}
				
				if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
					player2A.sendMessage("§3[Spleef] §c" + player1B.getName() + "§a ha caído! ");
					} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
						player2A.sendMessage("§3[Spleef] §b" + player1B.getName() + "§a has fallen!");  
					}
				
				if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
					player2B.sendMessage("§3[Spleef] §c" + player1B.getName() + "§a ha caído! ");
					} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
						player2B.sendMessage("§3[Spleef] §b" + player1B.getName() + "§a has fallen!");  
					}
				
				
			}
			}  else if (p == player2A) {
				
				if (g.getInGameSpect().contains(player2B)) {
					if (g.getPoints1() >= g.getWin()) {	
						Spleef2v2Game.gameOver(g.getPlayer1(), g.getPlayer2(), g.getId());
						
					} else {
						g.addPoints1();
						g.getSpectators().clear();
						Spleef2v2Game.teamTeleport(player1A, player1B, g.getSpawn1());
						Spleef2v2Game.teamTeleport(player2A, player2B, g.getSpawn2());
						
						for (Player sp : g.getSpectators()) {		
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
							sp.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
							} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
								sp.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
							}
						}
						
						if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
							player1A.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
							} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
								player1A.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
							}
						
						if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
							player1B.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
							} else if (DataManager.getLang(player1B).equalsIgnoreCase("ENG")) {
								player1B.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
							}
						
						if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
							player2A.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
							} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
								player2A.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
							}
						
						if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
							player2B.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
							} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
								player2B.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
							}
						
						
						
						GameManager.getManager().Countdown(g);
					}
				} else {
					g.getInGameSpect().add(p);
					for (Player sp : g.getSpectators()) {
						if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
							sp.sendMessage("§3[Spleef] §c" + player2A.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
								sp.sendMessage("§3[Spleef] §b" + player2A.getName() + "§a has fallen!");  
							}
					}
					if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
						player1A.sendMessage("§3[Spleef] §c" + player2A.getName() + "§a ha caído! ");
						} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
							player1A.sendMessage("§3[Spleef] §b" + player2A.getName() + "§a has fallen!");  
						}
					
					if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
						player1B.sendMessage("§3[Spleef] §c" + player2A.getName() + "§a ha caído! ");
						} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
							player1B.sendMessage("§3[Spleef] §b" + player2A.getName() + "§a has fallen!");  
						}
					
					if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
						player2A.sendMessage("§3[Spleef] §c" + player2A.getName() + "§a ha caído! ");
						} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
							player2A.sendMessage("§3[Spleef] §b" + player2A.getName() + "§a has fallen!");  
						}
					
					if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
						player2B.sendMessage("§3[Spleef] §c" + player2A.getName() + "§a ha caído! ");
						} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
							player2B.sendMessage("§3[Spleef] §b" + player2A.getName() + "§a has fallen!");  
						}
					
					
				}
				}  else if (p == player2B) {
					
					if (g.getInGameSpect().contains(player2A)) {
						if (g.getPoints1() >= g.getWin()) {	
							Spleef2v2Game.gameOver(g.getPlayer1(), g.getPlayer2(), g.getId());
							
						} else {
							g.addPoints1();
							g.getSpectators().clear();
							Spleef2v2Game.teamTeleport(player1A, player1B, g.getSpawn1());
							Spleef2v2Game.teamTeleport(player2A, player2B, g.getSpawn2());
							
							for (Player sp : g.getSpectators()) {		
								if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
								sp.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
									sp.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
								}
							}
							
							if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
								player1A.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
									player1A.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
								}
							
							if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
								player1B.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player1B).equalsIgnoreCase("ENG")) {
									player1B.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
								}
							
							if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
								player2A.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
									player2A.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
								}
							
							if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
								player2B.sendMessage("§3[Spleef] §b" + player1A.getName() + "-" + player1B.getName() + "§a han ganado la Ronda " + g.getRounds());
								} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
									player2B.sendMessage("§3[Spleef] §b" + player1A.getName()  + "-" + player1B.getName() + "§a has won the round " + g.getRounds());
								}
							
							
							
							GameManager.getManager().Countdown(g);
						}
					} else {
						g.getInGameSpect().add(p);
						for (Player sp : g.getSpectators()) {
							if (DataManager.getLang(sp).equalsIgnoreCase("ESP")) {
								sp.sendMessage("§3[Spleef] §c" + player2B.getName() + "§a ha caído! ");
								} else if (DataManager.getLang(sp).equalsIgnoreCase("ENG")) {
									sp.sendMessage("§3[Spleef] §b" + player2B.getName() + "§a has fallen!");  
								}
						}
						if (DataManager.getLang(player1A).equalsIgnoreCase("ESP")) {
							player1A.sendMessage("§3[Spleef] §c" + player2B.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player1A).equalsIgnoreCase("ENG")) {
								player1A.sendMessage("§3[Spleef] §b" + player2B.getName() + "§a has fallen!");  
							}
						
						if (DataManager.getLang(player1B).equalsIgnoreCase("ESP")) {
							player1B.sendMessage("§3[Spleef] §c" + player2B.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
								player1B.sendMessage("§3[Spleef] §b" + player2B.getName() + "§a has fallen!");  
							}
						
						if (DataManager.getLang(player2A).equalsIgnoreCase("ESP")) {
							player2A.sendMessage("§3[Spleef] §c" + player2B.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player2A).equalsIgnoreCase("ENG")) {
								player2A.sendMessage("§3[Spleef] §b" + player2B.getName() + "§a has fallen!");  
							}
						
						if (DataManager.getLang(player2B).equalsIgnoreCase("ESP")) {
							player2B.sendMessage("§3[Spleef] §c" + player2B.getName() + "§a ha caído! ");
							} else if (DataManager.getLang(player2B).equalsIgnoreCase("ENG")) {
								player2B.sendMessage("§3[Spleef] §b" + player2B.getName() + "§a has fallen!");  
							}
						
						
					}
					} 
			}
		}  else if (g.getType().equalsIgnoreCase("ffaspleef")) {
			
			
			if (GameManager.getManager().isInGame(p)) {
				if (getDeath(p.getLocation(),g)) {
					SpleefRankManager.levelUp(p);
						g.getPlayers().remove(p);
						g.getQueue().add(p);
						p.getInventory().clear();
						Main.givequeueItems(p);
						p.setGameMode(GameMode.ADVENTURE);
						p.teleport(g.getSpect());
						DataManager.addFFASpleefGames(p);
					if (g.getPlayers().size() <= 1) {
						
						
						
						
						FFASpleefGame.gameOver(g.getPlayers().get(0), g.getId());
						
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
		  	if (l.getY() >= g.getArena1().getBlockY()-2) {
		  		return false;
		  	} 
		  	return true;
		  }
	
}
