package com.santipingui58.spleef.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class SpleefCommand implements CommandExecutor{

	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("spleef")){
			Player p = (Player) sender;
			
			if(args.length == 0) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("§aPara retar a otros jugadores coloca con: §b/duel <jugador>");
				p.sendMessage("§aO también puedes entrar a las colas de las distintas modalidades con los Items de tu inventario, o los NPCs del Lobby!");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§aTo duel players use: §b/duel <player>");
					p.sendMessage("§aOr you can join the queues of the games with the Items of your inventory, or clicking the NPCs at the Lobby!");
				}
				return true;
			} else if(p.hasPermission("spleefcore.admin")) {
					if(args[0].equalsIgnoreCase("setup")) {
						if(args.length == 1) {
							
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/spleef setup setspawn1 <ID>"));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/spleef setup setspawn2 <ID>"));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/spleef setup setarena1 <ID> "));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/spleef setup setarena2 <ID>"));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/spleef setup settype <ID> <tipo>"));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/spleef create <ID>"));
							
					}  else if (args[1].equalsIgnoreCase("setlobby")) {
						Main.arena.getConfig().set("lobby", Main.setLoc(p.getLocation(), true));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del lobby."));
						Main.arena.save();
						return true;
					} else if (args[1].equalsIgnoreCase("setarenas")) {
						Main.arena.getConfig().set("arena", Main.setLoc(p.getLocation(), true));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del lobby del mundo arenas."));
						Main.arena.save();
						return true;
					} 
					else if (args[1].equalsIgnoreCase("setspawn1")) {
						if (args.length == 3) {
						Main.arena.getConfig().set("arenas."+ args[2]+ ".spawn1", Main.setLoc(p.getLocation(), true));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del spawn #1 de la arena: &b" + args[2]));
						Main.arena.save();
						return true; 
						}
					}  else if (args[1].equalsIgnoreCase("setspawn2")) {
						if (args.length == 3) {
						Main.arena.getConfig().set("arenas."+ args[2]+ ".spawn2", Main.setLoc(p.getLocation(), true));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del spawn #2 de la arena: &b" + args[2]));
						Main.arena.save();
						return true; 
						}
					}
					 else if (args[1].equalsIgnoreCase("setarena1")) {
							if (args.length == 3) {
							Main.arena.getConfig().set("arenas."+ args[2]+ ".arena1", Main.setLoc(p.getLocation(), true));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del punto de la arena #1 de la arena: &b" + args[2]));
							Main.arena.save();
							return true; 
							}
						}
					 else if (args[1].equalsIgnoreCase("setarena2")) {
							if (args.length == 3) {
							Main.arena.getConfig().set("arenas."+ args[2]+ ".arena2", Main.setLoc(p.getLocation(), true));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del punto de la arena #2 de la arena: &b" + args[2]));
							Main.arena.save();
							return true; 
							}
						}
						
					 else if (args[1].equalsIgnoreCase("setdeath1")) {
							if (args.length == 3) {
							Main.arena.getConfig().set("arenas."+ args[2]+ ".death1", Main.setLoc(p.getLocation(), true));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del punto de muerte #1 de la arena: &b" + args[2]));
							Main.arena.save();
							return true; 
							}
						}
					 else if (args[1].equalsIgnoreCase("setdeath2")) {
							if (args.length == 3) {
							Main.arena.getConfig().set("arenas."+ args[2]+ ".death2", Main.setLoc(p.getLocation(), true));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del punto de muerte #2 de la arena: &b" + args[2]));
							Main.arena.save();
							return true; 
							}
						}
						
					 else if (args[1].equalsIgnoreCase("setspect")) {
							if (args.length == 3) {
							Main.arena.getConfig().set("arenas."+ args[2]+ ".spect", Main.setLoc(p.getLocation(), true));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste la localizacion del espectador de la arena: &b" + args[2]));
							Main.arena.save();
							return true; 
							}
						} else if (args[1].equalsIgnoreCase("savearenablocks")) {
							if (args.length == 3) {
								if ((Main.arena.getConfig().contains("arenas." + args[2] + ".arena1")) &&
										(Main.arena.getConfig().contains("arenas." + args[2] + ".arena2")) &&
										(Main.arena.getConfig().contains("arenas." + args[2] + ".type"))) {
									String type = Main.arena.getConfig().getString("arenas." + args[2] + ".type");
									Location arena1 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[2] + ".arena1"), true);
									Location arena2 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[2] + ".arena2"), true);
									if (type.equalsIgnoreCase("BuildSpleefPvP")) {
									Main.arena.getConfig().set("arenas."+args[2] +".arenablocks", GameManager.getManager().saveArenaBlocks(arena1,arena2));
									Main.arena.save();
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aHas guardado la arena de: &b" + args[2]));
									}
								
								}
							}
						}
						
					 else if (args[1].equalsIgnoreCase("settype")) {
							if (args.length == 4) {
							Main.arena.getConfig().set("arenas."+ args[2]+ ".type", args[3]);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDefiniste el tipo de la arena: &b" + args[2]));
							Main.arena.save();
							return true; 
							}
						}
					} else if (args[0].equalsIgnoreCase("create")) {
						if (args.length == 2) {
							if (Main.arena.getConfig().contains("arenas." + args[1])) {
									if ((Main.arena.getConfig().contains("arenas." + args[1] + ".spawn1")) && 
										(Main.arena.getConfig().contains("arenas." + args[1] + ".spawn2"))&&
										(Main.arena.getConfig().contains("arenas." + args[1] + ".arena1")) &&
										(Main.arena.getConfig().contains("arenas." + args[1] + ".arena2")) &&
										(Main.arena.getConfig().contains("arenas." + args[1] + ".spect"))  &&
										(Main.arena.getConfig().contains("arenas." + args[1] + ".type"))) {
							Location spawn1 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".spawn1"), true);
							Location spawn2 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".spawn2"), true);
							Location arena1 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".arena1"), true);
							Location arena2 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".arena2"), true);
							Location spect = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".spect"), true);
							String id = args[1];
							String type = Main.arena.getConfig().getString("arenas." + args[1] + ".type");
							if (type.equalsIgnoreCase("BuildSpleefPvP")) {
								if (Main.arena.getConfig().contains("arenas."+args[1]+".death1") &&
										Main.arena.getConfig().contains("arenas."+args[1]+".death2")) {
									p.sendMessage("§aArena creada!");
									Main.arena.save();
									Location death1 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".death1"), true);
									Location death2 = Main.getLoc(Main.arena.getConfig().getString("arenas." + args[1] + ".death2"), true);
									GameManager.getManager().loadArena(spawn1, spawn2, arena1, arena2,death1,death2, spect, id, type);
								} else {
									p.sendMessage("§cNo se pudo crear esta arena, faltan localizaciones por definir. ");
								}
							}
							p.sendMessage("§aArena creada!");
							Main.arena.save();
							GameManager.getManager().loadArena(spawn1, spawn2, arena1, arena2,null,null, spect, id, type);
								} else {
									p.sendMessage("§cNo se pudo crear esta arena, faltan localizaciones por definir. ");
								}
							} else {
								p.sendMessage("§cNo existe ninguna arena con ese nombre.");
							}
						} 
						
					} else if (args[0].equalsIgnoreCase("arenas")) {
						p.sendMessage("§7Arenas cargadas: §b" + GameManager.getManager().getArenasList().size() );
						p.sendMessage("§5Arenas:");
						for (Game g : GameManager.getManager().getArenasList()) {
							if (GameManager.getManager().isStarted(g)) {
							p.sendMessage("§c" + g.getId());
							p.sendMessage("P1: " + g.getPlayer1().toString());
							p.sendMessage("P2: " + g.getPlayer2().toString());
							p.sendMessage("CanPlay: " + g.getCanPlay());
							p.sendMessage("Cuenta: " + g.getArenaStarting());
							
							} else if (g.getCanPlay()) {
								p.sendMessage("§6" + g.getId());
								p.sendMessage("CanPlay: " + g.getCanPlay());
								p.sendMessage("Cuenta: " + g.getArenaStarting());
							}else {
								p.sendMessage("§a" + g.getId());
								p.sendMessage("CanPlay: " + g.getCanPlay());
								p.sendMessage("Cuenta: " + g.getArenaStarting());
							}

						}
					
					} 
					
				}		
			}
		
		}
		return false;
	}
	
}