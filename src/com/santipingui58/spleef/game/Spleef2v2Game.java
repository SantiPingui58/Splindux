package com.santipingui58.spleef.game;



import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.santipingui58.spleef.Main;
import com.santipingui58.spleef.managers.DataManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
import com.santipingui58.spleef.utils.Scoreboard;

public class Spleef2v2Game implements Listener  {


  public static int task;
  public static ItemStack pala = new ItemStack (Material.DIAMOND_SPADE);

  
	  @SuppressWarnings("deprecation")
	public static void startCountdown(String id) {
		  
		  ItemMeta meta = pala.getItemMeta();
	      meta.spigot().setUnbreakable(true);
	      meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	      pala.setItemMeta(meta);
	      final Game g = GameManager.getManager().getArena(id);
	     final Player  p1A = g.getPlayer1().get(0);
	     final Player  p1B = g.getPlayer1().get(1);
	     
	     final Player  p2A = g.getPlayer2().get(0);
	     final Player  p2B = g.getPlayer2().get(1);
	     
	     p1A.setFlying(false);
	     p2A.setFlying(false);
	     p1B.setFlying(false);
	     p2B.setFlying(false);
	     
	     teamTeleport(p1A, p1B, g.getSpawn1());
	     teamTeleport(p2A, p2B, g.getSpawn2());
	     
	     
	     
	     if (DataManager.getNightVision(p1A)) {
	    	 p1A.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, 10000, 0));
	     }
	     
	     if (DataManager.getNightVision(p1B)) {
	    	 p1B.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, 10000, 0));
	     }
	     
	     if (DataManager.getNightVision(p2A)) {
	    	 p2A.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, 10000, 0));
	     }
	     
	     if (DataManager.getNightVision(p2B)) {
	    	 p2B.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, 10000, 0));
	     }
	     
	     
	     new BukkitRunnable() {
				@Override
				public void run() {
					 p1A.getInventory().clear();
				     p1B.getInventory().clear();
				     p2A.getInventory().clear();
				     p2B.getInventory().clear();
					p1A.getInventory().addItem(pala);
			   		p1B.getInventory().addItem(pala);
			   		p2A.getInventory().addItem(pala);
			   		p2B.getInventory().addItem(pala);
			      
				}
			}.runTaskLater(Main.get(), 3L);	
	      
	      
	      new Scoreboard().createScoreboardGame(p1A);
        	new Scoreboard().createScoreboardGame(p2A);
        	new Scoreboard().createScoreboardGame(p1B);
        	new Scoreboard().createScoreboardGame(p2B);
        	GameManager.getManager().Countdown(g);

	  }
	  
	  
	  public static void gameOver(List<Player> ganador, List<Player> perdedor, String id) {
	  	
		  Game g = GameManager.getManager().getArena(id);
		  
		  String team1 = g.getPlayer1().get(0).getName() + "-"+  g.getPlayer1().get(1).getName();
		  String team2 = g.getPlayer2().get(0).getName() + "-" + g.getPlayer2().get(1).getName();

		  
		  
		  
		  try {
	  		  
	  		  g.resetRounds();
	  		  GameManager.getManager().reinicio(g);
	  		  g.resetTime();
		  } catch (Exception e) {}
	  		  
	  		  if (ganador == null && perdedor == null) {
	  			try {
					  for (Player p1 : g.getPlayer1()) {
						  p1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
						  Main.giveItems(p1);
					  }
					  
					for (Player p2 : g.getPlayer2()) {
						  p2.teleport(Main.getLoc(Main.arena.get("lobby"), true));
						  Main.giveItems(p2);

					
					  }
				  } catch (Exception e) {}
				
				g.resetPoints();
				 g.getPlayer1().clear();
				 g.getPlayer2().clear();
				 
	  		  } else if (g.getPoints1() >= 5) {
	
	  			for (Player pa : ganador) {
	  				SpleefRankManager.levelUp(pa);
	  			  }
	  			
	  			for (Player pa : perdedor) {
	  				SpleefRankManager.levelUp(pa);
	  			  }
		  		   
	
		  		   for (Player sp : g.getSpectators()) {
		  			 sp.sendMessage("§3[Spleef] §a" + team1 + " §7le ha ganado a §c" + team2 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
		  		   }
		  		   for (Player p : ganador) {
	  				  p.sendMessage("§3[Spleef] §aLe has ganado a §b" + team2
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				Main.giveItems(p);
		  		   }
	  				 for (Player p : perdedor) {
	  				p.sendMessage("§3[Spleef] §cHas perdido contra §a" + team1 
	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				
	  				 }
	  				 	g.resetPoints();
	  					  g.getPlayer1().clear();
	  					  g.getPlayer2().clear();
	  					
	  			  } else if (g.getPoints2() >= 5) {

	  				for (Player pa : ganador) {
		  				SpleefRankManager.levelUp(pa);
		  			  }
		  			
		  			for (Player pa : perdedor) {
		  				SpleefRankManager.levelUp(pa);
		  			  }
	  	  		   
	  	  		   for (Player sp : g.getSpectators()) {
	  	  			 sp.sendMessage("§3[Spleef] §a" + team2 + " §7le ha ganado a §c" + team1
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  	  		   }
	  	  		   	for (Player p : ganador) {
	  				  p.sendMessage("§3[Spleef] §aLe has ganado a §b" +team1
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  Main.giveItems(p);
	  	  		   	}
	  	  		   	
	  	  		   	for (Player p : perdedor) {
	  				p.sendMessage("§3[Spleef] §cHas perdido contra §a" + team2
	  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  Main.giveItems(p);
	  	  		   	}
	  	  		   	
	  				 g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();


	  					
	  			  } else if (ganador == g.getPlayer1()) {

	  	  			for (Player pa : ganador) {
	  	  				SpleefRankManager.levelUp(pa);
	  	  			  }
	  	  			
	  	  			for (Player pa : perdedor) {
	  	  				SpleefRankManager.levelUp(pa);
	  	  			  }
	  		  		   
	  	
	  		  		   for (Player sp : g.getSpectators()) {
	  		  			 sp.sendMessage("§3[Spleef] §a" + team1 + " §7le ha ganado a §c" + team2 
	  	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  		  		   }
	  		  		   for (Player p : ganador) {
	  	  				  p.sendMessage("§3[Spleef] §aLe has ganado a §b" + team2
	  	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  	  				p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  	  				Main.giveItems(p);
	  		  		   }
	  	  				 for (Player p : perdedor) {
	  	  				p.sendMessage("§3[Spleef] §cHas perdido contra §a" + team1 
	  	  				  + " §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  	  				p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  	  				
	  	  				 }
	  	  				 	g.resetPoints();
	  	  					  g.getPlayer1().clear();
	  	  					  g.getPlayer2().clear();
	  			  } else if (ganador == g.getPlayer2()) {
	  				  

		  				for (Player pa : ganador) {
			  				SpleefRankManager.levelUp(pa);
			  			  }
			  			
			  			for (Player pa : perdedor) {
			  				SpleefRankManager.levelUp(pa);
			  			  }
		  	  		   
		  	  		   for (Player sp : g.getSpectators()) {
		  	  			 sp.sendMessage("§3[Spleef] §a" + team2 + " §7le ha ganado a §c" + team1
		  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
		  	  		   }
		  	  		   	for (Player p : ganador) {
		  				  p.sendMessage("§3[Spleef] §aLe has ganado a §b" +team1
		  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
		  				  p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
		  				  Main.giveItems(p);
		  	  		   	}
		  	  		   	
		  	  		   	for (Player p : perdedor) {
		  				p.sendMessage("§3[Spleef] §cHas perdido contra §a" + team2
		  				  + " §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
		  				  p.teleport(Main.getLoc(Main.arena.get("lobby"), true));
		  				  Main.giveItems(p);
		  	  		   	}
		  	  		   	
		  				 g.resetPoints();
		  				 g.getPlayer1().clear();
		  				 g.getPlayer2().clear();

	  			  } else {
	  				  try {
	  					  for (Player p1 : g.getPlayer1()) {
	  						  p1.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  						  Main.giveItems(p1);
	  					  }
	  					  
	  					for (Player p2 : g.getPlayer2()) {
	  						  p2.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  						  Main.giveItems(p2);
	  					  }
	  					
	  				  } catch (Exception e) {}
	  				
	  				g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();
	  				 for (Player po : Bukkit.getOnlinePlayers()) {
	  					 new Scoreboard().createScoreboard(po);
	  				 }
	  			  }
	  		
	  		 for (Player sp : g.getSpectators()) {
	  			  if (g.getSpectators().size() >= 1) {
	  			//		sp.performCommand("spect leave");
		  			  	 Main.giveItems(sp);
		  			   sp.setGameMode(GameMode.SURVIVAL);
		  			  	 sp.teleport(Main.getLoc(Main.arena.get("lobby"), true));
		 
		  			  	} else {
		  			  		return;
		  			  	}
	  			  }
	  				
	  				 g.getSpectators().clear();
	  		  
	  		  
	  	  }
	  

	  public static void teamTeleport(Player p1, Player p2, Location l) {
		  
		  int spawn1X = l.getBlockX() +2;
		  int spawn1Y = l.getBlockY();
		  int spawn1Z = l.getBlockZ();
		  
		  int spawn2X = l.getBlockX() -2;
		  int spawn2Y = l.getBlockY();
		  int spawn2Z = l.getBlockZ();
		  
		  Location a = new Location(l.getWorld(), spawn1X, spawn1Y, spawn1Z);
		  Location b = new Location (l.getWorld(), spawn2X, spawn2Y, spawn2Z);
		  p1.teleport(a);
		  p2.teleport(b);
		  
		  
	  }
	  
	  
	  
	  
	  
	  
}
	  
	
	

