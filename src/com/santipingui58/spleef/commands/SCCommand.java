package com.santipingui58.spleef.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.SplinduxCoinsManager;

public class SCCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("sc")) {
				if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
					if (DataManager.getLang(p).equalsIgnoreCase("ESP")) {
						p.sendMessage("§3/sc list §7- §fVe la lista de rangos y beneficios que puedes comprar con §3SC");
						p.sendMessage("§3/sc buy <ID> §7- §fAdquiere el item que quieras comprar (No se puede deshacer)");
						p.sendMessage("§3/sc pay <nombre> <cantidad> §7- §f Pagar la cantidad deseada a un jugador");
						p.sendMessage("§3/sc help §7- §fMuestra esta ayuda");
					}
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("list")) {
					p.sendMessage("§b§oRANK_VIP §7(§310 SC§7)");
					p.sendMessage("§b§oRANK_EPIC §7(§360 SC§7)");
					p.sendMessage("§b§oRANK_EXTREME §7(§3150 SC§7)");
					p.sendMessage("§b§o5_SPLINBOXES_5_STARS §7(§310 SC§7)");
					p.sendMessage("§b§o10_SPLINBOXES_5_STARS §7(§348 SC§7)");
					p.sendMessage("§b§o20_SPLINBOXES_5_STARS §7(§395 SC§7)");
					p.sendMessage("§b§oGADGETS_HATS_ALL §7(§3200 SC§7)");
					p.sendMessage("§b§oGADGETS_PARTICLES_ALL §7(§3200 SC§7)");
					p.sendMessage("§b§oGADGETS_SUITS_ALL §7(§3200 SC§7)");
					p.sendMessage("§b§oGADGETS_GADGETS_ALL §7(§3250 SC§7)");
					p.sendMessage("§b§oGADGETS_PETS_ALL §7(§3200 SC§7)");
					p.sendMessage("§b§oGADGETS_BANNERS_ALL §7(§3150 SC§7)");
					p.sendMessage("§b§oGADGETS_EMOTES_ALL §7(§3150 SC§7)");
					p.sendMessage("§b§oGADGETS_CLOAKS_ALL §7(§3150 SC§7)");
					p.sendMessage("§b§oSPLINDUX_CAPSULES_ALL §7(§3250 SC§7)");
					p.sendMessage("§b§oSPLINDUX_GIFT §7(§cProximamente§7)");
					p.sendMessage("§b§oIRON_SPLINDUX_GIFT §7(§cProximamente§7)");
					p.sendMessage("§b§oLAPIS_SPLINDUX_GIFT §7(§cProximamente§7)");
					p.sendMessage("§b§oREDSTONE_SPLINDUX_GIFT §7(§cProximamente§7)");
					p.sendMessage("§b§oGOLD_SPLINDUX_GIFT §7(§cProximamente§7)");
					p.sendMessage("§b§oEMERALD_SPLINDUX_GIFT §7(§cProximamente§7)");
					p.sendMessage("§b§oDIAMOND_SPLINDUX_GIFT §7(§cProximamente§7)");
					}
				} else if (args.length == 3) {
					if (args[0].equalsIgnoreCase("pay")) {
						
					} 
				}
			}
			return false;
		
		} else {
			if (cmd.getName().equalsIgnoreCase("sc")) {
				if (args.length == 3) {
			if (args[0].equalsIgnoreCase("give")) {	
				OfflinePlayer p = Bukkit.getServer().getPlayer(args[1]);
				//sc give SantiPingui58 25
				SplinduxCoinsManager.addSplinduxCoins(p.getUniqueId().toString(), Integer.parseInt(args[2]));
			
			}
	}
				}
		}
		return false;
}
}
