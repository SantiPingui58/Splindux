package com.santipingui58.spleef.listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;


public class VotifierListener implements Listener {
	
	public static boolean onNameMCVote(Player p) {
		
		String uuid = p.getUniqueId().toString();
		 boolean ret = false;
		try { 
			URL url = new URL("https://api.namemc.com/server/mc.splindux.com/likes?profile="+uuid);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String str = null;
	        while ((str = in.readLine()) != null) {
	            str = str.toLowerCase();
	            if (str.contains("true")) {
	                ret = true;
	                break;
	            }
	        }
	        in.close();
	} catch (Exception e) {}
		return ret;

}
	
	
	
	@EventHandler
	public void onPlayerVote(VotifierEvent e) {
		Vote v = e.getVote();
		Player p = Bukkit.getServer().getPlayer(v.getUsername());
		if (Bukkit.getServer().getOnlinePlayers().contains(p)) {
			if (v.getServiceName().equalsIgnoreCase("MinecraftServers.org")) {
				Main.votes.getConfig().set("players."+v.getUsername()+".minecraftservers", 1440);
				Main.votes.save();
			}
			if (v.getServiceName().equalsIgnoreCase("PlanetMinecraft.com")) {
				Main.votes.getConfig().set("players."+v.getUsername()+".planetminecraft", 1440);
				Main.votes.save();
			} 
			
			if (v.getServiceName().equalsIgnoreCase("Minecraft-MP.com")) {
				Main.votes.getConfig().set("players."+v.getUsername()+".minecraftMP", 1440);
				Main.votes.save();
			}
			
			if (v.getServiceName().equalsIgnoreCase("TopG.org")) {
				Main.votes.getConfig().set("players."+v.getUsername()+".topg", 1440);
				Main.votes.save();
			}
			
			
			int votestoday = 0;
			if (Main.votes.getConfig().contains("players."+v.getUsername()+".votestoday")) {
				 votestoday = Main.votes.getConfig().getInt("players."+v.getUsername()+".votestoday");
			}
			SpleefRankManager.giveExp(p, 10);
			p.sendMessage("§aYou have received: §310 EXP");
			EconomyManager.addCoins(p, 50, false);	
			
			if (p.hasPermission("splindux.votes.5") || (p.hasPermission("splindux.votes.4") && votestoday<4)  
					|| (votestoday<3)) {
				int rankeds = DataManager.getRankeds(p);
				rankeds++;
				DataManager.setRankeds(p, rankeds);
				p.sendMessage("§aYou have received: §b1 Ranked");	
			}
			votestoday++;
			 Main.votes.getConfig().set("players."+v.getUsername()+".votestoday",votestoday);
			 Main.votes.save();
			
		}
	}
	
	
	public static void voteTime() {
		Set<String> players = Main.votes.getConfig().getConfigurationSection("players").getKeys(false);
		
		for (String player: players) {
			Set<String> servers = Main.votes.getConfig().getConfigurationSection("players."+player).getKeys(false);
			//try {
				for (String server : servers) {
					if (!server.equalsIgnoreCase("votestoday")) {
				int time = Main.votes.getConfig().getInt("players."+player+"."+server);
				time = time-1;
				Main.votes.getConfig().set("players."+player+"."+server,time);
				Main.votes.save();
				if (time<=0) {
					Main.votes.getConfig().set("players."+player+"."+server,null);
					Main.votes.save();
						 int votestoday = Main.votes.getConfig().getInt("players."+player+".votestoday");
						 votestoday--;
						 if (votestoday<=0) {
							 Main.votes.getConfig().set("players."+player+".votestoday",null);
						 } else {
						 Main.votes.getConfig().set("players."+player+".votestoday", votestoday);
						 }
				}
				
					} 
			//} catch (Exception e) {}
		}
		}
	}
	
	public static String minutesToHours(Integer minutes) {
		
		if (minutes<= 60) {
			return "§b"+minutes+" minutes";
		} else {
			int hours = (int) minutes/60;
			return "§b"+hours+" hours";
		}
	}
	
}
