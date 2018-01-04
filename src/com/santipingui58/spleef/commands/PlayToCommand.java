package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class PlayToCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("playto")){
			Player p = (Player) sender;
			
			if (GameManager.getManager().isInGame(p)) {
				if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("spleef")) {
			if (args.length == 0 || args.length >= 2) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§aUso: /playto <número>");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§aUse: /playto <number>");
				}
				}  else {
					int por;
					try {
						por = Integer.parseInt(args[0]);
					} catch (Exception e) {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§b" + args[0] + "§c no es un número válido.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§b" + args[0] + "§c is not a valid number.");
						}
						return false;
					}
					
					if (por <= 100 && por >=1 ) {
						Game g = GameManager.getManager().getArenabyPlayer(p);
						Player rival = null;
						
						if (g.getPlayer1().contains(p)) {
							rival = g.getPlayer2().get(0);
						} else if (g.getPlayer2().contains(p)) {
							rival = g.getPlayer1().get(0);
						}
						
						
					
						if (g.getPlayTo().containsKey(rival)) {
						if (por == g.getPlayTo().get(rival)) {
							g.setWin(por);
							g.getPlayTo().clear();
							for (Player p1 : g.getPlayer1()) {
								if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
								p1.sendMessage("§3[Spleef]§6 Ultimo punto seteado a: §a" + por);
								} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
									p1.sendMessage("§3[Spleef]§6 Last point set to : §a" + por);
								}
							}
							for (Player p2 : g.getPlayer2()) {
								if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
								p2.sendMessage("§3[Spleef]§6 Ultimo punto seteado a: §a" + por);
								} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
									p2.sendMessage("§3[Spleef]§6 Last point set to : §a" + por);
								}
							}
							
							return true;
						
						} else {
							if (g.getPlayer1().contains(p) || g.getPlayer2().contains(p)) {
								if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§3[Spleef]§6 Has solicitado jugar hasta §e" + por);
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§3[Spleef]§6 You have requested to play to §e" + por);
								}
								if (g.getPlayer1().contains(p)) {
									Player p2 = GameManager.getManager().getArenabyPlayer(p).getPlayer2().get(0);
									if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
									p2.sendMessage("§3[Spleef]§aTu oponente ha solicitado jugar hasta §b" + por + "§a, coloca /playto " + por 
											+ "para aceptarlo."); 
									} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
										p2.sendMessage("§3[Spleef]§a Your oponent has requested to play to §b" +  por + "§a, type /playto " + por 
											+ "to accept it."); 
									}
								} else if (g.getPlayer2().contains(p)) {
									Player p1 = GameManager.getManager().getArenabyPlayer(p).getPlayer1().get(0);
									if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
									p1.sendMessage("§3[Spleef]§aTu oponente ha solicitado jugar hasta §b" + por + "§a, coloca /play to " + por 
											+ "para aceptarlo."); 
									} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
										p1.sendMessage("§3[Spleef]§a Your oponent has requested to play to §b" +  por + "§a, type /playto " + por 
												+ "to accept it."); 
									}
								}
									
							}
							g.getPlayTo().put(p, por);
						}
						
					} else {
						if (g.getPlayer1().contains(p) || g.getPlayer2().contains(p)) {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§3[Spleef]§6 Has solicitado jugar hasta §e" + por);
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§3[Spleef]§6 You have requested to play to §e" + por);
							}
							if (g.getPlayer1().contains(p)) {
								Player p2 = GameManager.getManager().getArenabyPlayer(p).getPlayer2().get(0);
								if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
								p2.sendMessage("§3[Spleef]§aTu oponente ha solicitado jugar hasta §b" + por + "§a, coloca /playto " + por 
										+ "para aceptarlo.");
								} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
									p2.sendMessage("§3[Spleef]§a Your oponent has requested to play to §b" +  por + "§a, type /playto " + por 
											+ "to accept it."); 
								}
							} else if (g.getPlayer2().contains(p)) {
								Player p1 = GameManager.getManager().getArenabyPlayer(p).getPlayer1().get(0);
								if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
								p1.sendMessage("§3[Spleef]§aTu oponente ha solicitado jugar hasta §b" + por + "§a, coloca /playto " + por 
										+ "para aceptarlo.");
								} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
									p1.sendMessage("§3[Spleef]§a Your oponent has requested to play to §b" +  por + "§a, type /playto " + por 
											+ "to accept it."); 
								}
							}
								
								
								
							
						}
						g.getPlayTo().put(p, por);
						return true;
					}
			
							
						
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl número debe ser un número entre 1 y 100.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe number must be a number between 1 and 100.");
						}
					}
					
					
					
					
				}
			
			
			}  else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEste comando no puede ejecutarse aquí");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThis command can't be executed here.");
				}
				
				
			}
		} else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.sendMessage("§cEste comando solo puede ejecutarse dentro de una partida.");
		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			p.sendMessage("§cThis command can only be executed in a match.");
		}
			}
		}

		}
		return false;
	}
}
