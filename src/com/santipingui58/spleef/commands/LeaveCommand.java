package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.game.Game;
import com.santipingui58.spleef.game.RankedSpleefGame;
import com.santipingui58.spleef.game.SpleefGame;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;

public class LeaveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("leave")){
			for (Game g : GameManager.getManager().getArenasList()) {
				
				
				try {
					if (g.getQueue().contains(p)) {				
						g.getQueue().remove(p);
					} 
					
					if (g.getSpectators().contains(p)) {
						g.getSpectators().remove(p);
					}
				
				if (g.getPlayer1().contains(p)) {
					if (GameManager.getManager().isRanked(g)) {
						RankedSpleefGame.gameOver(g.getPlayer2().get(0), p, g.getId());
					} else {
						SpleefGame.gameOver(g.getPlayer2().get(0), p, g.getId());
					}
				} 
				if (g.getPlayer2().contains(p)) {
					if (GameManager.getManager().isRanked(g)) {
						RankedSpleefGame.gameOver(g.getPlayer1().get(0), p, g.getId());
					} else {
						SpleefGame.gameOver(g.getPlayer1().get(0), p, g.getId());
					}
				} 
				if (g.getPlayers().contains(p)) {
					g.getPlayers().remove(p);
					if (g.getType().equalsIgnoreCase("ffaspleef")) {
						if (!GameManager.getManager().isStarted(g)) {
							if (g.getQueue().size() <= 3) {
							for (Player pa : g.getQueue()) {
								if (DataManager.getLang(pa).equalsIgnoreCase("ESP")) {
									pa.sendMessage("§3[FFASpleef] §cNo hay suficientes jugadores, partida cancelada.");
								} else if (DataManager.getLang(pa).equalsIgnoreCase("ENG")) {
									pa.sendMessage("§3[FFASpleef] §cThere are not enough players, game cancelled.");
								}
							}
							}
						}
					}
				} 
				if (g.getQueue().contains(p)) {
					g.getQueue().remove(p);
				}
				
				
				
				
				} catch (Exception e) {}
			}
			
			p.teleport(Main.getLoc(Main.arena.getConfig().getString("lobby")));
			Main.giveItems(p);
			if (DataManager.getLang(p).equalsIgnoreCase("ESP")){
				p.sendMessage("§aHas salido de todas las partidas y/o colas.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§aYou have been removed from all games or queues");
			}
			
			
			}
		}
		return false;
	} 
	

}
