package com.santipingui58.spleef.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;

public class MsgCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
	if(!(sender instanceof Player)) {
		
		sender.sendMessage("Solo los jugadores pueden hacer esto!");
		return true;
		
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
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEl jugador §b" + args[0] + "§c no existe o no se encuentra conectado.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThe player §b" + args[0] + "§c doesn't exists or is not online.");
				}
			}
		}
		
	
	}
	}
	return false;
	}

}
