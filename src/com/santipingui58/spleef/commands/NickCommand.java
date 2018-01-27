package com.santipingui58.spleef.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;

public class NickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("nick")){
			Player p = (Player) sender;
			if (p.hasPermission("splingdux.nick")) {
				if (args.length == 0 || args.length >= 3) {
					if (p.hasPermission("splingdux.admin")) {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§aUso del comando: /nick [jugador] <nick>");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§aUse of command: /nick [player] <nick>");
							}
					} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§aUso del comando: /nick <nick>");
					p.sendMessage("§aUso del comando: /nick off");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§aUse of command: /nick <nick>");
						p.sendMessage("§aUse of command: /nick off");
					}
					}
				} else if (args[0].equalsIgnoreCase("off")){
					if (p.hasPermission("splingux.admin")) {
						if (args.length == 2) {
							Player pa = Bukkit.getServer().getPlayer(args[1]);
							if (Bukkit.getOnlinePlayers().contains(pa)) {
								DataManager.deleteNick(pa);
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cEl nick de §b" + pa.getName() + "§c ha sido eliminado.");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cThe nick of §b" + pa.getName() + "§c has been deleted.");
							}
							} else {
								if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									p.sendMessage("§cEl jugador §b" + args[1] + "§c no existe o no se encuentra conectado.");
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§cThe player §b" + args[1] + "§c doesn't exists or is not online.");
								}
							}
						} else {
							DataManager.deleteNick(p);
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§7Nick desactivado");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§7Nick disabled");
							}
						}
					} else {
						DataManager.deleteNick(p);
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§7Nick desactivado");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§7Nick disabled");
						}
					}
				} else if (args.length == 2) {
					if (p.hasPermission("splingdux.admin")) {
						if (args[0].length() < 20) {
							if (args[0].length() > 3) {
							Set<String> data = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
							
							for (String s : data) {
								String name = Main.data.getConfig().getString("data."+s+".name");
								String nick = Main.data.getConfig().getString("data."+s+".nick");
									if (args[0].equalsIgnoreCase(name)) {
										
										if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§cEse nick ya está en uso.");
										} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
											p.sendMessage("§cThis nick is already in use.");
										}
										return false;
									} 
								
								
									if (args[0].equalsIgnoreCase(nick)) {
										if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§cEse nick ya está en uso.");
										} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
											p.sendMessage("§cThis nick is already in use.");
										}
										return false;
									}
								
							}
							
							for (Player ps : Bukkit.getServer().getOnlinePlayers()) {
								String s = ps.getName();
								if (args[0].equalsIgnoreCase(s)) {
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§cEse nick ya está en uso. Para desactivar tu nick usa §b/nick off");
										} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
											p.sendMessage("§cThis nick is already in use. To turn off your nick use §b/nick off");
										}
									return false;
								}
							}
							Player pa = Bukkit.getServer().getPlayer(args[1]);
							if (Bukkit.getOnlinePlayers().contains(pa)) {
								DataManager.setNick(pa, args[0]);
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§aNick del jugador §b" + pa.getName() + " §aestablecido a §b" + args[0]);
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§aNick of the player §b" + pa.getName() + " §asaved as §b" + args[0]);
								
							}
							} else {
								if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									p.sendMessage("§cEl jugador §b" + args[1] + "§c no existe o no se encuentra conectado.");
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§cThe player §b" + args[1] + "§c doesn't exists or is not online.");
								}
							}
						} else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cEl nick es demasiado corto.");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cThe nick is too short.");
							}
						}
						} else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cEl nick es demasiado largo.");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cThe nick is too long.");
							}
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§aUso del comando: /nick <nick>");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§aUse of command: /nick <nick>");
							}
					}
				} else {
					if (args[0].length() < 20) {
						if (args[0].length() > 3) {
						Set<String> data = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
						
						for (String s : data) {
							String name = Main.data.getConfig().getString("data."+s+".name");
							String nick = Main.data.getConfig().getString("data."+s+".nick");
								if (args[0].equalsIgnoreCase(name)) {
									
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									p.sendMessage("§cEse nick ya está en uso.");
									} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
										p.sendMessage("§cThis nick is already in use.");
									}
									return false;
								} 
							
							
								if (args[0].equalsIgnoreCase(nick)) {
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
									p.sendMessage("§cEse nick ya está en uso.");
									} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
										p.sendMessage("§cThis nick is already in use.");
									}
									return false;
								}
							
						
						}
						
						DataManager.setNick(p, args[0]);
								
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§aNick cambiado a §b" + args[0] );
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§aNick changed to §b" + args[0]);
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl nick es demasiado corto.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe nick is too short.");
						}
					}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl nick es demasiado largo.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe nick is too long.");
						}
					}
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes permiso para ejecutar este comando.");
					p.sendMessage("§aNecesitass un rango "
							+ "§1§l[Epic]§a o superior para poder usar esto, visita la tienda para más información: §bhttp://splinduxstore.buycraft.net/");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have permission to execute this command.");
					p.sendMessage("§aYou need a rank "
							+ "§1§l[Epic] §aor higher to use this, visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
				
				}
			}
			
		}
		}
	
		
		return false;
	}

}
