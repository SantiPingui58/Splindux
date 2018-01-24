package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.utils.HolographicAPI;

public class HGCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("hg")){
			Player p = (Player) sender;
			
			
			if (p.hasPermission("splindux.admin")) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("ffaspleef")) {
						
					} else if (args[0].equalsIgnoreCase("spleefelo")) {
						Main.arena.getConfig().set("hologramas.topelospleef", Main.setLoc(p.getLocation(), true));
						Main.arena.save();
						HolographicAPI.createTopELOSpleef();
					}  else if (args[0].equalsIgnoreCase("ffaspleefwins")) {
						Main.arena.getConfig().set("hologramas.ffaspleefwins", Main.setLoc(p.getLocation(), true));
						Main.arena.save();
						HolographicAPI.createTopFFASpleefWins();
					} else if (args[0].equalsIgnoreCase("delete")) {
						HolographicAPI.deleteHologram(p.getLocation());	
						p.sendMessage("§cHolograma borrado.");
					} else if (args[0].equalsIgnoreCase("deleteall")) {
						HolographicAPI.deleteHolograms();
						p.sendMessage("§cTodos los hologramas han sido borrados.");
					} else if (args[0].equalsIgnoreCase("update")) {
						HolographicAPI.update();
					}
				} 
			}
		}
		}
		return false;
		
	}
}