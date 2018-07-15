package com.santipingui58.spleef.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
public class StaffCommand implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			final Player p = (Player) sender;
			if (p.hasPermission("splindux.staff")) {
		if(cmd.getName().equalsIgnoreCase("staff")){
			
			
			if (args.length == 0) {
				
			} else if (args[0].equalsIgnoreCase("tp")) {
				if (args.length == 2) {
					if (args[1].equalsIgnoreCase("arenas")) {
						p.teleport((Main.getLoc(Main.arena.getConfig().getString("arena"))));
					} else if (args[1].equalsIgnoreCase("construccion")) {
						p.teleport(Bukkit.getWorld("construccion").getSpawnLocation());
					}
				}
			} else if (args[0].equalsIgnoreCase("points")) {
				if (args.length == 3) {
					Player pa =	Bukkit.getServer().getPlayer(args[1]);
					if (Bukkit.getServer().getOnlinePlayers().contains(pa)) {
						p.sendMessage("§aLe has dado §6" + args[2] + "§a puntos de Spleef a §b" + pa.getName());
						if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
							pa.sendMessage("§aHas ganado §6" + args[2] + "§a puntos de Spleef!");
						} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
							pa.sendMessage("§aYou have win §6" + args[2] + "§a Spleef points!");
						}
						
						SpleefRankManager.giveExp(pa, Integer.parseInt(args[2])); 
						} 
					}
				} else if (args[0].equalsIgnoreCase("eloreset")) {
					if (p.getName().equalsIgnoreCase("SantiPingui58")) {
					Set<String> data = Main.data.getConfig().getConfigurationSection("data").getKeys(false);
					for (String uuid : data) {
						try {
							Main.data.getConfig().set("data."+uuid+".ELO", 1000);
						} catch (Exception e) {}
					}
					Main.data.save();
					}
				} else if (args[0].equalsIgnoreCase("forcereset")) {
					if (GameManager.getManager().isSpectating(p)) {
						Game g = GameManager.getManager().getArenabyPlayer(p);
						GameManager.getManager().reinicio(g);
						for (Player p1 : g.getPlayer1()) {
							if (DataManager.getLang(p1).equalsIgnoreCase("ESP")) {
								p1.sendMessage("§cLa arena ha sido reiniciada por un Staff.");
							} else if (DataManager.getLang(p1).equalsIgnoreCase("ENG")) {
								p1.sendMessage("§cThe arena was reseted by an Staff.");
							}
						}
						
						for (Player p2 : g.getPlayer2()) {
							if (DataManager.getLang(p2).equalsIgnoreCase("ESP")) {
								p2.sendMessage("§cLa arena ha sido reiniciada por un Staff.");
							} else if (DataManager.getLang(p2).equalsIgnoreCase("ENG")) {
								p2.sendMessage("§cThe arena was reseted by an Staff.");
							}
						}
						
						for (Player spect : g.getSpectators()) {
							if (DataManager.getLang(spect).equalsIgnoreCase("ESP")) {
								spect.sendMessage("§cLa arena ha sido reiniciada por un Staff.");
							} else if (DataManager.getLang(spect).equalsIgnoreCase("ENG")) {
								spect.sendMessage("§cThe arena was reseted by an Staff.");
							}
						}
					}
				}
			} else if (cmd.getName().equalsIgnoreCase("schat")) {
				if (p.hasPermission("splindux.staff")) {
					 StringBuilder builder = new StringBuilder();
					    for (int i = 0; i < args.length; i++)
					    {
					      builder.append(args[i]).append(" ");
					    }
					  String message = builder.toString();
					  for (Player pa : Bukkit.getOnlinePlayers()) {
						  if (pa.hasPermission("splindux.staff")) {
							  pa.sendMessage("§f[§c§lStaff§f] §3" + p.getName() + "§7: §f" + message);
						  }
					  }
					
				}
			}
	
		}
		}	
		return false;
	}
}
