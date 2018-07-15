package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.menu.eng.DuelRequestMenu;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DuelCommand implements CommandExecutor{


	public static HashMap<Player,Player> duelrequest = new HashMap<Player, Player>();
	
	public static HashMap<Player,String> game = new HashMap<Player,String>();
	public static HashMap<Player, String> map = new HashMap<Player,String>();
	
	public static HashMap<Player,Player> temprequest = new HashMap<Player, Player>();
	
	
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
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aUso del comando: /duel <jugador>"));
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aUse of command: /duel <player>"));
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
										duelrequest.remove(pa);
										for (Game g : GameManager.getManager().getArenasList()) {
											g.getQueue().remove(pa);
											g.getQueue().remove(p);
										}
								} catch (Exception e) {}
								
								if (!map.containsKey(pa)) {
								if (game.get(pa).equalsIgnoreCase("spleef")) {
								GameManager.getManager().DuelGame(p, pa, null); 
								} else if (game.get(pa).equalsIgnoreCase("BuildSpleefPvP")) {
									GameManager.getManager().DuelGameBSP(p, pa, null);
								}  else if (game.get(pa).equalsIgnoreCase("bowspleef")) {
									GameManager.getManager().DuelGameBowSpleef(p, pa, null);
								} 
								game.remove(pa);
								return true;
							} else {
								if (game.get(pa).equalsIgnoreCase("spleef")) {
									GameManager.getManager().DuelGame(p, pa, map.get(pa)); 
									} else if (game.get(pa).equalsIgnoreCase("BuildSpleefPvP")) {
										GameManager.getManager().DuelGameBSP(p, pa, map.get(pa));
									}  else if (game.get(pa).equalsIgnoreCase("bowspleef")) {
										GameManager.getManager().DuelGameBowSpleef(p, pa, map.get(pa));
									} 
									game.remove(pa);
									return true;
							}
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
							DuelRequestMenu.page.put(p, 1);
							temprequest.put(p, pa);
							new DuelRequestMenu(p).o(p);
								@SuppressWarnings("unused")
								int task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
							    {
									@Override
									public void run() {
										duelrequest.remove(p, pa);
										try {
											temprequest.remove(p);
										} catch (Exception e) {}
									}
							    }
							    , 1200L);
						
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
	
