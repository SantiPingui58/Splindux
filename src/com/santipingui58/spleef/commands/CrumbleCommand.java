package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class CrumbleCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("crumble")){
			Player p = (Player) sender;
			
			if (GameManager.getManager().isInGame(p)) {
				if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("spleef")) {
			if (args.length == 0 || args.length >= 2) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§aUso: /crumble <porcentaje>");
					p.sendMessage("§7(El porcentaje debe ser entre 10 y 90, mientras más alto menos nieve en la arena)");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§aUse: /crumble <percentage>");
					p.sendMessage("§7(The percentage must be between 10 and 90, the higher will be the less snow in the arena)");
					
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
					
					if (por <= 90 && por >=10) {
						Game g = GameManager.getManager().getArenabyPlayer(p);
						Player rival = null;
						
						if (g.getPlayer1().contains(p)) {
							rival = g.getPlayer2().get(0);
						} else if (g.getPlayer2().contains(p)) {
							rival = g.getPlayer1().get(0);
						}
						
						
					
						if (g.getCrumble().containsKey(rival)) {
						if (por == g.getCrumble().get(rival)) {
						//
							
							GameManager.getManager().crumble(g, por);
							g.getCrumble().clear();
							return true;
						
						} else {
							if (g.getPlayer1().contains(p) || g.getPlayer2().contains(p)) {
								if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§3[Spleef]§6 Has solicitado crumblear la arena");
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§3[Spleef]§6 You have requested to crumble the arena");
								}
								if (g.getPlayer1().contains(p)) {
									Player p2 = GameManager.getManager().getArenabyPlayer(p).getPlayer2().get(0);
									if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
									p2.sendMessage("§3[Spleef]§aTu oponente ha solicitado crumblear la arena §7(§e"+por + "%§7)§a, coloca §b/crumble " 
											+ por + "§a para hacerlo.");
									} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
										p2.sendMessage("§3[Spleef]§a Your oponent has requested to crumble the arena§7(§e"+por + "%§7)§a, type §b/crumble " 
											+ por + "§a to do it.");
									}
								} else if (g.getPlayer2().contains(p)) {
									Player p1 = GameManager.getManager().getArenabyPlayer(p).getPlayer1().get(0);
									if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
									p1.sendMessage("§3[Spleef]§aTu oponente ha solicitado crumblear la arena §7(§e"+por + "%§7)§a, coloca §b/crumble " 
											+ por + "§a para hacerlo.");
									} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
										p1.sendMessage("§3[Spleef]§a Your oponent has requested to crumble the arena§7(§e"+por + "%§7)§a, type §b/crumble " 
												+ por + "§a to do it.");
									}
								}
									
							}
							g.getCrumble().put(p, por);
						}
						
					} else {
						if (g.getPlayer1().contains(p) || g.getPlayer2().contains(p)) {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§3[Spleef]§6 Has solicitado crumblear la arena");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§3[Spleef]§6 You have requested to crumble the arena");
							}
							if (g.getPlayer1().contains(p)) {
								Player p2 = GameManager.getManager().getArenabyPlayer(p).getPlayer2().get(0);
								if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
								p2.sendMessage("§3[Spleef]§aTu oponente ha solicitado crumblear la arena §7(§e"+por + "%§7)§a, coloca §b/crumble " 
										+ por + "§a para hacerlo.");
								} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
									p2.sendMessage("3[Spleef]§a Your oponent has requested to crumble the arena§7(§e"+por + "%§7)§a, type §b/crumble " 
										+ por + "§a to do it.");
								}
							} else if (g.getPlayer2().contains(p)) {
								Player p1 = GameManager.getManager().getArenabyPlayer(p).getPlayer1().get(0);
								if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
								p1.sendMessage("§3[Spleef]§aTu oponente ha solicitado crumblear la arena §7(§e"+por + "%§7)§a, coloca §b/crumble " 
										+ por + "§a para hacerlo.");
								} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
									p1.sendMessage("§3[Spleef]§a Your oponent has requested to crumble the arena§7(§e"+por + "%§7)§a, type §b/crumble " 
											+ por + "§a to do it.");
								}
							}
								
								
								
							
						}
						g.getCrumble().put(p, por);
						return true;
					}
			
							
						
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl porcentaje debe ser un número entre 10 y 90.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe percentage must be a number between 10 and 90.");
						}
					}
					
					
					
					
				}
			
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEste comando no puede ejecutarse aquí");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThis command can't be executed here.");
				}
			}
			}  else {
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
