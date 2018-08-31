package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class CrumbleCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("crumble")) {
			Player p = (Player) sender;
			
			if (GameManager.getManager().isInGame(p)) {
				if (GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("spleef") ||
						GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("spleef2v2") ||
						GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("bowspleef") ||
						GameManager.getManager().getArenabyPlayer(p).getType().equalsIgnoreCase("BuildSpleefPvP")) {
					if (!GameManager.getManager().isRanked(GameManager.getManager().getArenabyPlayer(p))) {
			if (args.length == 0 || args.length >= 2) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§aUso: /crumble <porcentaje>");
					p.sendMessage("§7(El porcentaje debe ser entre 10 y 90, mientras más alto menos nieve en la arena)");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§aUse: /crumble <percentage>");
					p.sendMessage("§7(The percentage must be between 10 and 90, the higher will be the less snow in the arena)");
					
				}
				}  else {
					int por;
					try {
						por = Integer.parseInt(args[0]);
					} catch (Exception e) {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§b" + args[0] + "§c no es un número válido.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§b" + args[0] + "§c is not a valid number.");
						}
						return false;
					}
					
					if (por <= 90 && por >=10) {
					GameManager.getManager().crumbleRequest(p, por);
					} else {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEl porcentaje debe ser un número entre 10 y 90.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThe percentage must be a number between 10 and 90.");
						}
					}
				}
				} else {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cEste comando no puede ejecutarse aquí");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cThis command can't be executed here.");
					}
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEste comando no puede ejecutarse aquí");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThis command can't be executed here.");
				}
			}
			}  else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cEste comando solo puede ejecutarse dentro de una partida.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cThis command can only be executed in a match.");
				}
			}
		}

		}
		return false;
	}
}
