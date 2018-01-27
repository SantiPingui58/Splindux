package com.santipingui58.spleef.commands;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class SpectCommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("spect")){
			Player p = (Player) sender;
			if (GameManager.getManager().isInGame(p)) {
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cNo puedes ejecutar este comando dentro de una partida.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cYou can't execute this command while playing a match.");
						}
					
			} else {
				if (args.length == 0 || args.length > 2) {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§aUso del comando: /spect <jugador>");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§aUse of command: /spect <player>");
						}
				} else if (args[0].equalsIgnoreCase("leave")){
					for (Game g : GameManager.getManager().getArenasList()) {
						try {
							g.getSpectators().remove(p);
						} catch (Exception e) {}
					}
					if (DataManager.getLang(p).equals("ESP")) {
						p.sendMessage("§3[Spleef] §6Has dejado de espectar");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§3[Spleef] §6 You aren't specting anymore");
					}
					p.setGameMode(GameMode.ADVENTURE);
					p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
				} else {
			
					Player pa = Bukkit.getServer().getPlayer(args[0]);
					if (Bukkit.getOnlinePlayers().contains(pa)) {
						for (Game g : GameManager.getManager().getArenasList()) {
						if (g.getPlayer1().contains(pa) || g.getPlayer2().contains(pa)) {
							for (Game ga : GameManager.getManager().getArenasList()) {
								try {
									ga.getSpectators().remove(p);
								} catch (Exception e) {}
							}
							p.setGameMode(GameMode.SPECTATOR);
							p.teleport(pa);
							g.getSpectators().add(p);
							if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
								p.sendMessage("§aAhora te encuentras espectando a §b" + pa.getName());
							} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
								p.sendMessage("§aNow you are spectating §b" + pa.getName());
							}
							return true;
							
						} 
						
						
							
						
						}
						if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
							p.sendMessage("§cEste jugador no se encuentra en una partida.");
						} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
							p.sendMessage("§cThis player is not in a match.");
						}
						
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
			
			
		
		}

		
		
		
		
		return false;
	}
	
	
	

}
