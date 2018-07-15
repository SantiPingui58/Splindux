package com.santipingui58.spleef.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.listener.VotifierListener;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.managers.SpleefRankManager;

public class VoteNameMCCommand implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			final Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("votenamemc")){
			if (VotifierListener.onNameMCVote(p)) {
				if (Main.votes.getConfig().contains("namemcvotes."+p.getUniqueId())) {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§cYa has reclamado este premio anteriormente.");
					} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
						p.sendMessage("§cYou have already claimed this reward before.");
					}
				} else {	
				Main.votes.getConfig().set("namemcvotes."+p.getUniqueId(), true);
				Main.votes.save();
				EconomyManager.addCoins(p, 100, false);		
				SpleefRankManager.giveExp(p, 50);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gmysteryboxes give "+ p.getName() + " 1 4");
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("§e§lSplin§b§lDux§5§lVotes §aGracias por votar por nosotros!");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§e§lSplin§b§lDux§5§lVotes §aThanks for voting for us!");
				}
				}
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
				p.sendMessage("§cNo nos has dado like en NameMC aún.");
			} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
				p.sendMessage("§cYou have not liked us at NameMC yet.");
			} 
				}
			
			
		}
		}
		return false;
				}
			
}
