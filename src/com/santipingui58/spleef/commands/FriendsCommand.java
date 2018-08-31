package com.santipingui58.spleef.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.FriendsManager;

public class FriendsCommand implements CommandExecutor {
	
	 private static HashMap<Player,List<Player>> friendrequests = new HashMap<Player, List<Player>>();
	 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			final Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("friends")){
			if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
				p.sendMessage("§3/friends add <jugador> §7- §2Mandar solicitud de amistad");
				p.sendMessage("§3/friends list §7- §2Ver lista de amigos");
				p.sendMessage(" ");					
				p.sendMessage("§3/friends help §7- §2Muestra esta ayuda");	

			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("add")) {
					
					final Player pa = Bukkit.getServer().getPlayer(args[1]);
					if (Bukkit.getOnlinePlayers().contains(pa)) {
						if (p!=pa) {
						if (!FriendsManager.areFriends(p, pa)) {
							if (friendrequests.containsKey(pa) && friendrequests.get(pa).contains(p)) {
									FriendsManager.beFriends(p, pa);
									if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
										pa.sendMessage("§b" + p.getName() + "§a ha aceptado tu solicitud de amistad!");
									} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
										pa.sendMessage("§b" + p.getName() + "§a has accepted your friend request!");
									}
									
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§aHas aceptado la solicitud de amistad de §b" + pa.getName()+"§a!");
									} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
										p.sendMessage("§aYou have accepted the friend request of §b" + pa.getName() + "§a!");
									}
								
							} else {
								  List<Player> requesteds = new ArrayList<Player>();
								if (friendrequests.containsKey(p)) {
									
									for (Player ps : friendrequests.get(p)) {
										requesteds.add(ps);
									}
									
								} 
									if (!requesteds.contains(pa)) {
									requesteds.add(pa);
									}
									friendrequests.put(p, requesteds);
								
								  
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§aHas enviado una solicitud de amistad a §b" + pa.getName());
									} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
										p.sendMessage("§aYou have sent a friend request to §b" + pa.getName());
									}
									if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
										pa.sendMessage("§aEl jugador §b" +  p.getName() + "§a te ha enviado una solicitud de amistad, "
												+ "coloca §6§l/friend add " + p.getName() + " §a para aceptarla. §7(La solicitud expira en 5 minutos.)");
									} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
										pa.sendMessage("§aThe player §b" + p.getName() + "§has sent you a friend request, type §7§l/friend add "
												+ p.getName() + "§a to accept it. §7(The request expires in 5 minutes.)");
									}
								  
								  
								  @SuppressWarnings("unused")
									int task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.get(), new Runnable()
								    {

										@Override
										public void run() {
											try {
												 List<Player> requesteds = new ArrayList<Player>();			 
												 requesteds = friendrequests.get(p);
												 requesteds.remove(p);
											} catch (Exception e) {
											}
										}
								    }
								    , 1200L);				  
							
							}
							
							
						} else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§cYa eres amigo de §b" + pa.getName());
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§cYou are already friend of §b" + pa.getName());
							}
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cNo puedes enviarte una solicitud de amistad a ti mismo...");		
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cYou cant send a friend request to yourself...");		
						}
					}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl jugador §b" + args[0] + "§c no existe o no se encuentra conectado.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe player §b" + args[0] + "§cdoesn't exists or is not online.");
						}
					}
				} 
				} else if (args.length== 1) {
				if (args[0].equalsIgnoreCase("list")) {
					if (!FriendsManager.getFriends(p).isEmpty()) {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§6-=-=-=-[§e§lAmigos§6]-=-=-=-");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")){
						p.sendMessage("§6-=-=-=-[§e§lFriends§6]-=-=-=-");
						}
					for (String f : FriendsManager.getFriends(p)) {
						OfflinePlayer target = Bukkit.getServer().getPlayer(UUID.fromString(f)) ;
						if (Bukkit.getServer().getOnlinePlayers().contains(target)) {
							
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§6" + target.getName() + " §aestá conectado ");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§6" + target.getName() + " §ais online");
								
							}
						} else {
							OfflinePlayer target1 = Bukkit.getOfflinePlayer(UUID.fromString(f));
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§6" + target1.getName() + " §cúltima vez visto: §b"+DataManager.getLastConnection(target1));
								} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
									p.sendMessage("§6" + target1.getName() + " §clast time seen: §b"+DataManager.getLastConnection(target1));
									
								}
						}
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cNo tienes amigos aún, para mandar una solicitud de amistad usa: §b/friends add <nombre>");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cYou don't have any friend yet, to send a friend request use: §b/friends add <name>");
					}
				}
			}
			
				}
}
}
		return false;
	}
}