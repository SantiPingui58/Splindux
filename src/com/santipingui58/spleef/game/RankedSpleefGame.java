package com.santipingui58.spleef.game;



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
import com.santipingui58.spleef.managers.EconomyManager;
import com.santipingui58.spleef.managers.GameManager;
import com.santipingui58.spleef.managers.SpleefRankManager;
import com.santipingui58.spleef.utils.Scoreboard;

public class RankedSpleefGame implements Listener  {


  public static int task;
  public static ItemStack pala = new ItemStack (Material.DIAMOND_SPADE);

  
	  @SuppressWarnings("deprecation")
	public static void startCountdown(String id) {
		  
		  ItemMeta meta = pala.getItemMeta();
	      meta.spigot().setUnbreakable(true);
	      meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
	      pala.setItemMeta(meta);
	      final Game g = GameManager.getManager().getArena(id);
	     
	     final Player  p1 = g.getPlayer1().get(0);
	     final Player  p2 = g.getPlayer2().get(0);
	     p1.setGameMode(GameMode.SURVIVAL);
	     p2.setGameMode(GameMode.SURVIVAL);
	    
	     
	     
	     p1.setFlying(false);
	     p2.setFlying(false);
	     p1.setAllowFlight(false);
	     p2.setAllowFlight(false);
	     p1.teleport(g.getSpawn1());
	     p2.teleport(g.getSpawn2());
	     
	     if (DataManager.getNightVision(p1)) {
	    	 p1.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
	     }
	     if (DataManager.getNightVision(p2)) {
	    	 p2.addPotionEffect(new PotionEffect (PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
	     }
	  		
	   		new BukkitRunnable() {
				@Override
				public void run() {
					 p1.getInventory().clear();
				     p2.getInventory().clear();
					p1.getInventory().addItem(pala);
			   		p2.getInventory().addItem(pala);
			      
				}
			}.runTaskLater(Main.get(), 3L);	
	      
	      
	      new Scoreboard().createScoreboardGame(p1);
        	new Scoreboard().createScoreboardGame(p2);
	  
        	GameManager.getManager().Countdown(g);

	  } 
	  
	  
	  public static void gameOver(Player ganador, Player perdedor, String id) {
	  
		  
		  Player player1 = null;
		  Player player2 = null;
		  Game g = GameManager.getManager().getArena(id);
		  try {
	  		   player1 = g.getPlayer1().get(0);
	  		   player2 = g.getPlayer2().get(0);
	  		 GameManager.getManager().getRankedGames().remove(g);
	  		  g.resetRounds();
	  		RankedSpleefGame.reinicio(g);
	  		GameManager.getManager().removeInGameArena(g);
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
				 g.getSpectators().clear();
	  		  } else if (g.getPoints1() >= 5) {

	  			
	  			int diferencia = g.getPoints1() - g.getPoints2();
	  			  int elodif =  (int) DataManager.newElo(ganador, diferencia, perdedor);
	  			 
	  			  Bukkit.broadcastMessage("§3[Spleef] §aEl jugador §b" + ganador.getName() + "§7(§e" +DataManager.getElo(ganador) 
  				  + "§7) §a(+" + elodif + ")"
  				  + "§a le ha ganado a §b" + perdedor.getName()  + "§7(§e" +DataManager.getElo(perdedor) 
  				  + "§7) §c(-" + elodif + ")" + 
  							" §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  			  
	  			SpleefRankManager.giveExp(perdedor,2);
  	  			SpleefRankManager.giveExp(ganador, 5);
  	  			EconomyManager.addCoins(ganador, 20,true);
  	  			EconomyManager.addCoins(perdedor, 2,true);
  	  			
  	  			
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  g.resetPoints();
	  					  g.getPlayer1().clear();
	  					  g.getPlayer2().clear();
	  					  
	  				  
	  				  Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);
	  					
	  					
	  					
	  					
	  					
	  			  } else if (g.getPoints2() >= 5) {

	  				 int diferencia = g.getPoints2() - g.getPoints1();
	  				  int elodif =  (int) DataManager.newElo(ganador, diferencia, perdedor);
	  				  
	  				SpleefRankManager.giveExp(perdedor,2);
	  	  			SpleefRankManager.giveExp(ganador, 5);
	  	  		EconomyManager.addCoins(ganador, 20,true);
  	  			EconomyManager.addCoins(perdedor, 2,true);
	  					  Bukkit.broadcastMessage("§3[Spleef] §aEl jugador §b" + ganador.getName() + "§7(§e" +DataManager.getElo(ganador) 
	  					  + "§7) §a(+" + elodif + ")"
	  					  + "§a le ha ganado a §b" + perdedor.getName()  + "§7(§e" +DataManager.getElo(perdedor) 
	  					  + "§7) §c(-" + elodif + ")" + 
	  								" §7(§e" + g.getPoints2() + "§7-§e" + g.getPoints1() + "§7)");
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  
	  				 g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();
	  				Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);

	  					
	  			  } else if (ganador == player1) {
	  				  
	  				  
	  	  			SpleefRankManager.giveExp(perdedor,1);
	  	  			SpleefRankManager.giveExp(ganador, 3);
	  	  		EconomyManager.addCoins(ganador, 20,true);
  	  			EconomyManager.addCoins(perdedor, 2,true);
	  				 int diferencia = g.getPoints1() - g.getPoints2();
	  				 int elodif =  (int) DataManager.newElo(ganador, diferencia, perdedor);
	  				  
  					 Bukkit.broadcastMessage("§3[Spleef] §aEl jugador §b" + ganador.getName() + "§7(§e" +DataManager.getElo(ganador) 
	  					 + "§7) §a(+" + elodif + ")"
	  				  + "§a le ha ganado a §b" + perdedor.getName()  + "§7(§e" +DataManager.getElo(perdedor) 
	  				  + "§7) §c(-" + elodif + ")" + 
	  								" §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  
	  				 g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();

	  				Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);  
	  				  
	  				  
	  			  } else if (ganador == player2) {
	  				  
	  				
	  				  
	  	  			SpleefRankManager.giveExp(perdedor,2);
	  	  			SpleefRankManager.giveExp(ganador, 5);
	  	  		EconomyManager.addCoins(ganador, 20,true);
  	  			EconomyManager.addCoins(perdedor, 2,true);
	  				int diferencia = g.getPoints2() - g.getPoints1();
	  				  int elodif =  (int) DataManager.newElo(ganador, diferencia, perdedor);	  
	  					  Bukkit.broadcastMessage("§3[Spleef] §aEl jugador §b" + ganador.getName() + "§7(§e" +DataManager.getElo(ganador) 
	  					  + "§7) §a(+" + elodif + ")"
	  					  + "§a le ha ganado a §b" + perdedor.getName()  + "§7(§e" +DataManager.getElo(perdedor) 
	  					  + "§7) §c(-" + elodif + ")" + 
	  								" §7(§e" + g.getPoints1() + "§7-§e" + g.getPoints2() + "§7)");
	  				
	  				  perdedor.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  ganador.teleport(Main.getLoc(Main.arena.get("lobby"), true));
	  				  
	  				  g.resetPoints();
	  				 g.getPlayer1().clear();
	  				 g.getPlayer2().clear();
	  				 
	  				 
	  				Main.giveItems(ganador);
	  				  Main.giveItems(perdedor);
	  				  
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
	  
	  public static void reinicio(Game g) {
		  Location a = g.getArena1();
		  Location b =g.getArena2();
		  int ax = a.getBlockX();
		  int az = a.getBlockZ();
		  
		  int y = a.getBlockY();
		  
		  int bx = b.getBlockX();
		  int bz = b.getBlockZ();
		  
		  	
		  for (int x = ax; x < bx; x++) {
			  for (int z = az; z < bz; z++) {
				  Location aire = new Location (a.getWorld(), x, y, z);
				  if (aire.getBlock().getType().equals(Material.AIR)) {
				  aire.getBlock().setType(Material.SNOW_BLOCK);
				  }
			  }
		  }
	  }
	  

	  
	  
}
	  
	
	

