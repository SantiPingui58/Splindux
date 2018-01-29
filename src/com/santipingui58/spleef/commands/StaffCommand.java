package com.santipingui58.spleef.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.GameManager;

public class StaffCommand implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, final String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
	
		if(cmd.getName().equalsIgnoreCase("staff")){
			final Player p = (Player) sender;
			if (p.hasPermission("splindux.staff")) {
			if (args.length == 0) {
				
			} else if (args[0].equalsIgnoreCase("tp")) {
				if (args.length == 2) {
					if (args[1].equalsIgnoreCase("arenas")) {
						p.teleport((Main.getLoc(Main.arena.getConfig().getString("arena"))));
					}
				}
			} else if (args[1].equalsIgnoreCase("forcespleef2v2")) {
				try {
				Player p1 =	Bukkit.getServer().getPlayer(args[2]);
				Player p2 =	Bukkit.getServer().getPlayer(args[3]);
				Player p3 =	Bukkit.getServer().getPlayer(args[4]);
				Player p4 =	Bukkit.getServer().getPlayer(args[5]);
				
				GameManager.getManager().addSpleef2v2Queue(p1, null);
				GameManager.getManager().addSpleef2v2Queue(p2, null);
				GameManager.getManager().addSpleef2v2Queue(p3, null);
				GameManager.getManager().addSpleef2v2Queue(p4, null);
				} catch (Exception e) {
					p.sendMessage("§a/staff forcespleef2v2 <jugador1> <jugador2> <jugador3> <jugador4>");
				}
			}
		}
		}
		}
		return false;
	}
}
