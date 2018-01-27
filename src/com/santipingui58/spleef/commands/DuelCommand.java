package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DuelCommand implements CommandExecutor{


	private static HashMap<Player,Player> duelrequest = new HashMap<Player, Player>();
	private static HashMap<Player,Player> duelrequestmap = new HashMap<Player, Player>();
	private static HashMap<Player, String> map = new HashMap<Player,String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("duel")){
			final Player p = (Player) sender;
			if (!GameManager.getManager().isInGame(p)) {
			if(args.length == 0 || args.length >= 3) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aUso del comando: /duel <jugador> <mapa>"));
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aUse of command: /duel <player> <map>"));
				}
				return true;
			} 
			
			if (args[0].equalsIgnoreCase("accept")) {
				if (args.length == 2) {
					final Player pa =Bukkit.getServer().getPlayer(args[1]);	
					if (Bukkit.getOnlinePlayers().contains(pa)) {
						if (!GameManager.getManager().isInGame(pa)) {
						if (duelrequest.containsKey(pa) && (duelrequest.containsValue(p))) {
							if (!(p==pa)) {
								duelrequest.remove(pa, p);
								try {
									duelrequestmap.remove(pa, p);
								} catch (Exception e) {}
								GameManager.getManager().DuelGame(p, pa, null);
								return true;
							}
						} else if (duelrequestmap.containsKey(pa) && duelrequestmap.containsValue(p)) {
							if (!(p==pa)) {
								duelrequestmap.remove(pa, p);
								try {
									duelrequest.remove(pa,p);
									for (Game g : GameManager.getManager().getArenasList()) {
										g.getQueue().remove(pa);
										g.getQueue().remove(p);
									}
									
									
								} catch(Exception e) {}
								GameManager.getManager().DuelGame(p, pa, map.get(pa));
								map.remove(pa);
								return true;
							}
						}
						else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cNo tienes una solicitud de duelo del jugador §b" + pa.getName());
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cYou don't have a request of duel of the player §b:" + pa.getName());
							}
							return false;
						}
						}	else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cEste jugador ya se encuentra en una partida.");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cThis player is already in a match.");
							}
							return false;
						}
					}  else { 
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cEl jugador §b" + args[0] + "§c no existe o no se encuentra conectado.");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cThe player §b" + args[0] + "§cdoesn't exists or is not online.");
					}
						return false;
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§aUso del comando: /duel accept <jugador>");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§aUse of command: /duel accept <player>");
					}
					return false;
				}
			}
				
			
				final Player pa =Bukkit.getServer().getPlayer(args[0]);		
				
					if(Bukkit.getOnlinePlayers().contains(pa)) {
						if (!(p==pa)) {
						if (!GameManager.getManager().isInGame(pa)) {
						if(args.length == 1) {
							
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§aLe has enviado un duelo a §b" + pa.getName() + "§a, "
									+ "el jugador tiene 1 minuto para aceptarlo.");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§aYou have sent a duel to §b" + pa.getName() + "§a, the "
										+ "player has 1 minute to accept it.");
							}
								if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
								pa.sendMessage("§3[Spleef] §aHas recibido un duelo de §b" + p.getName() + "§a, coloca §b/duel accept " + p.getName() +
										 "§a para aceptarla §7(La solicitud expira en 1 minuto.)");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3[Spleef] §aYou have received a duel of §b" + p.getName() + "§a, type §b/duel accept " + p.getName() +
									"§a to accept it §7(The request will expire in 1 minute.");
								}
								duelrequest.put(p, pa);
								
								@SuppressWarnings("unused")
								int task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
							    {

									@Override
									public void run() {
										duelrequest.remove(p, pa);
										try {
											duelrequestmap.remove(p,pa);						
										} catch (Exception e) {}
									}
							    }
							    , 1200L);
								
								
							
						} else if (args.length == 2) {
							for(Game g : GameManager.getManager().getArenasList()) {
								if (Main.containsIgnoreCase(args[1], g.getId())) {
									if (g.getPlayer1().isEmpty() && g.getPlayer2().isEmpty()) {
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§aLe has enviado un duelo a §b" + pa.getName() + "§a, "
												+ "el jugador tiene 1 minuto para aceptarlo.");
										} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
											p.sendMessage("§aYou have sent a duel to §b" + pa.getName() + "§a, the "
													+ "player has 1 minute to accept it.");
										}
									
									if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
										pa.sendMessage("§3[Spleef] §aHas recibido un duelo de §b" + p.getName() + "§a, coloca §b/duel accept " + p.getName() +
												 "§a para aceptarla §7(La solicitud expira en 1 minuto.)");
										} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
											pa.sendMessage("§3[Spleef] §aYou have received a duel of §b" + p.getName() + "§a, type §b/duel accept" + p.getName() +
											"§ato accept it §7(The request will expire in 1 minute.");
										}
									
											duelrequestmap.put(p, pa);
											map.put(p, args[1]);
											@SuppressWarnings("unused")
											int task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
										    {

												@Override
												public void run() {
													try {
														duelrequest.remove(p, pa);
													} catch(Exception e) {}
													map.remove(p,args[1]);
													duelrequestmap.remove(p, pa);
												}
										    }
										    , 1200L);
											
											
											return true;
											
									}
								} 
							}
							
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cNo se ha podido enviar el duelo, puede que la arena §b " + args[1] 
										+ " §cno exista o que no hayan arenas disponibles.");
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§cCould not send the duel, it could be because the arena §b " 
											+ args[1] + " §cdoesn't exists o there are not available arenas.");
								}
							return false;
							
						}
						} else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cEste jugador ya se encuentra en una partida.");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cThis player is already in a match.");
							}
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cNo puedes enviar un duelo a ti mismo...");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cYou can't send a duel to yourself...");
						}
					}
					} else { 
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cEl jugador §b" + args[0] + "§c no existe o no se encuentra conectado.");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cThe player §b" + args[0] + "§c doesn't exists or is not online.");
					}
						}
			
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou can't execute this command while playing a match.");
				}
			}
		}
		return false;
	}
	}
}
	
