package com.santipingui58.spleef.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.PartyManager;

public class PartyCommand implements CommandExecutor{

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("Solo los jugadores pueden hacer esto!");
			return true;
			
		} else {
			Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("party")){			
			if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§a/party invite <jugador> §7- §eInvita jugadores a tu Party");
					p.sendMessage("§a/party remove <jugador> §7- §eElimina jugadores de tu Party");
					p.sendMessage("§a/party duel <jugador> §7- §eMandar duelo al lider de otra Party");
					p.sendMessage("§a/party leader <jugador> §7- §eDar el liderazgo de tu Party a otro miembro de la misma");
					p.sendMessage("§a/party disband §7- §eDeshacer la Party");
					p.sendMessage(" ");				
					p.sendMessage("§a/party list §7- §eVer los integrantes de la Party");	
					p.sendMessage("§a/party leave §7- §eSalir de la Party");	
					p.sendMessage("§a/party help §7- §eMuestra esta ayuda");	
					p.sendMessage(" ");
					p.sendMessage("§a/pchat <texto> §7- §eHablar por el chat de la Party");
					p.sendMessage("§a/pc §7- §eHablar unicamente por el chat de la Party");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					
					p.sendMessage("§a/party invite <player> §7- §eInvite players to your Party");
					p.sendMessage("§a/party remove <player> §7- §eRemove player from your Party");			
					p.sendMessage("§a/party duel <player> §7- §eDuel the leader of another Party");
					p.sendMessage("§a/party leader <player> §7- §eGive the leader of the Party to another player of it");
					p.sendMessage("§a/party disband §7- §eDisband the Party");
					p.sendMessage(" ");
					p.sendMessage("§a/party list §7- §eSee the players of the Party");	
					p.sendMessage("§a/party leave §7- §eLeave the Party");	
					p.sendMessage("§a/party help §7- §eDisplays this help");	
					p.sendMessage(" ");
					p.sendMessage("§a/pchat <text> §7- §eTalk in the Party's chat");
					p.sendMessage("§a/pc §7- §eTalk only for the Party's chat");
				}
			} else if (args[0].equalsIgnoreCase("invite")) {
				
			}
		
		} else if (cmd.getName().equalsIgnoreCase("pchat")) {
			if (PartyManager.getManager().isInParty(p)) {
				
			} else {
				if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
					p.sendMessage("§cNecesitas estar en una Party para ejecutar este comando.");
				} else if (DataManager.getLang(p).equalsIgnoreCase("ENG")) {
					p.sendMessage("§cYou need to be in a Party to execute this command.");
				}
			}
			
		}
		}
		return false;
	}
}