package com.santipingui58.spleef.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;

public class MsgCommand implements CommandExecutor {
	
	private static HashMap<CommandSender,CommandSender> respond = new HashMap<CommandSender,CommandSender>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
	if(!(sender instanceof Player)) {
		if(cmd.getName().equalsIgnoreCase("msg")){
		
			if (args.length == 0 || args.length == 1) {
					sender.sendMessage("§aUso del comando: /msg <nombre> <mensaje>");
			} else {
				Player receptor = Bukkit.getServer().getPlayer(args[0]);
				
				if (Bukkit.getOnlinePlayers().contains(receptor)) {
					StringBuilder builder = new StringBuilder();
				    for (int i = 1; i < args.length; i++)
				    {
				      builder.append(args[i]).append(" ");
				    }
				  String message = builder.toString();
				  
					receptor.sendMessage("§6[SantiPingui58-> me] §f" + message);
					sender.sendMessage("§6[me -> " + receptor.getName() + "] §f" + message);
					respond.put(receptor, sender);
					respond.put(sender, receptor);
					
					
					
				} else {
						sender.sendMessage("§cEl jugador §b" + args[0] + "§c no existe o no se encuentra conectado.");		
				}
			}
			
		
		} else if (cmd.getName().equalsIgnoreCase("r")) {
			if (args.length >= 1) {
			if (respond.containsKey(sender)) {
				if (Bukkit.getServer().getOnlinePlayers().contains(respond.get(sender))) {
					
					StringBuilder builder = new StringBuilder();
				    for (int i = 0; i < args.length; i++)
				    {
				      builder.append(args[i]).append(" ");
				    }
				  String message = builder.toString();
					
					respond.get(sender).sendMessage("§6[SantiPingui58 -> me] §f" + message);
					sender.sendMessage("§6[me -> " + respond.get(sender).getName() + "] §f" + message);
				} else {
						sender.sendMessage("§cNo tienes a nadie a quien responder.");		
				}
			} else {
					sender.sendMessage("§cNo tienes a nadie a quien responder.");
				}
		} else {
				sender.sendMessage("§aUso del comando: /r <mensaje>");
			
		}
			}
		
		
	} else {

	if(cmd.getName().equalsIgnoreCase("msg")){
		final Player p = (Player) sender;
		if (args.length == 0 || args.length == 1) {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("§aUso del comando: /msg <nombre> <mensaje>");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§aUse of command: /msg <name> <message>");
			}
			
		} else {
			Player receptor = Bukkit.getServer().getPlayer(args[0]);
			
			if (Bukkit.getOnlinePlayers().contains(receptor)) {
				StringBuilder builder = new StringBuilder();
			    for (int i = 1; i < args.length; i++)
			    {
			      builder.append(args[i]).append(" ");
			    }
			  String message = builder.toString();
			  
				receptor.sendMessage("§6[" + p.getName() + " -> me] §f" + message);
				p.sendMessage("§6[me -> " + receptor.getName() + "] §f" + message);
				respond.put(receptor, p);
				respond.put(p, receptor);
				
				
				
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEl jugador §b" + args[0] + "§c no existe o no se encuentra conectado.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThe player §b" + args[0] + "§c doesn't exists or is not online.");
				}
			}
		}
		
	
	} else if (cmd.getName().equalsIgnoreCase("r")) {
		final Player p = (Player) sender;
		if (args.length >= 1) {
		if (respond.containsKey(p)) {
			if (Bukkit.getServer().getOnlinePlayers().contains(respond.get(p))) {
				
				StringBuilder builder = new StringBuilder();
			    for (int i = 0; i < args.length; i++)
			    {
			      builder.append(args[i]).append(" ");
			    }
			  String message = builder.toString();
				
				respond.get(p).sendMessage("§6[" + p.getName() + " -> me] §f" + message);
				p.sendMessage("§6[me -> " + respond.get(p).getName() + "] §f" + message);
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes a nadie a quien responder.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have anyone to reply.");
				}
			}
		} else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("§cNo tienes a nadie a quien responder.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§cYou don't have anyone to reply.");
			}
			}
	} else {
		if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
			p.sendMessage("§aUso del comando: /r <mensaje>");
		} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
			p.sendMessage("§aUse of command: /r <message>");
		}
	}
		}
	}
	return false;
	}

}
