package com.santipingui58.spleef.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class FlyCommand implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("fly")){
			final Player p = (Player) sender;
			if (p.hasPermission("splindux.fly")) {
				
				if (!GameManager.getManager().isInGame(p)) {
				if (p.isFlying()) {
					p.setAllowFlight(false);
					p.setFlying(false);		
					
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cFly desactivado");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cFly desactivated");
					}	
				} else {
					p.setAllowFlight(true);
					p.setFlying(true);						
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§aFly activado");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§aFly activated");
					}
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou can't execute this command while playing a match.");
				}
			}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNo tienes permiso para ejecutar este comando.");
					p.sendMessage("§aNecesitass un rango "
							+ "§5§l[Epic]§a o superior para poder usar esto, visita la tienda para más información: §bhttp://splinduxstore.buycraft.net/");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou don't have permission to execute this command.");
					p.sendMessage("§aYou need a rank "
							+ "§5§l[Epic] §aor higher to use this, visit the store for more info: §bhttp://splinduxstore.buycraft.net/");
				
				} 
			}
			
		}  
		}
		
		return false;
		
		
		}
	
}
