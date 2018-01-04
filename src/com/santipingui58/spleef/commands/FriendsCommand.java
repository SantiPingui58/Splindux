package com.santipingui58.spleef.commands;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.FriendsManager;

public class FriendsCommand implements CommandExecutor {
	
	
	public static List<HashMap<Player,Player>> friendrequests;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			final Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("friends")){
			if (args.length == 0) {
				
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("add")) {
					
					final Player pa = Bukkit.getServer().getPlayer(args[1]);
					if (Bukkit.getOnlinePlayers().contains(pa)) {
						if (p!=pa) {
						if (!FriendsManager.areFriends(p, pa)) {
							for (HashMap<Player,Player> h : friendrequests) {
								if (h.containsValue(p) && h.containsKey(pa)) {
									
									FriendsManager.addFriend(p, pa.getName());
									FriendsManager.addFriend(pa, p.getName());
									if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
										p.sendMessage("§b" + pa.getName() + "§a ha aceptado tu solicitud de amistad!");
									} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
										p.sendMessage("§b" + pa.getName() + "§a has accepted your friend request!");
									}
									
									friendrequests.remove(h);
									return true;
									
									
								}
							}
							
							
							
							final HashMap<Player,Player> request = new HashMap<Player,Player>();
							request.put(p, pa);
							friendrequests.add(request);
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
							
							
							new BukkitRunnable() {
								@Override
								public void run() {
									friendrequests.remove(request);
									try {
										if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
											p.sendMessage("§cLa solicitud de amistad para §b" + pa.getName() + "§c ha expirado.");
										} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
											p.sendMessage("§cThe friend request to §b" + pa.getName() + "§c has expired.");
										}
										
										if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
											pa.sendMessage("§cLa solicitud de amistad de §b" + p.getName() + "§c ha expirado.");
										} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
											pa.sendMessage("§cThe friend request from §b" + p.getName() + "§c has expired.");
										}
									} catch (Exception e) {}
								}
							}.runTaskLater(Main.get(), 1L);		
							
							
							
							
							
							
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
				} else if (args[0].equalsIgnoreCase("remove")) {
					if (FriendsManager.getFriends(p).contains(args[0])) {
						try {
							FriendsManager.removeFriend(p, args[0]);
						} catch (Exception e) {}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cNo tienes ningún amigo llamado §b" + args[0]);							
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cYou don't have any friend called §b" + args[0]);
						}
					}
					
					
					
				} else if (args[0].equalsIgnoreCase("list")) {
					if (!FriendsManager.getFriends(p).isEmpty()) {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§6-=-=-=-[§e§lAmigos§6]-=-=-=-");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")){
						p.sendMessage("§6-=-=-=-[§e§lFriends§6]-=-=-=-");
						}
					for (String f : FriendsManager.getFriends(p)) {
						if (Bukkit.getServer().getPlayer(f).isOnline()) {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§6" + f + " §a está conectado");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§6" + f + " §a is online");
								
							}
						} else {
							
						}
					}
				} else {
					
				}
			} }
			
			
}
}
		return false;
	}
}