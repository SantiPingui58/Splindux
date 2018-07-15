package com.santipingui58.spleef.commands;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class RideCommand implements CommandExecutor {

	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("ride")){
			final Player p = (Player) sender;
			
			if (p.hasPermission("splindux.ride")) {
				if (!p.getGameMode().equals(GameMode.SPECTATOR)) {
			if (!GameManager.getManager().isInGame(p) && !GameManager.getManager().isSpectating(p)) {
			if (args.length == 1) {
				final Player pa = Bukkit.getServer().getPlayer(args[0]);
				if (Bukkit.getOnlinePlayers().contains(pa)) {
					if (!pa.equals(p)) {
						if (!GameManager.getManager().isInGame(pa) && !GameManager.getManager().isSpectating(pa)) {						
							pa.setPassenger(p);
						} else {
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("�cNo puedes montar a este jugador en este momento");
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("�cYou cannot ride this player right now.");
							}
						}
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("�cNo puedes montarte a ti mismo..");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("�cYou cannot ride yourself..");
						}
					}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("�cEl jugador �b" + args[0] + "�c no existe o no se encuentra conectado.");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("�cThe player �b" + args[0] + "�cdoesn't exists or is not online.");
					}
				}
			}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("�cNo puedes ejecutar este comando dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("�cYou can't execute this command while playing a match.");
				}
			}
		} else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("�cNo puedes ejecutar este comando en modo espectador.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("�cYou can't execute this command in spectator mode.");
			}
		}
				}else {
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("�cNo tienes permiso para ejecutar este comando.");
				p.sendMessage("�aNecesitass un rango "
						+ "�5�l[Extreme]�a para poder usar esto, visita la tienda para m�s informaci�n: �bhttp://splinduxstore.buycraft.net/");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("�cYou don't have permission to execute this command.");
				p.sendMessage("�aYou need a rank "
						+ "�5�l[Extreme] �ato use this, visit the store for more info: �bhttp://splinduxstore.buycraft.net/");
			
			} 
		}}
		}
	
	return false;
}
}
