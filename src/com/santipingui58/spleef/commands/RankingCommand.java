package com.santipingui58.spleef.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.menu.RankingCountryMenu;
import com.santipingui58.spleef.menu.RankingMenu;

public class RankingCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
		if(cmd.getName().equalsIgnoreCase("ranking")){
			Player p = (Player) sender;
			if (args.length==0) {
				RankingMenu.page.put(p, 0);
				new RankingMenu(p).o(p);
			} else if (args.length==1) {
				if (args[0].equalsIgnoreCase("Argentina") || args[0].equalsIgnoreCase("AR")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "AR");
					new RankingCountryMenu(p,"AR").o(p);
				} else if (args[0].equalsIgnoreCase("Chile") || args[0].equalsIgnoreCase("CL")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "CL");
					new RankingCountryMenu(p,"CL").o(p);
				}  else if (args[0].equalsIgnoreCase("España") || args[0].equalsIgnoreCase("ES")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "ES");
					new RankingCountryMenu(p,"ES").o(p);
				}  else if (args[0].equalsIgnoreCase("Colombia") || args[0].equalsIgnoreCase("CO")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "CO");
					new RankingCountryMenu(p,"CO").o(p);
				} else if (args[0].equalsIgnoreCase("Peru") || args[0].equalsIgnoreCase("PE")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "PE");
					new RankingCountryMenu(p,"PE").o(p);
				}  else if (args[0].equalsIgnoreCase("Mexico") || args[0].equalsIgnoreCase("MX")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "MX");
					new RankingCountryMenu(p,"MX").o(p);
				} else if (args[0].equalsIgnoreCase("Ecuador") || args[0].equalsIgnoreCase("EC")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "EC");
					new RankingCountryMenu(p,"EC").o(p);
				} else if (args[0].equalsIgnoreCase("Uruguay") || args[0].equalsIgnoreCase("UY")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "UY");
					new RankingCountryMenu(p,"UY").o(p);
				}  else if (args[0].equalsIgnoreCase("USA") || args[0].equalsIgnoreCase("US")) {
					RankingCountryMenu.page.put(p, 0);
					RankingCountryMenu.country.put(p, "US");
					new RankingCountryMenu(p,"US").o(p);
				}
			}
		}
		}
		return false;
	}
}
